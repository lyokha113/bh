package project.prm.bh;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

public class MainActivity extends AppCompatActivity {

    private static final int MY_NOTIFICATION_ID = 12345;
    private static final int MY_REQUEST_CODE = 100;
    MenuItem prevMenuItem;
    Fragment newsFragment;
    Fragment mortgageFragment;
    Fragment shieldFragment;
    Fragment accountFragment;
    private BottomNavigationView bottomNavigation;
    private ActionBar actionBar;
    private ViewPager viewPager;
    private NotificationCompat.Builder notBuilder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        addControls();
        addEvents();

        setupActionBar();
        setBottomNavigationConfig();

        setupViewPager(viewPager);
    }


    private void addEvents() {
        bottomNavigation.setOnNavigationItemSelectedListener(
                new BottomNavigationView.OnNavigationItemSelectedListener() {

                    @Override
                    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                        setBottomNavigationSelectedItem(item);
                        switch (item.getItemId()) {
                            case R.id.news:
                                viewPager.setCurrentItem(0);
                                break;
                            case R.id.mortage:
                                viewPager.setCurrentItem(1);
                                break;
                            case R.id.shield:
                                viewPager.setCurrentItem(2);
                                break;
                            case R.id.account:
                                viewPager.setCurrentItem(3);
                                break;
                        }
                        return true;
                    }
                });

        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {

            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            }

            @Override
            public void onPageSelected(int position) {
                if (prevMenuItem != null)
                    prevMenuItem.setChecked(false);
                else
                    bottomNavigation.getMenu().getItem(0).setChecked(false);

                MenuItem item = bottomNavigation.getMenu().getItem(position);
                setBottomNavigationSelectedItem(item);
                item.setChecked(true);
                prevMenuItem = item;
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    private void addControls() {
        bottomNavigation = findViewById(R.id.bottom_navigation);
        actionBar = getSupportActionBar();
        viewPager = findViewById(R.id.viewpager);
    }

    private void setBottomNavigationConfig() {
        bottomNavigation.setItemIconTintList(null);
        bottomNavigation.getMenu().getItem(0).setIcon(R.drawable.newsselected);
    }

    private void setBottomNavigationSelectedItem(@NonNull MenuItem item) {

        Menu menu = bottomNavigation.getMenu();
        menu.getItem(0).setIcon(R.drawable.news);
        menu.getItem(1).setIcon(R.drawable.mortgage);
        menu.getItem(2).setIcon(R.drawable.shield);
        menu.getItem(3).setIcon(R.drawable.account);

        switch (item.getItemId()) {
            case R.id.news:
                item.setIcon(R.drawable.newsselected);
                break;
            case R.id.mortage:
                item.setIcon(R.drawable.mortgageselected);
                break;
            case R.id.shield:
                item.setIcon(R.drawable.shieldselected);
                break;
            case R.id.account:
                item.setIcon(R.drawable.accountselected);
                break;
        }

    }

    private void setupActionBar() {
        actionBar.setDisplayShowTitleEnabled(true);
        actionBar.setDisplayShowCustomEnabled(true);
        actionBar.setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

        ActionBar.LayoutParams layoutParam = new ActionBar.LayoutParams(ActionBar.LayoutParams.MATCH_PARENT, ActionBar.LayoutParams.WRAP_CONTENT);
        View customActionBar = LayoutInflater.from(this).inflate(R.layout.action_bar, null);

        actionBar.setCustomView(customActionBar, layoutParam);
    }

    private void setupViewPager(ViewPager viewPager) {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());

        newsFragment = new NewsFragment();
        mortgageFragment = new MortgageFragment();
        shieldFragment = new ShieldFragment();
        accountFragment = new AccountFragment();

        adapter.addFrag(newsFragment, "news");
        adapter.addFrag(mortgageFragment, "mortgage");
        adapter.addFrag(shieldFragment, "shield");
        adapter.addFrag(accountFragment, "account");

        viewPager.setAdapter(adapter);
    }


}
