package cs1302.p2;

import cs1302.adt.StringList;
import cs1302.adt.Node;

/**
 * {@code LinkedStringList} allows the user to created a list using linked node data structures.
 */
public class LinkedStringList extends BaseStringList {

    // INSTANCE VARIABLES
    private Node head; // start of linked node list

    // CONSTRUCTOR
    /**
     * Constructs a {@code LinkedStringList} data structure with a {@code head} as a start with
     * an initial {@code size} of 0.
     */
    public LinkedStringList() {
        head = new Node(null);
        this.size = 0;
    } // LinkedStringList

    // METHODS
    /**
     * Linked Nodes implementation of add method.
     *
     * <p>
     * {@inheritDoc}
     */
    @Override
    public boolean add(int index, String item) {
        if (item == null) {
            throw new NullPointerException("item parameter is null");
        } else if (item.isEmpty() == true) {
            throw new IllegalArgumentException("item parameter is empty");
        } else if (index < 0 || index > size()) {
            throw new IndexOutOfBoundsException("index parameter is < 0 or > size");
        } else {
            if (size == 0) {
                // add head
                head.setItem(item);
                size++;
            } else if (size != 0 && index == 0) {
                // move head over and place new head
                head = new Node(item, head);
                size++;
            } else {
                // either shifts indices of nodes to left to place new node or places at end.
                Node temp = new Node(item);
                Node current = this.head;
                Node previous = null;
                for (int i = 0; i < index; i++) {
                    previous = current;
                    current = current.getNext();
                    if (current == null) {
                        break;
                    } // if
                } // for
                temp.setNext(current);
                previous.setNext(temp);
                size++;
            } // if
            return true;
        } // if
    } // add

    /**
     * {@inheritDoc}
     */
    @Override
    public void clear() {
        size = 0;
        head = new Node(null);
    } // clear

    /**
     * {@inheritDoc}
     */
    @Override
    public String get(int index) {
        if (index < 0 || index >= size()) {
            throw new IndexOutOfBoundsException("index parameter is < 0 or >= size");
        } else {
            Node temp = head;
            for (int i = 0; i < index; i++) {
                temp = temp.getNext();
            } // for
            return temp.getItem();
        } // if
    } // get

    /**
     * {@inheritDoc}
     */
    @Override
    public String remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("index parameter is < 0 or >= size");
        } else {
            String removed = this.get(index);
            Node current = head;
            // removes head and shifts LinkedList
            if (index == 0) {
                size--;
                head = current.getNext();
                return removed;
            } // if
            // removes elsewhere
            Node temp = null;
            for (int i = 1; i <= index; i++) {
                temp = current;
                current = current.getNext();
            } // for
            temp.setNext(current.getNext());
            size--;
            return removed;
        } // if
    } // remove

    /**
     * {@inheritDoc}
     */
    @Override
    public StringList reverse() {
        StringList reversed = new LinkedStringList();
        int counter = size;
        for (int i = 0; i < size; i++) {
            reversed.add(i, this.get(counter - 1));
            counter = counter - 1;
        } // for
        return reversed;
    } // reverse

    /**
     * {@inheritDoc}
     */
    @Override
    public StringList slice(int start, int stop) {
        if (start < 0 || stop > size() || start > stop) {
            throw new IndexOutOfBoundsException("Illegal endpoint index value(s)");
        } else {
            StringList sliced = new LinkedStringList();
            int counter = 0;
            for (int i = start; i < stop; i++) {
                sliced.add(counter, this.get(i));
                counter++;
            } // for
            return sliced;
        } // if
    } // slice

} // LinkedStringList
