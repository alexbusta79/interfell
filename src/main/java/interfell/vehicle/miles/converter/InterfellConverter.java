package interfell.vehicle.miles.converter;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import interfell.vehicle.miles.dto.InterfellDTO;
import interfell.vehicle.miles.entity.InterfellEntity;

@Component
public class InterfellConverter {
	
	public List<InterfellDTO> convertInterfellsEntityToInterfellsDTO(List<InterfellEntity> Interfells) {
		return Interfells.stream().map(interfell -> 
			convertInterfellEntityToInterfellDTO(interfell)	
		).collect(Collectors.toList());
	}

	public InterfellEntity convertInterfellDTOToInterfellEntity(InterfellDTO input) {
		InterfellEntity interfellEntity = new InterfellEntity();
		interfellEntity.setId(input.getId());
		interfellEntity.setCondado(input.getCondado());
		interfellEntity.setDate(input.getDate());
		interfellEntity.setPorcentajeDeCambioParaEnero(input.getPorcentajeDeCambioParaEnero());
		interfellEntity.setNombreDelCondado(input.getNombreDelCondado());
		interfellEntity.setMediaDelCondado(input.getMediaDelCondado());
		
		return interfellEntity;
	}

	public InterfellDTO convertInterfellEntityToInterfellDTO(InterfellEntity interfellEntity) {
		InterfellDTO interfell = new InterfellDTO(); 
		interfell.setId(interfellEntity.getId());
		interfell.setCondado(interfellEntity.getCondado());
		interfell.setDate(interfellEntity.getDate());
		interfell.setPorcentajeDeCambioParaEnero(interfellEntity.getPorcentajeDeCambioParaEnero());
		interfell.setNombreDelCondado(interfellEntity.getNombreDelCondado());
		interfell.setMediaDelCondado(interfellEntity.getMediaDelCondado());
		
		return interfell;
	}
}
