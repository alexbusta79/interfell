package interfell.vehicle.miles.controller;

import org.slf4j.Logger;
import org.springframework.web.bind.annotation.RestController;
import interfell.vehicle.miles.core.ApplicationContext;
import interfell.vehicle.miles.interceptors.RequestContextHolder;
import interfell.vehicle.miles.utils.LoggerUtils;
import javax.servlet.http.HttpServletRequest;

@RestController
public abstract class BaseController {

	protected final Logger logger = LoggerUtils.getLogger(this.getClass());

	public static final String CLIENT_ID = "x-client-id";
	public static final String JWT_TOKEN = "bearer";
	public static final String REQUEST_ID = "x-request-id";

	public String getRequestId() {
		return getRequest().getHeader(REQUEST_ID);
	}

	public String getClientId() {
		return getRequest().getHeader(CLIENT_ID);
	}

	public String getJwtToken() {
		return getRequest().getHeader(JWT_TOKEN);
	}

	protected HttpServletRequest getRequest() {
		return RequestContextHolder.getRequest();
	}

	protected ApplicationContext getApplicationContext() {
		return RequestContextHolder.getApplicationContext();
	}
}
