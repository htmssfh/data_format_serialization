package com.fangye.serialization

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.fangye.serialization.R
import com.fangye.serialization.databinding.ActivityDataInputjsonBinding

class DataInputJsonActivity:AppCompatActivity(), View.OnClickListener {
    private lateinit var mViewBinding: ActivityDataInputjsonBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mViewBinding = ActivityDataInputjsonBinding.inflate(LayoutInflater.from(this))
        setContentView(mViewBinding.root)

        mViewBinding?.btnDataParser.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when(v?.id){
            R.id.btn_data_parser ->{

            }
            R.id.btn_data_clean ->{

            }
        }
    }
}