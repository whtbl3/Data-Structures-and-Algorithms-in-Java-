package Exercise;

import java.util.HashMap;
import java.util.Random;
import java.util.Scanner;

/**
 * 
 * @author whtbl3
 */
public class Creativity {
    
    /**
     * C-1.14
     * Write a Pseudocode.
     * 1. Initialize start Index as 0.
     * 2. Initialize end index as n - 1. (n is length of the array).
     * 3. In a loop, swap arr[start] and change start and end as 
     * (start = start + 1), (end = end - 1)
     * 4. Iteratively perform the above operation till start and end index
     * each other.
     * @param arr
     * @param start
     * @param end 
     */
    static void reverseArray(int arr[], int start, int end) {
        // temp varible is used to store element to swap
        // swap cannot be done without a temp varible.
        int temp;
        // iterate till start index is always less than index.
        // Ex: arr = [1, 2, 3, 4]
        // iter = 0,    start = 0,  end = 3,    swap (arr[0], arr[3])
        //              temp = 1,   arr[0] = arr[3] = 4,    arr[3] = temp
        //              arr[4, 2, 3, 1]
        // iter = 1,    start = 1,  end = 2,    swap (arr[1], arr[2])
        //              temp = 2,   arr[1] = arr[2] = 3,    arr[2] = temp
        //              arr[4, 3, 2, 1]
        // iter = 3,    start = 2,  end = 1 (loop terminated)
        while (start < end) {
            // used to store element to swap as show above.
            temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            // increase the postion start index by 1.
            start++;
            // decrease the pistion end index by 1.
            end--;
        }
    }
    
    /**
     * C-1.15
     * @param arr
     */
    public static void minMaxArray(int arr[]) {
        // Initialize first element as min element.
        int min = arr[0];
        // Initialize first element as max element.
        int max = arr[0];
        // Loop though all the elements.
        // Ex: arr[] = {4, 1, 8, 2}, min = 4, max = 4.
        //      iter = 1, arr[1] < min,     min = 1
        //                arr[1] !> max,    max = 4
        //      iter = 2, arr[2] !< min,    min = 1
        //                arr[2] > max,     max = 8
        //      iter = 3, arr[3] !< min,    min = 1
        //                arr[3] !> max,    max = 8
        for (int i = 1;  i < arr.length; i++) {
            if (arr[i] < min) min = arr[i];
            if (arr[i] > max) max = arr[i];
        }
        System.out.println("Minimum element is " + min);
        System.out.println("Maximum element is " + max);
    }
    
    /**
     * C-1.16
     * @param a
     * @param b
     * @param c
     * @return true if they can used in a correct arithmetic formula
     * a + b = c, a = b - c, or a * b = c. 
     * false if a, b, cannot used in a correct arithmetic expression.
     */
    public static boolean determine(int a, int b, int c) {
        if (a + b == c) return true;
        else if (b + c == a) return true;
        else if (a + c == b) return true;
        else if (a * c == b) return true;
        else if (a * b == c) return true;
        else if (b * c == a) return true;
        else return false;
    }
    
    /**
     * C-1.17
     * @param nums
     * @return 
     */
    public static boolean evenProduct(int [] nums) {
        // if first no is even, then its product with any no is even,
        // so only check whether any other element is distince from first element
        // ex: for arry [2,2,2,5,8]
        // array[0] is even(2), therefore arr[0] x arr[1] = 2 x 2 = 4 even
        // similarly, arr[0] x arr[3] = 2 x 5 = 10 even
        if (nums[0] % 2 == 0) {
           for (int i = 1; i < nums.length; i++) {
               // check if element is distinct from first element (array[0)
               if (nums[i] != nums[0]) return true;
           } 
        } else {
            // if first element is odd then find another element that is even
            // then return true
            for (int i = 1; i < nums.length; i++) {
                // if elemt is found, return true and end
                return true;
            }
        }
        return false;
    }
    
