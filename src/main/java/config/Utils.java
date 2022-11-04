package config;

import java.net.URI;

public class Utils {
    public static String getUsername() {
        Settings settings = new Settings();
        return URI.create(settings.getUsername()).toString();
    }

    public static String getPassword() {
        Settings settings = new Settings();
        return URI.create(settings.getPassword()).toString();
    }

    public static String getCareSpeakUrl() {
        Settings settings = new Settings();
        return URI.create(settings.getCareSpeakHost()).toString();
    }
}
