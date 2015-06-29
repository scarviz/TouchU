package com.github.scarviz.touchu;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

import com.unity3d.player.UnityPlayer;

public class TouchServiceCtrl {
    private static final String TAG = "TouchServiceCtrl";

    /**
     * サービスを起動する
     *
     * @param gameObjectNm
     */
    public void startService(String gameObjectNm) {
        Log.d(TAG, "startService");
        Activity activity = UnityPlayer.currentActivity;
        Context context = activity.getApplicationContext();

        Intent intent = new Intent(context, TouchUService.class);
        intent.putExtra(TouchUService.KEY_GAME_OBJ_NM, gameObjectNm);
        activity.startService(intent);
    }

    /**
     * サービスを停止する
     */
    public void stopService() {
        Log.d(TAG, "stopService");
        Activity activity = UnityPlayer.currentActivity;
        Context context = activity.getApplicationContext();
        activity.stopService(new Intent(context, TouchUService.class));
    }
}
