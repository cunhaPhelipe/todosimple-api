package com.phelipe.cunha.todosimple.services;

import com.phelipe.cunha.todosimple.models.Task;
import com.phelipe.cunha.todosimple.models.User;
import com.phelipe.cunha.todosimple.repositores.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
public class TaskService {

	@Autowired
	private TaskRepository taskRepository;

	@Autowired
	private UserService userService;

	public Task findById(Long id){
		Optional<Task> task = this.taskRepository.findById(id);
		return task.orElseThrow(() -> new RuntimeException("Tarefa não encontrada! Id: " + id + ", Tipo: " + Task.class.getName()));
	}

	@Transactional
	public Task create(Task obj) {
		User user = this.userService.findById(obj.getUser().getId());
		obj = this.taskRepository.save(obj);
		return obj;
	}

	@Transactional
	public Task update(Task obj){
		Task newObj = findById(obj.getId());
		newObj.setDescription(obj.getDescription());
		return this.taskRepository.save(newObj);
	}

	public void delete(Long id){
		findById(id);
		try {
			this.taskRepository.deleteById(id);
		}catch (Exception e) {
			throw new RuntimeException("Não é possivel excluir, usuário vinculado há outras entidades relacionadas!");
		}
	}


}
