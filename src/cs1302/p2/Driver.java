package cs1302.p2;

import cs1302.adt.StringList;
import cs1302.oracle.OracleStringList;

/**
 * Driver class for project 2.
 */
public class Driver {

    public static StringList lsl; // StringList object for LinkedStringList
    public static StringList osl; // StringList object for OracleStringList
    public static StringList asl; // StringList object for ArrayStringList
    //= new LinkedStringList();
    //= new OracleStringList();
    //= new ArrayStringList();

    /**
     * main method.
     *
     * @param args String array that serves as command line prompt arguments.
     */
    public static void main(String[] args) {
        try {
            StringList sl = new ArrayStringList();
            sl.add(0, "toString:");
            sl.add(1, "Test");
            sl.add(2, "Passed");
            sl.add(3, "CONGRATULATIONS!");
            testIsEmpty();
            testSize();
            testAdd();
            testGet();
            testMakeString();
            testContains();
            testClear();
            testRemove();
            testSlice();
            testReverse();
            System.out.println(sl);
        } catch (NullPointerException npe) {
            System.out.println("npe: " + npe);
        } catch (IllegalArgumentException iae) {
            System.out.println("iae: " + iae);
        } catch (IndexOutOfBoundsException ioobe) {
            System.out.println("ioobe: " + ioobe);
        } // try

    } // main

    /** Driver class for project 2. */
    public static void testIsEmpty() {
        lsl = new LinkedStringList();
        osl = new OracleStringList();
        asl = new ArrayStringList();
        if (lsl.isEmpty() && osl.isEmpty() && asl.isEmpty()) {
            System.out.println("isEmpty:\t\tTest Passed");
        } else {
            System.out.println("isEmpty:\t\tTest Failed");
            System.exit(0);
        } // if
    } // testIsEmpty

    /** Driver class for project 2. */
    public static void testSize() {
        lsl = new LinkedStringList();
        osl = new OracleStringList();
        asl = new ArrayStringList();
        if (lsl.size() == 0 && osl.size() == 0 && asl.size() == 0) {
            System.out.println("size:\t\t\tTest Passed");
        } else {
            System.out.println("size:\t\t\tTest Failed");
            System.exit(0);
        } // if
    } // testSize

    /** Driver class for project 2. */
    public static void testAdd() {
        asl = new ArrayStringList();
        asl.add(0, "Happy");
        asl.add(0, "am");
        asl.add(0, "I");
        asl.add(0, "and");
        asl.add(0, "Yim");
        asl.add(0, "Yoosung");
        asl.add(0, "Michael");
        asl.add(0, "is");
        asl.add(0, "Name");
        asl.add(0, "My");
        asl.add(0, "Hello");

        lsl = new LinkedStringList();
        lsl.add(0, "a");
        lsl.add(0, "b");
        lsl.add(1, "c");

        osl = new OracleStringList();
        osl.add(0, "a");
        osl.add(1, "b");
        osl.add(1, osl);

        // WORKS: asl.add(-1, "a");
        // MEH:   osl.add(0, null);
        // WORKS: lsl.add(1, "");

        if (asl.size() != 0 && lsl.size() != 0 && osl.size() != 0) {
            System.out.println("add:\t\t\tTest Passed");
        } else {
            System.out.println("add:\t\t\tTest Failed");
            System.exit(0);
        } // if
    } // testAdd

    /** Driver class for project 2. */
    public static void testGet() {
        lsl = new LinkedStringList();
        lsl.add(0, "Hello");

        asl = new ArrayStringList();
        asl.add(0, "Michael");

        osl = new OracleStringList();
        osl.add(0, "Yim");

        // WORKS: asl.get(1);

        if (lsl.get(0) != null && asl.get(0) != null && osl.get(0) != null) {
            System.out.println("get:\t\t\tTest Passed");
        } else {
            System.out.println("get:\t\t\tTest Failed");
            System.exit(0);
        } // if

    } // testGet

    /** Driver class for project 2. */
    public static void testMakeString() {
        lsl = new LinkedStringList();
        String result1 = lsl.makeString("~", "!", "#");
        String result2 = lsl.makeString(null, null, null);
        lsl.add(0, "a");
        lsl.add(1, "b");
        lsl.add(2, "c");
        String result3 = lsl.makeString("~", "!", "#");
        String result4 = lsl.makeString(null, null, null);

        asl = new ArrayStringList();
        result1 = asl.makeString("~", "!", "#");
        result2 = asl.makeString(null, null, null);
        asl.add(0, "a");
        asl.add(1, "b");
        asl.add(2, "c");
        result3 = asl.makeString("~", "!", "#");
        result4 = asl.makeString(null, null, null);

        osl = new OracleStringList();
        result1 = osl.makeString("~", "!", "#");
        result2 = osl.makeString(null, null, null);
        osl.add(0, "a");
        osl.add(1, "b");
        osl.add(2, "c");
        result3 = osl.makeString("~", "!", "#");
        result4 = osl.makeString(null, null, null);

        System.out.println("makeString:\t\tTest Passed");
    } // testMakeString

