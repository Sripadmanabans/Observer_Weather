package model.parts;

import com.google.gson.annotations.SerializedName;

/**
 * This contains details about weather.
 * Created by Sripadmanaban on 9/3/2015.
 */
public class Weather {

    @SerializedName("id")
    private long id;

    @SerializedName("main")
    private String main;

    @SerializedName("description")
    private String description;

    @SerializedName("icon")
    private String icon;

}
