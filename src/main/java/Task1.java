import java.util.Scanner;

public class Task1 {

    public static void main(String[] args) {
        //Enter the scanner to output from the console
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of brackets: ");
        int numberOfBrackets = scanner.nextInt();
        //checking for negativity
        if (numberOfBrackets < 0) {
            System.out.println("you can't enter a negative number");
        }
        //null check
        if (numberOfBrackets == 0) {
            System.out.println("the number of combinations is zero");
        }
        else {
            long numberOfCombinationsRecursive = catalan(numberOfBrackets);
            long numberOfCombinationsDynamicProgramming = catalanDP(numberOfBrackets);
            //recursive method
            System.out.println("recursive - " + numberOfCombinationsRecursive);
            //dynamic programming method
            System.out.println("dynamic programming - " + numberOfCombinationsDynamicProgramming);
        }

    }

    // A recursive function to find nth catalan number
    public static int catalan(int numberOfBrackets) {
        int res = 0;

        // Base case
        if (numberOfBrackets <= 1) {
            return 1;
        }
        for (int i = 0; i < numberOfBrackets; i++) {
            res += catalan(i)
                    * catalan(numberOfBrackets - i - 1);
        }
        return res;
    }

    // A dynamic programming based function to find nth
    // Catalan number
    static int catalanDP(int n) {
        // Table to store results of subproblems
        int catalan[] = new int[n + 2];

        // Initialize first two values in table
        catalan[0] = 1;
        catalan[1] = 1;

        // Fill entries in catalan[]
        // using recursive formula
        for (int i = 2; i <= n; i++) {
            catalan[i] = 0;
            for (int j = 0; j < i; j++) {
                catalan[i]
                        += catalan[j] * catalan[i - j - 1];
            }
        }

        // Return last entry
        return catalan[n];
    }


}
