package com.clarete.finance.dataprovider.mysql.http;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class validateTransfer {

    private final HttpClient httpClient = HttpClient.newHttpClient();

    public boolean authorizeTransaction() throws IOException, InterruptedException{
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://util.devi.tools/api/v2/authorize"))
                .GET()
                .build();

        HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());

        return Boolean.parseBoolean(response.body());
    }
}
