public class AplikasiTodolist {

    public static String[] model = new String[10];
    public static java.util.Scanner scanner = new java.util.Scanner(System.in);
    public static void main(String[] args) {
        viewShowTodoList();
    }

    /**
     * Menampilkan todo list
     */
    public static void showTodoList() {
        System.out.println("TODOLIST");
        for(var i = 0; i < model.length; i++) {
            var todo = model[i];
            var no = i + 1;
            if(todo != null) {
                System.out.println(no + ". " + todo);
            }
        }
    }
    /**
     * Test menampilkan todo list
     */
    public static void testShowTodoList() {
        model[0] = "Belajar Java Dasar";
        model[1] = "Studi Kasus Java Dasar : Aplikasi Todo List";
        showTodoList();
    }

    /**
     * Menambah todo ke list
     */
    public static void addTodoList(String todo) {
        // Cek apakah model penuh?
        var isFull = true;
        for (var i = 0; i < model.length; i++) {
            if(model[i] == null) {
                // Model masih ada yang kosong
                isFull = false;
                break;
            }
        }
        // Jika penuh, kita resize ukuran array 2x lipat
        if(isFull) {
            var temp = model;
            model = new String[model.length * 2];
            for (int i = 0; i < temp.length; i++) {
                model[i] = temp[i];
            }
        }
        // Tambahkan ke posisi yang data array nya penuh
        for (var i = 0; i < model.length; i++) {
            if(model[i] == null) {
                model[i] = todo;
                break;
            }
        }
    }
    /**
     * Test menambah todo ke list
     */
    public static void testAddTodoList() {
        for (int i = 0; i < 25; i++) {
            addTodoList("Contoh Todo Ke." + i);
        }
        showTodoList();
    }

    /**
     * Menghapus todo dari list
     */
    public static boolean removeTodoList(Integer number) {
        if((number - 1) >= model.length) {
            return false;
        } else if(model[number - 1] == null) {
            return false;
        } else {
            for (int i = (number - 1); i < model.length; i++) {
                if(i == (model.length - 1)) {
                    model[i] = null;
                } else {
                    model[i] = model[i + 1];
                }
            }
            return true;
        }
    }
    /**
     * Test menghapus todo dari list
     */
    public static void testRemoveTodoList() {
        addTodoList("Satu");
        addTodoList("Dua");
        addTodoList("Tiga");
        addTodoList("Empat");
        addTodoList("Lima");
        var result = removeTodoList(20);
        System.out.println(result);
        result = removeTodoList(7);
        System.out.println(result);
        result = removeTodoList(2);
        System.out.println(result);
        showTodoList();
    }

    /**
     * Input data
     */
    public static String input(String info) {
        System.out.print(info + " : ");
        String data = scanner.nextLine();
        return data;
    }
    /**
     * Test input data
     */
    public static void testInput() {
        var name = input("Nama");
        System.out.println("Hi " + name);
        var channel = input("Channel");
        System.out.println(channel);
    }

    /**
     * Menampilkan view todo list
     */
    public static void viewShowTodoList() {
        while(true) {
            showTodoList();
            System.out.println("MENU : ");
            System.out.println("1. Tambah");
            System.out.println("2. Hapus");
            System.out.println("X. Keluar");
            var input = input(("Pilih"));
            if(input.equals("1")) {
                viewAddShowTodoList();
            } else if(input.equals("2")) {
                viewRemoveTodoList();
            } else if(input.equals("X")) {
                break;
            } else {
                System.out.println("Pilihan tidak di mengerti");
            }
        }
    }
    /**
     * Test menampilkan view todo list
     */
    public static void testViewShowTodoList() {
        addTodoList("Satu");
        addTodoList("Dua");
        addTodoList("Tiga");
        addTodoList("Empat");
        addTodoList("Lima");
        viewShowTodoList();
    }
    

    /**
     * menampilkan view menambah todo list
     */
    public static void viewAddShowTodoList() {
        System.out.println("MENAMBAH TODOLIST");
        var todo = input("Todo (X Jika Batal)");
        if(todo.equals("X")) {
            // Batal
        } else {
            addTodoList(todo);
        }
    }
    /**
     * Test menampilkan view menambah todo list
     */
    public static void testViewAddTodoList() {
        addTodoList("Satu");
        addTodoList("Dua");
        viewAddShowTodoList();
        showTodoList();
    }

    /**
     * menampilkan view menghapus todo list
     */
    public static void viewRemoveTodoList() {
        System.out.println("MENGHAPUS TODOLIST");
        var number = input("Nomor yang dihapus (X jika batal)");
        if(number.equals("X")) {
            // Batal
        } else {
            boolean success = removeTodoList(Integer.valueOf(number));
            if(!success) {
                System.out.println("Gagal menghapus todolist : " + number);
            }
        }
    }
    /**
     * Test menampilkan view menghapus todo list
     */
    public static void testViewRemoveTodoList() {
        addTodoList("Satu");
        addTodoList("Dua");
        addTodoList("Tiga");
        showTodoList();
        viewRemoveTodoList();
        showTodoList(); 
    }
    
}