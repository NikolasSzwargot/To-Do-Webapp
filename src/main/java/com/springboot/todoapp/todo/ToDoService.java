package com.springboot.todoapp.todo;

import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

@Service
public class ToDoService {
    private static int counter = 1;
    private static List<ToDo> toDoList = new ArrayList<>();
    static {
        toDoList.add(new ToDo(counter++, "admin", "Get a life",
                LocalDate.now().plusYears(1), false));
        toDoList.add(new ToDo(counter++, "admin", "Learn Java",
                LocalDate.now().plusYears(2), false));
        toDoList.add(new ToDo(counter++, "admin", "Invite Michumisiu",
                LocalDate.now().plusYears(3), false));
    }

    public List<ToDo> findByUsername(String username){
        return toDoList;
    }

    public void addTodo(String username, String description, LocalDate date, boolean done){
        toDoList.add(new ToDo(counter++, username, description, date, done));
    }

    public void deleteTodoById(int id){
        Predicate<? super ToDo> predicate = toDo -> toDo.getId() == id;
        toDoList.removeIf(predicate);
    }

}
