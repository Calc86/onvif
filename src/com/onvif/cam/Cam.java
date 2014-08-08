package com.onvif.cam;

import com.onvif.JAXBContext;
import com.onvif.net.HTTP;
import com.onvif.Query;
import com.onvif.Response;
import com.onvif.security.Security;
import org.onvif.ver10.device.wsdl.GetCapabilities;
import org.onvif.ver10.device.wsdl.GetCapabilitiesResponse;
import org.onvif.ver10.device.wsdl.GetSystemDateAndTime;
import org.onvif.ver10.device.wsdl.GetSystemDateAndTimeResponse;
import org.onvif.ver10.media.wsdl.*;
import org.onvif.ver10.schema.CapabilityCategory;
import org.onvif.ver10.schema.DateTime;
import org.onvif.ver10.schema.StreamSetup;
import org.onvif.ver10.schema.StreamType;
import org.onvif.ver10.schema.Transport;
import org.onvif.ver10.schema.Profile;
import org.onvif.ver10.schema.TransportProtocol;
import org.w3._2003._05.soap_envelope.Body;
import org.w3._2003._05.soap_envelope.Envelope;
import org.w3._2003._05.soap_envelope.Header;
import sun.java2d.SurfaceDataProxy;

import javax.xml.bind.JAXBException;
import javax.xml.namespace.QName;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

/**
 * Created by calc on 11.07.14.
 *
 */
public class Cam {
    public static final TransportProtocol DEFAULT_PROTOCOL = TransportProtocol.TCP;
    public static final StreamType DEFAULT_STREAM = StreamType.RTP_UNICAST;
    private URL onvifURL;

    private boolean authorize = false;
    private String user;
    private String password;
    private Header header = null;


    private URL onvifDevice;
    private URL onvifMedia;
    private Query query = new Query();
    private HTTP http = new HTTP();
    private TransportProtocol transportProtocol;
    private StreamType streamType;
    private URL onvifAnalytics;
    private URL onvifEvents;
    private URL onvifImaging;
    private URL onvifPTZ;
    private boolean isDebug = false;

    private int sequence = 0;
    private boolean isSave = false;

    private List<Profile> profiles;

    public Cam(String onvifURL) throws MalformedURLException {
        this(onvifURL, DEFAULT_PROTOCOL, DEFAULT_STREAM);
    }

    public Cam(String onvifURL, TransportProtocol protocol, StreamType stream) throws MalformedURLException {
        transportProtocol = protocol;
        streamType = stream;
        this.onvifURL = new URL(onvifURL);
        if(this.onvifURL.getUserInfo() != null){
            authorize = true;
            String[] tmp = this.onvifURL.getUserInfo().split(":");
            user = tmp[0];
            if(tmp.length>1) password = tmp[1];
        }
    }

    public void setDebug(boolean value){
        isDebug = value;
    }

    public void setSave(boolean isSave) {
        this.isSave = isSave;
    }

    public void init() throws IOException {
        setEndpoints();
        setHeader();
        setProfiles();
    }

    private String query(URL endPoint, Object o) throws IOException {
        if(endPoint == null) return "";

        String query =this.query.getXML(o, header);
        if(isDebug) System.out.println(query);
        String response = null;
        try {
            response = http.post(endPoint, query);
        } catch (IOException e) {
            e.printStackTrace();
            System.err.println(endPoint);
            System.err.println(query);
            throw e;
        }
        if(isDebug) System.out.println(response);

        if(isSave){
            String method = o.getClass().toString();
            sequence++;
            save( endPoint.getHost() + "_" + sequence + "_" + method + "_query", query);
            save( endPoint.getHost() + "_" + sequence + "_" + method + "_response", response);
        }

        return response;
    }

