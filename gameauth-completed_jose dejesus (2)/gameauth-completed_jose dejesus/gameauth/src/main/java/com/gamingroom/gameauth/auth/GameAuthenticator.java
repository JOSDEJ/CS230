/**
 * CS 230 - Module Four Assignment
 * Author: Jose de Jesus
 */
package com.gamingroom.gameauth.auth;


import io.dropwizard.auth.AuthenticationException;
import io.dropwizard.auth.Authenticator;
import io.dropwizard.auth.basic.BasicCredentials;
 
import java.util.Map;
import java.util.Optional;
import java.util.Set;
 
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
 
public class GameAuthenticator implements Authenticator<BasicCredentials, GameUser> 
{
		
	private static final Map<String, Set<String>> VALID_USERS = ImmutableMap.of(
        "guest", ImmutableSet.of(),
        "user", ImmutableSet.of("USER"),
        "admin", ImmutableSet.of("ADMIN", "USER")
    );
 
    @Override
    public Optional<GameUser> authenticate(BasicCredentials credentials) throws AuthenticationException 
    {
        if (VALID_USERS.containsKey(credentials.getUsername()) && "password".equals(credentials.getPassword())) 
        {
            // Username/password checked out, so pull their roles from the map
            // above and wrap everything up in a GameUser the rest of the app can use.
            String username = credentials.getUsername();
            Set<String> roles = VALID_USERS.get(username);
            return Optional.of(new GameUser(username, roles));
        }
        return Optional.empty();
    }
}
