package design_patterns.bridge;

/**
 */
public interface Connection {
    String get();

    void write(final String message);
}
