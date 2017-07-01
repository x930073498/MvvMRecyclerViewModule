package com.mvvm.x930073498.lib.base;

import android.databinding.Bindable;

/**
 * Created by 930073498 on 2017/7/1.
 */

public abstract class BaseViewModel<T extends BaseData> implements IViewModel<T> {
    private T data;
    private int type;

    @Override
    public int getType() {
        return type;
    }

    @Override
    public void setType(int type) {
        this.type = type;
    }

    @Override
    public T getData() {
        return data;
    }

    @Override
    public void setData(T data) {
        this.data = data;
    }

    @Override
    public abstract int getBindId();

    @Override
    public abstract int getLayoutId();
}
