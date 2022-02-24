package interfell.vehicle.miles.command;

import java.util.List;

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
public class InterfellCommand extends BaseCommand<List<InterfellDTO>> {
	@Autowired 
	private InterfellService service;
	
	@Autowired 
	private InterfellConverter converter;
	
	@Override
	public List<InterfellDTO> doExecute() throws Exception{	
        long startTime = System.currentTimeMillis();
        
		List<InterfellEntity> interfells = this.service.getInterfells();
		
		logger.info("interfell={}|exito=OK", "RequestId",interfells);
	       
		logger.info("requestId={}|operacion=initial|exito=OK|duracionOperacion={}{}", "RequestId",(System.currentTimeMillis() - startTime)," ms");
       		
		return this.converter.convertInterfellsEntityToInterfellsDTO(interfells); 
	}
	
	
	@Override 
    protected boolean canExecute() throws InterfellForbiddenException {
        return true;
    }

}
