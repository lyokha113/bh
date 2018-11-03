package project.prm.bh;

import ss.com.bannerslider.adapters.SliderAdapter;
import ss.com.bannerslider.viewholder.ImageSlideViewHolder;

public class MainSliderAdapter extends SliderAdapter {

    @Override
    public int getItemCount() {
        return 3;
    }

    @Override
    public void onBindImageSlide(int position, ImageSlideViewHolder viewHolder) {
        switch (position) {
            case 0:
                viewHolder.bindImageSlide(R.drawable.banner1);
                break;
            case 1:
                viewHolder.bindImageSlide(R.drawable.banner2);
                break;
            case 2:
                viewHolder.bindImageSlide(R.drawable.banner3);
                break;
        }
    }
}