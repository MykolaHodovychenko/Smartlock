package ua.opu.smartlock.locks;

import android.graphics.Rect;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import ua.opu.smartlock.R;
import ua.opu.smartlock.model.Lock;

public class LocksFragment extends Fragment {

    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    List<Lock> locks;

    View rootView;

    public LocksFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        rootView = inflater.inflate(R.layout.fragment_locks, container, false);

        locks = populateLocks();
        setActiveKeysTextView();

        mRecyclerView = (RecyclerView) rootView.findViewById(R.id.locks_list);
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.addItemDecoration(new RecyclerView.ItemDecoration() {
            @Override
            public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
                if (parent.getChildAdapterPosition(view) == 0) {
                    outRect.top = 16;
                }
                outRect.bottom = 16;
            }
        });

        mLayoutManager = new LinearLayoutManager(getContext());
        mRecyclerView.setLayoutManager(mLayoutManager);

        mAdapter = new LocksAdapter(locks);
        mRecyclerView.setAdapter(mAdapter);


        return rootView;
    }

    private List<Lock> populateLocks() {
        List<Lock> locks = new ArrayList<>();
        locks.add(new Lock("My flat", "Smartlock which is installed in my flat"));

        return locks;
    }

    private void setActiveKeysTextView() {
        TextView textView = (TextView) rootView.findViewById(R.id.active_locks);
        textView.setText("Active locks: " + locks.size());
    }


}
