package com.fangye.serialization

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.fangye.dataparser.json.CommonJsonBuilder
import com.fangye.serialization.databinding.ActivityDataParserJsonBinding
import com.fangye.serialization.entity.*

/**
 * 数据解析详情页面
 * @Package: com.fangye.serialization
 * @Author: fanyeren51@gmail.com
 * @UpdateDate: 2020/05/05 06:40
 */
class DataParserDetailActivity:AppCompatActivity(), View.OnClickListener {

    companion object{
        private const val TYPE_NAME = "name"
        private const val TYPE_JSON = "json"
        private const val TYPE = "type"

        fun startIntent(context: Context,type:Int, name:String,json:String){
            val intent = Intent(context,DataParserDetailActivity::class.java)
            intent.putExtra(TYPE_NAME,name)
            intent.putExtra(TYPE_JSON,json)
            intent.putExtra(TYPE,type)
            context.startActivity(intent)
        }
    }

    private lateinit var mViewBinding:ActivityDataParserJsonBinding
    private var mName:String = ""
    private var mJson :String = ""
    private var mType :Int = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mViewBinding = ActivityDataParserJsonBinding.inflate(LayoutInflater.from(this))
        setContentView(mViewBinding.root)

        mName = intent.getStringExtra(TYPE_NAME);
        mJson = intent.getStringExtra(TYPE_JSON)
        mType = intent.getIntExtra(TYPE,0)
        mViewBinding?.etName.text = "提示:$mName"
        mViewBinding?.etJson.text = "json:$mJson"

        mViewBinding.btnDataClean.setOnClickListener(this)
        mViewBinding.btnDataParser.setOnClickListener(this)

    }

    override fun onClick(v: View?) {
        when(v?.id){
            R.id.btn_data_clean ->{
                mViewBinding.tvResult.text = ""
                mViewBinding.tvLine.visibility = View.GONE
            }
            R.id.btn_data_parser ->{
                dataParse()
            }
        }
    }

    private fun dataParse() {
        val start = System.currentTimeMillis();
        when (mType) {
            DataJsonActivity.TYPE_SHORT -> {
                var shortTest = CommonJsonBuilder.toObject(mJson, ShortEntity::class.java)
                val time = System.currentTimeMillis() -start
                mViewBinding.tvResult.text = CommonJsonBuilder.toJson(shortTest)+"\n\n耗时:$time 毫秒"
                mViewBinding.tvLine.visibility = View.VISIBLE
            }

            DataJsonActivity.TYPE_INT -> {
                var intTest = CommonJsonBuilder.toObject(mJson, IntEntity::class.java)
                val time = System.currentTimeMillis() -start
                mViewBinding.tvResult.text = CommonJsonBuilder.toJson(intTest)+"\n\n耗时:$time 毫秒"
                mViewBinding.tvLine.visibility = View.VISIBLE
            }

            DataJsonActivity.TYPE_LONG -> {
                var longTest = CommonJsonBuilder.toObject(mJson, LongEntity::class.java)
                val time = System.currentTimeMillis() -start
                mViewBinding.tvResult.text = CommonJsonBuilder.toJson(longTest)+"\n\n耗时:$time 毫秒"
                mViewBinding.tvLine.visibility = View.VISIBLE
            }

            DataJsonActivity.TYPE_FLOAT -> {
                var floatTest = CommonJsonBuilder.toObject(mJson, FloatEntity::class.java)
                val time = System.currentTimeMillis() -start
                mViewBinding.tvResult.text = CommonJsonBuilder.toJson(floatTest)+"\n\n耗时:$time 毫秒"
                mViewBinding.tvLine.visibility = View.VISIBLE
            }

            DataJsonActivity.TYPE_DOUBLE -> {
                var doubleTest = CommonJsonBuilder.toObject(mJson, DoubleEntity::class.java)
                val time = System.currentTimeMillis() -start
                mViewBinding.tvResult.text = CommonJsonBuilder.toJson(doubleTest)+"\n\n耗时:$time 毫秒"
                mViewBinding.tvLine.visibility = View.VISIBLE
            }

            DataJsonActivity.TYPE_STRING -> {
                var stringTest = CommonJsonBuilder.toObject(mJson, StringEntity::class.java)
                val time = System.currentTimeMillis() -start
                mViewBinding.tvResult.text = CommonJsonBuilder.toJson(stringTest)+"\n\n耗时:$time 毫秒"
                mViewBinding.tvLine.visibility = View.VISIBLE
            }
            DataJsonActivity.TYPE_OBJECT -> {
                var objectEntity = CommonJsonBuilder.toObject(mJson, ObjectEntity::class.java)
                val time = System.currentTimeMillis() -start
                mViewBinding.tvResult.text = CommonJsonBuilder.toJson(objectEntity)+"\n\n耗时:$time 毫秒"
                mViewBinding.tvLine.visibility = View.VISIBLE
            }
            DataJsonActivity.TYPE_ARRAY -> {
                var arrayE = CommonJsonBuilder.toObjectArray(mJson, ArrayEntity::class.java)
                val time = System.currentTimeMillis() -start
                mViewBinding.tvResult.text = CommonJsonBuilder.toJson(arrayE)+"\n\n耗时:$time 毫秒"
                mViewBinding.tvLine.visibility = View.VISIBLE
            }
            DataJsonActivity.TYPE_MAP -> {
                var mapE = CommonJsonBuilder.toObject(mJson, MapEntity::class.java)
                val time = System.currentTimeMillis() -start
                mViewBinding.tvResult.text = CommonJsonBuilder.toJson(mapE)+"\n\n耗时:$time 毫秒"
                mViewBinding.tvLine.visibility = View.VISIBLE
            }
            DataJsonActivity.TYPE_NO_JSON -> {
                var illegalEntity = CommonJsonBuilder.toObject(mJson, IllegalDataEntity::class.java)
                val time = System.currentTimeMillis() -start
                mViewBinding.tvResult.text = CommonJsonBuilder.toJson(illegalEntity)+"\n\n耗时:$time 毫秒"
                mViewBinding.tvLine.visibility = View.VISIBLE
            }
        }
    }
}