import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URL;

public class HttpStatusChecker {
    private static final String BASE_URL = "http.cat";

    public String getStatusImage(int code) throws Exception {
        URI uri = new URI("https", BASE_URL, "/" + code + ".jpg", null);
        URL url = uri.toURL();

        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");
        connection.connect();

        int responseCode = connection.getResponseCode();
        if (responseCode == 404) {
            throw new Exception("Image not found for HTTP status: " + code);
        }

        return url.toString();
    }

}
