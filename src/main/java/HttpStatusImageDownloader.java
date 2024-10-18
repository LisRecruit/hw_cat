
import java.io.InputStream;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;

public class HttpStatusImageDownloader {
    private final HttpStatusChecker checker = new HttpStatusChecker();

    public void downloadStatusImage(int code) throws Exception {
        try {
            String imageUrl = checker.getStatusImage(code);
            URL url = new URL(imageUrl);

            try (InputStream in = url.openStream()) {
                Files.copy(in, Paths.get(code + ".jpg"));
            }

            System.out.println("Image downloaded: " + code + ".jpg");
        } catch (Exception e) {
            throw new Exception("Failed to download image for HTTP status: " + code, e);
        }
    }
}
