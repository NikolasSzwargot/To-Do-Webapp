package com.springboot.todoapp.todo;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
public class ToDoService {
    private static List<ToDo> toDoList;
    static {
        toDoList.add(new ToDo(1, "admin", "Get a life",
                LocalDate.now().plusYears(1), false));
        toDoList.add(new ToDo(1, "admin", "Learn Java",
                LocalDate.now().plusYears(2), false));
        toDoList.add(new ToDo(1, "admin", "Invite Michumisiu",
                LocalDate.now().plusYears(3), false));
    }

    public List<ToDo> findByUsername(String username){
        return toDoList;
    }
}
