package repository;

import entity.Todolist;

/**
 * Membuat repository
 */
public interface TodolistRepository {

    Todolist[] getAll();

    void add(Todolist todolist);

    boolean remove(Integer number);
    
}
