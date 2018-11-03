package project.prm.bh;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;

import com.google.android.material.button.MaterialButton;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class MortgageResultDetailActivity extends AppCompatActivity {

    private ActionBar actionBar;
    private MaterialButton saveMortgage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mortgage_result_detail);

        actionBar = getSupportActionBar();
        setupActionBar();

        saveMortgage = findViewById(R.id.saveMortgage);
        saveMortgage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showAlertDialog("LƯU THẺ", "Lưu vào tài khoản thành công.", "ĐÓNG");
                saveMortgage.setVisibility(View.GONE);
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

    private void showAlertDialog(String title, String msg, String btnPos) {

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(title);
        builder.setMessage(msg);
        builder.setPositiveButton(btnPos, null);

        AlertDialog alertDialog = builder.create();
        alertDialog.show();

    }
}
