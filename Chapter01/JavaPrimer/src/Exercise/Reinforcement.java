package Exercise;
import java.util.Scanner;
/**
 * 
 * @author whtbl3
 */

public class Reinforcement {
   // R-1.1 
    public static void inputAllBaseTypes() {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter your name: ");
        String name = input.nextLine();
        System.out.println("Your name is: " + name);
        System.out.println("Enter your age: ");
        int age = input.nextInt();
        System.out.println("Your age is: " + age);
        System.out.println("Enter your heart rate: ");
        double rate = input.nextDouble();
        System.out.println("Your heart rate is: " + rate);
        System.out.println("Enter your gender [0]:Girl or [1]: Boy");
        boolean isboy = input.nextBoolean();
        if (isboy) System.out.println("You're boy"); 
        else System.out.println("You're girl");
        System.out.println("Enter your favorite character");
        char fvoriteChar = input.next().charAt(0);
        System.out.println("Your favorite char is " + fvoriteChar);
        System.out.println("Enter the byte number you want: ");
        Byte bnum = input.nextByte();
        System.out.println("Your bute number: " + bnum);
        System.out.println("Enter the short number: ");
        short snum = input.nextShort();
        System.out.println("Your short number: " + snum);
        System.out.println("Enter the long number: ");
        long lnum = input.nextLong();
        System.out.println("Your long number: " + lnum);
        System.out.println("Enter the float number: ");
        float fnum = input.nextFloat();
        System.out.println("Your float number: " + fnum);
    }
    
    
    /**
     * R - 1.3
     * @param n
     * @param m
     * @return 
     */
    public static boolean isMultiple(long n, long m) {
        return m % n == 0;
    }
    
    /**
     * R-1.4 - This method cannot use the multiplication,
     * modules, or division.
     * @param i
     * @return true if even, false if odd.
     */
    public static boolean isEven(int i) {
        return i % 2 == 0;
    }
    
    /**
     * R-1.5
     * @param n
     * @return sum of positive less than or equal n.
     */
    public static int sumOfPositive(int n) {
        if (n < 0) throw new RuntimeException("You must input postive number.");
        else {
            int sum = 0;
            for (int i = 1; i <= n; i++) {
                sum += i;
            }
            return sum;
        }
    }
    /**
     * R-1.6
     * @param n
     * @return sum of odd positive number;
     */
    public static int sumOddPostive(int n) {
        if (n < 0) throw new RuntimeException("You must input postive number.");
        else {
            int sum = 0;
            /* for (int i = 1; i <= n; i++) {
                if (i % 2 != 0) sum += i;
            }
            return sum;
            */
            for (int i = 1; i <= n; i = i+2) {
                sum += i;
            }
            return sum;
        }
    }
    
    /**
     * R-1.7
     * @param n
     * @return the sum of squares of all
     * positive integers less than or equal
     * to n.
     */
    public static int sumSquarePostive(int n) {
        if (n < 0) throw new RuntimeException("You must input postive number.");
        else {
            int sum = 0;
            for (int i = 1; i <= n; i++) {
                sum += i * i;
            }
            return sum;
        }
    }
    /**
     * R-1.8
     * @param s
     * @return the number of vowels in a given character
     * string.
     */
    public static int countVowels(String s) {
        if (s.isEmpty()) throw new RuntimeException("You must input non-empty string");
        else {
            int count = 0;
            for (int  i = 0; i < s.length(); i++) {
                String lwrCaseStr = s.toLowerCase();
                switch (lwrCaseStr.charAt(i)) {
                    case 'a':
                    case 'i':
                    case 'u':
                    case 'e':
                    case 'o':
                        count++;
                        break;
                    default:
                        break;
                }
            }
            return count;
        }
    }
    
    /**
     * R-1.9
     * @param s
     * @return the string which has been removed all the
     * punctuation from a string s storing a sentence.
     */
    public static String removePunctuation(String s) {
        if (s.isEmpty()) throw new RuntimeException("You must input non-empty string");
        else {
            StringBuilder sb = new StringBuilder(s);
            for (int i = s.length() - 1; i >= 0; i--) {
                switch (sb.charAt(i)) {
                    case '.':
                    case '?':
                    case '!':
                    case '’':
                    case '`':
                    case ',':
                    case ';':
                    case ':':
                    case '-':
                    case '[':
                    case ']':
                    case '{':
                    case '}':
                    case '(':
                    case ')':
                    case '\'':
                        sb.deleteCharAt(i);
                        break;
                    default:
                        break;
                }
            }
            return sb.toString();
        }
    }
    
