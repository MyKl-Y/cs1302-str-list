package cs1302.p2;

import cs1302.adt.StringList;

/**
 * {@code ArrayStringList} allows the user to created a list using String array data structures.
 */
public class ArrayStringList extends BaseStringList {

    // INSTANCE VARIABLES
    private String[] items;

    // CONSTRUCTOR
    /**
     * Constructs a {@code ArrayStringList} data structure with an {@code items} array initialized
     * with the memory capacity of 10 and an initial {@code size} of 0.
     */
    public ArrayStringList() {
        this.size = 0;
        this.items = new String[10];
    } // ArrayStringList

    // METHODS
    /**
     * Array implementation of add method.
     *
     * <p>
     * {@inheritDoc}
     *
     * <p>
     * Copies the existing array to a 1.5 times larger array if memory runs out in existing array.
     */
    @Override
    public boolean add(int index, String item) {
        if (item == null) {
            throw new NullPointerException("item parameter was null");
        } else if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("index parameter was either < 0 or > size");
        } else if (item.isEmpty() == true) {
            throw new IllegalArgumentException("item parameter is empty");
        } else {
            if (items[index] == null) {
                // Places item at designated index since slot was empty.
                items[index] = item;
                size++;
            } else if (items[index] != null && size != items.length) { //
                // Moves over existing items that are in the index spot or after.
                // Places item in new gap.
                for (int i = (items.length - 1); i > (index); i--) {
                    items[i] = items[i - 1];
                } // for
                items[index] = item;
                size++;
            } else {
                // Creates a temp array that holds copy values of current list.
                // Increases items array memory size by 1.5 times.
                // Moves the items over one if the index is before or on the spot.
                // Places item in new empty space.
                String[] temp = new String[items.length];
                for (int i = 0; i < items.length; i++) {
                    temp[i] = items[i];
                } // for
                items = new String[temp.length + (temp.length / 2)];
                for (int j = 0; j < temp.length; j++) {
                    items[j] = temp[j];
                } // for
                for (int k = (items.length - 1); k > (index); k--) {
                    items[k] = items[k - 1];
                } // for
                items[index] = item;
                size++;
            } // if

            if (size != 0) {
                return true;
            } else {
                return false;
            } // if
        } // if
    } // add

    /**
     * {@inheritDoc}
     */
    @Override
    public String get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("index parameter is < 0 or >= size");
        } else {
            return items[index];
        } // if
    } // get

    /**
     * {@inheritDoc}
     */
    @Override
    public void clear() {
        size = 0;
        items = new String[10];
    } // clear

    /**
     * {@inheritDoc}
     */
    @Override
    public String remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("index parameter is < 0 or >= size");
        } else {
            String removed = items[index];
            items[index] = null;
            for (int i = index + 1; i <= size; i++) {
                items[i - 1] = items[i];
            } // for
            size--;
            return removed;
        } // if
    } // remove

    /**
     * {@inheritDoc}
     */
    @Override
    public StringList reverse() {
        StringList reversed = new ArrayStringList();
        int counter = size;
        for (int i = 0; i < size; i++) {
            reversed.add(i, items[counter - 1]);
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
            StringList sliced = new ArrayStringList();
            int counter = 0;
            for (int i = start; i < stop; i++) {
                sliced.add(counter, items[i]);
                counter++;
            } // for
            return sliced;
        } // if
    } // slice

} // ArrayStringList
