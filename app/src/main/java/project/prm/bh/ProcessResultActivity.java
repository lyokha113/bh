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

public class ProcessResultActivity extends AppCompatActivity {

    MaterialButton procesDetailBtn1, procesDetailBtn2, procesDetailBtn3, procesDetailBtn4, procesDetailBtn5, procesDetailBtn6, procesDetailBtn7;
    private ActionBar actionBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_process_result);

        actionBar = getSupportActionBar();
        setupActionBar();

        procesDetailBtn1 = findViewById(R.id.procesDetailBtn1);
        procesDetailBtn2 = findViewById(R.id.procesDetailBtn2);
        procesDetailBtn3 = findViewById(R.id.procesDetailBtn3);
        procesDetailBtn4 = findViewById(R.id.procesDetailBtn4);
        procesDetailBtn5 = findViewById(R.id.procesDetailBtn5);
        procesDetailBtn6 = findViewById(R.id.procesDetailBtn6);
        procesDetailBtn7 = findViewById(R.id.procesDetailBtn7);

        View.OnClickListener onClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showAlertDialog("CHI TIẾT", "ĐÓNG");
            }
        };

        procesDetailBtn1.setOnClickListener(onClickListener);
        procesDetailBtn2.setOnClickListener(onClickListener);
        procesDetailBtn3.setOnClickListener(onClickListener);
        procesDetailBtn4.setOnClickListener(onClickListener);
        procesDetailBtn5.setOnClickListener(onClickListener);
        procesDetailBtn6.setOnClickListener(onClickListener);
        procesDetailBtn7.setOnClickListener(onClickListener);
    }

    private void setupActionBar() {
        actionBar.setDisplayShowTitleEnabled(true);
        actionBar.setDisplayShowCustomEnabled(true);
        actionBar.setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

        ActionBar.LayoutParams layoutParam = new ActionBar.LayoutParams(ActionBar.LayoutParams.MATCH_PARENT, ActionBar.LayoutParams.WRAP_CONTENT);
        View customActionBar = LayoutInflater.from(this).inflate(R.layout.action_bar, null);

        actionBar.setCustomView(customActionBar, layoutParam);
    }

    private void showAlertDialog(String title, String btnPos) {

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(title);
        builder.setPositiveButton(btnPos, null);
        builder.setView(R.layout.dialog_detail);

        AlertDialog alertDialog = builder.create();
        alertDialog.show();

    }
}