    /*
    C-1.18
    Use method overlaoding in which we can define multiple methods
    with same name with different parameters
    Ex: norm(int[], int) & norm(int[])
    both methods have samename but different no. of parameters
    */
    
    //method which calculates the p-norm value of vector v
    public static double norm(int[] v, int p) {
        /*
        Variable store the weighted sum for p-norm of the coordiates
        store in array v = (v1, v2) - 2 dimensional.
        wighted sum = (v1^p + v2^p)
        Ex: v = {7, 8}, p = 3.
        wghtd_sum = 7 ^ 3 + 8 ^ 3 = 855
        initialize with 0
        */
        double wghtd_sum = 0;
        /* 
         Iterate through the array to sum the weighted.
         value for all elements of array
         weighted sum = (v1^p + v2^p)
         Ex: v = {7, 8}, p = 3
         when i = 0, wghtd_sum = 0 +& ^ 3 = 343 (initially 0)
         when i = 1, wghtd_sum = 343 + 8 ^ 3 = 855
        */
        for (int i = 0; i < v.length; i++) {
            wghtd_sum += Math.pow(v[i], p);
            /*
             Normalize the weighted sum value (p-norm)
            Ex: v = {7, 8}, p = 3, then wghtd_sum = 855
            p-norm = (v1^p + v2^p)^(1/p) = wghtd_sum ^ (1/p) = 855 ^ (1/3) = 9.49
            Use 1.0/p and not 1/p because int/int will be int i.e, 1/3 = 0
            */
        }
        // return the p-norm value.
        double p_norm = Math.pow(wghtd_sum, 1.0/p);
        return p_norm;
    }
    
    // method which calculates the Euclidean norm value of vector v
    public static double norm(int[] v) {
        /*
        variable to store the weighted sum for Euclidean distance of
        the cordinates stored in array v = (v1, v2) - 2 dimesional
        Ex: v = {7, 8}
        wghted_sum = 7 ^ 2 + 8 ^ 2 = 113
        initialized with o
        */
        double wghtd_sum = 0;
        /*
        iterate through the array to sum the weighted
        value fo all elements of array
        weighted sum for Euclidean distance = (v1^2 + v2^2)
        Ex: v = {7, 8}
        when i = 0, wghtd_sum = 0+7*7 = 49 (initially 0)
        when i = 1, wghtd_sum = 49+8*8 = 113
        */
        for (int i = 0; i < v.length; i++) {
            wghtd_sum += v[i] * v[i];
            /*
            normalize the weighted sum value (Euclidean norm)
            Ex: v = {7, 8}, then wghtd_sum = 113
            Euclid norm = (v1^2 + v2^2) ^ (0.5)
            = wghtd_sum ^ 0.5 = 113^0.5 = 10.63
            */
        }
        double norm = Math.sqrt(wghtd_sum);
        // return the Euclidean norm distance
        return norm;
    }
    
