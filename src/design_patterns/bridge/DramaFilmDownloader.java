package design_patterns.bridge;

/**
 */
public class DramaFilmDownloader extends FilmDownloader {
    private Connection connection;

    public DramaFilmDownloader(final Connection connection) {
        this.connection = connection;
    }

    @Override
    String download() {
        return "DramaFilmDownloader got " + connection.get();
    }
}
