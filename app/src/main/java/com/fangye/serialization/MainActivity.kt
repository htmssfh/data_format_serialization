package com.fangye.serialization

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import com.fangye.serialization.R
import com.fangye.serialization.databinding.MainActivityBinding

class MainActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var mViewBinding:MainActivityBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.main_activity)
        mViewBinding  = MainActivityBinding.inflate(LayoutInflater.from(this))
        setContentView(mViewBinding.root)
        mViewBinding?.btnDefaultShortTest.setOnClickListener(this)
        mViewBinding?.btnDefaultIntTest.setOnClickListener(this)
        mViewBinding?.btnDefaultLongTest.setOnClickListener(this)
        mViewBinding?.btnDefaultFloatTest.setOnClickListener(this)
        mViewBinding?.btnDefaultDoubleTest.setOnClickListener(this)
        mViewBinding?.btnDefaultStringTest.setOnClickListener(this)
        mViewBinding?.btnDefaultObjectTest.setOnClickListener(this)
        mViewBinding?.btnDefaultArrayTest.setOnClickListener(this)
        mViewBinding?.btnDefaultMapTest.setOnClickListener(this)
        mViewBinding?.btnSelfInputTest.setOnClickListener(this)

    }

    override fun onClick(v: View?) {
        when(v?.id){
            R.id.btn_self_input_test -> {
                //输入json 验证测试
                startActivity(Intent(this,DataInputJsonActivity::class.java))
            }
            R.id.btn_default_short_test ->{
                //默认为short

            }
            R.id.btn_default_int_test -> {
                //默认为int
            }
            R.id.btn_default_long_test ->{
                //默认为long
            }
            R.id.btn_default_float_test ->{
                //默认为float
            }
            R.id.btn_default_double_test -> {
                //默认为double
            }
            R.id.btn_default_string_test ->{
                //默认为string
            }
            R.id.btn_default_object_test ->{
                //默认为object
            }
            R.id.btn_default_array_test ->{
                //默认为array
            }
            R.id.btn_default_map_test ->{
                //默认为map
            }
            else -> {

            }

        }
    }

}
