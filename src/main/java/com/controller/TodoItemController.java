package com.controller;

import com.model.TodoData;
import com.model.TodoItem;
import com.service.TodoItemService;
import com.utils.AttributeNames;
import com.utils.Mappings;
import com.utils.ViewNames;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;

@Controller
public class TodoItemController {
    // == Fields ==
    private final TodoItemService todoItemService;

    // == Controllers ==
    @Autowired
    public TodoItemController(TodoItemService todoItemService) {
        this.todoItemService = todoItemService;
    }

    @ModelAttribute
    public TodoData todoData(){
        return todoItemService.getData();
    }

    @GetMapping(Mappings.ITEMS)
    public String items(){
        return ViewNames.ITEMS_LIST;
    }

    @GetMapping(Mappings.VIEW_ITEM)
    public String viewItem(@RequestParam int id, Model model){
        TodoItem item = todoItemService.getItem(id);
        model.addAttribute(AttributeNames.TODO_ITEM, item);
        return ViewNames.VIEW_ITEM;
    }

    @GetMapping(Mappings.ADD_ITEM)
    public String addEditItem(@RequestParam(required = false, defaultValue = "-1") int id, Model model){
        TodoItem todoItem = todoItemService.getItem(id); // null if item doesnt exist
        if (todoItem == null){ // then create new item
            todoItem = new TodoItem("","", LocalDate.now());
        }

        model.addAttribute(AttributeNames.TODO_ITEM, todoItem);
        return ViewNames.ADD_ITEM;
    }

    @PostMapping(Mappings.ADD_ITEM)
    public String processItem(@ModelAttribute(AttributeNames.TODO_ITEM) TodoItem todoItem){
        if (todoItem.getId() == 0){ //new item
            todoItemService.addItem(todoItem);
        }else{// update the existing item
            todoItemService.updateItem(todoItem);
        }
        return "redirect:/" + Mappings.ITEMS;
    }

    @GetMapping(Mappings.DELETE_ITEM)
    public String deleteItem(@RequestParam int id){
        todoItemService.removeItem(id);
        return "redirect:/" + Mappings.ITEMS;
    }
}
