import com.cam.Cam;
import com.cam.Profile;
import com.google.gson.Gson;
import com.onvif.JAXBContext;
import org.onvif.ver10.media.wsdl.GetSnapshotUriResponse;
import org.onvif.ver10.media.wsdl.GetStreamUriResponse;

import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.net.ConnectException;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.List;


/**
 * Created by calc on 10.07.14.
 *
 */
public class Main {

    private static String json(String error, String profiles){
        return "{\"error\":\"" + error + "\", \"profiles\":" + profiles + "}";
    }

    private static void error(String s){
        System.out.println(json(s, "[]"));
    }

    private static void error(Exception e){
        error(e.getMessage());
    }

    private static void usage(){
        System.out.println("Usage: onvif [OPTION]... [URL]");
        System.out.println("Get onvif data and convert it to json");
        System.out.println();
        System.out.println("  -s, --save     save xml query and response");
        System.out.println("  -d, --debug    debug output of xml");
    }

    public static void main(String[] args){
        if(args.length == 0){
            error("need onvif url");
            return;
        }

        try {
            JAXBContext.create();
        } catch (JAXBException e) {
            e.printStackTrace();
            error("JAXBContext init fail");
            return;
        }

        Cam cam;

        try {
            cam = new Cam(args[args.length-1]);

            for(String param : args){
                if(param.equals("--debug") || param.equals("-d")){
                    cam.setDebug(true);
                }
                if(param.equals("--save") || param.equals("-s")){
                    cam.setSave(true);
                }
            }

            cam.init();

        } catch (ConnectException | MalformedURLException e){
            error(e); return;
        } catch (IOException e) {
            e.printStackTrace();
            error(e); return;
        }

        List<Profile> profiles = new ArrayList<>();

        for(org.onvif.ver10.schema.Profile p : cam.getProfiles()){
            GetStreamUriResponse stream = null;
            GetSnapshotUriResponse snap = null;
            try {
                stream = cam.getStreamUri(p);
                snap = cam.getSnapshotUri(p);
            } catch (IOException e) {
                e.printStackTrace();
            }

            Profile profile = new Profile();
            profile.setName(p.getName());
            profile.setEncoding(p.getVideoEncoderConfiguration().getEncoding().value());
            profile.setWidth(p.getVideoEncoderConfiguration().getResolution().getWidth());
            profile.setHeight(p.getVideoEncoderConfiguration().getResolution().getHeight());
            profile.setQuality(p.getVideoEncoderConfiguration().getQuality());

            Profile.URI video = profile.new URI();
            profile.setVideo(video);
            Profile.URI snapshot = profile.new URI();
            profile.setSnap(snapshot);

            if(stream != null){
                video.setUri(stream.getMediaUri().getUri());
                if(stream.getMediaUri().getTimeout() != null)
                    video.setTtl(stream.getMediaUri().getTimeout().toString());
                video.setInvalidAfterConnection(stream.getMediaUri().isInvalidAfterConnect());
                video.setInvalidAfterReboot(stream.getMediaUri().isInvalidAfterReboot());
            }

            if(snap != null){
                snapshot.setUri(snap.getMediaUri().getUri());
                if(snap.getMediaUri().getTimeout() != null)
                    snapshot.setTtl(snap.getMediaUri().getTimeout().toString());
                snapshot.setInvalidAfterConnection(snap.getMediaUri().isInvalidAfterConnect());
                snapshot.setInvalidAfterReboot(snap.getMediaUri().isInvalidAfterReboot());
            }

            profiles.add(profile);
        }

        Gson gson = new Gson();
        System.out.println(json("null", gson.toJson(profiles)));

    }
}
