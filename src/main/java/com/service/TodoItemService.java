package com.service;

import com.model.TodoData;
import com.model.TodoItem;

public interface TodoItemService {
    void addItem(TodoItem item);
    void removeItem(int id);
    TodoItem getItem(int id);
    void updateItem(TodoItem item);
    TodoData getData();
}
