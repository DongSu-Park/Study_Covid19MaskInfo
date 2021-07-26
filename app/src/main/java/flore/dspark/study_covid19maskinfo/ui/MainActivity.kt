package flore.dspark.study_covid19maskinfo.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import flore.dspark.study_covid19maskinfo.R
import flore.dspark.study_covid19maskinfo.databinding.ActivityMainBinding
import flore.dspark.study_covid19maskinfo.util.StoreRVAdapter
import flore.dspark.study_covid19maskinfo.viewmodel.StoreViewModel

class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding
    private lateinit var storeViewModel : StoreViewModel
    private val storeRVAdapter = StoreRVAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)

        // 엑티비티 바인딩 설정
        initActivity()

        // 레트로핏으로 api call 요청
        getStoreInfo()

        // 리사이클러 뷰 설정
        initRecyclerView()

        // livedata Observer 후 리사이클러 표시
        setRecyclerViewItem()
    }

    /** 엑티비티 바인딩 설정 */
    private fun initActivity() {
        storeViewModel = ViewModelProvider(this).get(StoreViewModel::class.java)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.lifecycleOwner = this
        binding.viewModel = storeViewModel
    }

    /** 레트로핏으로 api call 요청 */
    private fun getStoreInfo() {
        storeViewModel.maskInfoAPICall()
    }

    /** 리사이클러 뷰 설정 */
    private fun initRecyclerView() {
        val mLayoutManager = LinearLayoutManager(this, RecyclerView.VERTICAL, false)
        binding.rvStoreList.layoutManager = mLayoutManager
        binding.rvStoreList.adapter = storeRVAdapter
    }

    /** 라이브데이터 옵저빙 후 리사이클러 뷰 표시*/
    private fun setRecyclerViewItem() {
        storeViewModel.storeMutableLiveData.observe(this, Observer { items ->
            storeRVAdapter.updateListItem(items)
        })
    }
}