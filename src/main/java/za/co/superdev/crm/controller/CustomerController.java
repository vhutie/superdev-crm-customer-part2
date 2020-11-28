package za.co.superdev.crm.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import za.co.superdev.crm.model.Customer;
import za.co.superdev.crm.service.CustomerService;

@RestController
@RequestMapping("v1/api/customer")
public class CustomerController {

	private static final Logger LOGGER = LoggerFactory.getLogger(CustomerController.class);
	 
	@Autowired
	private CustomerService customerService;
	
	
	@CrossOrigin(origins = "*")
    @PostMapping
    public @ResponseBody ResponseEntity<Object> createUser(@RequestBody Customer customer) {
		
		try {
			 Customer response = customerService.create(customer);
			 return new ResponseEntity<>(response, HttpStatus.OK);
		}catch (Exception e) {
			for (StackTraceElement ste : e.getStackTrace()) {
                LOGGER.error(ste.toString());
            }
            LOGGER.error(e.getMessage());
			return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@CrossOrigin(origins = "*")
    @GetMapping("/{customerId}")
    public @ResponseBody ResponseEntity<Object> getById(@PathVariable(name = "customerId", required = true) Long customerId) {
		
		try {
			 Customer response = customerService.findById(customerId);
			 return new ResponseEntity<>(response, HttpStatus.OK);
		}catch (Exception e) {
			for (StackTraceElement ste : e.getStackTrace()) {
                LOGGER.error(ste.toString());
            }
            LOGGER.error(e.getMessage());
			return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@CrossOrigin(origins = "*")
    @GetMapping("/extended/{customerName}")
    public @ResponseBody ResponseEntity<Object> getByName(@PathVariable(name = "customerName", required = true) String customerName) {
		
		try {
			 List<Customer> response = customerService.findByName(customerName);
			 return new ResponseEntity<>(response, HttpStatus.OK);
		}catch (Exception e) {
			for (StackTraceElement ste : e.getStackTrace()) {
                LOGGER.error(ste.toString());
            }
            LOGGER.error(e.getMessage());
			return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	
	@CrossOrigin(origins = "*")
    @GetMapping
    public @ResponseBody ResponseEntity<Object> getAll() {
		
		try {
			 List<Customer> response = customerService.findAll();
			 return new ResponseEntity<>(response, HttpStatus.OK);
		}catch (Exception e) {
			for (StackTraceElement ste : e.getStackTrace()) {
                LOGGER.error(ste.toString());
            }
            LOGGER.error(e.getMessage());
			return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
