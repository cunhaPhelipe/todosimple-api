package com.phelipe.cunha.todosimple.repositores;
import com.phelipe.cunha.todosimple.models.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;


@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {

	List<Task> findByUser_Id(Long id);

//	@Query(value = "SELECT t FROM Task t WHERE t.user.id = :id")
//	List<Task> findByUser_Id(@Param("id") Long id);
 }
