package ua.opu.smartlock.tabs.history;

import android.graphics.Rect;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import ua.opu.smartlock.R;
import ua.opu.smartlock.model.History;
import ua.opu.smartlock.model.HistoryAction;
import ua.opu.smartlock.tabs.keys.KeysAdapter;

public class HistoryFragment extends Fragment {
    View rootView;

    List<HistoryAction> historyActions;

    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    public HistoryFragment() {}

    public static HistoryFragment newInstance() {
        HistoryFragment fragment = new HistoryFragment();
        Bundle args = new Bundle();
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_history, container, false);

        mRecyclerView = (RecyclerView) rootView.findViewById(R.id.keys_list);
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.addItemDecoration(new RecyclerView.ItemDecoration() {
            @Override
            public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
                outRect.bottom = 8;
            }
        });

        historyActions = populateHistoryList();

        mLayoutManager = new LinearLayoutManager(getContext());
        mRecyclerView.setLayoutManager(mLayoutManager);

        mAdapter = new HistoryAdapter(historyActions);
        mRecyclerView.setAdapter(mAdapter);

        return rootView;
    }

    private List<HistoryAction> populateHistoryList() {
        List<HistoryAction> history = new ArrayList<>();

        history.add(new HistoryAction(History.ACTION_KEY_ADD,"Key 'John Doe' has been added. Key 'John Doe' has been added. Key 'John Doe' has been added. Key 'John Doe' has been added. Key 'John Doe' has been added. Key 'John Doe' has been added. Key 'John Doe' has been added. Key 'John Doe' has been added. Key 'John Doe' has been added.",new Date()));
        history.add(new HistoryAction(History.ACTION_KEY_ADD,"Key 'Sister Key' has been added.",new Date()));
        history.add(new HistoryAction(History.ACTION_KEY_ADD,"Key 'My Key' has been added.",new Date()));
        history.add(new HistoryAction(History.ACTION_KEY_ADD,"Key 'My Key' has been added.",new Date()));
        history.add(new HistoryAction(History.ACTION_KEY_ADD,"Key 'My Key' has been added.",new Date()));
        history.add(new HistoryAction(History.ACTION_KEY_ADD,"Key 'My Key' has been added.",new Date()));
        history.add(new HistoryAction(History.ACTION_KEY_ADD,"Key 'My Key' has been added.",new Date()));
        return history;
    }
}
