package com.mvvm.x930073498.lib.base;

import android.databinding.BaseObservable;

/**
 * Created by 930073498 on 2017/7/1.
 */

public class BaseData extends BaseObservable {
    private String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
