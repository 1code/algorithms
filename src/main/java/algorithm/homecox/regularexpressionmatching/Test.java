package algorithm.homecox.regularexpressionmatching;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 * 正则表达式匹配。其中'.'匹配任意一个字符，‘*'匹配任意多个前序字符，如'a*'匹配任意多个'a'。
 * 请实现方法
 * isMatch(String a, String p)，其中第一个参数为输入字符串，第二个参数为正则表达式。
 * 
 * 输出示例：
 * isMatch("a", "a") => true
 * isMatch("a", "b") => false
 * isMatch("a", ".") => true
 * isMatch("a", ".*") => true
 * isMatch("ababac", "a.c") => false
 * isMatch("abc", ".*") => true
 * isMatch("abc", "abc") => true
 * isMatch("abc", "a*b*c*") => true
 * isMatch("abab", "a.*b") => true
 */
class Solution {
  // O(mn) space, O(mn) time
  // 2D DP
  public boolean isMatch(String s, String p) {
    // Start typing your Java solution below
    // DO NOT write main() function
    if (s == null || p == null)
      return false;
    int m = s.length(), n = p.length();
    boolean[][] match = new boolean[m + 1][n + 1];
    match[0][0] = true;
    for (int j = 1; j <= n; j++) {
      if (p.charAt(j - 1) == '*') {
        match[0][j] = match[0][j - 2]; // if current is *
      } 
    }

    for (int i = 1; i <= m; i++) {
      for (int j = 1; j <= n; j++) {
        if (p.charAt(j - 1) != '*') {
          match[i][j] = match[i - 1][j - 1] // prefix is matching
              && (s.charAt(i - 1) == p.charAt(j - 1) || p.charAt(j - 1) == '.');
        }
        else { // pattern is *
          match[i][j] = match[i][j - 2]; // if current * does not generate any character
          if (p.charAt(j - 2) == '.' // if current is .*
              || s.charAt(i - 1) == p.charAt(j - 2)) { // if pattern has the same character as current character
            match[i][j] |= match[i - 1][j];
          }
        }
      }
    }

    return match[m][n];
  }
}

class OJ {
  
  private static boolean DEBUG = false;
  
  /**
   * Each string is delimited by "|".
   */
  public static ArrayList<String> read_AL_String(String input) {
    String[] v = input.split("[|]");
    ArrayList<String> w = new ArrayList<String>();

    for (int i = 0; i < v.length; ++i) {
      w.add(v[i]);
    }

    if (DEBUG) {
      System.out.println("Input:  {" + input + "}");
      System.out.print("Output: ");
      dump_AL_String(w);
      System.out.println("\nsize = " + w.size() + "\n");
    }

    return w;
  }
  
  public static void dump_AL_AL_String(ArrayList<ArrayList<String>> v) {
    for (int i = 0; i < v.size(); ++i) {
      if (i > 0)
        System.out.print(" ");
      dump_AL_String(v.get(i));
    }
  }
  
  /**
   * Each string representing an arraylist of Strings is delimited by "|". Empty
   * string is allowed, which represents an empty arraylist.
   * <p>
   * Each string representing a String value in an arraylist of Strings is
   * delimited by ",". Empty string is allowed.
   * <p>
   * Any space will NOT be trimmed.
   * <p>
   * An example input is: "a,bc|e,f,gh||kkk".
   */
  public static ArrayList<ArrayList<String>> read_AL_AL_String(String input) {
    ArrayList<ArrayList<String>> w = new ArrayList<ArrayList<String>>();
    String[] v = input.split("[|]"); // [|] is regular expression of "|".

    for (int i = 0; i < v.length; ++i) {
      if (v[i].equals("")) { // empty AL_String.
        ArrayList<String> x = new ArrayList<String>();
        w.add(x);
        continue;
      }

      String[] u = v[i].split(",");

      ArrayList<String> x = new ArrayList<String>();
      for (int j = 0; j < u.length; ++j) {
        x.add(u[j]);
      }
      w.add(x);
    }

    if (DEBUG) {
      System.out.println("Input:  " + input);
      System.out.print("Out:   ");
      dump_AL_AL_String(w);
      System.out.println("\nsize = " + w.size() + "\n");
    }

    return w;
  }
  
  public static void dump(String v) {
    System.out.print(v);
  }
  /**
   * Sort the input arraylists before comparing.
   */
  public static boolean equal_AL_String(ArrayList<String> a, ArrayList<String> b) {
    return equal_AL_String(a, b, true);
  }
  
