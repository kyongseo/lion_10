package org.example.restexam.Service;

import org.example.restexam.domain.Todo;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class TodoServiceTest {

    @Autowired TodoService service;
    private static final Logger log = LoggerFactory.getLogger(TodoServiceTest.class);

    @Test
    void getTodos() {
        List<Todo> todos = service.getTodos();
        todos.forEach(todo -> log.info("Todo:::"+todo));
    }

    @Test
    @DisplayName("Todo 조회하기")
    void getTodo() {
        Todo todo = service.getTodo(1L);
        log.info("Todo::::::::"+todo);
    }

    @Test
    @DisplayName("Todo 추가하기")
    void addTodo() {
        Todo todo = service.addTodo("Todo4");
        log.info("Todo::::"+todo);
    }

    @Test
    @DisplayName("ID로 업데이트 하기")
    void updateTodoById() {
        log.info("Before Todo::::::::"+service.getTodo(1L));
        Todo todo = service.updateTodo(1L);
        log.info("After Todo:::::::::"+todo);
    }

    @Test
    @DisplayName("ID에 해당하는 Todo 변경")
    void updateTodo() {
        Todo todo = new Todo("update todo");
        todo.setId(1L);
        log.info("Before Todo :::::::::::: "+ service.getTodo(1L));
        service.updateTodo(todo);
        log.info("After Todo :::::::::::: "+ service.getTodo(1L));
    }

    @Test
    void deleteTodo() {
        service.deleteTodo(1L);
        log.info("Todo:::"+service.getTodo(1L));
    }
}