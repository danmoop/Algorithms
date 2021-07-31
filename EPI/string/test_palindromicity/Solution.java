import java.util.*;
import java.lang.*;
import java.io.*;

public class Solution {

    private static FastScanner sc;

    private static class FastScanner {
        private Scanner sc;

        FastScanner() {
            sc = new Scanner(System.in);
        }

        public int ni() {
            return sc.nextInt();
        }

        public String ns() {
            return sc.nextLine();
        }

        public long nl() {
            return sc.nextLong();
        }

        public double nd() {
            return sc.nextDouble();
        }
    }

    private static void print(Object o) {
        System.out.print(o);
    }

    private static void println(Object o) {
        System.out.println(o);
    }

    private static void ln() {
        print("\n");
    }

    private static void printf(String s, Object... data) {
        System.out.printf(s, data);
    }

    private static void arrayFillRandom(int[] arr, int bound) {
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) Math.floor(Math.random() * bound);
        }
    }

    private static void shuffleArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int index = (int) Math.floor(Math.random() * arr.length);

            int temp = arr[index];
            arr[index] = arr[i];
            arr[i] = temp;
        }
    }

    public static void main(String[] args) {
        sc = new FastScanner();

        solve();
    }   

    /*
        7.5 TEST PALINDROMICITY
        For the purpose of this problem, define a palindromic string to be a string which
        when all the nonalphanumeric are removed it reads the same front to back ignoring
        case. For example, "A man, a plan, a canal, Panama." and "Able was I, ere I saw
        Elba!" are palindromic, but "Ray a Ray" is not.
        Implement a function which takes as input a string s and returns true if s is a palin¬
        dromic string.
    */
    private static void solve() {
        String s = sc.ns();
        println(isPalindrome(s));
    }

    private static boolean isPalindrome(String s) {
        int i = 0, j = s.length() - 1;

        while (i < j) {
            char left = Character.toLowerCase(s.charAt(i));
            char right = Character.toLowerCase(s.charAt(j));

            while (!Character.isLetter(left)) {
                i++;
                left = Character.toLowerCase(s.charAt(i));
            }

            while (!Character.isLetter(right)) {
                j--;
                right = Character.toLowerCase(s.charAt(j));
            }

            if (left != right) return false;

            i++; j--;
        }

        return true;
    }
}