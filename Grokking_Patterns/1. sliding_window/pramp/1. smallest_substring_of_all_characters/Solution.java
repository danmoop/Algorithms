import java.io.*;
import java.util.*;

class Solution {

  static String getShortestUniqueSubstring(char[] arr, String s) {
    String result = "";
    Map <Character,Integer> map = new HashMap<>();

    int i = 0, j = 0, size = arr.length;

    while (j < s.length()) {
      char right = s.charAt(j);

      if (!map.containsKey(right)) {
        size--;
      }
      map.put(right, map.getOrDefault(right, 0) + 1);
      j++;

      while (map.size() == arr.length) {
        char left = s.charAt(i);

        int freq = map.get(left) - 1;
          if (freq == 0) {
            map.remove(left);
            size++;
          } else {
            map.put(left, freq);
          }

          if (result.length() == 0) {
            result = s.substring(i, j);
          } else if (s.substring(i, j).length() < result.length()) {
            result = s.substring(i, j);
          }

          i++;
      }
    }

    return result;
  }

  public static void main(String[] args) {
    char[] chars = {'a', 'b', 'c', 'd', 'e'};
    String str = "eeedeedecdbabebeb";

    System.out.println(getShortestUniqueSubstring(chars, str));

  }
}