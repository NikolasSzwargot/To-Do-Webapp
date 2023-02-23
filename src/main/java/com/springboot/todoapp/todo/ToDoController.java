package com.springboot.todoapp.todo;

import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

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
    public String showNewTodoPage(ModelMap model){
        String username = (String) model.get("name");
        ToDo todo = new ToDo(0, username, "", LocalDate.now().plusYears(1), false);
        model.put("todo", todo);
        return "todo";
    }

    @RequestMapping(value = "add-todo", method = RequestMethod.POST)
    public String showUpdatedTodoPage(ModelMap model, @Valid @ModelAttribute("todo") ToDo todo,
                                      BindingResult result){

        if (result.hasErrors()){
            return "todo";
        }

        String username = (String) model.get("name");
        toDoService.addTodo(username, todo.getDescription(),
                todo.getTargetDate(), false);
        return "redirect:list-todo";
    }

    @RequestMapping("delete-todo")
    public String getTodoListPageAfterDelete(@RequestParam int id){
        toDoService.deleteTodoById(id);
        return "redirect:list-todo";
    }

    @RequestMapping( value = "update-todo", method = RequestMethod.GET)
    public String getUpdateTodoPage(ModelMap model, @RequestParam int id){
        model.put("todo", toDoService.findById(id));
        return "todo";
    }

    @RequestMapping( value = "update-todo", method = RequestMethod.POST)
    public String redirectUpdatedTodo(ModelMap model, @RequestParam int id,
                                      @Valid @ModelAttribute("todo") ToDo todo, BindingResult result){
        String username = (String) model.get("name");
        if (result.hasErrors()){
            return "todo";
        }
        todo.setOwnerUsername(username);

        toDoService.updateTodo(todo);
        return "redirect:list-todo";
    }
}
