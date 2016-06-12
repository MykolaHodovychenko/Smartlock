package ua.opu.smartlock.tabs.history;

import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import ua.opu.smartlock.R;
import ua.opu.smartlock.model.History;
import ua.opu.smartlock.model.HistoryAction;
import ua.opu.smartlock.model.Key;

public class HistoryAdapter extends RecyclerView.Adapter<HistoryAdapter.ViewHolder> {

    List <HistoryAction> historyActions;

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView timestamp;
        public ImageView action;
        public TextView description;

        public ViewHolder(View v) {
            super(v);

            timestamp = (TextView) v.findViewById(R.id.timestamp);
            action = (ImageView) v.findViewById(R.id.action_image);
            description = (TextView) v.findViewById(R.id.description);
        }
    }

    public HistoryAdapter(List<HistoryAction> historyActions) {
        this.historyActions = historyActions;
    }

    @Override
    public HistoryAdapter.ViewHolder onCreateViewHolder(ViewGroup parent,
                                                        int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.history_list_item, parent, false);
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.timestamp.setText(historyActions.get(position).getTimestamp());
        holder.action.setImageResource(historyActions.get(position).getActionResource());
        holder.description.setText(historyActions.get(position).description);
    }

    @Override
    public int getItemCount() {
        return historyActions.size();
    }
}

