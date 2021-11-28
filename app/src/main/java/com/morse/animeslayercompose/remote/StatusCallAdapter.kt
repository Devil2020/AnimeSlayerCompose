package com.expertapps.base.network

import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.suspendCancellableCoroutine
import retrofit2.*
import java.lang.reflect.Type
import kotlin.coroutines.resume
import kotlin.coroutines.resumeWithException

class Try<T : Any?> private constructor(val value: Any?) {

    companion object {
        fun <T : Any?> loading(): Try<T?> = Try(Loading())

        fun <T : Any> success(value: T): Try<T> = Try(value)

        fun <T : Any?> failure(error: Throwable, errorMsg: String?): Try<T> =
            Try(Failure(error, errorMsg))

    }

    fun isSuccess(): Boolean = this.value !is Failure || this.value !is Loading

    fun isFailure(): Boolean = this.value is Failure

    @Suppress("UNCHECKED_CAST")
    fun materialize(onFailure: (error: Throwable) -> T): T = when (this.value) {
        is Failure -> onFailure.invoke(this.value.error)
        else -> this.value as T
    }

    fun on(
        onSuccess: (value: T?) -> Unit,
        onLoading: () -> Unit,
        onFailure: (Failure) -> Unit
    ) {
        when (this.value) {
            is Failure -> onFailure.invoke(this.value)
            is Loading -> onLoading.invoke()
            else -> onSuccess.invoke((this.value as Try<T>).value as T)
        }
    }

   /* fun asResponseState(): ResponseState2<T> = when (this.value) {
        is Failure -> ResponseState2.Error(this.value.error, this.value.errorMsg)
        is Loading -> ResponseState2.Loading
        else -> ResponseState2.Success((this.value as Try<T>).value as T)
    }

    fun ResponseState2<*>.asError() = this as ResponseState2.Error*/

  /*  @Suppress("UNCHECKED_CAST")
    fun <U : Any> map(f: (T) -> U): Try<U?> = when (this.value) {
        is Failure -> failure(this.value.error, this.value.errorMsg)
        else -> success(f.invoke(this.value as T))
    }*/

    class Failure(val error: Throwable, val errorMsg: String?)

    class Loading
}

internal class StatusCallAdapter<R : Any?>(private val responseType: Type) :
    CallAdapter<R, Flow<Try<R>>> {

    override fun responseType() = responseType

    /*   override fun adapt(call: Call<R>): Flow<Try<R?>> {
           return flow {
               emit(Try.loading())

               val response =  call.awaitResponse()

               if (response.isSuccessful && response.body() != null) {
                   emit(Try.success(response.body()))
               } else {
                   emit(Try.failure<R?>(error = Throwable(), errorMsg = response.errorMsg()))
               }
           }.catch { exception: Throwable ->
               Log.e("ApiCallHandler", exception.toString())
               emit(Try.failure(error = exception, errorMsg = exception.errorString()))
           }
       }
   */

    @ExperimentalCoroutinesApi
    override fun adapt(call: Call<R>): Flow<Try<R>> {
        return flow {

         val x =  call.awaitResponse()
           x.raw()
           x.body()
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

    private fun Throwable.errorString() = message.toString()

    suspend fun <T : Any> Call<T?>.await(): T? {
        return suspendCancellableCoroutine { continuation ->
            continuation.invokeOnCancellation {
                cancel()
            }
            enqueue(object : Callback<T?> {
                override fun onResponse(call: Call<T?>, response: Response<T?>) {
                    if (response.isSuccessful) {
                        continuation.resume(response.body())
                    } else {
                        continuation.resumeWithException(HttpException(response))
                    }
                }

                override fun onFailure(call: Call<T?>, t: Throwable) {
                    continuation.resumeWithException(t)
                }
            })
        }
    }
}

