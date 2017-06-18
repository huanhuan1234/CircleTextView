package hhh.bawei.com.seconda;

import android.app.Application;

import org.xutils.x;

/**
 * Created by Huangminghuan on 2017/6/17.
 */

public class MyApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();

        x.Ext.init(this);
    }
}
