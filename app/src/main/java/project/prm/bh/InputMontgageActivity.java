package project.prm.bh;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ArrayAdapter;

import com.google.android.material.button.MaterialButton;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import fr.ganfra.materialspinner.MaterialSpinner;

public class InputMontgageActivity extends AppCompatActivity {

    private ActionBar actionBar;
    private MaterialButton inputMortgageBtn;
    private MaterialSpinner spinner;
    private String[] ITEMS = {
            "Thành phố Cần Thơ         ",
            "Tỉnh Kiên Giang           ",
            "Tỉnh Đồng Nai             ",
            "Tỉnh Lạng Sơn             ",
            "Tỉnh An Giang             ",
            "Tỉnh Thái Bình            ",
            "Tỉnh Kon Tum              ",
            "Tỉnh Quảng Trị            ",
            "Tỉnh Ninh Thuận           ",
            "Tỉnh Bình Dương           ",
            "Tỉnh Ninh Bình            ",
            "Thành phố Hải Phòng       ",
            "Tỉnh Bạc Liêu             ",
            "Tỉnh Tuyên Quang          ",
            "Tỉnh Sơn La               ",
            "Tỉnh Nam Định             ",
            "Tỉnh Phú Thọ              ",
            "Tỉnh Hà Tĩnh              ",
            "Tỉnh Hậu Giang            ",
            "Tỉnh Tiền Giang           ",
            "Tỉnh Đắk Lắk              ",
            "Tỉnh Long An              ",
            "Tỉnh Hòa Bình             ",
            "Tỉnh Đồng Tháp            ",
            "Tỉnh Thái Nguyên          ",
            "Tỉnh Bến Tre              ",
            "Tỉnh Phú Yên              ",
            "Tỉnh Vĩnh Phúc            ",
            "Tỉnh Sóc Trăng            ",
            "Tỉnh Bình Thuận           ",
            "Tỉnh Quảng Ngãi           ",
            "Tỉnh Gia Lai              ",
            "Tỉnh Bà Rịa - Vũng Tàu    ",
            "Thành phố Hồ Chí Minh     ",
            "Tỉnh Hà Giang             ",
            "Tỉnh Lâm Đồng             ",
            "Tỉnh Hà Nam               ",
            "Thành phố Đà Nẵng         ",
            "Tỉnh Bình Phước           ",
            "Tỉnh Quảng Nam            ",
            "Tỉnh Thanh Hóa            ",
            "Tỉnh Trà Vinh             ",
            "Tỉnh Điện Biên            ",
            "Tỉnh Bắc Ninh             ",
            "Tỉnh Hải Dương            ",
            "Tỉnh Thừa Thiên Huế       ",
            "Tỉnh Đắk Nông             ",
            "Tỉnh Quảng Bình           ",
            "Tỉnh Quảng Ninh           ",
            "Tỉnh Hưng Yên             ",
            "Tỉnh Cà Mau               ",
            "Tỉnh Lào Cai              ",
            "Tỉnh Khánh Hòa            ",
            "Tỉnh Nghệ An              ",
            "Tỉnh Lai Châu             ",
            "Tỉnh Tây Ninh             ",
            "Tỉnh Vĩnh Long            ",
            "Tỉnh Bắc Giang            ",
            "Tỉnh Cao Bằng             ",
            "Tỉnh Yên Bái              ",
            "Tỉnh Bình Định            ",
            "Thành phố Hà Nội          ",
            "Tỉnh Bắc Kạn              ",
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input_montgage);

        addControls();

        setupActionBar();
    }

    private void addControls() {
        actionBar = getSupportActionBar();

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, ITEMS);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner = findViewById(R.id.spinner);
        spinner.setAdapter(adapter);

        inputMortgageBtn = findViewById(R.id.inputMortgageBtn);
        inputMortgageBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), MortgageResultActivity.class);
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
