package com.fangye.serialization.utils

import com.fangye.serialization.DataJsonActivity
import com.fangye.serialization.entity.JsonItemEntity

/**
 * 数据准备工具类
 * @Package: com.fangye.serialization.utils
 * @Author: fanyeren51@gmail.com
 * @UpdateDate: 2020/05/05 06:40
 */
class DataUtils {
    companion object{
        fun getList(type:Int):MutableList<JsonItemEntity>?{
            when (type) {
                DataJsonActivity.TYPE_SHORT -> return getShortList()
                DataJsonActivity.TYPE_INT -> return getIntList()
                DataJsonActivity.TYPE_LONG -> return getLongList()
                DataJsonActivity.TYPE_FLOAT -> return getFloatList()
                DataJsonActivity.TYPE_DOUBLE -> return getDoubleList()
                DataJsonActivity.TYPE_STRING -> return getStringList()
                DataJsonActivity.TYPE_OBJECT -> return getObjectList()
                DataJsonActivity.TYPE_ARRAY -> return getArrayList()
                DataJsonActivity.TYPE_MAP -> return getMapList()
            }
           return null
        }


        private fun getObjectList(): MutableList<JsonItemEntity> {
            val list = mutableListOf<JsonItemEntity>()
            return list
        }

        private fun getArrayList(): MutableList<JsonItemEntity> {
            val list = mutableListOf<JsonItemEntity>()
            return list
        }

        private fun getMapList(): MutableList<JsonItemEntity> {
            val list = mutableListOf<JsonItemEntity>()
            return list
        }

        private fun getStringList(): MutableList<JsonItemEntity> {
            val list = mutableListOf<JsonItemEntity>()
            val dataIntFloatName0 = "要string,给的float/double,可正常解析"
            val dataIntFloatJson0 = "{\"id\":122342424232424.333,\"name\":\"sssss\"}"

            val dataIntFloatName1 = "要string ，给的int/short/long,可正常解析"
            val dataIntFloatJson1 = "{\"id\":12234242423,\"name\":\"sssss\"}"

            val dataIntFloatName2 = "要string ,给的boolean ,可正常解析，返回字符串boolean"
            val dataIntFloatJson2 = "{\"id\":true,\"name\":\"sssss\"}"

            val dataIntFloatName3 = "要string ，给的空字符串 ，可正常解析，返回空字符串"
            val dataIntFloatJson3 = "{\"id\":\"\",\"name\":\"sssss\"}"

            val dataIntFloatName4 = "要string ，给的字符串 ，可正常解析，返回字符串"
            val dataIntFloatJson4 = "{\"id\":\"sdssdfs\",\"name\":\"sssss\"}"

            val dataIntFloatName5 = "要string ，给的字符串boolean，可正常解析，返回字符串boolean"
            val dataIntFloatJson5 = "{\"id\":\"true\",\"name\":\"sssss\"}"

            val dataIntFloatName6 = "要string 给的字符串float/double ，可正常解析，返回字符串float/double"
            val dataIntFloatJson6 = "{\"id\":\"16.33\",\"name\":\"sssss\"}"

            val dataIntFloatName7 = "要string 给的字符串int/long/short ，可正常解析,返回该字符串"
            val dataIntFloatJson7 = "{\"id\":\"1564564646464646464466\",\"name\":\"sssss\"}"

            val dataIntFloatName8 = "要string 给的object，返回转义的字符串"
            val dataIntFloatJson8 = "{\"id\":{\"aa\":\"00\"},\"name\":\"sssss\"}"

            val dataIntFloatName9 = "要string 给的array，返回转义的字符串"
            val dataIntFloatJson9 = "{\"id\":[{\"aa\":\"00\"}],\"name\":\"sssss\"}"

            list.add(JsonItemEntity(dataIntFloatName0, dataIntFloatJson0))
            list.add(JsonItemEntity(dataIntFloatName1, dataIntFloatJson1))
            list.add(JsonItemEntity(dataIntFloatName2, dataIntFloatJson2))
            list.add(JsonItemEntity(dataIntFloatName3, dataIntFloatJson3))
            list.add(JsonItemEntity(dataIntFloatName4, dataIntFloatJson4))
            list.add(JsonItemEntity(dataIntFloatName5, dataIntFloatJson5))
            list.add(JsonItemEntity(dataIntFloatName6, dataIntFloatJson6))
            list.add(JsonItemEntity(dataIntFloatName7, dataIntFloatJson7))
            list.add(JsonItemEntity(dataIntFloatName8, dataIntFloatJson8))
            list.add(JsonItemEntity(dataIntFloatName9, dataIntFloatJson9))
            return list
        }


        private fun getDoubleList(): MutableList<JsonItemEntity> {
            val list = mutableListOf<JsonItemEntity>()
            val dataIntFloatName0 = "要double ，给的float/double,可正常解析"
            val dataIntFloatJson0 = "{\"id\":122342424232424.333,\"name\":\"sssss\"}"

            val dataIntFloatName1 = "要double ，给的int/short/long,可正常解析"
            val dataIntFloatJson1 = "{\"id\":12234242423,\"name\":\"sssss\"}"

            val dataIntFloatName2 = "要double ,给的boolean ,返回0.0"
            val dataIntFloatJson2 = "{\"id\":true,\"name\":\"sssss\"}"

            val dataIntFloatName3 = "要double ，给的空字符串 ，返回0.0"
            val dataIntFloatJson3 = "{\"id\":\"\",\"name\":\"sssss\"}"

            val dataIntFloatName4 = "要double ，给的字符串 ，返回0.0"
            val dataIntFloatJson4 = "{\"id\":\"sdssdfs\",\"name\":\"sssss\"}"

            val dataIntFloatName5 = "要double ，给的字符串boolean，返回0.0"
            val dataIntFloatJson5 = "{\"id\":\"true\",\"name\":\"sssss\"}"

            val dataIntFloatName6 = "要double 给的字符串float/double ,没有问题，可正常解析"
            val dataIntFloatJson6 = "{\"id\":\"16.33\",\"name\":\"sssss\"}"

            val dataIntFloatName7 = "要double 给的字符串int/long/short ,没有问题，可正常解析"
            val dataIntFloatJson7 = "{\"id\":\"1564564646464646464466\",\"name\":\"sssss\"}"

            val dataIntFloatName8 = "要double 给的object，返回0.0"
            val dataIntFloatJson8 = "{\"id\":{\"aa\":\"00\"},\"name\":\"sssss\"}"

            val dataIntFloatName9 = "要double 给的array，返回0.0"
            val dataIntFloatJson9 = "{\"id\":[{\"aa\":\"00\"}],\"name\":\"sssss\"}"

            list.add(JsonItemEntity(dataIntFloatName0, dataIntFloatJson0))
            list.add(JsonItemEntity(dataIntFloatName1, dataIntFloatJson1))
            list.add(JsonItemEntity(dataIntFloatName2, dataIntFloatJson2))
            list.add(JsonItemEntity(dataIntFloatName3, dataIntFloatJson3))
            list.add(JsonItemEntity(dataIntFloatName4, dataIntFloatJson4))
            list.add(JsonItemEntity(dataIntFloatName5, dataIntFloatJson5))
            list.add(JsonItemEntity(dataIntFloatName6, dataIntFloatJson6))
            list.add(JsonItemEntity(dataIntFloatName7, dataIntFloatJson7))
            list.add(JsonItemEntity(dataIntFloatName8, dataIntFloatJson8))
            list.add(JsonItemEntity(dataIntFloatName9, dataIntFloatJson9))
            return list
        }

        private fun getFloatList(): MutableList<JsonItemEntity> {
            val list = mutableListOf<JsonItemEntity>()
            val dataIntFloatName0 = "要float ，给的float/double,可正常解析"
            val dataIntFloatJson0 = "{\"id\":122342424232424.333,\"name\":\"sssss\"}"

            val dataIntFloatName1 = "要float ，给的int/short/long,可正常解析"
            val dataIntFloatJson1 = "{\"id\":1223424456462423,\"name\":\"sssss\"}"

            val dataIntFloatName2 = "要float ,给的boolean ,返回0.0"
            val dataIntFloatJson2 = "{\"id\":true,\"name\":\"sssss\"}"

            val dataIntFloatName3 = "要float ，给的空字符串 ，返回0.0"
            val dataIntFloatJson3 = "{\"id\":\"\",\"name\":\"sssss\"}"

            val dataIntFloatName4 = "要float ，给的字符串 ，返回0.0"
            val dataIntFloatJson4 = "{\"id\":\"sdssdfs\",\"name\":\"sssss\"}"

            val dataIntFloatName5 = "要float ，给的字符串boolean，返回0.0"
            val dataIntFloatJson5 = "{\"id\":\"true\",\"name\":\"sssss\"}"

            val dataIntFloatName6 = "要float 给的字符串float/double ,没有问题，可正常解析"
            val dataIntFloatJson6 = "{\"id\":\"16.33\",\"name\":\"sssss\"}"

            val dataIntFloatName7 = "要float 给的字符串int/long/short ,没有问题，可正常解析"
            val dataIntFloatJson7 = "{\"id\":\"1635353534535353553\",\"name\":\"sssss\"}"

            val dataIntFloatName8 = "要float 给的object，返回0.0"
            val dataIntFloatJson8 = "{\"id\":{\"aa\":\"00\"},\"name\":\"sssss\"}"

            val dataIntFloatName9 = "要float 给的array，返回0.0"
            val dataIntFloatJson9 = "{\"id\":[{\"aa\":\"00\"}],\"name\":\"sssss\"}"

            list.add(JsonItemEntity(dataIntFloatName0, dataIntFloatJson0))
            list.add(JsonItemEntity(dataIntFloatName1, dataIntFloatJson1))
            list.add(JsonItemEntity(dataIntFloatName2, dataIntFloatJson2))
            list.add(JsonItemEntity(dataIntFloatName3, dataIntFloatJson3))
            list.add(JsonItemEntity(dataIntFloatName4, dataIntFloatJson4))
            list.add(JsonItemEntity(dataIntFloatName5, dataIntFloatJson5))
            list.add(JsonItemEntity(dataIntFloatName6, dataIntFloatJson6))
            list.add(JsonItemEntity(dataIntFloatName7, dataIntFloatJson7))
            list.add(JsonItemEntity(dataIntFloatName8, dataIntFloatJson8))
            list.add(JsonItemEntity(dataIntFloatName9, dataIntFloatJson9))
            return list
        }

        private fun getLongList(): MutableList<JsonItemEntity> {
            val list = mutableListOf<JsonItemEntity>()
            val dataIntFloatName0 = "要long ，给的为long/int/short ,数据正常，解析正常"
            val dataIntFloatJson0 = "{\"id\":122222221222,\"name\":\"sssss\"}"

            //todo
            val dataIntFloatName1 = "要long ，给的float或者double ,会崩溃"
            val dataIntFloatJson1 = "{\"id\":1.6,\"name\":\"sssss\"}"

            val dataIntFloatName3 = "要long ,给的boolean ,返回0"
            val dataIntFloatJson3 = "{\"id\":true,\"name\":\"sssss\"}"

            val dataIntFloatName4 = "要long ，给的空字符串 ，返回0"
            val dataIntFloatJson4 = "{\"id\":\"\",\"name\":\"sssss\"}"

            val dataIntFloatName5 = "要long ，给的字符串 ，返回0"
            val dataIntFloatJson5 = "{\"id\":\"sdssdfs\",\"name\":\"sssss\"}"

            val dataIntFloatName6 = "要long ，给的字符串boolean，返回0"
            val dataIntFloatJson6 = "{\"id\":\"true\",\"name\":\"sssss\"}"

            val dataIntFloatName7 = "要long 给的字符串int/long/short ,没有问题，可正常解析"
            val dataIntFloatJson7 = "{\"id\":\"16\",\"name\":\"sssss\"}"

            val dataIntFloatName8 = "要long 给的字符串float/double ,返回0"
            val dataIntFloatJson8 = "{\"id\":\"1.6555555\",\"name\":\"sssss\"}"

            val dataIntFloatName9 = "要long 给的object，返回0"
            val dataIntFloatJson9 = "{\"id\":{\"aa\":\"00\"},\"name\":\"sssss\"}"

            val dataIntFloatName10 = "要long 给的array，返回0"
            val dataIntFloatJson10 = "{\"id\":[{\"aa\":\"00\"}],\"name\":\"sssss\"}"

            list.add(JsonItemEntity(dataIntFloatName0, dataIntFloatJson0))
            list.add(JsonItemEntity(dataIntFloatName1, dataIntFloatJson1))
//            list.add(JsonItemEntity(dataIntFloatName2, dataIntFloatJson2))
            list.add(JsonItemEntity(dataIntFloatName3, dataIntFloatJson3))
            list.add(JsonItemEntity(dataIntFloatName4, dataIntFloatJson4))
            list.add(JsonItemEntity(dataIntFloatName5, dataIntFloatJson5))
            list.add(JsonItemEntity(dataIntFloatName6, dataIntFloatJson6))
            list.add(JsonItemEntity(dataIntFloatName7, dataIntFloatJson7))
            list.add(JsonItemEntity(dataIntFloatName8, dataIntFloatJson8))
            list.add(JsonItemEntity(dataIntFloatName9, dataIntFloatJson9))
            list.add(JsonItemEntity(dataIntFloatName10, dataIntFloatJson10))
            return list
        }



        private fun getIntList(): MutableList<JsonItemEntity> {
            val list = mutableListOf<JsonItemEntity>()
            val dataIntFloatName0 = "要int ，给的为int/short ,数据正常，解析正常"
            val dataIntFloatJson0 = "{\"id\":100,\"name\":\"sssss\"}"

            //todo
            val dataIntFloatName1 = "要int ，给的float或者double ,会崩溃"
            val dataIntFloatJson1 = "{\"id\":1.6,\"name\":\"sssss\"}"

            //todo
            val dataIntFloatName2 = "要int ，返回long，会崩溃，属于正常现象"
            val dataIntFloatJson2 = "{\"id\":21474836477,\"name\":\"sssss\"}"

            val dataIntFloatName3 = "要int ,给的boolean ,返回0"
            val dataIntFloatJson3 = "{\"id\":true,\"name\":\"sssss\"}"

            val dataIntFloatName4 = "要int ，给的空字符串 ，返回0"
            val dataIntFloatJson4 = "{\"id\":\"\",\"name\":\"sssss\"}"

            val dataIntFloatName5 = "要int ，给的字符串 ，返回0"
            val dataIntFloatJson5 = "{\"id\":\"sdssdfs\",\"name\":\"sssss\"}"

            val dataIntFloatName6 = "要int ，给的字符串boolean，返回0"
            val dataIntFloatJson6 = "{\"id\":\"true\",\"name\":\"sssss\"}"

            val dataIntFloatName7 = "要int 给的字符串int/short ,没有问题，可正常解析"
            val dataIntFloatJson7 = "{\"id\":\"16\",\"name\":\"sssss\"}"

            //todo ,最好是崩溃
            val dataIntFloatName7_1 = "要int ，给的字符串long，返回0"
            val dataIntFloatJson7_1 = "{\"id\":\"1623332234234242\",\"name\":\"sssss\"}"

            val dataIntFloatName8 = "要int 给的字符串float/double ,返回0"
            val dataIntFloatJson8 = "{\"id\":\"1.6555555\",\"name\":\"sssss\"}"

            val dataIntFloatName9 = "要int 给的object，返回0"
            val dataIntFloatJson9 = "{\"id\":{\"aa\":\"00\"},\"name\":\"sssss\"}"

            val dataIntFloatName10 = "要int 给的array，返回0"
            val dataIntFloatJson10 = "{\"id\":[{\"aa\":\"00\"}],\"name\":\"sssss\"}"

            list.add(JsonItemEntity(dataIntFloatName0, dataIntFloatJson0))
            list.add(JsonItemEntity(dataIntFloatName1, dataIntFloatJson1))
            list.add(JsonItemEntity(dataIntFloatName2, dataIntFloatJson2))
            list.add(JsonItemEntity(dataIntFloatName3, dataIntFloatJson3))
            list.add(JsonItemEntity(dataIntFloatName4, dataIntFloatJson4))
            list.add(JsonItemEntity(dataIntFloatName5, dataIntFloatJson5))
            list.add(JsonItemEntity(dataIntFloatName6, dataIntFloatJson6))
            list.add(JsonItemEntity(dataIntFloatName7, dataIntFloatJson7))
            list.add(JsonItemEntity(dataIntFloatName7_1, dataIntFloatJson7_1))
            list.add(JsonItemEntity(dataIntFloatName8, dataIntFloatJson8))
            list.add(JsonItemEntity(dataIntFloatName9, dataIntFloatJson9))
            list.add(JsonItemEntity(dataIntFloatName10, dataIntFloatJson10))
            return list
        }

        private fun getShortList(): MutableList<JsonItemEntity> {
            val list = mutableListOf<JsonItemEntity>()
            val dataIntFloatName0 = "要short ，给的为short ,数据正常，解析正常"
            val dataIntFloatJson0 = "{\"id\":1,\"name\":\"sssss\"}"

            //todo
            val dataIntFloatName1 = "要short ，给的float或者double ,会崩溃"
            val dataIntFloatJson1 = "{\"id\":1.6,\"name\":\"sssss\"}"

            //todo
            val dataIntFloatName2 = "要short ，short（-32768 32767）给的括号之外会的值（int/long），返回数据有问题"
            val dataIntFloatJson2 = "{\"id\":3278845,\"name\":\"sssss\"}"

            val dataIntFloatName3 = "要short ,给的boolean ,返回0"
            val dataIntFloatJson3 = "{\"id\":true,\"name\":\"sssss\"}"

            val dataIntFloatName4 = "要short ，给的空字符串 ，返回0"
            val dataIntFloatJson4 = "{\"id\":\"\",\"name\":\"sssss\"}"

            val dataIntFloatName5 = "要short ，给的字符串 ，返回0"
            val dataIntFloatJson5 = "{\"id\":\"sdssdfs\",\"name\":\"sssss\"}"

            val dataIntFloatName6 = "要short ，给的字符串boolean，返回0"
            val dataIntFloatJson6 = "{\"id\":\"true\",\"name\":\"sssss\"}"

            val dataIntFloatName7 = "要short 给的字符串short ,没有问题，可正常解析"
            val dataIntFloatJson7 = "{\"id\":\"16\",\"name\":\"sssss\"}"

            //todo
            val dataIntFloatName7_1 = "要short 给的字符串short ,超过short取值范围（-32768 32767）, 返回数据有问题"
            val dataIntFloatJson7_1 = "{\"id\":\"327671\",\"name\":\"sssss\"}"

            val dataIntFloatName8 = "要short 给的字符串float/double ,返回0"
            val dataIntFloatJson8 = "{\"id\":\"1.6555555\",\"name\":\"sssss\"}"

            val dataIntFloatName9 = "要short 给的object，返回0"
            val dataIntFloatJson9 = "{\"id\":{\"aa\":\"00\"},\"name\":\"sssss\"}"

            val dataIntFloatName10 = "要short 给的array，返回0"
            val dataIntFloatJson10 = "{\"id\":[{\"aa\":\"00\"}],\"name\":\"sssss\"}"

            list.add(JsonItemEntity(dataIntFloatName0, dataIntFloatJson0))
            list.add(JsonItemEntity(dataIntFloatName1, dataIntFloatJson1))
            list.add(JsonItemEntity(dataIntFloatName2, dataIntFloatJson2))
            list.add(JsonItemEntity(dataIntFloatName3, dataIntFloatJson3))
            list.add(JsonItemEntity(dataIntFloatName4, dataIntFloatJson4))
            list.add(JsonItemEntity(dataIntFloatName5, dataIntFloatJson5))
            list.add(JsonItemEntity(dataIntFloatName6, dataIntFloatJson6))
            list.add(JsonItemEntity(dataIntFloatName7, dataIntFloatJson7))
            list.add(JsonItemEntity(dataIntFloatName7_1, dataIntFloatJson7_1))
            list.add(JsonItemEntity(dataIntFloatName8, dataIntFloatJson8))
            list.add(JsonItemEntity(dataIntFloatName9, dataIntFloatJson9))
            list.add(JsonItemEntity(dataIntFloatName10, dataIntFloatJson10))
            return list
        }


    }


}