package com.service;

import com.model.TodoData;
import com.model.TodoItem;
import org.springframework.stereotype.Service;

@Service
public class TodoItemServiceImpl implements TodoItemService {
    private static final TodoData data = new TodoData();

    @Override
    public void addItem(TodoItem item) { data.addItem(item); }
    @Override
    public void removeItem(int id) { data.removeItem(id); }
    @Override
    public TodoItem getItem(int id) { return data.getItem(id); }
    @Override
    public void updateItem(TodoItem item) { data.updateItem(item); }
    @Override
    public TodoData getData() { return data; }
}
