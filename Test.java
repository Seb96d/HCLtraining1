package com.company;

import java.util.Queue;

public class Test{
    public static void main(String[] arg){
//        CStack<Integer> mystack = new CStack<>();
//        System.out.println(mystack.isEmpty());
//        System.out.println(mystack.size());
//        mystack.push(1);
//        mystack.push(2);
//        mystack.push(3);
//        mystack.push(10);
//        mystack.iterator();
//        System.out.println(mystack.peek());
//        System.out.println(mystack.pop());
//        System.out.println(mystack.peek());
//        System.out.println(mystack.size());


        CQueue<Integer> q = new CQueue();
        System.out.println(q.front);
        System.out.println(q.rear);
        q.iterator();
        q.enqueue(1);
        q.enqueue(2);
        q.enqueue(3);
        q.enqueue(4);
        q.enqueue(5);
        q.enqueue(6);
        System.out.println("iterator :");
        q.iterator();

        q.emptyQueue();
        q.enqueue(999);
        q.iterator();
    }

}
