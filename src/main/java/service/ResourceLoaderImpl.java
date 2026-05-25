package service;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

@Service
@Primary
public class ResourceLoaderImpl implements ResourceLoader {
    public Properties loadProperties(String resourceName) {
        Properties properties = new Properties();

        try (InputStream input = getClass()
            .getClassLoader()
            .getResourceAsStream(resourceName)) {

            properties.load(input);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return properties;
    }
}
