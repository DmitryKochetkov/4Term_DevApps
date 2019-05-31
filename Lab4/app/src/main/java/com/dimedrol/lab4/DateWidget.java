package com.dimedrol.lab4;

import android.app.Notification;
import android.app.NotificationManager;
import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.Context;
import android.support.v4.app.NotificationCompat;
import android.view.LayoutInflater;
import android.widget.RemoteViews;
import android.widget.TextView;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;

import static android.content.Context.NOTIFICATION_SERVICE;

/**
 * Implementation of App Widget functionality.
 */
public class DateWidget extends AppWidgetProvider {

    static Calendar aim;
    static boolean done = false;

    static void updateAppWidget(Context context, AppWidgetManager appWidgetManager,
                                int appWidgetId) {


        // Construct the RemoteViews object
        RemoteViews views = new RemoteViews(context.getPackageName(), R.layout.date_widget);

        DateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy", Locale.getDefault());
        Date d = aim.getTime();
        views.setTextViewText(R.id.date_text, "Notification date: " + dateFormat.format(d));
        //views.setTextViewText(R.id.date_text, "Notification date: " + dateFormat.format(aim.getTime()));

        // Instruct the widget manager to update the widget
        appWidgetManager.updateAppWidget(appWidgetId, views);
    }

    @Override
    public void onUpdate(Context context, AppWidgetManager appWidgetManager, int[] appWidgetIds) {
        // There may be multiple widgets active, so update all of them
        for (int appWidgetId : appWidgetIds) {
            updateAppWidget(context, appWidgetManager, appWidgetId);
        }
        Calendar now = new GregorianCalendar();
        now.add(Calendar.DAY_OF_YEAR, 1); //убрать
        DateFormat day = new SimpleDateFormat("dd", Locale.getDefault());
        DateFormat hour = new SimpleDateFormat("hh", Locale.getDefault());
        if (hour.format(now.getTime()) == "10" && !done)
        {
            done = true;
            NotificationCompat.Builder builder =
                    new NotificationCompat.Builder(context)
                            .setSmallIcon(R.mipmap.ic_launcher)
                            .setContentTitle("Date Notification")
                            .setContentText("It's 9 o'clock!");

            Notification notification = builder.build();

            NotificationManager notificationManager = (NotificationManager) context.getSystemService(NOTIFICATION_SERVICE);
            notificationManager.notify(1, notification);
        }
    }

    @Override
    public void onEnabled(Context context) {
        aim = new GregorianCalendar();
        aim.add(Calendar.DAY_OF_YEAR, 1);
    }

    @Override
    public void onDisabled(Context context) {
        // Enter relevant functionality for when the last widget is disabled
    }
}

