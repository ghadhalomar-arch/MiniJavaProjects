/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ;

/**
 *
 * @author ghadh
 */
public class Dll<T> {

    private Node<T> header;
    private Node<T> tailer;
    private Node<T> curr;
    private int size;

    public Dll() {
        header = new Node<T>();
        tailer = new Node<T>();
        header.setNext(tailer);
        tailer.setPrev(header);

    }

    public int size() {

        return size;

    }

    public boolean isEmpty() {

        return size == 0;

    }

    public T first() {
        if (isEmpty()) {
            return null;
        } else {
            return header.getNext().getElm();
        }
    }

    public T last() {
        if (isEmpty()) {
            return null;
        } else {
            return tailer.getPrev().getElm();
        }
    }

    public void addfirst(T elm) {
        addbetween(elm, header, header.getNext());

    }

    public void addlast(T elm) {
        addbetween(elm, tailer, tailer.getPrev());

    }

    public void removefirst(T elm) {
        removebetween(header.getNext());

    }

    public void removelast(T elm) {
        removebetween(tailer.getPrev());

    }

    private void addbetween(T elm, Node header, Node tailer) {
        Node<T> newn = new Node<T>(elm);
        newn.setPrev(header);
        newn.setNext(tailer);
        header.setNext(newn);
        tailer.setPrev(newn);
        size++;
    }

    private T removebetween(Node<T> node) {
        Node<T> prev = node.getPrev();
        Node<T> next = node.getNext();
        prev.setNext(next);
        next.setPrev(prev);
        size--;
        return node.getElm();

    }
}
