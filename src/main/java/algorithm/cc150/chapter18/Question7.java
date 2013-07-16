package algorithm.cc150.chapter18;

import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Given a list of words, write a program to find the longest word made of other
 * words in the list.
 * 
 */
public class Question7 {

  public static class LenComparator implements Comparator<String> {
    public int compare(String str1, String str2) {
      if (str1.length() > str2.length()) {
        return -1;
      }
      return -str1.compareTo(str2);
    }
  }
  
  public String longestWord(List<String> words) {
    // write implementation here
    Map<String, Boolean> map = new HashMap<String, Boolean>();
    Collections.sort(words, new LenComparator());
    return "";
  }

}

