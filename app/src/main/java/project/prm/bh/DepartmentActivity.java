package project.prm.bh;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import fr.ganfra.materialspinner.MaterialSpinner;

public class DepartmentActivity extends AppCompatActivity {

    String[] hcm = {
            "Bảo hiểm Xã hội huyện Bình Chánh",
            "Bảo hiểm Xã hội huyện Cần Giờ   ",
            "Bảo hiểm Xã hội huyện Củ Chi    ",
            "Bảo hiểm Xã hội huyện Hóc Môn   ",
            "Bảo hiểm Xã hội huyện Nhà Bè    ",
            "Bảo hiểm Xã hội quận 1          ",
            "Bảo hiểm Xã hội quận 10         ",
            "Bảo hiểm Xã hội quận 11         ",
            "Bảo hiểm Xã hội quận 12         ",
            "Bảo hiểm Xã hội quận 2          ",
            "Bảo hiểm Xã hội quận 3          ",
            "Bảo hiểm Xã hội quận 4          ",
            "Bảo hiểm Xã hội quận 5          ",
            "Bảo hiểm Xã hội quận 6          ",
            "Bảo hiểm Xã hội quận 7          ",
            "Bảo hiểm Xã hội quận 8          ",
            "Bảo hiểm Xã hội quận 9          ",
            "Bảo hiểm Xã hội quận Bình Tân   ",
            "Bảo hiểm Xã hội quận Bình Thạnh ",
            "Bảo hiểm Xã hội quận Gò Vấp     ",
            "Bảo hiểm Xã hội quận Phú Nhuận  ",
            "Bảo hiểm Xã hội quận Tân Bình   ",
            "Bảo hiểm Xã hội quận Tân Phú    ",
            "Bảo hiểm Xã hội quận Thủ Đức    ",
            "VP Bảo hiểm Xã hội TP HCM       "
    };
    String[] hanoi = {
            "Bảo hiểm Xã hội huyện Ba Vì             ",
            "Bảo hiểm Xã hội huyện Chương Mỹ         ",
            "Bảo hiểm Xã hội huyện Đan Phượng        ",
            "Bảo hiểm Xã hội huyện Đông Anh          ",
            "Bảo hiểm Xã hội huyện Gia Lâm           ",
            "Bảo hiểm Xã hội huyện Hoài Đức          ",
            "Bảo hiểm Xã hội huyện Mê Linh           ",
            "Bảo hiểm Xã hội huyện Mỹ Đức            ",
            "Bảo hiểm Xã hội huyện Phú Xuyên         ",
            "Bảo hiểm Xã hội huyện Phúc Thọ          ",
            "Bảo hiểm Xã hội huyện Quốc Oai          ",
            "Bảo hiểm Xã hội huyện Sóc Sơn           ",
            "Bảo hiểm Xã hội huyện Thạch Thất        ",
            "Bảo hiểm Xã hội huyện Thanh Oai         ",
            "Bảo hiểm Xã hội huyện Thanh Trì         ",
            "Bảo hiểm Xã hội huyện Thường Tín        ",
            "Bảo hiểm Xã hội huyện Ứng Hòa           ",
            "Bảo hiểm Xã hội quận Ba Đình            ",
            "Bảo hiểm Xã hội quận Bắc Từ Liêm        ",
            "Bảo hiểm Xã hội quận Cầu Giấy           ",
            "Bảo hiểm Xã hội quận Đống Đa            ",
            "Bảo hiểm Xã hội quận Hà Đông            ",
            "Bảo hiểm Xã hội quận Hai Bà Trưng       ",
            "Bảo hiểm Xã hội quận Hoàn Kiếm          ",
            "Bảo hiểm Xã hội quận Hoàng Mai          ",
            "Bảo hiểm Xã hội quận Long Biên          ",
            "Bảo hiểm Xã hội quận Nam Từ Liêm        ",
            "Bảo hiểm Xã hội quận Tây Hồ             ",
            "Bảo hiểm Xã hội quận Thanh Xuân         ",
            "Bảo hiểm Xã hội TX Sơn Tây              ",
            "VP Bảo hiểm Xã hội TP Hà Nội            "
    };
    String[] danang = {
            "Bảo hiểm Xã hội huyện Hòa Vang         ",
            "Bảo hiểm xã hội huyện Hoàng Sa         ",
            "Bảo hiểm Xã hội quận Cẩm Lệ            ",
            "Bảo hiểm Xã hội quận Hải Châu          ",
            "Bảo hiểm Xã hội quận Liên Chiểu        ",
            "Bảo hiểm Xã hội quận Ngũ Hành Sơn      ",
            "Bảo hiểm Xã hội quận Sơn Trà           ",
            "Bảo hiểm Xã hội quận Thanh Khê         ",
            "VP Bảo hiểm Xã hội TP Đà Nẵng          "
    };
    private ActionBar actionBar;
    private LinearLayout depList;
    private MaterialSpinner spinner;
    private String[] ITEMS = {
            "Bảo hiểm Xã hội TP Hồ Chí Minh",
            "Bảo hiểm Xã hội TP Hà Nội",
            "Bảo hiểm Xã hội TP Đà Nẵng"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_department);
        addControls();

        setupActionBar();
    }

    private void addControls() {
        actionBar = getSupportActionBar();

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, ITEMS);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner = findViewById(R.id.spinner);
        spinner.setAdapter(adapter);

        final List<String[]> subItems = new ArrayList<>();
        subItems.add(hcm);
        subItems.add(hanoi);
        subItems.add(danang);

        depList = findViewById(R.id.depList);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                if (position >= 0) {
                    String[] deps = subItems.get(position);
                    depList.removeAllViews();
                    for (int i = 0; i < deps.length; i++) {
                        TextView textLine = new TextView(getApplicationContext());
                        textLine.setText(deps[i]);
                        textLine.setTextSize(18);
                        textLine.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                                ViewGroup.LayoutParams.WRAP_CONTENT));
                        depList.addView(textLine);
                    }
                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

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
