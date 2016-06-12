package ua.opu.smartlock.tabs.keys;

import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import ua.opu.smartlock.R;
import ua.opu.smartlock.model.Key;

public class KeysAdapter extends RecyclerView.Adapter<KeysAdapter.ViewHolder> {

    List <Key> keys;

    public static class ViewHolder extends RecyclerView.ViewHolder {

        // Это поля для view holder`а
        public TextView name;
        public TextView phone;
        public TextView schedule;

        public ViewHolder(View v) {
            super(v);

            // присваиваем полям ссылки на виджеты пункта списка
            name = (TextView) v.findViewById(R.id.name);
            phone = (TextView) v.findViewById(R.id.phone);
            schedule = (TextView) v.findViewById(R.id.schedule);
        }
    }

    public KeysAdapter(List<Key> keys) {
        this.keys = keys;
    }

    @Override
    public KeysAdapter.ViewHolder onCreateViewHolder(ViewGroup parent,
                                                   int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.key_card, parent, false);
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    // В этом методе меняем значения виджетов пункта списка
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.name.setText(keys.get(position).name);
        holder.phone.setText(keys.get(position).phone);
        holder.schedule.setText(Html.fromHtml(keys.get(position).schedule.toString()));
    }

    @Override
    public int getItemCount() {
        return keys.size();
    }
}

