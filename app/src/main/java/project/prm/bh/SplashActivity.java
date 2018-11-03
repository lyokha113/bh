package project.prm.bh;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.Handler;

import androidx.appcompat.app.AppCompatActivity;

public class SplashActivity extends AppCompatActivity {

    final long delay = 1500L; // 1000ms = 1s
    final Runnable action = new Runnable() {
        public void run() {
            Intent goToMain = new Intent(SplashActivity.this, MainActivity.class);
            startActivity(goToMain);
            finish();
        }
    };
    private androidx.appcompat.app.ActionBar actionBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        actionBar = getSupportActionBar();
        setupActionBar();

        Handler handler = new Handler();
        handler.postDelayed(action, delay);
    }

    private void setupActionBar() {
        actionBar.setDisplayShowTitleEnabled(false);
        actionBar.setDisplayShowCustomEnabled(false);
        actionBar.setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
    }
}
