package com.mittidesign.soundprofiletoggle;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.media.AudioManager;
import android.widget.RemoteViews;

public class RingerModeIntentReciever extends BroadcastReceiver {

    //When the defined Click happens, do this
    @Override
    public void onReceive(Context context, Intent intent) {
        if (intent.getAction().equals("android.media.RINGER_MODE_CHANGED")) {
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
        if (audioManager.getRingerMode() == 0) {
            return R.drawable.mute2;
        }
        else if (audioManager.getRingerMode() == 1) {
            return R.drawable.vibra2;
        }
        else if (audioManager.getRingerMode() == 2) {
            return R.drawable.speaker2;
        }

        return R.drawable.speaker2;
    }

}