package co.edu.escuelaing.sparksimpleexample.entities;

/**
 * <h1>LinkedList</h1>
 * Implementacion de la estructura de datos LinkedList
 * @param <T> tipo generico
 */
public class LinkedList<T>{

    Node head;
    /**
     * Construye una linked list con su head nulla
     */
    public LinkedList(){
        this.head = null; 
    }

    /**
     * Clase interna encargada de almacenar los datos y la referencia hacia los demas nodos
     */
    private class Node{
        T data;
        Node nextNode;
        /**
         * Construye un nodo con los datos y la referencia hacia otro node nula
         * @param data
         */
        Node(T data){
            this.data = data;
            this.nextNode = null;
        }
    }

    /**
     * Retorna el tamano de la linkedList
     * @return int
     */
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
    /**
     * Agrega los datos enviados a la linkedList mediante un nodo
     * @param data dato que se quiere guardar en la estuctura de datos
     */
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
    /**
     * Remueve uno de los datos que se encuentran en la linkedList
     * @param index indice del dato el cual se quiere borrar
     */
    public void remove(int index){
        Node temp = head;
        for (int i = 0; i < index-1 && temp != null; i++) {
            temp = temp.nextNode;
        }
        temp.nextNode = temp.nextNode.nextNode;
    }

    /**
     * Retorna el dato que se encuentra en el indice especificado
     * @param index indice del ldato que se quiere retornar
     * @return T dato generico que se retornara
     */
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
