package org.some.pkg.entity;

/**
 * Created by siarqua on 10.08.15.
 */
public enum ActivityType {
    LOGING(1), SPINNING(2), CYCLING(3), GYM(4);

    private int activityTypeNumber;

    public int getActivityTypeNumber() {
        return activityTypeNumber;
    }

    public void setActivityTypeNumber(int activityTypeNumber) {
        this.activityTypeNumber = activityTypeNumber;
    }

    private ActivityType(int i) {
        activityTypeNumber = i;

    }
}
