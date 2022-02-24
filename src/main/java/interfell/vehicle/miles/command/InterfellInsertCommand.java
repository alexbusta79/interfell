package interfell.vehicle.miles.command;

import java.util.ArrayList;
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
public class InterfellInsertCommand extends BaseCommand<InterfellDTO> {
 
    @Autowired
    private InterfellService service; 
 
    @Autowired
    private InterfellConverter converter;
    
	private final InterfellDTO input;
	
	public InterfellInsertCommand(InterfellDTO params) {
		this.input = params;
	}
	
	@Override
    public InterfellDTO doExecute() throws Exception {	
        long startTime = System.currentTimeMillis();
        InterfellEntity interfell = this.converter.convertInterfellDTOToInterfellEntity(this.input); 
        InterfellEntity interfellEntity = this.service.insert(interfell);
        
		return this.converter.convertInterfellEntityToInterfellDTO(interfellEntity); 
    }

    @Override 
    protected boolean canExecute() throws InterfellForbiddenException {
        return true;
    }
}