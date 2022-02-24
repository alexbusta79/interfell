package interfell.vehicle.miles.core;

import java.io.Serializable;

public class BaseContext<U, C> implements Serializable {

    public static final BaseContext EMPTY_SESSION = new BaseContext();

    private String sessionId;
    private String environment;
    private U user;
    private C customer;

    public String getSessionId() {
        return sessionId;
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }

    public String getEnvironment() {
        return environment;
    }

    public void setEnvironment(String environment) {
        this.environment = environment;
    }

    public U getUser() {
        return user;
    }

    public void setUser(U user) {
        this.user = user;
    }

    public C getCustomer() {
        return customer;
    }

    public void setCustomer(C customer) {
        this.customer = customer;
    }

}
