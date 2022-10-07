package dev.tigrao.devpass.api.di

import com.squareup.moshi.Moshi
import dev.tigrao.devpass.api.NetworkService
import dev.tigrao.devpass.api.OkhttpClientFactory
import okhttp3.Interceptor
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.dsl.bind
import org.koin.dsl.module

val networkImplModule = module {

    factory {
        HttpLoggingInterceptor()
    } bind Interceptor::class

    single {
        Moshi.Builder().build()
    }

    single {
        NetworkService(
            networkBuilder = get(),
            okhttpClientFactory = get(),
            moshi = get(),
            callAdapterFactoryList = getAll(),
        )
            .createRetrofitInstance()
    }

    single {
        val interceptor = getAll<Interceptor>()
        OkhttpClientFactory(interceptor)
    }
}
