package com.codefactory.fleetguard360.controller.graphql;

import com.codefactory.fleetguard360.controller.graphql.payload.AuthPayload;
import com.codefactory.fleetguard360.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.stereotype.Controller;

@Controller
public class AuthGraphQLController {

    @Autowired
    private AuthService authService;

    @MutationMapping
    public AuthPayload login(@Argument String correo, @Argument String password) {
        String token = authService.login(correo, password);
        return new AuthPayload(token);
    }
}
