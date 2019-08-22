/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.escuelaing.sparksimpleexample.entities;

public class LinkedList<T>{

    Node head;

    public LinkedList(){
        this.head = null; 
    }

    private class Node{
        T data;
        Node nextNode;
        Node(T data){
            this.data = data;
            this.nextNode = null;
        }
    }

    

    public int size(){
        int count = 0;
        Node temp = head;
        if(this.head != null){
            while(temp.nextNode != null){
                temp = temp.nextNode;
                count += 1; 
            }
            count += 1;
        }
        return count;
    }

    public void add(T data){
        Node newNode = new Node(data);
        newNode.nextNode = null;

        if(this.head == null){
            this.head = newNode;
        }else{
            Node temp = head;
            while(temp.nextNode != null){
                temp = temp.nextNode;
            }
            temp.nextNode = newNode;
        }
    }

    public void remove(int index){
        Node temp = head;
        for (int i = 0; i < index-1 && temp != null; i++) {
            temp = temp.nextNode;
        }
        temp.nextNode = temp.nextNode.nextNode;
    }

    public T get(int index){
        Node temp = head;
        for (int i = 0; i < index && temp != null; i++) {
            temp = temp.nextNode;
        }
        return temp.data;
    }

    public void myString(){
        Node temp = head;
        if(temp == null) System.out.println("im empty :T");
        else{
            for (int i = 0; i < size(); i++) {
                System.out.print("node "+i+"= "+temp.data.toString()+",my next is ");
                if(temp.nextNode == null)System.out.println("null");
                else System.out.println(temp.nextNode.data.toString());
                temp = temp.nextNode;
            }
        }
    }

    public void clean(){
        this.head=null;
    }

}
