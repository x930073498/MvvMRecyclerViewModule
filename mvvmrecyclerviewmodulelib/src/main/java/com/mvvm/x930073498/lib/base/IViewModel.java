package com.mvvm.x930073498.lib.base;

import android.databinding.BaseObservable;
import android.databinding.Observable;

/**
 * Created by 930073498 on 2017/7/1.
 */

public interface IViewModel<T extends BaseData> {

    int getType();

    void setType(int type);

    T getData();

    void setData(T data);

    int getBindId();

    int getLayoutId();
}
