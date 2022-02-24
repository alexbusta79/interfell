package interfell.vehicle.miles.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import interfell.vehicle.miles.entity.InterfellEntity;
import interfell.vehicle.miles.exceptions.InterfellDomainException;
import interfell.vehicle.miles.repository.InterfellRepository;

@SpringBootTest
public class InterfellServiceTest {
	
	@InjectMocks
	InterfellService service;
	
	@Mock
	InterfellRepository repository;
	
	@Before
	    public void init() {
	        MockitoAnnotations.initMocks(this);
	    }
	 
	@Test
	public void getInterfells(){
		List<InterfellEntity> listaInterfell = new ArrayList<InterfellEntity>();

		InterfellEntity uno = new InterfellEntity();
        uno.setNombreDelCondado("nombreDelCondado");
        uno.setCondado(1234);
        uno.setDate(new Date());
        uno.setId(new Long(1));
        uno.setMediaDelCondado(15.3);
        
		InterfellEntity dos = new InterfellEntity();
		dos.setNombreDelCondado("nombreDelCondado");
		dos.setCondado(1234);
        dos.setDate(new Date());
        dos.setId(new Long(1));
        dos.setMediaDelCondado(15.3);
          
        listaInterfell.add(uno);
        listaInterfell.add(dos);
        
        Mockito.when(repository.findAll()).thenReturn(listaInterfell);
        
        List<InterfellEntity> listaTest = service.getInterfells();
        assertEquals(2, listaTest.size());
        assertEquals(listaInterfell, listaTest);
	}
	
	@Test
	public void updateTest() {
		InterfellEntity newInterfell = new InterfellEntity();
		newInterfell.setNombreDelCondado("nombreDelCondado");
		newInterfell.setCondado(1234);
		newInterfell.setDate(new Date());
		newInterfell.setId(new Long(1));
		newInterfell.setMediaDelCondado(15.3);
			
	    Optional<InterfellEntity> opt = Optional.of(newInterfell);
		
		Mockito.when(repository.findById(newInterfell.getId())).thenReturn(opt);
		Mockito.when(repository.save(newInterfell)).thenReturn(newInterfell);
		
		InterfellEntity interfellTest = null;
		try {
			interfellTest = service.update(newInterfell);		
		} catch (InterfellDomainException e) {
			e.printStackTrace();
		}
			
		assertEquals(newInterfell, interfellTest);
		assertTrue(opt.isPresent());	
	}
	
	@Test(expected = InterfellDomainException.class)
	public void updateTestException() throws InterfellDomainException {
		InterfellEntity newInterfell = new InterfellEntity();
		newInterfell.setNombreDelCondado("nombreDelCondado");
		newInterfell.setCondado(1234);
		newInterfell.setDate(new Date());
		newInterfell.setId(new Long(1));
		newInterfell.setMediaDelCondado(15.3);
		
	    Optional<InterfellEntity> optNull = Optional.empty();
	  
		Mockito.when(repository.findById(newInterfell.getId())).thenReturn(optNull);

		this.service.update(newInterfell);	
	}
	
	@Test
	public void deleteTest() {		
		InterfellEntity newInterfell = new InterfellEntity();
		newInterfell.setNombreDelCondado("nombreDelCondado");
		newInterfell.setCondado(1234);
		newInterfell.setDate(new Date());
		newInterfell.setId(new Long(1));
		newInterfell.setMediaDelCondado(15.3);

	    Optional<InterfellEntity> opt = Optional.of(newInterfell);
		
		Mockito.when(repository.findById(newInterfell.getId())).thenReturn(opt);
		Mockito.when(repository.save(newInterfell)).thenReturn(newInterfell);
		
		boolean deleteTest=false;
		try {
			deleteTest = service.deleteInterfellById(newInterfell.getId());
			
		} catch (InterfellDomainException e) {
			e.printStackTrace();
		}
		
		assertTrue(deleteTest);
	}
	
	@Test
	public void insertTest() {	
		InterfellEntity newInterfell = new InterfellEntity();
		newInterfell.setNombreDelCondado("nombreDelCondado");
		newInterfell.setCondado(1234);
		newInterfell.setDate(new Date());
		newInterfell.setId(new Long(1));
		newInterfell.setMediaDelCondado(15.3);
		
		Mockito.when(repository.save(newInterfell)).thenReturn(newInterfell);
		
		InterfellEntity insertTest = new InterfellEntity();
		try {
			insertTest = service.insert(newInterfell);
		} catch (InterfellDomainException e) {
			e.printStackTrace();
		}	
		assertEquals(newInterfell, insertTest);
	}

}
