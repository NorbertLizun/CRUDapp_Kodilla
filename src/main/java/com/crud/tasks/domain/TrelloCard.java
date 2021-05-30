package com.crud.tasks.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@AllArgsConstructor
@Component
@Data
@NoArgsConstructor
public class TrelloCard {

    private String name;
    private String description;
    private String pos;
    private String listId;
}
