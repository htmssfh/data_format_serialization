package com.fangye.serialization.entity

/**
 * 列表
 */
class JsonItemEntity(var name: String, var json: String) {

    override fun toString(): String {
        return "JsonItemEntity{" +
                "name='" + name + '\'' +
                ", json='" + json + '\'' +
                '}'
    }

}