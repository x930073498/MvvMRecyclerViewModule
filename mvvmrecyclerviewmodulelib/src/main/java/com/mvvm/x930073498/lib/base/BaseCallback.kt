package com.mvvm.x930073498.lib.base

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Context
import android.content.Intent
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
    private var id: Int? = null

    fun getId(): Int {
        return id!!
    }

    private fun setId(id: Int) {
        this.id = id
    }

    fun getTag(): Any {
        return tag
    }

    companion object {
        private var index: Int = 0
        private var mTag: Any? = null
        @SuppressLint("StaticFieldLeak")
        private var context: Context? = null
        private val map: ArrayMap<Any, List<BaseCallback>> = ArrayMap()
        private var list: List<Any> = listOf()
        private var tags: List<Any> = listOf()
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
            tags.plus(tag)
        }

        fun add(vararg callback: BaseCallback) {
        }

        fun add(callback: BaseCallback) {

        }

        fun add(callbacks: List<BaseCallback>) {

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

inline fun <reified T> Activity.startActivity(){
    startActivity(Intent(this,T::class.java))
}
