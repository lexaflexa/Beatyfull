package com.lexass.View.adapters.viewHolders;

import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.lexass.databinding.GameElementBinding;


public class APIViewHolder extends RecyclerView.ViewHolder {
    RadioButton radioButton;
    ImageView mImageView;
    TextView textView;

    public APIViewHolder(GameElementBinding ceb) {
        super(ceb.getRoot());
        radioButton = ceb.rButton2;
        mImageView = ceb.gameImageView;
        textView = ceb.describeGame;
    }

    public RadioButton getRadioButton(){
        return radioButton;
    }
    public ImageView getImageView(){
        return mImageView;
    }
    public TextView getTextView(){
        return textView;
    }
}
