package flore.dspark.study_covid19maskinfo.repository

import flore.dspark.study_covid19maskinfo.model.StoreInfo
import retrofit2.Call
import retrofit2.http.GET

interface StoreInfoAPI {
    companion object{
        const val BASE_URL = "https://gist.githubusercontent.com/junsuk5/"
        const val GET_URL = "bb7485d5f70974deee920b8f0cd1e2f0/raw/063f64d9b343120c2cb01a6555cf9b38761b1d94/"
    }

    @GET(GET_URL)
    fun fetchStoreInfo() : Call<StoreInfo>
}