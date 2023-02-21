package com.springboot.todoapp.todo;

import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class ToDoService {
    private static List<ToDo> toDoList = new ArrayList<>();
    static {
        toDoList.add(new ToDo(1, "admin", "Get a life",
                LocalDate.now().plusYears(1), false));
        toDoList.add(new ToDo(2, "admin", "Learn Java",
                LocalDate.now().plusYears(2), false));
        toDoList.add(new ToDo(3, "admin", "Invite Michumisiu",
                LocalDate.now().plusYears(3), false));
    }

    public List<ToDo> findByUsername(String username){
        return toDoList;
    }
}