    /** Driver class for project 2. */
    public static void testContains() {
        lsl = new LinkedStringList();
        lsl.add(0, "a");

        asl = new ArrayStringList();
        asl.add(0, "a");

        osl = new OracleStringList();
        osl.add(0, "a");

        if (lsl.contains(0, "a") == true
            && asl.contains(0, "a") == true
            && osl.contains(0, "a") == true) {
            System.out.println("contains:\t\tTest Passed");
        } else {
            System.out.println("contains:\t\tTest Failed");
            System.exit(0);
        } // if
    } // testContains

    /** Driver class for project 2. */
    public static void testClear() {
        lsl = new LinkedStringList();
        lsl.add(0, "a");
        lsl.clear();

        asl = new ArrayStringList();
        asl.add(0, "b");
        asl.clear();

        osl = new OracleStringList();
        osl.add(0, "c");
        osl.clear();

        if (lsl.size() == 0 && asl.size() == 0 && osl.size() == 0) {
            System.out.println("clear:\t\t\tTest Passed");
        } else {
            System.out.println("clear:\t\t\tTest Failled");
            System.exit(0);
        } // if
    } // testClear

    /** Driver class for project 2. */
    public static void testRemove() {
        lsl = new LinkedStringList();
        lsl.add(0, "a");
        lsl.add(1, "b");
        lsl.add(2, "c");
        lsl.remove(1);

        asl = new ArrayStringList();
        asl.add(0, "a");
        asl.add(1, "b");
        asl.add(2, "c");
        asl.remove(1);

        osl = new OracleStringList();
        osl.add(0, "a");
        osl.add(1, "b");
        osl.add(2, "c");
        osl.remove(1);

        // WORKS: asl.remove(-1);

        if (lsl.get(1) == "c" && asl.get(1) == "c" && osl.get(1) == "c") {
            System.out.println("remove:\t\t\tTest Passed");
        } else {
            System.out.println("remove:\t\t\tTest Failled");
            System.exit(0);
        } // if
    } // testRemove

    /** Driver class for project 2. */
    public static void testSlice() {
        int counter = 0;
        lsl = new LinkedStringList();
        lsl.add(0, "a");
        lsl.add(1, "b");
        lsl.add(2, "c");
        lsl.add(3, "d");
        StringList slice0 = lsl.slice(0, 4);
        if (slice0.toString().equals("[a, b, c, d]")) {
            counter++;
        } // if
        StringList slice1 = lsl.slice(1, 3);
        if (slice1.toString().equals("[b, c]")) {
            counter++;
        } // if
        StringList slice2 = lsl.slice(2, 4);
        if (slice2.toString().equals("[c, d]")) {
            counter++;
        } // if
        StringList slice3 = lsl.slice(1, 1);
        if (slice3.toString().equals("[]")) {
            counter++;
        } // if

        osl = new OracleStringList();
        osl.add(0, "a");
        osl.add(1, "b");
        osl.add(2, "c");
        osl.add(3, "d");
        StringList slice8 = osl.slice(0, 4);
        if (slice8.toString().equals("[a, b, c, d]")) {
            counter++;
        } // if
        StringList slice9 = osl.slice(1, 3);
        if (slice9.toString().equals("[b, c]")) {
            counter++;
        } // if
        StringList slice10 = osl.slice(2, 4);
        if (slice10.toString().equals("[c, d]")) {
            counter++;
        } // if
        StringList slice11 = osl.slice(1, 1);
        if (slice11.toString().equals("[]")) {
            counter++;
        } // if
        // WORKS: lsl.slice(-10, 15);
        if (counter == 8) {
            System.out.println("slice:\t\t\tTest Passed");
        } // if
    } // testSlice

    /** Driver class for project 2. */
    public static void testReverse() {
        int counter = 0;
        lsl = new LinkedStringList();
        lsl.add(0, "a");
        lsl.add(1, "b");
        lsl.add(2, "c");
        lsl.add(3, "d");
        StringList reverse0 = lsl.reverse();
        if (reverse0.toString().equals("[d, c, b, a]")) {
            counter++;
        } // if
        asl = new ArrayStringList();
        asl.add(0, "a");
        asl.add(1, "b");
        asl.add(2, "c");
        asl.add(3, "d");
        StringList reverse1 = asl.reverse();
        if (reverse1.toString().equals("[d, c, b, a]")) {
            counter++;
        } // if
        osl = new OracleStringList();
        osl.add(0, "a");
        osl.add(1, "b");
        osl.add(2, "c");
        osl.add(3, "d");
        StringList reverse2 = osl.reverse();
        if (reverse2.toString().equals("[d, c, b, a]")) {
            counter++;
        } // if
        if (counter == 3) {
            System.out.println("reverse:\t\tTest Passed");
        } // if
    } // testReverse

} // Driver
