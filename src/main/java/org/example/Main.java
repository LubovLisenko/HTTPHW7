package org.example;

import java.io.IOException;
import java.net.URISyntaxException;

public class Main {
    public static void main(String[] args) throws URISyntaxException, IOException, InterruptedException {
        //new HttpStatusChecker().getStatusImage(306);
        //new HttpStatusImageDownloader().downloadStatusImage(103);
        new HttpImageStatusCli().askStatus();


    }
}