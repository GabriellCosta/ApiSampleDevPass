package dev.tigrao.devpass.api

import dev.tigrao.devpass.api.network.NetworkBuilder
import com.squareup.moshi.Moshi
import retrofit2.CallAdapter
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.moshi.MoshiConverterFactory

internal class NetworkService(
    private val networkBuilder: NetworkBuilder,
    private val okhttpClientFactory: OkhttpClientFactory,
    private val moshi: Moshi,
    private val callAdapterFactoryList: List<CallAdapter.Factory>,
) {

    fun createRetrofitInstance(): Retrofit =
        Retrofit.Builder()
            .baseUrl(networkBuilder.baseUrl)
            .client(okhttpClientFactory.createNewInstance())
            .addConverterFactory(GsonConverterFactory.create())
            .addConverterFactory(MoshiConverterFactory.create(moshi))
            .apply {
                callAdapterFactoryList.forEach {
                    addCallAdapterFactory(it)
                }
            }
            .build()
}
