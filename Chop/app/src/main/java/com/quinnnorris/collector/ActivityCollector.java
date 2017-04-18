package com.quinnnorris.collector;

import android.app.Activity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by QuinnNorris on 2017/4/18.
 */

public class ActivityCollector {

    public static List<Activity> activities = new ArrayList<>();

    /**
     * Add an activity to the list.
     *
     * @param activity Activities to be added
     */
    public static void addActivity(Activity activity) {
        activities.add(activity);
    }

    /**
     * Delete an activity from the list.
     *
     * @param activity Activities to be deleted
     */
    public static void removeActivity(Activity activity) {
        activities.remove(activity);
    }

    /**
     * Stop all activities.
     */
    public static void finishAll() {
        for (Activity activity : activities) {
            if (!activity.isFinishing())
                activity.finish();
        }
        activities.clear();
    }

}
