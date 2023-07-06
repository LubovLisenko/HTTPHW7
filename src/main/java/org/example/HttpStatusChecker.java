package org.example;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class HttpStatusChecker {
    String uri;

    String getStatusImage(int code) {
        uri = "https://http.cat/status/" + code;
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
            } else System.out.println("send.statusCode() = "+send.statusCode());
            return uri;
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
