package org.example.restexam.controller;

import jakarta.persistence.Id;
import lombok.RequiredArgsConstructor;
import org.example.restexam.Service.TodoService;
import org.example.restexam.domain.Todo;
import org.example.restexam.repository.TodoRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.List;

/**
 *            url --> 자원(복수)            method      --> 행위
 *  http://localhost:8080/api/todos      ==> Get       --> TodoList리턴
 *  http://localhost:8080/api/todos/{id} ==> Get       --> id에 해당하는 Todo리턴
 *  http://localhost:8080/api/todos      ==> Post      --> Todo한건 저장
 *  http://localhost:8080/api/todos      ==> Put/Patch --> Todo수정
 *  http://localhost:8080/api/todos      ==> Delete    --> Todo삭제
 */

@RestController
@RequestMapping("/api/todos")
@RequiredArgsConstructor // todoService 주입
public class TodoController {

    private final TodoService todoService;

    /**
     * 조회하기
     */
    @GetMapping
    public List<Todo> getTodos() {
        return todoService.getTodos();
    }

    /**
     * 상세보기
     */
    @GetMapping("/{id}")
    public Todo getTodo(@PathVariable("id") Long Id) {
        return todoService.getTodo(Id);
    }

    /**
     * 추가하기
     */
    @PostMapping
    public Todo addTodo(@RequestBody Todo todo) {
        return todoService.addTodo(todo.getTodo());
    }

    /**
     * 업데이트 --> 수정하기
     * (1) Put   --> 새로운 것을 하나 만들 때 사용 .... 하지만 경계가 구분되어 있지 않다.
     * (2) Patch --> 부분만 수정될 때 사용
     */
    // ID 일치하는지 확인 => @PathVariable 사용하여 아이디 확인
    // 일치하면 done 이 true 로 변경
    @PatchMapping("/{id}")
    public Todo updateTodoById(@PathVariable("id") Long id) {
        return todoService.updateTodo(id);
    }

    // Id에 맞는 Todo의 내용 변경하기
    @PatchMapping
    public Todo updateTodo(@RequestBody Todo todo) {
        return todoService.updateTodo(todo);
    }

    /**
     * 삭제하기
     */
    @DeleteMapping
    public String deleteTodo(@RequestBody Todo todo) {
        todoService.deleteTodo(todo.getId());
        return "Todo successfully deleted";
    }
}
