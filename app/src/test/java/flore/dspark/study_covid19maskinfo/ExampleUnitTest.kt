package flore.dspark.study_covid19maskinfo

import flore.dspark.study_covid19maskinfo.model.StoreInfo
import flore.dspark.study_covid19maskinfo.repository.MaskService
import org.junit.Test

import org.junit.Assert.*
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
    @Test
    fun addition_isCorrect() {
        assertEquals(4, 2 + 2)
    }

    @Test
    fun retrofitTest(){
        // Retrofit api builder 객체
        val retrofit = Retrofit.Builder()
            .baseUrl(MaskService.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        val service: MaskService = retrofit.create(MaskService::class.java)

        // Retrofit call 요청 객체
        val storeInfoCall : Call<StoreInfo> = service.fetchStoreInfo()

        // Call 리퀘스트 동기 방식으로 실행 (실제로는 네트워킹을 이용하기 때문에 비동기 방식으로 진행해야 함)
        val storeInfo : StoreInfo? = storeInfoCall.execute().body()

        // 테스트 1 : 리퀘스트 결과 카운트 값이 222와 동일한지 확인
        assertEquals(222, storeInfo?.count)

        // 테스트 2 : 리퀘스트로 받은 stores 리스트 결과 값이 222와 동일한지 확인
        assertEquals(221, storeInfo?.stores?.size)
    }

}