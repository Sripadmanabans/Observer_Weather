package model.part;

import com.google.gson.annotations.SerializedName;

/**
 * This class contains the coordinates of the place that is referred,
 * Created by Sripadmanaban on 9/3/2015.
 */
public class Coordinates {

    @SerializedName("lon")
    private double longitude;

    @SerializedName("lat")
    private double latitude;

}
