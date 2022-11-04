package config;

import basic.exceptions.UnknownPropertyException;
import java.util.ResourceBundle;

public class Settings {

    private static String site;
    private static String username;
    private static String password;
    private static ResourceBundle resourceBundle;
    private static String careSpeakHost;

    public Settings() {
        loadSettings();
    }

    public static String getCareSpeakHost() {
        return careSpeakHost;
    }

    public static String getUsername() {
        return username;
    }

    public static String getPassword() {
        return password;
    }

    public static String getPropertyOrNull(String name) {
        return getProperty(name, false);
    }

    private static String getProperty(String name, boolean forceExceptionIfNotDefined) {
        String result;
        if ((result = System.getProperty(name)) != null && result.length() > 0) {
            return result;
        } else if ((result = getPropertyFromPropertiesFile(name)) != null && result.length() > 0) {
            return result;
        } else if (forceExceptionIfNotDefined) {
            throw new UnknownPropertyException("Unknown property: [" + name + "]");
        }
        return result;
    }

    private static String getPropertyFromPropertiesFile(String name) {
        try {
            return resourceBundle.getString(name);
        } catch (java.lang.NullPointerException | java.util.MissingResourceException e) {
            return "";
        }
    }

    private void loadSettings() {
        resourceBundle = loadResourceBundle();
        site = getPropertyOrNull("site");
        username = getPropertyOrNull("username");
        password = getPropertyOrNull("password");
        careSpeakHost = getPropertyOrNull("careSpeakHost");
    }

    private ResourceBundle loadResourceBundle() {
        // get specified resource bundle
        if (site == null || site.equals(""))
            return ResourceBundle.getBundle("dev");
        else if (site.contains("DEV"))
            return ResourceBundle.getBundle("dev");
        return null;
    }
}
