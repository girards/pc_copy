package com.petitchef.petitchef.objects;

import java.io.Serializable;

/**
 * Created by nicolasgirardot on 4/26/17.
 */

public class Step implements Serializable  {

    private String stepPictureUrl;
    private String stepDescription;

    public Step(String stepPictureUrl, String stepDescription) {
        this.stepPictureUrl = stepPictureUrl;
        this.stepDescription = stepDescription;
    }

    public String getStepPictureUrl() {
        return stepPictureUrl;
    }

    public String getStepDescription() {
        return stepDescription;
    }
}
