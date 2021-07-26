package flore.dspark.study_covid19maskinfo.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import flore.dspark.study_covid19maskinfo.model.Store
import flore.dspark.study_covid19maskinfo.repository.StoreInfoRepository

class StoreViewModel : ViewModel() {
    private val storeInfoRepo = StoreInfoRepository()

    var storeMutableLiveData = MutableLiveData<List<Store>>()
    fun maskInfoAPICall() { storeInfoRepo.getStoreInfo(storeMutableLiveData) }
}