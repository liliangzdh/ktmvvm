package com.kaoyaya.kt.adapter

import androidx.databinding.DataBindingUtil
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.viewholder.BaseDataBindingHolder
import com.chad.library.adapter.base.viewholder.BaseViewHolder
import com.kaoyaya.kt.R
import com.kaoyaya.kt.databinding.ItemExamBinding
import com.kaoyaya.kt.entity.ExamInfo


//class HomeExamAdapter : RecyclerView.Adapter {
//    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ExamInfo {
//    }
//
//    override fun getItemCount(): Int {
//    }
//
//    override fun onBindViewHolder(holder: ExamInfo, position: Int) {
//    }
//
//
//
//
//}


class HomeExamAdapter(data: MutableList<ExamInfo>) :
    BaseQuickAdapter<ExamInfo, BaseViewHolder>(R.layout.item_exam, data) {


    override fun onItemViewHolderCreated(viewHolder: BaseViewHolder, viewType: Int) {
        BaseDataBindingHolder<ItemExamBinding>(viewHolder.itemView)
    }

    override fun convert(holder: BaseViewHolder, item: ExamInfo) {
        val binding = DataBindingUtil.getBinding<ItemExamBinding>(holder.itemView)
        binding?.item = item
    }


}