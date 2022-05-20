package com.company;

public class CQueue<T> {
    Node front;
    Node rear;
    int size=0;
    public CQueue(){
    }

    class Node{
        T value;
        Node prevNode;
        Node nextNode;

        public Node(T v){
            this.value = v;
        }
        public Node(T v, Node nxtNode, Node preNode){
            this.value = v;
            this.nextNode = nxtNode;
            this.prevNode = preNode;
        }
    }

    public void enqueue(T t){
        if (front == null & rear == null){
            Node node = new Node(t);
            this.front = node;
            this.rear = node;
        }
        else {
            Node node = new Node(t, null, this.rear);
            this.rear.nextNode = node;
            this.rear = node;
        }
        size++;
    }


    public Node getFront(){
        return this.front;
    }

    public Node getRear(){
        return this.rear;
    }

    public void iterator(){
        Node last = this.front;
        while ( last != null ){
            System.out.println(last.value);
            last = last.nextNode;
        }
    }

    public boolean isEmpty(){
        if (front == null & rear == null)
            return true;
        return false;
    }

    public void emptyQueue(){
        int stop = size;
        for (int i = 0; i < stop; i++)
            dequeue();
    }
    public T dequeue(){
        T vv = this.front.value;
        if (size==1){
            this.front=null;
            this.rear=null;
            size--;
        }
        else {
            this.front = this.front.nextNode;
            this.front.prevNode = null;
            size--;
        }
        return vv;
    }
}