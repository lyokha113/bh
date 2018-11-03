package project.prm.bh;


import android.content.Intent;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.fragment.app.Fragment;
import ss.com.bannerslider.ImageLoadingService;
import ss.com.bannerslider.Slider;

public class NewsFragment extends Fragment {

    Slider slider;
    View news1, news2, news3;

    View.OnClickListener newsClick = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent = new Intent(getActivity(), News1Activity.class);
            if (v.getId() == R.id.news1Content) {
                intent.putExtra("newsContent", R.layout.activity_news1);
            } else if (v.getId() == R.id.news2Content) {
                intent.putExtra("newsContent", R.layout.activity_news2);
            } else if (v.getId() == R.id.news3Content) {
                intent.putExtra("newsContent", R.layout.activity_news3);
            }
            startActivity(intent);
        }
    };

    public NewsFragment() {
    }

    @Override
    public void onStart() {
        super.onStart();

        Slider.init(new ImageLoadingService() {
            @Override
            public void loadImage(String url, ImageView imageView) {
                imageView.setImageBitmap(BitmapFactory.decodeFile(url));
            }

            @Override
            public void loadImage(int resource, ImageView imageView) {
                imageView.setImageResource(resource);
            }

            @Override
            public void loadImage(String url, int placeHolder, int errorDrawable, ImageView imageView) {
            }
        });

        slider = getActivity().findViewById(R.id.bannerSlider);
        slider.setAdapter(new MainSliderAdapter());
        slider.setSelectedSlide(0);

        news1 = getActivity().findViewById(R.id.news1Content);
        news2 = getActivity().findViewById(R.id.news2Content);
        news3 = getActivity().findViewById(R.id.news3Content);

        news1.setOnClickListener(newsClick);
        news2.setOnClickListener(newsClick);
        news3.setOnClickListener(newsClick);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_news, container, false);
    }

}
