package com.geekster.todo.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TodoController {
    @Autowired
    List<Todo> todoList;
    // create todo
    @PostMapping("todo")
    public String addtodo(@RequestBody Todo myTodo){
        todoList.add(myTodo);
        return "todo added";
    }
      //  get  Api
    @GetMapping("todos")
    public List<Todo>getAllTodos(){

        return todoList;
    }
    // update todo
    // send a todo id and status
    @PostMapping("todo/id/{id}/status")
    public String setTodoStatusById(@PathVariable Integer id, @RequestParam boolean flag){
        for (Todo todo : todoList){
            if(todo.getTodoId().equals(id)){
                todo.setTodoStatus(flag);
                return "todo:" + id + "updated to" + flag;
            }
        }
        return "Invalid id";
    }
    @PostMapping("todos")
    public String addTodos(@RequestBody List<Todo> myTodos){
        todoList.addAll(myTodos);
        return myTodos.size() + "todos added";
    }

}
