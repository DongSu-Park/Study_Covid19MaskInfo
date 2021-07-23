package flore.dspark.study_covid19maskinfo.model

import com.google.gson.annotations.SerializedName

data class StoreInfo(
    @SerializedName(value = "count")
    val count: Int,
    @SerializedName(value = "stores")
    val stores: List<Store>
)