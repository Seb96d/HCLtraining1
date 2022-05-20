import java.util.Stack;

//package com.company;
//
//import java.io.FileInputStream;
//import java.io.ObjectOutput;
//import java.io.ObjectOutputStream;
//import java.io.Serializable;
//import java.util.Properties;
//
public class Test4 {

    public static void main(String[] args) {

        happyPlants();

    }
//
//    char arr[] = new char[]{'a', 'c', 'b'};
//    //        int arrInt[] = new int[arr.length];
//    char temp = 0;
//
//
//    for (int i = 0; i < arr.length; i++) {
//        for (int j = i + 1; j < arr.length; j++) {
//            if ((int)arr[i] > (int)arr[j]) {
//                temp = arr[i];
//                arr[i] = arr[j];
//                arr[j] =  temp;
//            }
//        }
//    }
//
//    for (int i = 0; i < arr.length; i++) {
//        System.out.println((arr[i]));
//    }
//
//    MyClass myClass = new MyClass(1,"a");
//    ObjectOutputStream out = new ObjectOutputStream(myClass);
//
////    out.writeObject(myClass);
//
//    out.writeUTF("would you read me? i would read me hard");
//
//    FileInputStream fileInputStream = new FileInputStream("myfile.txt");
//
//
//
//
//    Properties pr = new Properties();
//
//    pr.setProperty("1", "a");
//    pr.setProperty("2", "a");
//    pr.setProperty("3", "a");
//
//    for (Object obj : pr.keySet()){
//        System.out.println(obj.toString() + " " + pr.get(obj));
//    }
//
//}
//
//class MyClass implements Serializable(
//    int id;
//    String name;
//
//    public MyClass(int id, String name) {
//        this.id = id;
//        this.name = name;
//    })
//
//
//

  static Stack happyPlants(){
    int [] plantSlots = {1,3,5,10};
    int [] showerSlots = {2,4};
    int radius = 6;
    Stack wateredPlants = new Stack();
    for (int i = 0; i < showerSlots.length; i++){
        for (int reachable : plantSlots){
            if (showerSlots[i]+radius >= reachable)
                if (!wateredPlants.contains(reachable))
                    wateredPlants.push(reachable);
            System.out.println("reachable : " + reachable);
        }
    }
    for (Object waterPlant : wateredPlants)
        System.out.println(waterPlant);
    return wateredPlants;
}
//
}
//


