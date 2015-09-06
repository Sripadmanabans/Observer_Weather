package model.parts;

import com.google.gson.annotations.SerializedName;

/**
 * This contains data about the place and sunrise and sunset.
 * Created by Sripadmanaban on 9/3/2015.
 */
public class SystemDetails {

    @SerializedName("type")
    private int type;

    @SerializedName("id")
    private long id;

    @SerializedName("message")
    private double message;

    @SerializedName("country")
    private String country;

    @SerializedName("sunrise")
    private long sunrise;

    @SerializedName("sunset")
    private long sunset;

}
