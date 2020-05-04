package com.fangye.serialization.adapter

import android.util.Log
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.viewholder.BaseViewHolder
import com.fangye.dataparser.json.CommonJsonBuilder
import com.fangye.serialization.R
import com.fangye.serialization.entity.JsonItemEntity

/**
 * recyclerview 列表适配器
 * @Package: com.fangye.serialization.adapter
 * @Author: fanyeren51@gmail.com
 * @UpdateDate: 2020/05/05 06:32
 */
class ListItemAdapter( layoutResId: Int,data: MutableList<JsonItemEntity>?):
    BaseQuickAdapter<JsonItemEntity, BaseViewHolder>(layoutResId, data) {

    override fun convert(holder: BaseViewHolder, item: JsonItemEntity) {
        holder.setText(R.id.tv_data,item.json)
        holder.setText(R.id.tv_name,item.name)
    }
}