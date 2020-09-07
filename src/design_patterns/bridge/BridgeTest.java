package design_patterns.bridge;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;

/**
 */
public class BridgeTest {
    @Test
    public void testBasics() {
        final Connection connection = new WifiConnection();
        connection.write("<some film content>");

        final FilmDownloader downloader = new DramaFilmDownloader(connection);

        assertThat(downloader.download())
                .isEqualTo("DramaFilmDownloader got <some film content> by Wifi connection");
    }

    @Test
    public void testAdditionalDownloaderWithAdditionalConnection() {
        final Connection connection = new SuperWifiConnection();
        connection.write("<romantic film content #1>");

        final FilmDownloader downloader = new RomanticFilmDownloader(connection);

        assertThat(downloader.download())
                .isEqualTo("RomanticFilmDownloader obtained <romantic film content #1> by Super-Wifi connection");
    }
}
