package flore.dspark.study_covid19maskinfo.repository

import flore.dspark.study_covid19maskinfo.model.StoreInfo
import retrofit2.Call
import retrofit2.http.GET

interface MaskService {
    companion object{
        const val BASE_URL = "https://gist.githubusercontent.com/junsuk5/"
        const val GET_URL = "API_HIDDEN"
    }

    @GET(GET_URL)
    fun fetchStoreInfo() : Call<StoreInfo>
}