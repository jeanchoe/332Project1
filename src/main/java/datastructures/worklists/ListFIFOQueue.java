package datastructures.worklists;

//import cse332.exceptions.NotYetImplementedException;
import cse332.interfaces.worklists.FIFOWorkList;

import java.util.NoSuchElementException;

/**
 * See cse332/interfaces/worklists/FIFOWorkList.java
 * for method specifications.
 */
public class ListFIFOQueue<E> extends FIFOWorkList<E> {
    private Node<E> front;
    private Node<E> back;
    private int length;

    private static class Node<E>{
        E data;
        Node<E> next;

        public Node(E data){
            this.data = data;
            this.next = null;
        }
    }
    public ListFIFOQueue() {
        //throw new NotYetImplementedException();
        front = null;
        back = null;
        length = 0;
    }

    @Override
    public void add(E work) {

        // throw new NotYetImplementedException();
        Node<E> newestNode = new Node<>(work);

        // Checking for an empty que,
        // sets both front and back to the newest node.
        if(back == null){
            front = newestNode;
            back = newestNode;
        }else {
            // Enters if there was something in the queue,
            // then adds the newest node to the end
            back.next = newestNode;
            back = newestNode;
        }
        length++;
    }

    @Override
    public E peek() {
        // throw new NotYetImplementedException();
        if(front == null){
            throw new NoSuchElementException("Queue is empty");
        }
        return front.data;
    }

    @Override
    public E next() {
        //throw new NotYetImplementedException();
        if (front == null){
            throw new NoSuchElementException("Queue is empty");
        }
        length--;
        E data = front.data;
        front = front.next;
        return data;
    }

    @Override
    public int size() {
        // throw new NotYetImplementedException();
        return length;
    }

    @Override
    public void clear() {
        // throw new NotYetImplementedException();
        front = null;
        back = null;
        length = 0;
    }
}