    /**
     * C-1.20
     * @param numbers
     * @return true if all the numbers are different from each other
     */
    public static boolean distinct(float[] numbers) {
        /*
        HashMap is a Map based collection class that is used for storing
        Key & value pairs like HasMap<Key,Value> or HashMap<K, V>
        Here 'key' is of type 'Float' and 'value' is of type 'Integer'
        key is used to store the elements of float array
        value is used to check if key (i.e elements) exist one more than once
        Ex: for array [12.2f, 16.4f, 13.5f, 13.50f]
        */        
        HashMap<Float, Integer> map = new HashMap<>();
        /*
        Loop to check whether key of HashMap already exists
        if it exists, then oviously it has more than 1 same value
        for array [12.2f, 16.4f, 13.5f, 13.50f]
        when i = 0;     arr[0] = 12.2, HashMap has no key as 12.2
            Create a HashMap element with key: 12.2 & value: 1
        when i = 1;     arr[1] = 16.4, HashMap has no key as 16.4
            Create a HashMap element with key: 16.4 & value: 1
        when i = 2;     arr[2] = 13.5, HashMap has no key as 13.5
            Create a HashMap element with key: 13.5 & value: 1
        when i = 3;     arr[1] = 16.4, HashMap has no key as 13.50
            Return true i.e similar element exists
        */
        for (int i = 0; i < numbers.length; i++) {
            // check whether ith element of array already exists as key
            // in the HashMap<K, V>
            if (map.containsKey(numbers[i])) // if it exists, then return true
                return true;
            else {
                // if ith element of array does not exist as key in the
                // HashMap, then create an element in hte HashMap with
                // 'key' as ith element and 1 as 'value'
                map.put(numbers[i], 1);
            }
        }
        // if the loop iterates through all elements, without finding
        // any existing key in the ith interation, then return false
        return false;
    }
    /**
     * C-1.21
     * This program can be called multiple times and it will display
     * a shuffled array of each possible order with equal probability
     * Ex: no. of combinations of the array = 52! (factorial)
     * Therefore, running this program 52! times will display all
     * order with probability of almost 1/(52!)
     * @param arr 
     */
    static void shuffleArray(int[] arr) {
        /*
        To Create a list with 52 element.
        */
        int totalElement = 52;
        int[] num_arr;
        num_arr = new int[totalElement];
        for (int i = 0; i <= totalElement; i++) {
            num_arr[i] = i + 1;
        }
        /*
        To shuffle the array.
        */
        // create an object of class Random.
        Random rd = new Random();
        /*
        Run a loop to shuffle all elements of array randomly
        nextInt() method creates a random integer between 0 to 51
        then the array element at the current iteration
        Ex: iter = 0,   arr[0] = 1, random_pos = 31, arr[31] = 32
                        now, arr[0] = 32 and arr[1] = 1
            iter = 1,   arr[1] = 2, random_pos = 17, arr[17] = 18
                        now arr[1] = 18 and arr[17] = 2 and so on.
        */
        for (int i = 0; i < arr.length; i++) {
            int random_pos = rd.nextInt(arr.length);
            /*
            temp variable to hold one of the swap elements
            without temp variable swap cannot be done as value will lost
            */
            int temp = arr[i];
            arr[i] = arr[random_pos];
            arr[random_pos] = temp;
        }
    }
}

class DivisibilityByTwo {
    public static void main(String[] args) throws Exception {
       /**
        * Creating a object of a Scanner class produces
        * values scanned form input stream using (System.in) 
        * i.e taking input
        */
        Scanner sc = new Scanner(System.in);
        /**
         * Scans the next token of the input as Integer datatype
         * It is 32 bit-signed two's complement integer
         * Minimum value = -(2^31) & Maximum value = (2^31-1) (inclusive)
         * Ex: int n = 65
         */
        int n = sc.nextInt();
        // check if the number, n is greater than 0
        if (n > 0) System.out.println(timeDivisibleByTwo(n));
        else throw new Exception("Please enter postive integer");
    }
    /**
     * C-1.19
     * @param n
     * @return the number of times one must repeatedly divide 
     * this number by 2 before getting a value less than 2.
     */
    public static int timeDivisibleByTwo(int n) {
        /*
        counter varible to store the no. of time n can be divided
        by 2 before getting a no. less than 2
        */
        int count = 0;
        // iteratively divide the no. n by 2 and at each iteration check
        // if n is not less than 2
        /*
        Ex int n = 65
        when iteration = 1, n = 65/2 = 32 (note int/int is int)
        when iteration = 2, n = 32/2 = 16
        when iteration = 3, n = 16/2 = 8
        when iteration = 4, n = 8/2 = 4
        when iteration = 5, n = 4/2 = 2
        when iteration = 6, n = 2/2 = 1 (less than 2)
        */
        while (n >= 2) {
            // Update the value of n at each iteration at shown above
            n = n / 2;
            // Increase the counter variable by 1 at each iteration
            // to track no. of times n is divisible  by 2
            count++;
        }
        return count;
    }
}

