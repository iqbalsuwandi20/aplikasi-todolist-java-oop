package repository;

import entity.Todolist;

/**
 * Membuat repository
 */
public interface TodolistRepository {

    Todolist[] getAll();

    void add(Todolist todolist);

    void remove(Integer number);
    
}
