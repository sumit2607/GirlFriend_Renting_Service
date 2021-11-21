package com.example.girlfriend_renting_service.viewholder;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.girlfriend_renting_service.ItemClickListener;
import com.example.girlfriend_renting_service.ProfileDTO;
import com.example.girlfriend_renting_service.R;

public class ProfileViewHolder extends RecyclerView.ViewHolder {

    private ImageView mIvProfile;
    private CardView mCardView;
    private TextView mTvName;
    private ItemClickListener itemClickListener;

    public ProfileViewHolder(@NonNull View itemView, ItemClickListener itemClickListener) {
        super(itemView);
        mIvProfile = itemView.findViewById(R.id.ivPic);
        mCardView = itemView.findViewById(R.id.cardView);
        mTvName = itemView.findViewById(R.id.textView5);
        this.itemClickListener = itemClickListener;
    }

    public void setData(ProfileDTO profileDTO) {
        Glide.with(mIvProfile).load(profileDTO.getProfileImageUrl()).into(mIvProfile);
        mTvName.setText(profileDTO.getName());
        mCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                itemClickListener.onItemClick(profileDTO);
            }
        });
    }
}
