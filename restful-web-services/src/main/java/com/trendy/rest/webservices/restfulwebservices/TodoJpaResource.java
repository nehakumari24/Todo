package com.trendy.rest.webservices.restfulwebservices;
import java.net.URI;
import java.util.List;

import javax.persistence.EntityManagerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.trendy.rest.webservices.restfulwebservices.todo.TodoHardCodedService;
import com.mysql.cj.xdevapi.SessionFactory;
import com.trendy.rest.webservices.restfulwebservices.todo.Todo;

@RestController
@CrossOrigin(origins="http://localhost:4200")
public class TodoJpaResource {
	
	@Autowired
	private TodoHardCodedService todoService;
	
	@Autowired
	private TodoJpaRepository todoJpaRepository;
	
	/*@Autowired//del from here
	private EntityManagerFactory entityManagerFactory;
	
	@Bean
	public SessionFactory getSessionFactory() {
		if(entityManagerFactory.unwrap(SessionFactory.class)== null) {
			throw new NullPointerException("Factory is not hibernate");
		}
		return entityManagerFactory.unwrap(SessionFactory.class);
	}*/
	
	
	@GetMapping("/jpa/username/{un}/todos")//This is beginning
	public List<Todo> getAllTodos(@PathVariable String un){
		return todoJpaRepository.findByUn(un);
		//return todoService.findAll();
		}
	
	@GetMapping("/jpa/username/{un}/todos/{id}")
	public Todo getTodo(@PathVariable String un, @PathVariable long id){
		return todoJpaRepository.findById(id).get();
		//return todoService.findById(id);		
	}
	
	@DeleteMapping("/jpa/username/{un}/todos/{id}")
	public ResponseEntity<Void> deleteTodo (@PathVariable String un, @PathVariable long id){
		
		todoJpaRepository.deleteById(id);
		
			return ResponseEntity.noContent().build();
		
		}
	@PutMapping("/jpa/username/{un}/todos/{id}")
	public ResponseEntity<Todo>UpdateTodo(
			@PathVariable String un,
			@PathVariable long id,@RequestBody Todo todo){
		todo.setUn(un);
		Todo todoUpdated= todoJpaRepository.save(todo);
		
		return new ResponseEntity<Todo>(todo, HttpStatus.OK);			
	}
			
	@PostMapping("/jpa/username/{un}/todos")
	public ResponseEntity<Void>CreateTodo(
			@PathVariable String un,
			@RequestBody Todo todo){
		todo.setUn(un);
		Todo createdTodo= todoJpaRepository.save(todo);
		URI uri=ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}").buildAndExpand(createdTodo.getId()).toUri();
		return  ResponseEntity.created(uri).build();			
	}
	
	
	
	}

