package com.mittidesign.soundprofiletoggle;

//Class for the Widget Provider

import android.app.PendingIntent;
import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.widget.RemoteViews;

public class SoundToggleWidgetProvider extends AppWidgetProvider {


    //Called on regular Widget Update defined in Manifest
    @Override
    public void onUpdate(Context context, AppWidgetManager appWidgetManager, int[] appWidgetIds) {
        //Get a RemoteView
        RemoteViews remoteViews = new RemoteViews(context.getPackageName(), R.layout.sound_toggle_layout);
        //Load the custom pending intent into to the onClick
        remoteViews.setOnClickPendingIntent(R.id.img_speaker, getRefreshPendingIntent(context));
        //Update Widget
        pushWidgetUpdate(context, remoteViews);
    }

    //Custom Pending Intent
    public static PendingIntent getRefreshPendingIntent(Context context){
        //Get Intent Object
        Intent changeProfileIntent = new Intent();
        //Set the intents action to the one defined in the Manifest
        changeProfileIntent.setAction("com.mittidesign.intent.action.CHANGE_IMAGE");
        //return the Pending Intent
        return PendingIntent.getBroadcast(context, 0, changeProfileIntent, PendingIntent.FLAG_UPDATE_CURRENT);
    }

    //Start Widget Update
    public static void pushWidgetUpdate(Context context, RemoteViews remoteViews) {
        //Load the Widget into a Component
        ComponentName myWidget = new ComponentName(context, SoundToggleWidgetProvider.class);
        // Get the Appwidgetmanager
        AppWidgetManager manager = AppWidgetManager.getInstance(context);
        //Update the Widget
        manager.updateAppWidget(myWidget, remoteViews);
    }
}


