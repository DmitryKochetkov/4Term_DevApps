package com.dimedrol.lab2;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Tech {
    @SerializedName("graphic")
    @Expose
    private String graphicUrl;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("helptext")
    @Expose
    private String helptext;

    public String getGraphicUrl() {
        return graphicUrl;
    }

    public void setGraphicUrl(String graphicUrl) {
        this.graphicUrl = graphicUrl;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getHelptext() {
        return helptext;
    }

    public void setHelptext(String helptext) {
        this.helptext = helptext;
    }
}
