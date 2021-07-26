package flore.dspark.study_covid19maskinfo.util

import android.content.Context
import android.os.Build
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import flore.dspark.study_covid19maskinfo.R
import flore.dspark.study_covid19maskinfo.model.Store

class StoreRVAdapter() : RecyclerView.Adapter<StoreRVAdapter.StoreViewHolder>() {
    companion object {
        const val PLENTY = "plenty"
        const val SOME = "some"
        const val FEW = "few"
        const val EMPTY = "empty"
        const val BREAK = "break"
    }

    private var mStoreItems = ArrayList<Store>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StoreRVAdapter.StoreViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_store, parent, false)
        return StoreViewHolder(view, parent.context)
    }

    override fun onBindViewHolder(holder: StoreRVAdapter.StoreViewHolder, position: Int) {
        holder.bind(mStoreItems[position])
    }

    override fun getItemCount(): Int {
        return mStoreItems.size
    }

    // 갱신 문제 발생 문제 해결
    override fun getItemViewType(position: Int): Int {
        return position
    }

    fun updateListItem(items: List<Store>) {
        for (element in items){
            mStoreItems.add(element)
        }

        notifyDataSetChanged()
    }

    inner class StoreViewHolder(view: View, context: Context) : RecyclerView.ViewHolder(view){

        private val storeName : TextView = itemView.findViewById(R.id.tv_store_name)
        private val storeAddress : TextView = itemView.findViewById(R.id.tv_store_address)
        private val storeRemainState : TextView = itemView.findViewById(R.id.tv_store_mask_remainState)
        private val parentContext = context

        fun bind(store: Store) {
            storeName.text = store.name
            storeAddress.text = store.address

            /** 마스크 재고에 따른 텍스트 뷰 세팅 처리 */
            /** remainStat = 재고 상태 (아래 내용은 API 제공자의 프론트엔드 개발시 권장 요구사항)
             *      100개 이상(녹색): 'plenty' / 30개 이상 100개미만(노랑색): 'some' /
             *      2개 이상 30개 미만(빨강색): 'few' / 1개 이하(회색): 'empty' / 판매중지: 'break' */

            when (store.remainStat){
                PLENTY -> {
                    storeRemainState.text = parentContext.getString(R.string.tv_store_mask_remainState_plenty)
                    setColor(storeRemainState, R.color.mask_remain_plenty_green)
                }

                SOME -> {
                    storeRemainState.text = parentContext.getString(R.string.tv_store_mask_remainState_some)
                    setColor(storeRemainState, R.color.mask_remain_some_yellow)
                }

                FEW -> {
                    storeRemainState.text = parentContext.getString(R.string.tv_store_mask_remainState_few)
                    setColor(storeRemainState, R.color.mask_remain_few_red)
                }

                EMPTY -> {
                    storeRemainState.text = parentContext.getString(R.string.tv_store_mask_remainState_empty)
                    setColor(storeRemainState, R.color.mask_remain_empty_gray)
                }

                BREAK -> {
                    storeRemainState.text = parentContext.getString(R.string.tv_store_mask_remainState_break)
                    setColor(storeRemainState, R.color.mask_remain_break_black)
                }
            }
        }

        private fun setColor(storeRemainState: TextView, remainColor: Int) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M){
                storeRemainState.setTextColor(parentContext.resources.getColor(remainColor, null))
            } else {
                storeRemainState.setTextColor(parentContext.resources.getColor(remainColor))
            }
        }
    }

}