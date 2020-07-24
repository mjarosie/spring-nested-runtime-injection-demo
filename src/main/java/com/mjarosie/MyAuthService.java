package com.mjarosie;

public class MyAuthService {
    private final String environment;
    private final String clientId;
    private final String clientSecret;

    public MyAuthService(String environment, String clientId, String clientSecret) {
        this.environment = environment;
        this.clientId = clientId;
        this.clientSecret = clientSecret;
    }

    public String getToken() {
        System.out.println("Retrieving a token on " + environment +
                " environment with client ID: " + clientId +
                ", client secret: "+ clientSecret);
        return "___SECRET_TOKEN___";
    }
}
