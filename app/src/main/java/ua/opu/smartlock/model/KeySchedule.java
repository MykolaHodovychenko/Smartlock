package ua.opu.smartlock.model;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class KeySchedule {

    boolean isPersistent;

    Date startDate;
    Date endDate;

    public KeySchedule(boolean isPersistent) {
        this.isPersistent = isPersistent;
    }

    @Override
    public String toString() {

        if (isPersistent) {
            return "This key is <b>permanent</b>";
        } else {
            DateFormat formatter = new SimpleDateFormat("dd MMM H:mm");
            return "This key is valid <br>from <b>" + formatter.format(new Date()) + "</b> till <b>" + formatter.format(new Date()) + "</b>";
        }
    }
}
