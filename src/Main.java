import com.net.HTTP;
import com.onvif.Query;
import com.onvif.Response;
import org.onvif.ver10.device.wsdl.GetCapabilities;
import org.onvif.ver10.device.wsdl.GetCapabilitiesResponse;
import org.onvif.ver10.device.wsdl.GetDeviceInformation;
import org.onvif.ver10.media.wsdl.GetVideoSourceConfiguration;
import org.onvif.ver10.media.wsdl.GetVideoSourceConfigurationResponse;
import org.onvif.ver10.media.wsdl.GetVideoSources;
import org.onvif.ver10.media.wsdl.GetVideoSourcesResponse;
import org.onvif.ver10.schema.CapabilityCategory;
import org.onvif.ver10.schema.VideoSource;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;


/**
 * Created by calc on 10.07.14.
 *
 */
public class Main {
    public static void main(String[] args){
        GetCapabilities getCapabilities = new GetCapabilities();
        getCapabilities.getCategory().add(CapabilityCategory.ALL);

        Query o = new Query();
        String xml = o.getXML(getCapabilities);
        System.out.println(xml);

        HTTP http = new HTTP();
        String response = "";
        try {
            response = http.post(new URL("http://10.113.151.152:12001/"), xml);
            System.out.println(response);
            File resFile = new File("res.xml");
            FileWriter fw = new FileWriter(resFile);
            fw.write(response);
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        Response<GetCapabilitiesResponse> r = new Response<>(GetCapabilitiesResponse.class);
        GetCapabilitiesResponse g2 = r.getResponse(response);

        //http://10.113.151.152:12001/tds/device
        xml = o.getXML(new GetDeviceInformation());
        System.out.println(xml);

        try {
            response = http.post(new URL("http://10.113.151.152:12001/tds/device"), xml);
            System.out.println(response);

            Response<GetCapabilitiesResponse> r2 = new Response<>(GetCapabilitiesResponse.class);
        } catch (IOException e) {
            e.printStackTrace();
        }

        xml = o.getXML(new GetVideoSources());
        System.out.println(xml);

        try {
            response = http.post(new URL("http://10.113.151.152:12001/tds/media"), xml);
            System.out.println(response);

            Response<GetVideoSourcesResponse> r3 = new Response<>(GetVideoSourcesResponse.class);
            GetVideoSourcesResponse vss = r3.getResponse(response);

            VideoSource vs = vss.getVideoSources().get(0);
            String token = vs.getToken();

            GetVideoSourceConfiguration vsc = new GetVideoSourceConfiguration();
            vsc.setConfigurationToken(token);
            xml = o.getXML(vsc);
            System.out.println(xml);
            response = http.post(new URL("http://10.113.151.152:12001/tds/media"), xml);
            System.out.println(response);
            Response<GetVideoSourceConfigurationResponse> rvsc = new Response<>(GetVideoSourceConfigurationResponse.class);
            GetVideoSourceConfigurationResponse vscr = rvsc.getResponse(response);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
