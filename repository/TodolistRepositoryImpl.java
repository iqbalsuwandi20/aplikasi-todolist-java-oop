package repository;

import entity.Todolist;

/**
 * Membuat repository & service : menampilkan todolist
 */
public class TodolistRepositoryImpl implements TodolistRepository {

    public Todolist[] data = new Todolist[10];

    @Override
    public Todolist[] getAll() {
        return data;
    }

    public boolean isFull() {
        // Cek apakah model penuh?
        var isFull = true;
        for (var i = 0; i < data.length; i++) {
            if(data[i] == null) {
                // Model masih ada yang kosong
                isFull = false;
                break;
            }
        }
        return isFull();
    }

    public void resizeIsFull() {
        // Jika penuh, kita resize ukuran array 2x lipat
        if(isFull()) {
            var temp = data;
            data = new Todolist[data.length * 2];
            for (int i = 0; i < temp.length; i++) {
                data[i] = temp[i];
            }
        }
    }

    @Override
    public void add(Todolist todolist) {

        resizeIsFull();

        // Tambahkan ke posisi yang data array nya penuh
        for (var i = 0; i < data.length; i++) {
            if(data[i] == null) {
                data[i] = todolist;
                break;
            }
        }
    }

    @Override
    public void remove(Integer number) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'remove'");
    }
    
}
