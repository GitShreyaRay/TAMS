package fullstackbasics.io.tams_core_api.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.thoughtworks.xstream.XStream;

@Configuration
public class AxonXStreamConfig {
    @Bean
    public XStream xStream() {
        XStream xStream = new XStream();
 
 
        xStream.allowTypesByWildcard(new String[] {
                "io.fullstackbasics.**",
                "fullstackbasics.io.**"
        });
 
        return xStream;
    }
}

