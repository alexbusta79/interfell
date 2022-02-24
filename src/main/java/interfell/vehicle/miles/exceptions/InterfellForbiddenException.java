package interfell.vehicle.miles.exceptions;

import org.springframework.http.HttpStatus;

public class InterfellForbiddenException extends InterfellDomainException {

	private static final long serialVersionUID = -6106500527886476791L;

	public InterfellForbiddenException(String message) {
        this(message, InterfellErrorCode.CODE_GENERIC);
    }

    public InterfellForbiddenException(String message, String code) {
        super(message, code, HttpStatus.FORBIDDEN);
    }

}
