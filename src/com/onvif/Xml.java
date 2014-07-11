package com.onvif;

import org.xmlsoap.schemas.soap.envelope.Envelope;

/**
 * Created by calc on 10.07.14.
 *
 */
public class Xml {
    private Envelope Envelope;

    public Envelope getEnvelope() {
        return Envelope;
    }

    public void setEnvelope(Envelope envelope) {
        Envelope = envelope;
    }
}
