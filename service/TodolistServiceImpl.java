package service;

import entity.Todolist;
import repository.TodolistRepository;

/**
 * Membuat repository & service : menampilkan todolist
 */
public class TodolistServiceImpl implements TodolistService {

    private TodolistRepository todolistRepository;

    public TodolistServiceImpl(TodolistRepository todolistRepository) {
        this.todolistRepository = todolistRepository;
    }

    @Override
    public void showTodolist() {
        Todolist[] model = todolistRepository.getAll();

        System.out.println("TODOLIST");
        for(var i = 0; i < model.length; i++) {
            var todolist = model[i];
            var no = i + 1;
            if(todolist != null) {
                System.out.println(no + ". " + todolist.getTodo());
            }
        }
    }

    @Override
    public void addTodolist(String todo) {

        Todolist todolist = new Todolist(todo);
        todolistRepository.add(todolist);
        System.out.println("SUKSES MENAMBAH TODO : " + todo);

    }

    @Override
    public void removeTodolist(Integer number) {
     
    }
    
}
