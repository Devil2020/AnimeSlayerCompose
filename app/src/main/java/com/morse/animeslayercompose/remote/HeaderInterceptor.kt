package com.morse.retrofit.core

import okhttp3.Interceptor
import okhttp3.Response
import java.io.IOException
import java.net.SocketTimeoutException

class HeaderInterceptor () : Interceptor {

    @Throws(IOException::class)
    override fun intercept(chain: Interceptor.Chain): Response {
        var request = chain.request()
        try {
            request = request.newBuilder()
                .addHeader("Accept", "application/json")
                .addHeader("X-localization", "en")
                .build()
        } catch (e: SocketTimeoutException) {
            e.printStackTrace()
        }
        return chain.proceed(request)
    }
}


