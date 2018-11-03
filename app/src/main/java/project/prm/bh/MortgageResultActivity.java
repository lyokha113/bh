package project.prm.bh;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;

import com.google.android.material.card.MaterialCardView;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

public class MortgageResultActivity extends AppCompatActivity {

    MaterialCardView mortageResult1, mortageResult2;
    private ActionBar actionBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mortgage_result);

        actionBar = getSupportActionBar();
        setupActionBar();

        mortageResult1 = findViewById(R.id.mortageResult1);
        mortageResult1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), MortgageResultDetailActivity.class);
                startActivity(intent);
            }
        });

        mortageResult2 = findViewById(R.id.mortageResult2);
        mortageResult2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), MortgageResultDetailActivity.class);
                startActivity(intent);
            }
        });
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
