package com.company;

public class CStack<T> {

    Node rootNode;
    Node lastNode;
    int size = 0;

    public CStack(){
    }

    class Node{
        T value;
        Node lastNode;
        public Node(T ele){
            this.value = ele;
            this.lastNode = null;
        }
        public Node(T ele , Node ls){
            this.value = ele;
            this.lastNode = ls;
        }
    }

    public void iterator(){
        Node last = this.lastNode;
        while ( last != null ){
            System.out.println(last.value);
            last = last.lastNode;
        }
    }

    public T peek(){
        if(size==0){
            return null;
        }
        return this.lastNode.value;
    }

    public T pop(){
        if(size==0){
            return null;
        }
        this.size--;
        Node temp = this.lastNode;
        this.lastNode = temp.lastNode;
        return temp.value;
    }

    public void push( T ele ){
        this.size++;
        if(this.rootNode == null){
            this.rootNode = new Node(ele);
            this.lastNode = this.rootNode;
        } else {
            this.lastNode = new Node( ele , this.lastNode );
        }
    }

    public int size(){
        return this.size;
    }

    public boolean isEmpty(){
        return this.size == 0;
    }
}