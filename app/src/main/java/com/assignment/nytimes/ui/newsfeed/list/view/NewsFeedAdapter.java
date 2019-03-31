package com.assignment.nytimes.ui.newsfeed.list.view;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.assignment.nytimes.api.newsfeed.list.ResultsItem;
import com.assignment.nytimes.databinding.ItemNewsFeedBinding;

import java.util.List;

/**
 * Created by Dhaval Parmar on 31/03/19.
 * Email : dhaval.parmar@wwindia.com
 */
public class NewsFeedAdapter extends RecyclerView.Adapter<NewsFeedAdapter.NewsFeedViewHolder> {

    private List<ResultsItem> mData;
    private OnNewsItemClickListener listener;

    public NewsFeedAdapter(List<ResultsItem> mData, OnNewsItemClickListener listener) {
        this.mData = mData;
        this.listener = listener;
    }

    @NonNull
    @Override
    public NewsFeedViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        ItemNewsFeedBinding itemNewsFeedBinding =
                ItemNewsFeedBinding.inflate(
                        LayoutInflater.from(viewGroup.getContext()), viewGroup, false);

        return new NewsFeedViewHolder(itemNewsFeedBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull NewsFeedViewHolder baseViewHolder, int i) {
        baseViewHolder.onBind(i);
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public interface OnNewsItemClickListener {
        void onNewsItemClick(int position);
    }

    public class NewsFeedViewHolder extends RecyclerView.ViewHolder {

        private ItemNewsFeedBinding itemNewsFeedBinding;

        public NewsFeedViewHolder(ItemNewsFeedBinding itemNewsFeedBinding) {
            super(itemNewsFeedBinding.getRoot());
            this.itemNewsFeedBinding = itemNewsFeedBinding;
        }

        public void onBind(int position) {
            itemNewsFeedBinding.setFeed(mData.get(position));

            itemNewsFeedBinding.getRoot().setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listener.onNewsItemClick(position);
                }
            });
        }
    }
}
