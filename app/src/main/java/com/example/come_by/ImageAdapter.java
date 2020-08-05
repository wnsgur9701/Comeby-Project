package com.example.come_by;


import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

public class ImageAdapter extends PagerAdapter {

    private Context mContext;
    private int[] mImageIds = new int[] {R.drawable.hotdog, R.drawable.chicken, R.drawable.pizza};

    ImageAdapter(Context context) {
        mContext = context;
    }


    @Override
    public int getCount() {
        return mImageIds.length;
    } // 전체 페이지 수

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == object; //해당 뷰와 오브젝트가 동일한 지 검사
    }

    //화면에 표시할 페이지 뷰 생성
    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        ImageView imageView = new ImageView(mContext);
        imageView.setScaleType(ImageView.ScaleType.CENTER_CROP); // ceter_crop ---> 이미지뷰에 크기에 맞게 꽉차게 이미지를 넣는다.
        imageView.setImageResource(mImageIds[position]);
        container.addView(imageView, 0);
        return imageView;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((ImageView) object); //뷰페이져에서 삭제
    }
}
