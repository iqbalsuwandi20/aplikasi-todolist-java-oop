package view;

import service.TodolistService;
import util.InputUtil;

/**
 * Membuat view
 */
public class TodolistView {

    private TodolistService todolistService;
    
    public TodolistView(TodolistService todolistService) {
        this.todolistService = todolistService;
    }

    public void showTodolist() {
        while(true) {
            todolistService.showTodolist();
            System.out.println("MENU : ");
            System.out.println("1. Tambah");
            System.out.println("2. Hapus");
            System.out.println("X. Keluar");
            var input = InputUtil.input("Pilih");
            if(input.equals("1")) {
                addTodolist();
            } else if(input.equals("2")) {
                removeTodolist();
            } else if(input.equals("X")) {
                break;
            } else {
                System.out.println("Pilihan tidak di mengerti");
            }
        }
    }

    public void addTodolist() {
        System.out.println("MENAMBAH TODOLIST");
        var todo = InputUtil.input("Todo (X Jika Batal)");
        if(todo.equals("X")) {
            // Batal
        } else {
            todolistService.addTodolist(todo);
        }
    }

    public void removeTodolist() {
        System.out.println("MENGHAPUS TODOLIST");
        var number = InputUtil.input("Nomor yang dihapus (X jika batal)");
        if(number.equals("X")) {
            // Batal
        } else {
            todolistService.removeTodolist(Integer.valueOf(number));
        }
    }

}
