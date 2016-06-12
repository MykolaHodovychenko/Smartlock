package ua.opu.smartlock;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

/**
 * Стартовое активити.
 * В данном окне происходит выбор умного замка, после чего осуществляется переход
 * в TabsActivity, где можно выполнить действия для выбранного умного замка
 */
public class LocksActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_locks);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        if (toolbar != null)
            toolbar.setNavigationIcon(R.drawable.lock_toolbar);

        // Кнопка "Добавить новый замок"
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // TODO: Реализовать добавление нового замка
                Snackbar.make(view, getString(R.string.feature_error), Snackbar.LENGTH_SHORT).show();
            }
        });
    }

}
