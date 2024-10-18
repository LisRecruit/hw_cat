import java.util.Scanner;

public class HttpImageStatusCli {
    private final HttpStatusImageDownloader downloader = new HttpStatusImageDownloader();

    public void askStatus() {
        Scanner scanner = new Scanner(System.in);
        boolean isValid = false;
        while (!isValid) {
            System.out.print("Enter HTTP status code: ");
            String input = scanner.nextLine();
            try {
                int code = Integer.parseInt(input);
                downloader.downloadStatusImage(code);
                System.out.println("Image downloaded successfully for status " + code);
                isValid = true;
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid number");
            } catch (Exception e) {
                isValid = true;
                System.out.println("There is no image for HTTP status " + input);
            }
        }
    }

    public static void main(String[] args) {
        HttpImageStatusCli cli = new HttpImageStatusCli();
        cli.askStatus();
    }
}
