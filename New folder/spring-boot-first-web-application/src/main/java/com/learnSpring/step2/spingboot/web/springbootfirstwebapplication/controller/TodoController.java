package com.learnSpring.step2.spingboot.web.springbootfirstwebapplication.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.learnSpring.step2.spingboot.web.service.LoginService;
import com.learnSpring.step2.spingboot.web.service.ToDoService;
import java.util.Date;
@Controller
@SessionAttributes("name")
public class TodoController {
    
    @Autowired
    
    ToDoService service;

    @RequestMapping(value="/list-todos", method=RequestMethod.GET)
    public String showTodos(ModelMap model){
        String name =(String) model.get("name");
        model.put("todos", service.retrieveTodos(name));
        return "list-todos";
    }
    @RequestMapping(value="/add-todo", method=RequestMethod.GET)
    public String showAddTodoPage(ModelMap model){
        // String name =(String) model.get("name");
        // model.put("todos", service.retrieveTodos(name));
        return "todo";
    }

    @RequestMapping(value="/add-todo", method=RequestMethod.POST)
    public String addTodo(ModelMap model, @RequestParam String desc){
        // String name =(String) model.get("name");
        // model.put("todos", service.retrieveTodos(name));
        service.addTodo((String) model.get("name"), desc, new Date(), false);
        return "redirect:/list-todos";
    }
}
