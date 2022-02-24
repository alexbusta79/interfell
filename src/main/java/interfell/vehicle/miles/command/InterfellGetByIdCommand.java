package interfell.vehicle.miles.command;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import interfell.vehicle.miles.converter.InterfellConverter;
import interfell.vehicle.miles.dto.InterfellDTO;
import interfell.vehicle.miles.entity.InterfellEntity;
import interfell.vehicle.miles.exceptions.InterfellForbiddenException;
import interfell.vehicle.miles.service.InterfellService;

@Component
@Scope("prototype")
public class InterfellGetByIdCommand extends BaseCommand<InterfellDTO> {
	
	@Autowired 
	private InterfellService service;
	
	@Autowired 
	private InterfellConverter converter;
	
	private final Long idInterfell;
	
	public InterfellGetByIdCommand(Long idInterfell) {
		this.idInterfell = idInterfell;
	}
	
	@Override
	public  InterfellDTO doExecute() throws Exception {	
		long startTime = System.currentTimeMillis(); 
		
		InterfellEntity interfell = this.service.getInterfellById(this.idInterfell);
		logger.info("requestId={}|operacion=initial|exito=OK|duracionOperacion={}{}", "RequestId",(System.currentTimeMillis() - startTime)," ms");
		
		return this.converter.convertInterfellEntityToInterfellDTO(interfell);
	}
	
	@Override 
    protected boolean canExecute() throws InterfellForbiddenException {
        return true;
    }
}
