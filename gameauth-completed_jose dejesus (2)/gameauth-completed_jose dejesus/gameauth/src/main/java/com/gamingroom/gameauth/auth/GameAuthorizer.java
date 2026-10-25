/**
 * CS 230 - Module Four Assignment
 * Author: Jose de Jesus
 */
package com.gamingroom.gameauth.auth;

import io.dropwizard.auth.Authorizer;

public class GameAuthorizer implements Authorizer<GameUser> 
{
    @Override
    public boolean authorize(GameUser user, String role) {

        // Just check whether the role we're asking about is one this user
        // was given back in GameAuthenticator. No user or no roles = no access.
        return user != null
                && user.getRoles() != null
                && user.getRoles().contains(role);
    }
}
