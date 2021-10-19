package com.example.loadgithubprofiles;

import android.widget.ImageView;

public class model {
    private String name, login;
    private ImageView iv_avatar;

    public model(String name, String login, ImageView iv_avatar) {
        this.name = name;
        this.login = login;
        this.iv_avatar = iv_avatar;
    }

    public String getName() {
        return name;
    }

    public String getLogin() {
        return login;
    }

    public ImageView getIv_avatar() {
        return iv_avatar;
    }
}
