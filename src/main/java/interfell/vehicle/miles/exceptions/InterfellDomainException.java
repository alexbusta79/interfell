package interfell.vehicle.miles.exceptions;

import org.springframework.http.HttpStatus;
import java.util.Map;

public class InterfellDomainException  extends Exception implements IInterfellDomainException {

	private static final long serialVersionUID = -7106410725106229997L;

	/**
     * error code
     */
    private final String code;

    /**
     * status of the http response (default 500)
     */
    private final HttpStatus responseStatus;

    /**
     * error type (default TECHNICAL)
     */
    private final InterfellErrorTypeEnum errorType;

    /**
     * error severity (default ERROR)
     */
    private final InterfellSeverityEnum severity;

    /**
     * map of custom domain information
     */
    private final Map<String,Object> additionalInfo;



    public InterfellDomainException(String message, String code, HttpStatus responseStatus) {
        super(message);
        this.code = code;
        this.responseStatus = responseStatus;
        this.errorType = InterfellErrorTypeEnum.BUSINESS;
        this.severity= InterfellSeverityEnum.ERROR;
        this.additionalInfo = null;
    }

    public InterfellDomainException(String message, String code, HttpStatus responseStatus, InterfellErrorTypeEnum errorType, InterfellSeverityEnum severity) {
        super(message);
        this.code = code;
        this.responseStatus = responseStatus;
        this.errorType = errorType;
        this.severity = severity;
        this.additionalInfo = null;
    }

    public InterfellDomainException(String message, String code, HttpStatus responseStatus, InterfellErrorTypeEnum errorType, InterfellSeverityEnum severity, Map<String, Object> additionalInfo) {
        super(message);
        this.code = code;
        this.responseStatus = responseStatus;
        this.errorType = errorType;
        this.severity = severity;
        this.additionalInfo = additionalInfo;
    }

    @Override
    public String getCode() {
        return code;
    }

    @Override
    public HttpStatus getResponseStatus() {
        return responseStatus;
    }

    public InterfellErrorTypeEnum getErrorType() {
        return errorType;
    }

    public InterfellSeverityEnum getSeverity() {
        return severity;
    }

    @Override
    public Map<String, Object> getAdditionalInfo() {
        return additionalInfo;
    }
}
