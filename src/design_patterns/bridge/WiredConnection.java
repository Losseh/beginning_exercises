package design_patterns.bridge;

/**
 */
public class WiredConnection implements Connection {
    private String obtainedMessage;

    public WiredConnection() {
        obtainedMessage = "";
    }

    @Override
    public String get() {
        return obtainedMessage + " by Wired connection";
    }

    @Override
    public void write(final String message) {
        obtainedMessage = message;
    }
}
