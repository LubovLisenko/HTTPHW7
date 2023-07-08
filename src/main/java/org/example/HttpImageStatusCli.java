package org.example;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Scanner;

public class HttpImageStatusCli {
    HttpStatusChecker httpStatusChecker = new HttpStatusChecker();
    HttpStatusImageDownloader downloader = new HttpStatusImageDownloader();

    void askStatus() throws URISyntaxException, IOException {
        System.out.println("Enter HTTP status code");
        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();
        scanner.close();
        String image = httpStatusChecker.getStatusImage(number);
        if (image != null) {
            downloader.downloadStatusImage(number);
        } else System.out.println(("Enter valid number"));
    }
}

