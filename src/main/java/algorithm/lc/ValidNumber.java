package algorithm.lc;

/**
 * Validate if a given string is numeric.
 * 
 * Some examples: "0" => true " 0.1 " => true "abc" => false "1 a" => false
 * "2e10" => true
 * 
 * Note: It is intended for the problem statement to be ambiguous. You should
 * gather all requirements up front before implementing one.
 * 
 */
// O(1) space, O(n) time
public class ValidNumber {

  public class Solution {
    public boolean isNumber(String s) {
          // Start typing your Java solution below
          // DO NOT write main() function
      s = s.trim();
      if (s.length() == 0) {
        return false;
      }
      int e = s.indexOf('e');
      if (e == -1) {
        return isDouble(s);
      }
      else {
        return isDouble(s.substring(0, e)) && isInt(s.substring(e + 1));
      }
    }
    
    private boolean isDouble(String s) {
      if (s.length() == 0) {
        return false;
      }
      if (s.charAt(0) == '-' || s.charAt(0) == '+') {
        if (s.length() == 1) {
          return false;
        }
        return isUnsignedDouble(s.substring(1));
      }
      return isUnsignedDouble(s);
    }
    
    private boolean isUnsignedDouble(String s) {
      int dot = s.indexOf('.');
      if (dot == -1) {
        return isUnsignedInt(s);
      }
      
      if (s.length() == 1) {
        return false;
      }
      return isUnsignedInt(s.substring(0, dot)) && isUnsignedInt(s.substring(dot + 1));
    }
    
    private boolean isInt(String s) {
      if (s.length() == 0) {
        return false;
      }
      if (s.charAt(0) == '-' || s.charAt(0) == '+') {
        if (s.length() == 1) {
          return false;
        }
        return isUnsignedInt(s.substring(1));
      }
      return isUnsignedInt(s);
    }
    
    private boolean isUnsignedInt(String s) {
      for (int i = 0; i < s.length(); ++i) {
        char ch = s.charAt(i);
        if (ch < '0' || ch > '9') {
          return false;
        }
      }
      return true;
    }
  }

}
