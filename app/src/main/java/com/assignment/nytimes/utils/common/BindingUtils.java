package com.assignment.nytimes.utils.common;

import android.databinding.BindingAdapter;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.RequestOptions;

/**
 * Created by Dhaval Parmar on 31/03/19.
 * Email : dhaval.parmar@wwindia.com
 */
public class BindingUtils {
    @BindingAdapter("news_image")
    public static void loadNewsCircleImage(ImageView imageView, String url) {
        if (url != null) {
            Glide.with(imageView.getContext())
                    .load(url)
                    .apply(new RequestOptions()
                            .circleCrop()
                            .override(imageView.getWidth(), imageView.getHeight())
                            .diskCacheStrategy(DiskCacheStrategy.ALL))
                    .into(imageView);
        }
    }
}
