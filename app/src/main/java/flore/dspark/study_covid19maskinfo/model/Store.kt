package flore.dspark.study_covid19maskinfo.model

import com.google.gson.annotations.SerializedName

/** 리퀘스트 결과 정보 내용
 * (자세한 내용은 https://app.swaggerhub.com/apis-docs/Promptech/public-mask-info/20200307-oas3#/ 참고)
 *  address = 약국 주소
 *  code = 약국 코드
 *  created_at = 데이터 생성 일자
 *  lat, lng = 위도, 경도 값
 *  name = 약국 이름
 *  remainStat = 재고 상태 (아래 내용은 API 제공자의 프론트엔드 개발시 권장 요구사항)
 *      100개 이상(녹색): 'plenty' / 30개 이상 100개미만(노랑색): 'some' /
 *      2개 이상 30개 미만(빨강색): 'few' / 1개 이하(회색): 'empty' / 판매중지: 'break'
 *  stockAt = 입고 시간
 *  type = 판매처 유형 (번호에 따른 판매처 유형이 다름)
 *      약국: '01', 우체국: '02', 농협: '03'*/

data class Store(
    @SerializedName(value = "addr")
    val address: String,
    @SerializedName(value = "code")
    val code: String,
    @SerializedName(value = "created_at")
    val createdAt: String,
    @SerializedName(value = "lat")
    val lat: Double,
    @SerializedName(value = "lng")
    val lng: Double,
    @SerializedName(value = "name")
    val name: String,
    @SerializedName(value = "remain_stat")
    val remainStat: String,
    @SerializedName(value = "stock_at")
    val stockAt: String,
    @SerializedName(value = "type")
    val type: String
)