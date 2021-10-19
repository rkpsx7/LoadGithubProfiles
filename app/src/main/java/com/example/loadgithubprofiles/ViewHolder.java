package com.example.loadgithubprofiles;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

public class ViewHolder extends RecyclerView.ViewHolder {
    private ImageView iv_avatar;
    private TextView tv_name, tv_login;

    public ViewHolder(@NonNull View itemView) {
        super(itemView);
        iv_avatar = itemView.findViewById(R.id.profile_pic);
        tv_name = itemView.findViewById(R.id.tv_name);
        tv_login = itemView.findViewById(R.id.tv_login);

    }

    public void setData(ResponseDTOItem item) {
        Glide.with(iv_avatar).load(item.getOwner().getAvatarUrl()).into(iv_avatar);
        tv_name.setText(item.getName());
        tv_login.setText(item.getOwner().getLogin());
    }
}
