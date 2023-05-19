package cs1302.p2;

import cs1302.adt.StringList;

/**
 * Abstract parent class for {@code LinkedStringList} and {@code ArrayStringList}. Allows
 * the user to create a list using {@code StringList} objects.
 */
public abstract class BaseStringList implements StringList {

    // INSTANCE VARIABLES
    protected int size;

    // CONSTRUCTOR
    /**
     * Constructs the {@code BaseStringList} object with an initiallized {@code size} of 0.
     */
    public BaseStringList() {
        this.size = 0;
    } // BaseStringList

    // METHODS
    /**
     * {@inheritDoc}
     */
    @Override
    public int size() {
        return size;
    } // size

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean isEmpty() {
        if (this.size == 0) {
            return true;
        } else {
            return false;
        } // if
    } // isEmpty

    /**
     * {@inheritDoc}
     */
    @Override
    public String makeString(String start, String sep, String end) {
        String makeString = start;
        for (int i = 0; i < size; i++) {
            if (i != (size - 1)) {
                makeString = makeString + this.get(i) + sep;
            } else {
                makeString = makeString + this.get(i);
            } // if
        } // for
        makeString = makeString + end;
        return makeString;
    } // makeString

    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        return this.makeString("[", ", ", "]");
    } // toString

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean contains(int start, String target) {
        int counter = 0;
        if (start >= 0) {
            for (int i = start; i < size; i++) {
                if (this.get(i) == target) {
                    counter++;
                } // if
            } // for
            if (counter > 0) {
                return true;
            } else {
                return false;
            } // if
        } else {
            return false;
        } // if
    } // contains

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean add(int index, StringList itemList) {
        if (itemList == null) {
            throw new NullPointerException("itemList parameter is null");
        } else if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("index parameter was < 0 or > size");
        } else {
            this.add(index, itemList);
            return !itemList.isEmpty();
        } // if
    } //add

} // BaseStringList
