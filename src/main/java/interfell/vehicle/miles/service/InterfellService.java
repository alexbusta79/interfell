package interfell.vehicle.miles.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import interfell.vehicle.miles.entity.InterfellEntity;
import interfell.vehicle.miles.exceptions.InterfellDomainException;
import interfell.vehicle.miles.repository.InterfellRepository;

@Service
public class InterfellService extends BaseService{
	
	@Autowired
	InterfellRepository repository;
	
	/**
	 * Metodo que permite obtener todos los Interfell.
	 * @return retorna la lista de los Interfell 
	 */
	public List<InterfellEntity> getInterfells(){
		logger.debug("getInterfells");
		
		List<InterfellEntity> interfells = repository.findAll();
		logger.info("size Interfell = ", interfells.size());

		return interfells.size() >0 ? interfells : new ArrayList<InterfellEntity>();
	}
	
	public InterfellEntity getInterfellById(Long id) throws InterfellDomainException{
	 Optional<InterfellEntity> interfell = repository.findById(id);
		if(interfell.isPresent()){
			return interfell.get();
		} else {
			throw new InterfellDomainException("mensaje de Error", "code", HttpStatus.BAD_REQUEST);
		}
	}

	public Boolean deleteInterfellById(Long id) throws InterfellDomainException {
		Optional<InterfellEntity> interfell = repository.findById(id);
		if (interfell.isPresent()) {
			repository.deleteById(id);
			return true;
		} else {
			return false;
		} 
	}

	/**
	 * Metodo que permite insertar un nuevo Interfell.
	 * @param Interfell es el objeto Interfell 
	 * @return retorna el nuevo Interfell 
	 * @throws InterfellDomainException
	 */
	public InterfellEntity insert(InterfellEntity interfell) throws InterfellDomainException {
		logger.info("{}", "alex");
		logger.info("{}", interfell.toString());
		return repository.save(interfell);
	}
	
	/**
	 * Metodo que permite modificar los campos de Interfell.
	 * @param Interfell es el objeto Interfell con nuevos campos
	 * @return retorna el nuevo Interfell modificado.
	 * @throws InterfellDomainException
	 */
	public InterfellEntity update(InterfellEntity Interfell) throws InterfellDomainException {
		Optional<InterfellEntity> interfellTemp = repository.findById(Interfell.getId());
        if(interfellTemp.isPresent()) {
            InterfellEntity newInterfell = interfellTemp.get();
            newInterfell.setCondado(Interfell.getCondado());
            newInterfell.setDate(Interfell.getDate());
            newInterfell.setPorcentajeDeCambioParaEnero(Interfell.getPorcentajeDeCambioParaEnero());
            newInterfell.setMediaDelCondado(Interfell.getMediaDelCondado());     
            
            newInterfell = repository.save(newInterfell);
             
            return newInterfell;
            
        } else {
        	throw new InterfellDomainException("Interfell esta presente", "code", HttpStatus.BAD_REQUEST);
        }
	}
}
