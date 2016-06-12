package ua.opu.smartlock.locks;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import ua.opu.smartlock.R;
import ua.opu.smartlock.model.Lock;
import ua.opu.smartlock.tabs.TabsActivity;

public class LocksAdapter extends RecyclerView.Adapter<LocksAdapter.ViewHolder> implements View.OnClickListener {

    List <Lock> locks;

    @Override
    public void onClick(View v) {
        Intent i = new Intent(v.getContext(), TabsActivity.class);
        v.getContext().startActivity(i);
        ((Activity)v.getContext()).overridePendingTransition(android.R.anim.slide_in_left,android.R.anim.slide_out_right);
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView name;
        public TextView description;

        public ViewHolder(View v) {
            super(v);

            name = (TextView) v.findViewById(R.id.name);
            description = (TextView) v.findViewById(R.id.description);
        }
    }

    public LocksAdapter(List<Lock> locks) {
        this.locks = locks;
    }

    @Override
    public LocksAdapter.ViewHolder onCreateViewHolder(ViewGroup parent,
                                                      int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.lock_card, parent, false);
        v.setOnClickListener(this);
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.name.setText(locks.get(position).name);
        holder.description.setText(locks.get(position).description);
    }

    @Override
    public int getItemCount() {
        return locks.size();
    }
}

