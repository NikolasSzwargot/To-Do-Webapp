package com.springboot.todoapp.todo;

import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

@Service
public class ToDoService {
    private static int counter = 1;
    private static List<ToDo> toDoList = new ArrayList<>();
    static {
        toDoList.add(new ToDo(counter++, "admin", "Get AWS Certificate",
                LocalDate.now().plusYears(1), false));
        toDoList.add(new ToDo(counter++, "admin", "Learn Java SpringBoot",
                LocalDate.now().plusYears(2), false));
        toDoList.add(new ToDo(counter++, "admin", "Invite Michael's friend",
                LocalDate.now().plusYears(3), false));
    }

    public List<ToDo> findByUsername(String username){
        return toDoList;
    }

    public void addTodo(String username, String description, LocalDate date, boolean done){
        toDoList.add(new ToDo(counter++, username, description, date, done));
    }

    public ToDo findById(int id){
        Predicate<? super ToDo> predicate = toDo -> toDo.getId() == id;
        return toDoList.stream().filter(predicate).findFirst().orElse(null);
    }

    public void deleteTodoById(int id){
        toDoList.remove(findById(id));
    }

    public void updateTodo(ToDo todo){
        toDoList.set(toDoList.indexOf(findById(todo.getId())), todo);
    }

}
