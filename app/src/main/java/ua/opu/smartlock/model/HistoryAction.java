package ua.opu.smartlock.model;

import android.graphics.drawable.Drawable;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import ua.opu.smartlock.R;

public class HistoryAction {

    public Date timestamp;
    public int action;
    public String description;

    public HistoryAction(int action, String description, Date timestamp) {
        this.action = action;
        this.description = description;
        this.timestamp = timestamp;
    }

    public int getActionResource() {
        switch (action) {
            case History.ACTION_KEY_ADD:
                return R.drawable.ic_key_add;

            case History.ACTION_KEY_REMOVE:
                return R.drawable.ic_key_add;

            case History.ACTION_LOCK_OPEN:
                return R.drawable.ic_key_add;

            case History.ACTION_LOCK_CLOSE:
                return R.drawable.ic_key_add;

            case History.ACTION_LOCK_MANUAL_OPEN:
                return R.drawable.ic_key_add;

            case History.ACTION_LOCK_MANUAL_CLOSE:
                return R.drawable.ic_key_add;

            default:
                return 0;
        }
    }

    public String getTimestamp() {
        DateFormat formatter = new SimpleDateFormat("dd MMM H:mm");
        return formatter.format(timestamp);
    }

}
