package model.part;

import com.google.gson.annotations.SerializedName;

/**
 * This class contains data about Wind.
 * Created by Sripadmanaban on 9/3/2015.
 */
public class Wind {

    @SerializedName("speed")
    private double speed;

    @SerializedName("deg")
    private int degree;

}
