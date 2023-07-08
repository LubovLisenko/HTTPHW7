package org.example;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class HttpStatusChecker {
    String uri;

    String getStatusImage(int code) {
        uri = "https://http.cat/" + code + ".jpg";
        HttpRequest httpRequest = HttpRequest.newBuilder()
                .uri(URI.create(uri))
                .GET()
                .build();
        HttpClient httpClient = HttpClient.newBuilder()
                .version(HttpClient.Version.HTTP_1_1)
                .build();
        try {
            HttpResponse<String> send = httpClient.send(httpRequest, HttpResponse.BodyHandlers.ofString());
            if (send.statusCode() == 200) {
                return uri;
            }
            else if (send.statusCode() ==404){
                throw new IOException("Wrong error code " + send.statusCode());
            }
        } catch (IOException | InterruptedException e) {
            System.out.println("There is not image for HTTP status " + code);

        }
        return null;
    }
}
