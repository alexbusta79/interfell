package interfell.vehicle.miles.core;

import java.util.UUID;

public class ApplicationContext {

	private String name;
	private String transactionId;
	private String requestId;
	private String forwaredFor;
	private String clientId;

	public static ApplicationContext initWithDefault() {
		ApplicationContext applicationContext = new ApplicationContext();
		applicationContext.setRequestId(UUID.randomUUID().toString());
		applicationContext.setTransactionId(UUID.randomUUID().toString());
		return applicationContext;
	}

	public String getClientId() {
		return clientId;
	}

	public void setClientId(String clientId) {
		this.clientId = clientId;
	}

	public String getForwaredFor() {
		return forwaredFor;
	}

	public void setForwaredFor(String forwaredFor) {
		this.forwaredFor = forwaredFor;
	}

	public String getName() {
		return this.name;
	}

	public String getTransactionId() {
		return this.transactionId;
	}

	public String getRequestId() {
		return this.requestId;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setTransactionId(String transactionId) {
		this.transactionId = transactionId;
	}

	public void setRequestId(String requestId) {
		this.requestId = requestId;
	}
}
