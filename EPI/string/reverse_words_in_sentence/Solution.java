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
        7.6 REVERSE ALL THE WORDS IN A SENTENCE
        Given a string containing a set of words separated by whitespace, we would like to
        transform it to a string in which the words appear in the reverse order. For example,
        "Alice likes Bob" transformsto "Bob likes Alice". We do not need to keep the original
        string.
        Implement a function for reversing the wordsin a string s
    */
    private static void solve() {
        String s = "Alice likes Bob";
        char[] chars = s.toCharArray();
        reverse(chars, 0, chars.length - 1);

        int i = 0, j = 0;

        while (j < s.length()) {
            if (chars[j] == ' ') {
                reverse(chars, i, j - 1);
                i = j + 1;
            }
            j++;
        }
        reverse(chars, i, j - 1);

        println(new String(chars));
    }

    private static void reverse(char[] chars, int i, int j) {
        while (i < j) {
            char t= chars[i];
            chars[i] = chars[j];
            chars[j] = t;
            i++; j--;
        }
    }
}