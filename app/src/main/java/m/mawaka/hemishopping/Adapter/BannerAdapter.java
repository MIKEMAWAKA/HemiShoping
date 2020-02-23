package m.mawaka.hemishopping.Adapter;

import java.util.List;

import m.mawaka.hemishopping.Model.Banner;
import ss.com.bannerslider.adapters.SliderAdapter;
import ss.com.bannerslider.viewholder.ImageSlideViewHolder;

import static m.mawaka.hemishopping.Common.Common.BANNER_IMAGE;

public class BannerAdapter extends SliderAdapter {

    List<Banner> bannerList;

    public BannerAdapter(List<Banner> bannerList) {
        this.bannerList = bannerList;
    }

    @Override
    public int getItemCount() {
        return bannerList.size();
    }

    @Override
    public void onBindImageSlide(int position, ImageSlideViewHolder imageSlideViewHolder) {
        imageSlideViewHolder.bindImageSlide(BANNER_IMAGE+bannerList.get(position).getLink());

    }
}

