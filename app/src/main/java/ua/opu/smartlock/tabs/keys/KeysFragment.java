package ua.opu.smartlock.tabs.keys;

import android.graphics.Rect;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v7.widget.CardView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import ua.opu.smartlock.R;
import ua.opu.smartlock.model.Key;
import ua.opu.smartlock.model.KeySchedule;

/**
 * Фрагмент для вкладки Keys.
 * Данный фрагмент содержит операции для управления ключами
 * (добавление нового, изменение и удаление существующего)
 */
public class KeysFragment extends Fragment{

    // Список ключей
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    // Коллекция с ключами
    List<Key> keys;

    View rootView;

    public KeysFragment() {}

    public static KeysFragment newInstance() {
        KeysFragment fragment = new KeysFragment();
        Bundle args = new Bundle();
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_keys, container, false);

        mRecyclerView = (RecyclerView) rootView.findViewById(R.id.keys_list);
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.addItemDecoration(new RecyclerView.ItemDecoration() {
            @Override
            public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
                outRect.bottom = 32;
            }
        });

        // Наполнение коллекции тестовыми данными
        keys = populateKeysList();
        // Изменения текстового поля "Количество ключей :"
        setActiveKeysTextView();

        // Кнопка "Добавить новый ключ"
        CardView key = (CardView) rootView.findViewById(R.id.add_new_key);
        key.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO: Реализовать добавление нового замка
                Snackbar.make(v, getString(R.string.feature_error), Snackbar.LENGTH_SHORT).show();
            }
        });

        mLayoutManager = new LinearLayoutManager(getContext());
        mRecyclerView.setLayoutManager(mLayoutManager);
        mAdapter = new KeysAdapter(keys);
        mRecyclerView.setAdapter(mAdapter);

        return rootView;
    }

    // Наполнение коллекции с ключами тестовыми данными
    private List<Key> populateKeysList() {
        List<Key> keys = new ArrayList<>();
        keys.add(new Key("My Key","+380682619923",new KeySchedule(true)));
        keys.add(new Key("Andrew's Key","+380673561202",new KeySchedule(false)));
        keys.add(new Key("Sister Key","+380501256712",new KeySchedule(true)));
        keys.add(new Key("My Key","+380682619923",new KeySchedule(false)));
        keys.add(new Key("Andrew's Key","+380673561202",new KeySchedule(true)));
        keys.add(new Key("Sister Key","+380501256712",new KeySchedule(false)));
        keys.add(new Key("My Key","+380682619923",new KeySchedule(true)));
        keys.add(new Key("Andrew's Key","+380673561202",new KeySchedule(false)));
        keys.add(new Key("Sister Key","+380501256712",new KeySchedule(true)));

        return keys;
    }

    // Изменение текстового поля "Количество ключей"
    private void setActiveKeysTextView() {
        TextView textView = (TextView) rootView.findViewById(R.id.active_keys);
        textView.setText("Active keys: " + keys.size());
    }

}
