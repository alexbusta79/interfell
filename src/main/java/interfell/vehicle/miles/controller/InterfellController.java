package interfell.vehicle.miles.controller;

import java.util.List;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import interfell.vehicle.miles.command.InterfellCommand;
import interfell.vehicle.miles.command.InterfellDeleteByIdCommand;
import interfell.vehicle.miles.command.InterfellGetByIdCommand;
import interfell.vehicle.miles.command.InterfellInsertCommand;
import interfell.vehicle.miles.command.InterfellUpdateCommand;
import interfell.vehicle.miles.dto.InterfellDTO;


@RestController 
@RequestMapping(value = "interfell")
public class InterfellController extends BaseController{
	
	@Autowired
	private BeanFactory beanFactory;
	
	@GetMapping
	public ResponseEntity<List<InterfellDTO>> all() throws Exception{
		logger.info("requestId={}|operacion=validarRequest|esito=OK", "123456");

		InterfellCommand command = beanFactory.getBean(InterfellCommand.class);
		List<InterfellDTO> result = command.execute();
		
		return ResponseEntity.ok(result);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<InterfellDTO> getById(@PathVariable Long id) throws Exception{
		logger.info("requestId={}|operacion=validarRequest|esito=OK", "123456");
		long startTime = System.currentTimeMillis();

		InterfellGetByIdCommand command = beanFactory.getBean(InterfellGetByIdCommand.class,id);
		InterfellDTO result = command.execute();
		
		logger.info("requestId={}|pedido=fin|duracionOperacion={}{}","654321",(System.currentTimeMillis() - startTime)," ms");
		
		return ResponseEntity.ok(result);
		
	}
	
	@DeleteMapping("/{id}")	
	public ResponseEntity<Boolean> deleteInterfellById(@PathVariable Long id) throws Exception{	
		InterfellDeleteByIdCommand command = beanFactory.getBean(InterfellDeleteByIdCommand.class,id);
		Boolean result = command.execute();
		
		return ResponseEntity.ok(result);
	}
	
	@PostMapping("/insert") 
	public ResponseEntity<InterfellDTO> insertInterfell(@RequestBody InterfellDTO interfell) throws Exception{
		logger.info("requestId={}|operacion=validarRequest|esito=OK", "123456");
		
		InterfellInsertCommand command = beanFactory.getBean(InterfellInsertCommand.class, interfell);
		InterfellDTO result = command.execute();

		return ResponseEntity.ok(result);
	}
	
	@PutMapping("/update")
	public  ResponseEntity<InterfellDTO> updateInterfell(@RequestBody InterfellDTO interfell) throws Exception{
		logger.info("requestId={}|operacion=validarRequest|esito=OK", "123456");
		
		InterfellUpdateCommand command = beanFactory.getBean(InterfellUpdateCommand.class, interfell);
		InterfellDTO result = command.execute();
		
		return ResponseEntity.ok(result);
	}
}
