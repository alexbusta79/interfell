package interfell.vehicle.miles.exceptions;

import java.util.Map;
import org.springframework.http.HttpStatus;

public interface IInterfellDomainException {

    String getCode();
    
    HttpStatus getResponseStatus();
    
    Map<String, Object> getAdditionalInfo();
}
