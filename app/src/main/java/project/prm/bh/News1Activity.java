package project.prm.bh;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

public class News1Activity extends AppCompatActivity {

    ActionBar actionBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent intent = getIntent();

        setContentView(intent.getIntExtra("newsContent", R.layout.activity_news1));
        actionBar = getSupportActionBar();
        setupActionBar();
    }

    private void setupActionBar() {
        actionBar.setDisplayShowTitleEnabled(true);
        actionBar.setDisplayShowCustomEnabled(true);
        actionBar.setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

        ActionBar.LayoutParams layoutParam = new ActionBar.LayoutParams(ActionBar.LayoutParams.MATCH_PARENT, ActionBar.LayoutParams.WRAP_CONTENT);
        View customActionBar = LayoutInflater.from(this).inflate(R.layout.action_bar, null);

        actionBar.setCustomView(customActionBar, layoutParam);
    }
}
