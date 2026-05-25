package service;

import java.util.Properties;

public interface ResourceLoader {
    Properties loadProperties(String resourceName);
}
