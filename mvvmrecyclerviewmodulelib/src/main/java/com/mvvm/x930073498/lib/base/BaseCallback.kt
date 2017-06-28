package com.mvvm.x930073498.lib.base

import android.content.Context
import android.databinding.BaseObservable

import android.support.v4.util.ArrayMap

/**
 * Created by x930073498 on 2017/6/28.
 */
abstract class BaseCallback : BaseObservable() {
    init {
        if (mTag == null) throw RuntimeException("must call BaseCallback#open(tag) first")
    }

    protected val mContext: Context = context!!
    private var tag: Any = mTag!!

    fun getTag(): Any {
        return tag
    }

    companion object {
        private var mTag: Any? = null
        private var context: Context? = null
        private val map: ArrayMap<Any, List<BaseCallback>> = ArrayMap()
        private var list: List<Any> = listOf()
        fun init(mContext: Context) {
            context = mContext
        }

        fun init(mContext: Context, tag: Any) {
            init(mContext)
            open(tag)
        }

        fun open(tag: Any) {
            mTag = tag
            list.plus(tag)
        }


        fun close(tag: Any) {
            list.minus(tag)
            mTag = list.lastOrNull()
        }

        fun close() {
            list.dropLast(1)
            mTag = list.last()
        }

        fun clear(tag: Any) {
            map.remove(tag)
        }

        fun destroy() {
            context = null
        }

    }

}

abstract class BaseData(var id: String)
