package com.mvvm.x930073498.lib.base;

import android.content.Context;
import android.support.v4.util.ArrayMap;
import android.util.SparseIntArray;

import java.lang.ref.WeakReference;

/**
 * Created by 930073498 on 2017/7/1.
 */

public abstract class BaseBridge {
    private static final String defaultTag = BaseBridge.class.getName();
    private static int currentType = 0;

    private static Object currentTag;
    private static ViewModelPool currentPool;


    private static WeakReference<Context> mContext;
    private static ArrayMap<Object, ViewModelPool> pools;

    private static SparseIntArray layouts;


    private static Context getContext() {
        checkInit();
        return mContext.get();
    }

    public static void init(Context context) {
        mContext = new WeakReference<>(context);
        pools = new ArrayMap<>();
        layouts = new SparseIntArray();
    }

    public static void init(Context context, Object tag) {

    }


    public static void open() {
        open(defaultTag);
    }

    public static void close() {

    }

    public static void open(Object tag) {
        openPool(tag);
    }

    public static void close(Object tag) {
        checkOpened(tag);
    }

    private static void checkInit() {

    }

    private static void checkOpened(Object tag) {
        checkInit();

    }


    public static ViewModelPool add(IViewModel model) {
        checkOpened(currentTag);
        setType(model);
        currentPool.add(model);
        return currentPool;
    }

    private static void openPool(Object tag) {
        checkInit();
        currentPool = pools.get(tag);
        if (currentPool == null) currentPool = new ViewModelPool();
        currentTag = tag;
    }

    private static void setType(IViewModel model) {
        int index = layouts.indexOfValue(model.getType());
        if (index < 0) {
            model.setType(currentType);
            layouts.put(currentType, model.getLayoutId());
            currentType++;
        } else {
            model.setType(layouts.keyAt(index));
        }
    }
    public static void destroy(){

    }
}
