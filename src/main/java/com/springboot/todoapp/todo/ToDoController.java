package com.springboot.todoapp.todo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import java.util.List;

@Controller
@SessionAttributes("name")
public class ToDoController {

    private ToDoService toDoService;

    public ToDoController(ToDoService toDoService) {
        this.toDoService = toDoService;
    }

    @RequestMapping(value = "list-todo")
    public String getToDoListPage(ModelMap model){
        List<ToDo> todos = toDoService.findByUsername("admin");
        model.addAttribute("todos", todos);

        return "listTodos";
    }
}
