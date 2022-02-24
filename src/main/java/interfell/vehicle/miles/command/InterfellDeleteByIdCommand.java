package interfell.vehicle.miles.command;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import interfell.vehicle.miles.exceptions.InterfellForbiddenException;
import interfell.vehicle.miles.service.InterfellService;

@Component
@Scope("prototype")
public class InterfellDeleteByIdCommand extends BaseCommand<Boolean> {
	
	@Autowired 
	private InterfellService service;
	
	private final Long idInterfell;
	
	public InterfellDeleteByIdCommand(Long idInterfell) {
		this.idInterfell = idInterfell;
	}
	
	@Override
	public Boolean doExecute() throws Exception {
		long startTime = System.currentTimeMillis(); 

		Boolean interfellDelete = this.service.deleteInterfellById(this.idInterfell);

		return interfellDelete;
	}
	
	@Override 
    protected boolean canExecute() throws InterfellForbiddenException {
        return true;
    }
}