  /**
   * If sort is true, sort the input arraylists before comparing.
   */
  public static boolean equal_AL_String(ArrayList<String> a,
      ArrayList<String> b, boolean sort) {
    if (a.size() != b.size())
      return false;

    if (sort) {
      Collections.sort(a);
      Collections.sort(b);
    }

    String[] as = a.toArray(new String[0]);
    String[] bs = b.toArray(new String[0]);

    return equal(as, bs);
  }
  
  /**
   * Sort the input arrays before comparing.
   */
  public static boolean equal(String[] a, String[] b) {
    return equal(a, b, true);
  }
  
  public static void dump_AL_String(ArrayList<String> v) {
    System.out.print("[");
    for (int i = 0; i < v.size(); ++i) {
      if (i > 0)
        System.out.print(", ");
      System.out.print(v.get(i));
    }
    System.out.print("]");
  }
  
  /**
   * If sort is true, sort the input arrays before comparing.
   */
  public static boolean equal(String[] a, String[] b, boolean sort) {
    if (a.length != b.length)
      return false;

    if (sort) {
      Arrays.sort(a);
      Arrays.sort(b);
    }

    for (int i = 0, len = a.length; i < len; ++i) {
      if (!a[i].equals(b[i]))
        return false;
    }
    return true;
  }
  
}

public class Test {
  
  private String input_small;
  private String input_large;
  private String output_small;
  private String output_large;
  private boolean DEBUG;

  Test() { // 1) Initialization.
    DEBUG = true;
    input_small = "a,a|a,b|a,c|a,a*|abc,abc|abc,bc|ababab,ababab|abababab,abab.*ab|ccccc,a*b*";
    output_small = "true|false|false|true|true|false|true|true|false";
    
    StringBuilder sbInput = new StringBuilder();
    sbInput.append(input_small);
    sbInput.append("|abc,a*b*c*|abc,a.c|abc,..c");
    sbInput.append("|abc,aaa|abcde,abcde|abcde,a.c.e|abcde,ab.d.*|aaaaa,a*");
    sbInput.append("|ababababab,a.*|abababababababababab,a*b*a*b*a*b*a*b*a*b*a*b*a*b*a*b*a*b*a*b*");
    sbInput.append("|abcabcabcabcabcabcabcdededededeababababab,a.*a.*");
    sbInput.append("|abcabcabcabcabcabcabcdededededeababababab,a.*ab.a*.*c.b.*d*e*.*ea*bababa.*");
    sbInput.append("|abcabcabcabcabcabcabcdededededeabababababadfadsfasdlksdflasdgualskdjfsasldkjsakdala,a.*aba.*");
    input_large = sbInput.toString();
    
    StringBuilder sbOutput = new StringBuilder();
    sbOutput.append(output_small);
    sbOutput.append("|true|true|true");
    sbOutput.append("|false|true|true|true|true");
    sbOutput.append("|true|true");
    sbOutput.append("|true");
    sbOutput.append("|true");
    sbOutput.append("|true");
    output_large = sbOutput.toString();
  }

  private void test_small() {
    test(input_small);
  }

  private void test_large() {
    test(input_large);
  }

  private void test(String input) {
    Solution so = new Solution();

    // 2) Get input.
    ArrayList<ArrayList<String>> in = OJ.read_AL_AL_String(input);
    ArrayList<String> out_large = OJ.read_AL_String(output_large);
    int good_ct = 0, total_ct = in.size();
    for (int i = 0; i < total_ct; ++i) {
      // 3) For each input, get output.
      String s = in.get(i).get(0);
      String p = in.get(i).get(1);
      Boolean ans = so.isMatch(s, p);
      String expect = out_large.get(i);
      if (Boolean.parseBoolean(expect) == ans) {
        System.out.print("good:");
        ++good_ct;
      }
      else {
        System.out.print("bad:");
      }
      
      
      
      // 4). Give feedback.
      System.out.print("input:{");
      OJ.dump_AL_String(in.get(i));
      System.out.print("}output:{");
      OJ.dump(ans.toString());
      System.out.print("}expected:{");
      OJ.dump(expect);
      System.out.print("}");

      System.out.println("");
    }
    System.out.println("correct:" + good_ct + "/" + total_ct);
  }
  
  public static void main(String[] args) {
    new Test().test_large();
  }

}
