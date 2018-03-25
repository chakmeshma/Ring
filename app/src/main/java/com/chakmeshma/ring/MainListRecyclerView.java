package com.chakmeshma.ring;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.annotation.Nullable;
import android.support.v7.widget.AppCompatImageView;
import android.support.v7.widget.AppCompatTextView;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import pl.droidsonroids.gif.GifImageView;

/**
 * Created by amrosi on 3/25/2018.
 */

public class MainListRecyclerView extends RecyclerView {
    private int loadingGifRef = 0;
    private GifImageView gifImageView = null;
    private boolean loading = true;
    private View parent;

    public MainListRecyclerView(Context context) {
        super(context);

        init();
    }

    public MainListRecyclerView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);

        applyAttrs(context, attrs);
        init();
    }

    public MainListRecyclerView(Context context, @Nullable AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);

        applyAttrs(context, attrs);
        init();
    }

    private void init() {
        this.parent = (View) getParent();

        if (this.parent != null) {
            gifImageView = this.parent.findViewById(loadingGifRef);
        }
    }

    private void applyAttrs(Context context, AttributeSet attrs) {
        TypedArray typedAttrs = context.obtainStyledAttributes(attrs, R.styleable.MainListRecyclerView, 0, 0);

        try {
            loadingGifRef = typedAttrs.getResourceId(R.styleable.MainListRecyclerView_loading_state_placeholder, -1);
        } catch (Exception e) {

        }
    }

    private void updateLoadingState() {
        if (loading) {

        }
    }

    public static class RecyclerViewAdapter extends Adapter<RecyclerViewAdapter.ViewHolder> {
        private String[] dataSet;

        public RecyclerViewAdapter(String[] dateSet) {
            this.dataSet = dateSet;
        }

        @Override
        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            LayoutInflater inflater = LayoutInflater.from(parent.getContext());

            return new ViewHolder((ViewGroup) inflater.inflate(R.layout.main_list_item, parent, false));
        }

        @Override
        public void onBindViewHolder(ViewHolder holder, int position) {

            holder.textView.setText(dataSet[position]);
        }

        @Override
        public int getItemCount() {
            return dataSet.length;
        }

        static class ViewHolder extends RecyclerView.ViewHolder {
            private ViewGroup listItemLayoutView;
            private AppCompatImageView imageView;
            private AppCompatTextView headerTextView;
            private AppCompatTextView locationTextView;
            private AppCompatTextView priceTextView;


            private ViewHolder(ViewGroup listItemLayoutView) {
                super(listItemLayoutView);

                this.listItemLayoutView = listItemLayoutView;

                imageView = listItemLayoutView.findViewById(R.id.list_item_image);
                headerTextView = listItemLayoutView.findViewById(R.id.list_item_header);
                locationTextView = listItemLayoutView.findViewById(R.id.list_item_location);
                priceTextView = listItemLayoutView.findViewById(R.id.list_item_price);
            }


            void setHeader(String string) {

            }
        }
    }
}
