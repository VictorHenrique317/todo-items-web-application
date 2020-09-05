package com.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Data
@EqualsAndHashCode(of = "id")
public class TodoItem {
    private int id;
    private String title;
    private String details;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate deadLine;

    public TodoItem(String title, String details, LocalDate deadLine) {
        this.title = title;
        this.details = details;
        this.deadLine = deadLine;
    }
}