    private void save(String name, String xml){
        try {
            File f = new File(name + ".xml");
            FileWriter fw = new FileWriter(f);
            fw.write(xml);

            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void setEndpoints() throws IOException {
        GetCapabilities getCapabilities = new GetCapabilities();
        getCapabilities.getCategory().add(CapabilityCategory.ALL);

        String response = query(onvifURL, getCapabilities);

        Response<GetCapabilitiesResponse> r = new Response<>();
        GetCapabilitiesResponse capabilities = r.getResponse(response);

        if(capabilities.getCapabilities().getAnalytics() != null)
            if(capabilities.getCapabilities().getAnalytics().isAnalyticsModuleSupport())
                onvifAnalytics = new URL(capabilities.getCapabilities().getAnalytics().getXAddr());

        if(capabilities.getCapabilities().getDevice() != null
                && capabilities.getCapabilities().getDevice().getXAddr() != null)
            onvifDevice = new URL(capabilities.getCapabilities().getDevice().getXAddr());

        if(capabilities.getCapabilities().getEvents() != null
                && capabilities.getCapabilities().getEvents().getXAddr() != null)
            onvifEvents = new URL(capabilities.getCapabilities().getEvents().getXAddr());

        if(capabilities.getCapabilities().getImaging() != null
                && capabilities.getCapabilities().getImaging().getXAddr() != null)
            onvifImaging = new URL(capabilities.getCapabilities().getImaging().getXAddr());

        if(capabilities.getCapabilities().getMedia() != null
                && capabilities.getCapabilities().getMedia().getXAddr() != null)
            onvifMedia = new URL(capabilities.getCapabilities().getMedia().getXAddr());

        if(capabilities.getCapabilities().getPTZ() != null
                && capabilities.getCapabilities().getPTZ().getXAddr() != null)
            onvifPTZ = new URL(capabilities.getCapabilities().getPTZ().getXAddr());
    }

    private void setHeader() throws IOException {
        if(!authorize) return;

        GetSystemDateAndTimeResponse r = getSystemDateAndTime();
        DateTime dateTime = r.getSystemDateAndTime().getLocalDateTime();

        Security security = new Security(dateTime, user, password, "calcOnvif");
        header = security.buildHeader();
    }

    public void test(Security security){
        Header header = security.buildHeader();
        /*Body body = new Body();
        Envelope e = new Envelope();
        e.setHeader(header);
        e.setBody(body);*/

        System.out.println(query.getXML(null, header));

    }

    private void setProfiles() throws IOException {
        String response = query(onvifMedia, new GetProfiles());

        Response<GetProfilesResponse> r = new Response<>();
        GetProfilesResponse profilesResponse = r.getResponse(response);

        profiles = profilesResponse.getProfiles();
    }

    public GetSystemDateAndTimeResponse getSystemDateAndTime() throws IOException {
        GetSystemDateAndTime getSystemDateAndTime = new GetSystemDateAndTime();

        String response = query(onvifMedia, getSystemDateAndTime);

        Response<GetSystemDateAndTimeResponse> r = new Response<>();
        return r.getResponse(response);
    }

    public GetStreamUriResponse getStreamUri(Profile profile) throws IOException {
        GetStreamUri s = new GetStreamUri();
        StreamSetup ss = new StreamSetup();
        Transport t = new Transport();
        t.setProtocol(transportProtocol);
        ss.setTransport(t);
        ss.setStream(streamType);
        s.setStreamSetup(ss);
        s.setProfileToken(profile.getToken());

        String response = query(onvifMedia, s);

        Response<GetStreamUriResponse> r = new Response<>();
        return r.getResponse(response);
    }

    public GetSnapshotUriResponse getSnapshotUri(Profile profile) throws IOException {
        GetSnapshotUri getSnapshotUri = new GetSnapshotUri();
        getSnapshotUri.setProfileToken(profile.getToken());

        String response = query(onvifMedia, getSnapshotUri);

        Response<GetSnapshotUriResponse> r = new Response<>();
        return r.getResponse(response);
    }

    public List<Profile> getProfiles() {
        return profiles;
    }

    public static void main(String[] args) {

        try {
            JAXBContext.create();
        } catch (JAXBException e) {
            e.printStackTrace();
        }

        GetSystemDateAndTimeResponse r = null;
        try {
            Cam cam = new Cam("http://admin:admin@10.112.28.231/onvif/device_service");
            cam.init();
            //r.getSystemDateAndTime().
            //cam.init();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        /*try {
            URL url = new URL("http://admin@10.112.28.231/onvif/device_service");
            System.out.println(url.getAuthority());
            System.out.println(url.getUserInfo());
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }*/
    }
}
