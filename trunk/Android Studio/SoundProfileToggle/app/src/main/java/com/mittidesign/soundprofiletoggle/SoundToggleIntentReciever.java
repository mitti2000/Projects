package com.mittidesign.soundprofiletoggle;

//Reciver Class to recieve the Click Event

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.media.AudioManager;
import android.util.Log;
import android.widget.RemoteViews;

public class SoundToggleIntentReciever extends BroadcastReceiver {

    //When the defined Click happens, do this
    @Override
    public void onReceive(Context context, Intent intent) {
        if (intent.getAction().equals("com.mittidesign.intent.action.CHANGE_IMAGE")) {
            updateWidgetPictureAndButtonListener(context);
        }
    }


    private void updateWidgetPictureAndButtonListener(Context context) {
        RemoteViews remoteViews = new RemoteViews(context.getPackageName(), R.layout.sound_toggle_layout);
        remoteViews.setImageViewResource(R.id.img_speaker, getImageToSet(context));
        remoteViews.setOnClickPendingIntent(R.id.img_speaker, SoundToggleWidgetProvider.getRefreshPendingIntent(context));
        SoundToggleWidgetProvider.pushWidgetUpdate(context.getApplicationContext(), remoteViews);
    }

    private int getImageToSet(Context context) {
        final AudioManager audioManager = (AudioManager) context.getSystemService(Context.AUDIO_SERVICE);
        if (audioManager.getRingerMode() == 1) {
            audioManager.setRingerMode(AudioManager.RINGER_MODE_NORMAL);
            return R.drawable.speaker2;
        }
        else if (audioManager.getRingerMode() == 2) {
            audioManager.setRingerMode(AudioManager.RINGER_MODE_VIBRATE);
            return R.drawable.vibra2;
        }
        return R.drawable.speaker2;
    }
}
