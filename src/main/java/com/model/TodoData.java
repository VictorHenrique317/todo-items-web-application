package com.model;

import lombok.NonNull;

import java.time.LocalDate;
import java.util.*;

public class TodoData {
    // == fields ==
    private static int idValue = 1;
    private final List<TodoItem> items = new ArrayList<>();

    // == constructor ==
    public TodoData() {
        addItem(new TodoItem("first", "first comment", LocalDate.now()));
        addItem(new TodoItem("second", "second comment", LocalDate.now()));
        addItem(new TodoItem("third", "third comment", LocalDate.now()));
        addItem(new TodoItem("fourth", "fourth comment", LocalDate.now()));
    }

    // == public methods ==
    public List<TodoItem> getItems() {
        return Collections.unmodifiableList(items);
    }

    public void addItem(@NonNull TodoItem item){
        item.setId(idValue);
        items.add(item);
        idValue++;
    }

    public void removeItem(int id){
        items.removeIf(todoItem -> todoItem.getId() == id);
    }

    public TodoItem getItem(int id){
        for (TodoItem item: items){
            if (item.getId() == id) return item;
        }
        return null;
    }

    public void updateItem(@NonNull TodoItem item){
        ListIterator<TodoItem> iterator = items.listIterator();
        while (iterator.hasNext()){
            TodoItem current = iterator.next();

            if (current.equals(item)){
                iterator.set(item);
                break;
            }
        }
    }
}
