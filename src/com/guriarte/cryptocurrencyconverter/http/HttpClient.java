package com.guriarte.cryptocurrencyconverter.http;

import com.guriarte.cryptocurrencyconverter.http.exceptions.HttpUnexpectedError;
import com.guriarte.cryptocurrencyconverter.mappers.JsonMapper;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class HttpClient {

    private final java.net.http.HttpClient client;

    public HttpClient() {
        this.client = java.net.http.HttpClient.newHttpClient();

    }

    public HttpResponse<String> get(String url) throws HttpUnexpectedError {
        try {
            return this.client.send(createGetRequest(url), HttpResponse.BodyHandlers.ofString());
        } catch (IOException | InterruptedException e) {
            throw new HttpUnexpectedError();
        }
    }

    private HttpRequest createGetRequest (String url) {
        return HttpRequest.newBuilder()
                .uri(URI.create(url))
                .GET()
                .build();
    }

}
