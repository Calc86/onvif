package com.cam;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by calc on 11.07.14.
 *
 */
public class Cam {
    private URL onvif;
    private URL onvifDevice;
    private URL onvifMedia;

    public Cam(String onvif) throws MalformedURLException {
        this.onvif = new URL(onvif);
    }

    private void setEndpoints(){
            
    }
}
