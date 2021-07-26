package flore.dspark.study_covid19maskinfo.repository

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object StoreInfoAPIBuilder {
    fun api(): StoreInfoAPI {
        return Retrofit.Builder()
            .baseUrl(StoreInfoAPI.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(StoreInfoAPI::class.java)
    }
}