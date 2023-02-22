package com.springboot.todoapp.todo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import java.time.LocalDate;
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

    @RequestMapping(value = "add-todo", method = RequestMethod.GET)
    public String showNewTodoPage(){

        return "todo";
    }

    @RequestMapping(value = "add-todo", method = RequestMethod.POST)
    public String showUpdatedTodoPage(ModelMap model, @RequestParam String description){
        String username = (String) model.get("name");
        toDoService.addTodo(username, description,
                LocalDate.now().plusYears(1), false);
        return "redirect:list-todo";
    }
}
