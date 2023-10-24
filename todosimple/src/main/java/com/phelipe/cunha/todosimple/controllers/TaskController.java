package com.phelipe.cunha.todosimple.controllers;
import com.phelipe.cunha.todosimple.models.Task;
import com.phelipe.cunha.todosimple.services.TaskService;
import com.phelipe.cunha.todosimple.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/task")
@Validated
public class TaskController {

	@Autowired
	private TaskService taskService;

	@Autowired
	private  UserService userService;

	@GetMapping("/{id}")
	public ResponseEntity<Task> findById(@PathVariable Long id){
		Task task = this.taskService.findById(id);
		return  ResponseEntity.ok(task);
	}

	@PostMapping
	@Validated
	public ResponseEntity<Void> create(@Valid @RequestBody Task obj){
		this.taskService.create(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return  ResponseEntity.created(uri).build();
	}

	@PutMapping("/{id}")
	@Validated
	public ResponseEntity<Void> update(@Valid @RequestBody Task obj, @PathVariable Long id){
		obj.setId(id);
		this.taskService.update(obj);
		return ResponseEntity.noContent().build();
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete (@PathVariable long id){
		this.taskService.delete(id);
		return ResponseEntity.noContent().build();
	}

	@GetMapping("/user/{userId}")
	public ResponseEntity<List<Task>> findByUserId(@PathVariable Long userId){
		userService.findById(userId);
		List<Task> obj = this.taskService.findAllByUserId(userId);
		return ResponseEntity.ok().body(obj);
	}

}
