package com.example.girlfriend_renting_service.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.girlfriend_renting_service.ItemClickListener;
import com.example.girlfriend_renting_service.ProfileDTO;
import com.example.girlfriend_renting_service.viewholder.ProfileViewHolder;
import com.example.girlfriend_renting_service.R;

import java.util.List;

public class ProfileAdapter extends RecyclerView.Adapter<ProfileViewHolder> {

    private List<ProfileDTO> profileDTOS;
    public ItemClickListener itemClickListener;

    public ProfileAdapter(List<ProfileDTO> profileDTOS, ItemClickListener itemClickListener) {
        this.profileDTOS = profileDTOS;
        this.itemClickListener = itemClickListener;
    }

    @NonNull
    @Override
    public ProfileViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_layout_profile, parent, false);
        return new ProfileViewHolder(view, itemClickListener);
    }

    @Override
    public void onBindViewHolder(@NonNull ProfileViewHolder holder, int position) {
        ProfileDTO profileDTO = profileDTOS.get(position);
        holder.setData(profileDTO);
    }

    @Override
    public int getItemCount() {
        return profileDTOS.size();
    }
}
