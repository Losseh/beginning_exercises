package design_patterns.bridge;

/**
 */
public class SciFiFilmDownloader extends FilmDownloader {
    private Connection connection;

    public SciFiFilmDownloader(final Connection connection) {
        this.connection = connection;
    }

    @Override
    String download() {
        return "SciFiFilmDownloader got " + connection.get();
    }
}
