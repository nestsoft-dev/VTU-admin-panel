package com.netsoftddevelopers.vtuadmin.Core;

public class ItemModel {
    private String network_name;
    private int network_icon;


    public ItemModel(String network_name, int network_icon) {
        this.network_name = network_name;
        this.network_icon = network_icon;
    }

    public String getNetwork_name() {
        return network_name;
    }

    public void setNetwork_name(String network_name) {
        this.network_name = network_name;
    }

    public int getNetwork_icon() {
        return network_icon;
    }

    public void setNetwork_icon(int network_icon) {
        this.network_icon = network_icon;
    }
}
