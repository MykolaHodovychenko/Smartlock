package ua.opu.smartlock.tabs;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import ua.opu.smartlock.R;
import ua.opu.smartlock.tabs.history.HistoryFragment;
import ua.opu.smartlock.tabs.home.HomeFragment;
import ua.opu.smartlock.tabs.keys.KeysFragment;
import ua.opu.smartlock.tabs.users.UsersFragment;

/**
 * Окно с операциями для выбранного умного замка
 */
public class TabsActivity extends AppCompatActivity {

    private SectionsPagerAdapter mSectionsPagerAdapter;
    private ViewPager mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        if (toolbar != null)
            toolbar.setNavigationIcon(R.drawable.lock_toolbar);

        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());

        mViewPager = (ViewPager) findViewById(R.id.container);
        if (mViewPager != null)
            mViewPager.setAdapter(mSectionsPagerAdapter);

        // Иконки для вкладок
        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);
        if (tabLayout != null) {
            tabLayout.setupWithViewPager(mViewPager);
            tabLayout.getTabAt(0).setIcon(R.drawable.key);
            tabLayout.getTabAt(1).setIcon(R.drawable.users);
            tabLayout.getTabAt(2).setIcon(R.drawable.history);
            tabLayout.getTabAt(3).setIcon(R.drawable.house);
        }

        // Кнопка "Открытие замка"
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        if (fab != null)
            fab.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    // TODO: Реализовать открытие замка
                    Snackbar.make(view, getString(R.string.feature_error), Snackbar.LENGTH_SHORT).show();
                }
            });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public class SectionsPagerAdapter extends FragmentPagerAdapter {

        public SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        // Получение фрагмента при инициализации пунктов пейджера
        @Override
        public Fragment getItem(int position) {
            switch (position) {
                case 0:
                    return KeysFragment.newInstance();
                case 1:
                    return UsersFragment.newInstance();
                case 2:
                    return HistoryFragment.newInstance();
                case 3:
                    return HomeFragment.newInstance();
            }
            return null;
        }

        @Override
        public int getCount() {
            return 4;
        }

        // Заголовки вкладок
        @Override
        public CharSequence getPageTitle(int position) {
            switch (position) {
                case 0:
                    return "KEYS";
                case 1:
                    return "USERS";
                case 2:
                    return "HISTORY";
                case 3:
                    return "HOME";
            }
            return null;
        }
    }
}
