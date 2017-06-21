package com.project.jebus.appsolar.ui.view;

import android.content.Context;

/**
 * Created by jebus on 11/08/15.
 */
public interface ListVideoView {

    void serviceResult(Object object, int type);
    void serviceError(Object object, int type);
    Context getViewContext();
}
