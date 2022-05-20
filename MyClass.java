package com.company;

public class MyClass {

    public static void main (String [] args) {

//        @Autowired
        MyDatabase myDatabase;
        MyStudent myStudent = new MyStudent ( new MyDatabase ("b1","black","awesome"));
//        MyStudent myStudent1 = new MyStudent( myDatabase);
//        MyStudent myStudent2 = new MyStudent();
//        myStudent.addToBoard("Test message");
    }
}

class MyStudent {
    MyDatabase myDatabase;
    MyStudent(MyDatabase myDatabase) {
        this.myDatabase = myDatabase;
    }
    public void addToBoard(String msg) {
        myDatabase.connect();
    }
}

class MyBoard {

    String board, name, color, desing;

    MyBoard (String name,String color,String desing){
        this.name = name;
        this.color=color;
        this.desing=desing;
    }

    public String getBoard() {
        return this.board;
    }

    public void writeBoard(String str) {
        this.board = str;
        System.out.println(this.board);
    }
}

class MyDatabase {

    String ip, port, name;

    MyDatabase (String ip,String port, String name){
        this.ip=ip;
        this.port=port;
        this.name = name;
    }

    public void connect() {
        System.out.println("connected");
    }
}

