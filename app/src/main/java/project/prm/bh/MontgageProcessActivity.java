package project.prm.bh;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.DatePicker;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import fr.ganfra.materialspinner.MaterialSpinner;

public class MontgageProcessActivity extends AppCompatActivity {

    private MaterialButton processBtn;
    private ActionBar actionBar;
    private TextInputEditText fromDate, toDate;
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
        setContentView(R.layout.activity_montgage_process);

        addControls();

        setupActionBar();
    }

    private void addControls() {
        actionBar = getSupportActionBar();

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, ITEMS);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner = findViewById(R.id.spinner);
        spinner.setAdapter(adapter);

        processBtn = findViewById(R.id.mortageProcessBtn);

        processBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), ProcessResultActivity.class);
                startActivity(intent);
            }
        });


        final Calendar myCalendar = Calendar.getInstance();
        fromDate = findViewById(R.id.fromDate);
        final DatePickerDialog.OnDateSetListener fdate = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int monthOfYear,
                                  int dayOfMonth) {
                myCalendar.set(Calendar.YEAR, year);
                myCalendar.set(Calendar.MONTH, monthOfYear);
                myCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
                String myFormat = "MM/dd/yy";
                SimpleDateFormat sdf = new SimpleDateFormat(myFormat, Locale.US);
                fromDate.setText(sdf.format(myCalendar.getTime()));
            }

        };

        fromDate.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                new DatePickerDialog(MontgageProcessActivity.this, fdate, myCalendar
                        .get(Calendar.YEAR), myCalendar.get(Calendar.MONTH),
                        myCalendar.get(Calendar.DAY_OF_MONTH)).show();
            }
        });

        toDate = findViewById(R.id.toDate);
        final DatePickerDialog.OnDateSetListener tdate = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int monthOfYear,
                                  int dayOfMonth) {
                myCalendar.set(Calendar.YEAR, year);
                myCalendar.set(Calendar.MONTH, monthOfYear);
                myCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
                String myFormat = "MM/dd/yy";
                SimpleDateFormat sdf = new SimpleDateFormat(myFormat, Locale.US);
                toDate.setText(sdf.format(myCalendar.getTime()));
            }

        };

        toDate.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                new DatePickerDialog(MontgageProcessActivity.this, tdate, myCalendar
                        .get(Calendar.YEAR), myCalendar.get(Calendar.MONTH),
                        myCalendar.get(Calendar.DAY_OF_MONTH)).show();
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
