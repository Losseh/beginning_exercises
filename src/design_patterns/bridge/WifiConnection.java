package design_patterns.bridge;

/**
 */
public class WifiConnection implements Connection {
    private String obtainedMessage;

    public WifiConnection() {
        obtainedMessage = "";
    }

    @Override
    public String get() {
        return obtainedMessage + " by Wifi connection";
    }

    @Override
    public void write(final String message) {
        obtainedMessage = message;
    }
}
