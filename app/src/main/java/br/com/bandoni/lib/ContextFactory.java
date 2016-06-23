package br.com.bandoni.lib;

import android.app.Application;
import android.content.Context;

/**
 * Created by gustavo.bandoni on 14/06/2016.
 */
public class ContextFactory extends Application
{

    private static Context mContext;

    @Override
    public void onCreate() {
        super.onCreate();
        mContext = getApplicationContext();
    }

    public static Context getContext() {
        return mContext;
    }
}