    public static void main(String[] args) {
        //inputAllBaseTypes();
        //scoreGameEntry();
        //System.out.println(isMultiple(20, 40));                    // return true.
        //System.out.println(isEven(23));                            // return fasle.
        //System.out.println(sumOfPositive(0));                      // return 0.
        //System.out.println(sumOddPostive(8));                      // return 16.
        //System.out.println(sumSquarePostive(5));                   // return 55;
        //System.out.println(countVowels("AeroPlAnE"));              // return 5;
        //System.out.println(removePunctuation("Let’s try, Mike!")); // return ""Lets try Mike"
    }
}

/**
 * R-1.10
 * @author whtbl3
 */
class Flower {
    private String flowerName;
    private int numberOfPetals;
    private float price;

    public Flower(String flowerName, int numberOfPetals, float price) {
        this.flowerName = flowerName;
        this.numberOfPetals = numberOfPetals;
        this.price = price;
    }

    public String getFlowerName() {
        return flowerName;
    }

    public int getNumberOfPetals() {
        return numberOfPetals;
    }

    public float getPrice() {
        return price;
    }

    public void setFlowerName(String flowerName) {
        this.flowerName = flowerName;
    }

    public void setNumberOfPetals(int numberOfPetals) {
        this.numberOfPetals = numberOfPetals;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    
    public static void main(String[] args) {
        Flower rose = new Flower("Rose", 10, 30.2f);
        rose.setNumberOfPetals(5);
        System.out.println(rose.getNumberOfPetals()); // print 5.
    }
}


/**
 * 
 * @author whtbl3
 * R-1.11, R-1.12, R-1.13
 */
class CreditCard {
    //Instance variables;
    private String customer;     // name of the customer
    private String bank;         // name of the bank
    private String account;      // account identifier
    private int limit;           // credit =limit (measured in dollars)
    protected double balance;    // current balance (measured in dollars)
    
    // Constructors:
    public CreditCard(String cust, String bk, String acnt, int lim, double initialBal) {
        customer = cust;
        bank = bk;
        account = acnt;
        limit = lim;
        balance = initialBal;
    }
    
    public CreditCard(String cust, String bk, String acnt, int lim){
        this(cust, bk, acnt, lim, 0.0); // use a balance of zero default.
    }
    
    // Accessor methods:
    public String getCustomer() { return customer; }
    public String getBank() { return bank; }
    public String getAccount() { return account; }
    public int getLimit() { return limit; }
    public  double getBalance() { return balance; }
    
    // Update methods:
    public boolean charge(double price) {
        // make a charge if charge would surpass limit.
        if (price + balance > limit) return false;
        // at this point, the charge is successful
        balance += price;
        return true;
    }
    
    // Make a payment.
    /**
     * R-1.12
     * @param amount 
     */
    public void makePayment(double amount) {
        if (balance >= amount) balance -= amount;
    }
    
    // Utility method to print a card's information.
    public static void printSummary(CreditCard card) {
        System.out.println("Customer = " + card.customer);
        System.out.println("Bank = " + card.bank);
        System.out.println("Account = " + card.account);
        System.out.println("Balance = " + card.balance);
        System.out.println("Limit = " + card.limit);
    }
    
    // Method to set the Credit card limit
    /**
     * R-1.11
     * @param lim 
     */
    public void setCreditLimit(int lim) {
        // set the value of the instance variable limit.
        limit = lim;
    }
    /**
     * Code Fragment 1.6: Main method of the Credit card class.
     * R-1.13
     * @param args 
     */
    public static void main(String[] args) {
        CreditCard[] wallet = new CreditCard[3];
        wallet[0] = new CreditCard("John Bowman", "California Saving", "5391 0375 9387 5309", 5000);
        wallet[1] = new CreditCard("John Bowman", "California Federal", "3485 0399 3395 1954", 3500);
        wallet[2] = new CreditCard("John Bowman", "California Finance", "5391 0375 9387 5309", 2500, 300);
        
        // Modify for loop so that its charges will cause exactly one
        // of the three credit cards to attempt to go over its credit limt.
        // => answer: at 58, the wallet[0] credit card attempts to go over
        for (int val = 1; val <= 16; val++) {
            wallet[0].charge(3*val);
            wallet[1].charge(2*val);
            wallet[2].charge(val);
        }

        for (CreditCard card : wallet) {
            CreditCard.printSummary(card); //calling staic method.
            while (card.getBalance() > 200.0) {
                card.makePayment(200);
                System.out.println("New balance = " + card.getBalance());
            }
        }
    }
}
