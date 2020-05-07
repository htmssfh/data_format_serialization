package com.fangye.serialization

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import com.fangye.dataparser.json.CommonJsonBuilder
import com.fangye.serialization.databinding.MainActivityBinding

/**
 * @Package: com.fangye.serialization
 * @Author: fanyeren51@gmail.com
 * @UpdateDate: 2020/05/05 06:32
 */
class MainActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var mViewBinding:MainActivityBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.main_activity)
        mViewBinding  = MainActivityBinding.inflate(LayoutInflater.from(this))
        setContentView(mViewBinding.root)
        mViewBinding?.btnDefaultByteTest.setOnClickListener(this)
        mViewBinding?.btnDefaultShortTest.setOnClickListener(this)
        mViewBinding?.btnDefaultIntTest.setOnClickListener(this)
        mViewBinding?.btnDefaultLongTest.setOnClickListener(this)
        mViewBinding?.btnDefaultFloatTest.setOnClickListener(this)
        mViewBinding?.btnDefaultDoubleTest.setOnClickListener(this)
        mViewBinding?.btnDefaultStringTest.setOnClickListener(this)
        mViewBinding?.btnDefaultObjectTest.setOnClickListener(this)
        mViewBinding?.btnDefaultArrayTest.setOnClickListener(this)
        mViewBinding?.btnDefaultMapTest.setOnClickListener(this)
        mViewBinding?.btnDefaultOtherTest.setOnClickListener(this)
        mViewBinding?.btnDefaultBooleanTest.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when(v?.id){
            R.id.btn_default_byte_test -> {
                //默认为byte
                DataJsonActivity.startIntent(this,DataJsonActivity.TYPE_BYTE)
            }
            R.id.btn_default_short_test ->{
                //默认为short
                DataJsonActivity.startIntent(this,DataJsonActivity.TYPE_SHORT)
            }
            R.id.btn_default_int_test -> {
                //默认为int
                DataJsonActivity.startIntent(this,DataJsonActivity.TYPE_INT)
            }
            R.id.btn_default_long_test ->{
                //默认为long
                DataJsonActivity.startIntent(this,DataJsonActivity.TYPE_LONG)
            }
            R.id.btn_default_boolean_test -> {
                DataJsonActivity.startIntent(this,DataJsonActivity.TYPE_BOOLEAN)
            }
            R.id.btn_default_float_test ->{
                //默认为float
                DataJsonActivity.startIntent(this,DataJsonActivity.TYPE_FLOAT)
            }
            R.id.btn_default_double_test -> {
                //默认为double
                DataJsonActivity.startIntent(this,DataJsonActivity.TYPE_DOUBLE)
            }
            R.id.btn_default_string_test ->{
                //默认为string
                DataJsonActivity.startIntent(this,DataJsonActivity.TYPE_STRING)
            }
            R.id.btn_default_object_test ->{
                //默认为object
                DataJsonActivity.startIntent(this,DataJsonActivity.TYPE_OBJECT)
            }
            R.id.btn_default_array_test ->{
                //默认为array
                DataJsonActivity.startIntent(this,DataJsonActivity.TYPE_ARRAY)
            }
            R.id.btn_default_map_test ->{
                //默认为map
                DataJsonActivity.startIntent(this,DataJsonActivity.TYPE_MAP)
            }
            else -> {
                DataJsonActivity.startIntent(this,DataJsonActivity.TYPE_NO_JSON)
            }

        }
    }

}
