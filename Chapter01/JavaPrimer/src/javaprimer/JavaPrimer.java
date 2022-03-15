package javaprimer;

class JavaPrimer {
    
    /*
    * 1.1 Declarations and initializations of several base-type variables.
    */
    public static void main(String[] args) {
//        boolean flag = true;
//        boolean verbose, debug; // two variables declared, but not yet initialized
//        char grade = 'A';
//        byte b = 12;
//        short s = 24;
//        int i, j, k = 257;
//        long l = 890L; // note use L
//        float pi = 3.1416F; // note use F
//        double e = 2.71828, a = 6.022e23;
        int j = 8;
        Integer a = new Integer(12);
        int k = a;                      // implicit call to a.intValue().
        int m = j + a;                  // a is automatically unboxed before the addition.
        a = 3 * m;                      
        Integer b = new Integer("-135");
        int n = Integer.parseInt("2013");
    }
}

class Counter {
    /* 
    * 1.2: A Counter class for a simple counter, which can be queried,
    * incremented, and reset.
    */
    private int count;    // a simple integer instance varible.
    public Counter() {}  // default constructor (count = 0).
    public Counter(int initial) {count = initial;} // an alternate constructor.
    public int getCount() { return count; } // an accessor method.
    public void increment() { count++; } // an update method
    public void increment(int delta) { count += delta; } //an update method.
    public void reset() { count = 0; }
}

class CounterDemo {
    public static void main(String[] args)
    {
        Counter c; // Declares a variable; no counter yet constructred
        c = new Counter(); // constructs a counter; assigns its reference to c
        c.increment(); // increases its value by one.
        c.increment(3); // increase its value by three more.
        int temp = c.getCount(); // will be 4
        c.reset(); // value becomes 0.
        Counter d = new Counter(5); //declares and construcs a counter having value5.
        d.increment(); //will br 6.
        Counter e = d;
        System.out.println("value of e before: " + e.getCount());
        d.increment();
        System.out.println("value of e ater d increment: " + e.getCount());
    }
}