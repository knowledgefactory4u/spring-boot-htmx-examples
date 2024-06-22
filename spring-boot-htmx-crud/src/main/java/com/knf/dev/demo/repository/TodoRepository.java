package com.knf.dev.demo.repository;

import com.knf.dev.demo.entity.Todo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TodoRepository extends JpaRepository<Todo,Long> {
}