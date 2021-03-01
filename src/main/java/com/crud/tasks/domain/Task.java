package com.crud.tasks.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;


@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "tasks")
public class Task {

    @Id
    @NotNull
    @GeneratedValue
    private Long id;
    @Column(name = "name")
    private String title;
    @Column(name = "description")
    private String content;
}
