package com.trendy.rest.webservices.restfulwebservices;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Repository;

import com.trendy.rest.webservices.restfulwebservices.todo.Todo;

@Repository
public interface TodoJpaRepository extends JpaRepository<Todo, Long> {
	List<Todo>findByUn(String un);
}
