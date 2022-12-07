package com.lexass.View.adapters;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.lexass.View.APIFragment;
import com.lexass.View.adapters.viewHolders.APIViewHolder;
import com.lexass.R;
import com.lexass.databinding.FragmentPeopleBinding;
import com.lexass.databinding.GameElementBinding;

import java.util.List;

public class APIAdapter extends RecyclerView.Adapter<APIViewHolder> {
    private final List<String> games;
    private final APIFragment peopleFragment;
    private final List<String> urlImg;
    FragmentPeopleBinding binding;
    private Context mContext;


    public APIAdapter(APIFragment peopleFragment, List<String> games, List<String> urlImg){
        this.peopleFragment = peopleFragment;
        this.games = games;
        this.urlImg = urlImg;
        mContext = peopleFragment.getContext();
        //binding = FragmentPeopleBinding.inflate(inflater, container, false);
    }


    @NonNull
    @Override
    public APIViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        GameElementBinding ceb = GameElementBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);

        return new APIViewHolder(ceb);
    }

    @Override
    public void onBindViewHolder(@NonNull APIViewHolder holder, int position) {
        ImageView imageView = holder.getImageView();
        holder.getRadioButton().setText(games.get(position));
        //holder.getTextView().setText(urlImg.get(position));

        Glide.with(mContext)
                .load(urlImg.get(position))
                .placeholder(R.drawable.ic_baseline_self_improvement_24)
                .into(imageView);
    }


    @Override
    public int getItemCount() {
        return games.size();
    }
}
