package com.codefactory.fleetguard360.controller.graphql.payload;

public class AuthPayload {
    private String token;

    public AuthPayload(String token) {
        this.token = token;
    }

    public String getToken() {
        return token;
    }
}
