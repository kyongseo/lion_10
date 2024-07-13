package org.example.restexam.Service;

import lombok.RequiredArgsConstructor;
import org.example.restexam.domain.Todo;
import org.example.restexam.repository.TodoRepository;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TodoService {
    private final TodoRepository todoRepository; // 생성자로 주입

    // 리스트
    @Transactional(readOnly = true)
    public List<Todo> getTodos(){
        return todoRepository.findAll(Sort.by("id").descending());
    }

    // 상세 정보
    @Transactional(readOnly = true)
    public Todo getTodo(Long id){
        return todoRepository.findById(id).get();
    }

    // 입력
    @Transactional
    public Todo addTodo(String todo) {
        return todoRepository.save(new Todo(todo));
    }

    // 수정
    // id 값에 해당하는 done 을 토글하고 id에 해당하는 todo정보를 바꾸는
    @Transactional
    public Todo updateTodo(Long id){  //id 값에 해당하는 done 을 토글하도록.
        Todo updateTodo=null;
        try{
            updateTodo = todoRepository.findById(id).orElseThrow();
            updateTodo.setDone(!updateTodo.isDone());
        }catch (Exception e){
            System.out.println(e);
        }
        return updateTodo;
    }

    // id에 해당하는 todo정보 변경
    @Transactional
    public Todo updateTodo(Todo todo){  //id에 해당하는 todo 정보를 바꾸고 싶어요.
        Todo updateTodo = null;
        try{
            updateTodo = todoRepository.save(todo);
        }catch (Exception e){
            e.printStackTrace();        }
        return updateTodo;
    }

    // 삭제
    public void deleteTodo(Long id) { //id에 해당하는 todo 삭제
        Optional<Todo> findTodo = todoRepository.findById(id);
        if (findTodo.isEmpty())
            return;
        todoRepository.delete(findTodo.get());
    }

}
