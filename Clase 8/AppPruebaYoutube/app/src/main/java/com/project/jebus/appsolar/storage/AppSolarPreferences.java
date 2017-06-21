package com.project.jebus.appsolar.storage;

import android.content.Context;
import android.content.SharedPreferences;

import com.project.jebus.appsolar.model.UserEntity;
import com.project.jebus.appsolar.ui.coreJebus.JSONJebus;

/**
 * Created by jebus on 17/04/15.
 */
public class AppSolarPreferences {

    protected static final String ISEND = "APP_SOLAR";
    protected static final String USER = "USER";

    protected static SharedPreferences mSettings;
    protected static SharedPreferences.Editor mEditor;

    private static void initSharedPreferences(Context ctx) {
        if (mSettings == null) {
            mSettings = ctx.getSharedPreferences(ISEND, Context.MODE_PRIVATE);
        }
        mEditor = mSettings.edit();
    }

    /**
     * Preferences USUARIO
     */
    public static void saveUser(Context context, UserEntity userEntity) {
        initSharedPreferences(context);

        mEditor.putString(USER, JSONJebus.generateJSONObject(userEntity).toString());
        mEditor.commit();
    }

    public static UserEntity getUser(Context context) {
        initSharedPreferences(context);
        String userString = mSettings.getString(USER, "");
        UserEntity userEntity = (UserEntity) JSONJebus.jsonStringToObject(userString, UserEntity.class);
        return userEntity;
    }

    public static void deleteUser(Context context) {
        initSharedPreferences(context);
        mEditor.putString(USER, null);
        mEditor.commit();
    }
}