/**
 * C-1.22
 * Write a short Java program that outputs all possible
 * strings formed by using the character 'c', 'a', 't', 'd', 'o',
 * 'g' exactly one.
 * @author whtbl3
 */
class Permutation {
    public static void main(String[] args) {
        //chracter aray to store elements.
        char[] elements = new char[] {'a', 'b', 'c'};
        // convert the character array to String.
        String strElement = String.valueOf(elements);
        // store lenght of character array.
        int len = strElement.length();
        // create an object of class Permutation.
        Permutation prmtt = new Permutation();
        // print all possible combinarions using backpropagation.
        prmtt.combine(strElement, 0, len - 1);
        
    }
    // Produces n factorial pissible combinations of the characters.
    private void combine(String str, int left, int right) {
        // swap the left and right element until left = right.
        if (left == right) {
            System.out.println(str);
        } else  {
            /*
            recursively swap the left element
            with the ith element
            use the principle of backpropagation.
            */
            for (int i = left; i <= right; i++) {
                str = swap(str, left, i);
                combine(str, left + 1, right);
                str = swap(str, left, i);
            }
        }
    }
    
    // method to swap ith element with jth element.
    public String swap(String a, int i, int j) {
        // temporary variable to hold swap element.
        char temp;
        // convert String to character array.
        char[] c_Array = a.toCharArray();
        temp = c_Array[i];
        c_Array[i] = c_Array[j];
        c_Array[j] = temp;
        // convert character array to String.
        return String.valueOf(c_Array);
    }
}
/**
 * C-1.23
 * @author phucl
 */
class elementwiseProduct {
    public static void main(String[] args) {
        /*
        Creating an object of a Scanner Class that productes values scanned
        from the input stream using System.in i.e taking user input.
        */
        Scanner sc= new Scanner(System.in);
        // Display to tell the user to enter length of array a & b
        System.out.println("Enter the no. of elements in array a and b: ");
        /*
        Vairble to store no. of element in array a, b, c
        Scans the next token of the user inputa s an Integer datatype
        and stores it in the variable, n.
        Ex: int n = 3
        */
        // Both allocate memory for n element.
        int n = sc.nextInt();
        int[] a = new int[n]; // Declare an array a of type integer.
        int[] b = new int[n]; // Declare an array b of type integer.
        /*
        Use a loop to take user input at each iteration and store
        it in the memory allocated to the array elements.
        Ex:,    i = 0;  if user enters 2 followed by 3
                    2 is store in a[0] & 3 is store in b[0]
                i = 1;  if user enters 4 followed by 5
                    4 is store in a[1] & 5 is store in b[1]
                i = 2;  if user enters 6 followed by 7
                    6 is store in a[2] & 7 is store in b[2]
        array a = [2, 4, 6], array b = [3, 5, 7]
        */
        for (int i = 0; i < n; i++) {
            // Display to ask the user to enter the ith element for arr a
            System.out.print("Enter element " + ( i + 1 ) + " for array a: ");
            a[i] = sc.nextInt();
            System.out.print("Enter element " + ( i + 1 ) + " for array b: ");
            b[i] = sc.nextInt();
        }
        /*
        Array c which stores the elementise dot product of array a & b
        returned by the method -> dot Prodcut(int[], int[])
        */
        int[] c = dotProduct(a, b);
        for (int i = 0; i < n; i++) {
            System.out.println("a[" + i + "] * b [" + i + "] = "
            + (a[i] * b[i]));
        }
    }
    /**
     * 
     * @param a
     * @param b
     * @return dot product of array b & b
     */
    public static int[] dotProduct(int[] a, int[] b) {
        int[] c = new int[a.length];
        for (int i = 0; i < a.length; i++) {
            c[i] = a[i] * b[i];
        }
        return c;
    }
}
