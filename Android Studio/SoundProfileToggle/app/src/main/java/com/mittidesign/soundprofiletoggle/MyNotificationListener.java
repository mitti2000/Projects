package com.mittidesign.soundprofiletoggle;

import android.service.notification.NotificationListenerService;

public class MyNotificationListener extends NotificationListenerService {

    @Override
    public void onInterruptionFilterChanged(int interruptionFilter) {
        super.onInterruptionFilterChanged(interruptionFilter);
        if(getCurrentInterruptionFilter()==INTERRUPTION_FILTER_PRIORITY){
            requestInterruptionFilter(INTERRUPTION_FILTER_NONE);
        }
    }
}
