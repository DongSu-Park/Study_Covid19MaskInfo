package flore.dspark.study_covid19maskinfo.repository

import android.util.Log
import androidx.lifecycle.MutableLiveData
import flore.dspark.study_covid19maskinfo.model.Store
import flore.dspark.study_covid19maskinfo.model.StoreInfo
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class StoreInfoRepository {
    private val api = StoreInfoAPIBuilder.api()

    fun getStoreInfo(storeMutableLiveData: MutableLiveData<List<Store>>) {
        api.fetchStoreInfo().enqueue(object : Callback<StoreInfo>{
            override fun onResponse(call: Call<StoreInfo>, response: Response<StoreInfo>) {
                if (response.isSuccessful){
                    val list : List<Store> = response.body()!!.stores
                    storeMutableLiveData.value = list
                } else {
                    storeMutableLiveData.value = null
                }
            }

            override fun onFailure(call: Call<StoreInfo>, t: Throwable) {
                /** 리퀘스트 에러코드 또는 인터넷 접속 오류로 인한 Fail 발생 시*/
                // TODO: 리퀘스트 패일 발생 시 토스트 메세지 또는 얼럿박스를 통해 사용자에게 재시도 요청 유도
                Log.e("Retrofit API", "Error Message: ${t.message}")
            }
        })
    }
}