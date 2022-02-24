package interfell.vehicle.miles.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import interfell.vehicle.miles.entity.InterfellEntity;

@Repository
public interface InterfellRepository extends JpaRepository<InterfellEntity, Long>{
	
}
