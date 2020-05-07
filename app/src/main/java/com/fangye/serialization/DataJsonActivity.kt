package com.fangye.serialization

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.listener.OnItemChildClickListener
import com.fangye.dataparser.json.CommonJsonBuilder
import com.fangye.serialization.adapter.ListItemAdapter
import com.fangye.serialization.databinding.ActivityListDataBinding
import com.fangye.serialization.entity.JsonItemEntity
import com.fangye.serialization.utils.DataUtils

/**
 *  json解析的各种情况列表页面
 * @Package: com.fangye.serialization
 * @Author: fanyeren51@gmail.com
 * @UpdateDate: 2020/05/05 06:30
 */
class DataJsonActivity : AppCompatActivity(), OnItemChildClickListener {

    companion object{
        const val TYPE_BYTE = 1
        const val TYPE_SHORT= 2
        const val TYPE_INT= 3
        const val TYPE_LONG= 4
        const val TYPE_FLOAT= 5
        const val TYPE_DOUBLE= 6
        const val TYPE_STRING= 7
        const val TYPE_OBJECT= 8
        const val TYPE_ARRAY= 9
        const val TYPE_MAP= 10
        const val TYPE_NO_JSON =0
        private const val TYPE_NAME = "type"

        fun startIntent(context: Context,type:Int){
            val intent = Intent(context,DataJsonActivity::class.java)
            intent.putExtra(TYPE_NAME,type)
            context.startActivity(intent)
        }
    }

    private lateinit var mViewBinding: ActivityListDataBinding
    private var mType:Int = 0;
    private var list:MutableList<JsonItemEntity>? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mViewBinding = ActivityListDataBinding.inflate(LayoutInflater.from(this))
        setContentView(mViewBinding.root)
        mType = intent.getIntExtra(TYPE_NAME, TYPE_INT)
        list = DataUtils.getList(mType)
        val mAdapter = ListItemAdapter(R.layout.item_data,list)
        mViewBinding.rvList.layoutManager = LinearLayoutManager(this)
        mViewBinding.rvList.adapter = mAdapter
        mAdapter.setDiffNewData(list)
        mAdapter.addChildClickViewIds(R.id.btn_item_data_parser)
        mAdapter.setOnItemChildClickListener(this)

    }

    override fun onItemChildClick(adapter: BaseQuickAdapter<*, *>, view: View, position: Int) {
        if(view.id == R.id.btn_item_data_parser){
            list?.get(position)?.name?.let {
                DataParserDetailActivity.startIntent(this,
                    mType,it, list!![position].json)
            }
        }
    }





}