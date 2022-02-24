package interfell.vehicle.miles.core;

import java.util.Map;

public class AuthorizationContext {

    private String jwtToken;
    private String authorizationHeader;
    private Map<String, Object> additionalClaims;

    public String getJwtToken() {
        return jwtToken;
    }

    public void setJwtToken(String jwtToken) {
        this.jwtToken = jwtToken;
    }

    public String getAuthorizationHeader() {
        return authorizationHeader;
    }

    public void setAuthorizationHeader(String authorizationHeader) {
        this.authorizationHeader = authorizationHeader;
    }

    public Map<String, Object> getAdditionalClaims() {
        return additionalClaims;
    }

    public void setAdditionalClaims(Map<String, Object> additionalClaims) {
        this.additionalClaims = additionalClaims;
    }
}
