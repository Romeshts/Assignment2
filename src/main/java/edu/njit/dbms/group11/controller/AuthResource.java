package edu.njit.dbms.group11.controller;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.map.ObjectMapper;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;
import java.io.IOException;
import java.net.URI;

@Path("/auth")
public class AuthResource {

    @GET
    @Path("/google")
    public Response redirectToGoogle() {
        String redirectUri = "http://localhost:8080/mavenLMSWebAppProject/RAHLMS/auth/google/callback";
        String clientId = "659825330701-64d8r9cb03at52elv06r91ke24s0n6ja.apps.googleusercontent.com";
        String oauthUrl = "https://accounts.google.com/o/oauth2/auth" +
                "?response_type=code" +
                "&client_id=" + clientId +
                "&redirect_uri=" + redirectUri +
                "&scope=email%20profile%20openid";
        return Response.seeOther(URI.create(oauthUrl)).build();
    }

    @GET
    @Path("/google/callback")
    public Response handleGoogleCallback(@QueryParam("code") String code) {
        if (code == null || code.isEmpty()) {
            // Handle error: No authorization code received
            return Response.status(Response.Status.BAD_REQUEST).entity("Authorization code not received").build();
        }

        // Exchange authorization code for access token
        String accessToken = exchangeCodeForAccessToken(code);
        if (accessToken == null || accessToken.isEmpty()) {
            // Handle error: Failed to exchange authorization code for access token
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("Failed to exchange code for access token").build();
        }

        // Use the access token to fetch user info
        String userInfo = getUserInfo(accessToken);
        //System.out.println(userInfo.toString());
        if (userInfo == null || userInfo.isEmpty()) {
            // Handle error: Failed to fetch user info
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("Failed to fetch user info").build();
        }

        // Here, you would typically create or authenticate the user in your system
        // Redirect the user to the desired page after successful login
        return Response.seeOther(URI.create("/")).build();
    }

    private String exchangeCodeForAccessToken(String code) {
        try {
            String clientId = "659825330701-64d8r9cb03at52elv06r91ke24s0n6ja.apps.googleusercontent.com";
            String clientSecret = "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";
            String redirectUri = "http://localhost:8080/mavenLMSWebAppProject/RAHLMS/auth/google/callback";
            String response = GoogleOAuthHelper.exchangeCodeForAccessToken(code, clientId, clientSecret, redirectUri);
            JsonParser parser = new JsonParser();
            JsonObject json = parser.parse(response).getAsJsonObject();
            String accessToken = json.get("access_token").getAsString();

            return accessToken;
        } catch (IOException e) {
            // Handle exception
            e.printStackTrace();
        }
        return null;
    }

    private String getUserInfo(String accessToken) {
        try {
            String userInfo = GoogleOAuthHelper.getUserInfo(accessToken);
            // Parse the JSON response and extract user information
            // Example JSON response: {"sub": "1234567890", "name": "John Doe", "email": "johndoe@example.com", ...}
            // Example: return userInfo;

            // Assuming userInfo is a JSON string, you can parse it using a JSON library like Jackson
            ObjectMapper objectMapper = new ObjectMapper();
            JsonNode jsonNode = objectMapper.readTree(userInfo);

            // Extract user information from JSON response
            String userId = jsonNode.get("sub").asText();
            String name = jsonNode.get("name").asText();
            String email = jsonNode.get("email").asText();

            // Create a User object or return the extracted information
            // Example:
            //User user = new User();
            //user.setId(userId);
            //user.setName(name);
            //user.setEmail(email);
            // return user;
            return userId;

        } catch (IOException e) {
            // Handle exception
            e.printStackTrace();
        }
        return null;
    }

}
