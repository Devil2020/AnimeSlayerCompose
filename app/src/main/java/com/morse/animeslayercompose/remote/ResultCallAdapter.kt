package com.expertapps.base.network

import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.callbackFlow
import retrofit2.Call
import retrofit2.CallAdapter
import retrofit2.Callback
import retrofit2.Response
import java.lang.reflect.Type
import java.util.concurrent.atomic.AtomicBoolean


internal class ResultCallAdapter<R : Any?>(private val responseType: Type) :
    CallAdapter<R, Flow<Result<R?>>> {

    override fun responseType() = responseType

    @ExperimentalCoroutinesApi
    override fun adapt(call: Call<R>): Flow<Result<R?>> {
        return callbackFlow {
            val started = AtomicBoolean(false)
            if (started.compareAndSet(false, true)) {
                call.enqueue(object : Callback<R> {
                    override fun onResponse(call: Call<R>, response: Response<R>) {

                        if (response.isSuccessful) {
                            val body = response.body()
                            if (body == null || response.code() == 204) {
                                trySend(Result.failure<R?>( exception =   Throwable()))

                               // cancel(CancellationException("HTTP status code: ${response.code()}"))
                            } else {
                                trySend(Result.success(body))
                                channel.close()
                            }
                        } else {
                            offer(
                                Result.failure<R?>(
                                  Throwable()
                                )
                            )
                            channel.close()

                            //cancel(CancellationException(errorMsg(response) ?: "unknown error"))
                        }
                    }

                    override fun onFailure(call: Call<R>, throwable: Throwable) {
                        offer(Result.failure<R>(throwable))
                        channel.close()

                        // cancel(CancellationException(throwable.localizedMessage, throwable))
                    }
                })
            }
            awaitClose { call.cancel() }
        }
    }

    private fun Response<R>.errorMsg(): String? {
        val msg = errorBody()?.string()
        return if (msg.isNullOrEmpty()) {
            message()
        } else {
            msg
        }
    }


}

