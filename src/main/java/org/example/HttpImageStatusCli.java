package org.example;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Scanner;

public class HttpImageStatusCli {
    HttpStatusChecker httpStatusChecker = new HttpStatusChecker();
    HttpStatusImageDownloader downloader = new HttpStatusImageDownloader();

    void askStatus() throws URISyntaxException, IOException {
        System.out.println("Enter HTTP status code: ");
        Scanner scanner = new Scanner(System.in);
        String number = scanner.nextLine();
        try {
            int numberDbl = Integer.parseInt(number);
            String image = httpStatusChecker.getStatusImage(numberDbl);
            if (image != null) {
                downloader.downloadStatusImage(numberDbl);
            }
        } catch (NumberFormatException ex) {
            System.out.println("Please enter valid number");
        }
        scanner.close();
    }
}


