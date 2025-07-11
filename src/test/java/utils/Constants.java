package utils;

public class Constants {
    public static final int IMPLICIT_WAIT = ConfigReader.getInt("implicitWait");
    public static final int EXPLICIT_WAIT = ConfigReader.getInt("explicitWait");
    public static final int PAGE_LOAD_TIMEOUT = ConfigReader.getInt("pageLoadTimeout");
    public static final String CORRECT_EMAIL = ConfigReader.get("correctEmail");
    public static final String CORRECT_PASSWORD = ConfigReader.get("correctPassword");
}
