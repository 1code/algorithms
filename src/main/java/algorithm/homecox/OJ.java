package algorithm.homecox;
//
// OJ class. Java version.
//
// Ways to use this class: 
// 1) Copy relevant part of this class to the user file.
//    Then compile as:  javac Test.java
// 2) Put this file in the same folder as the user file.
//    Then compile as:  javac Test.java OJ.java
// 3) Package this as a jar file and place in user folder.
//
// Instruction on packing this as a jar file:
// (note: if use a package name, you have to include the package name at the 
//  top of this file, and also keep the folder structure when create jar file.)
//    - include "package Homecox;" at the top of this file.
//    - create a folder Homecox, copy this file OJ.java into it.
//    - enter the Homecox folder, compile: javac OJ.java
//    - now remove OJ.java if you don't want it included in the jar file.
//    - enter upper folder of Homecox, create jar file: jar cf OJ.jar Homecox
// Then you can use the OJ.jar file as a library when compiling your program:
//    - in your program, include "import Homecox.OJ;" at the top.
//    - place OJ.jar in the same folder (or other places) as your program
//    - compile on unix:    javac -classpath .:OJ.jar Test.java
//      compile on windows: javac -classpath .;OJ.jar Test.java
// However, then to run your program, you also have to include the jar file:
//    - run on unix:    java -classpath .:OJ.jar Test
//    - run on windows: java -classpath .;OJ.jar Test
//
// To generate API documentation: javadoc OJ.java -d OJ_doc
//
// How to Write Doc Comments for the Javadoc Tool:
// http://www.oracle.com/technetwork/java/javase/documentation/index-137868.html
//
// Author: Xin Chen
// Created on: 8/5/2013
// Last modified: 8/7/2013
//

//package Homecox;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
// no need so far.
// no need so far.
// no need so far.
// no need so far.
// no need so far.
// no need so far.
// no need so far.
// no need so far.

//
// Data structures needed by OJ. Package-private.
//

/**
 * TreeNode class.
 */
class TreeNode {
  int val;
  TreeNode left;
  TreeNode right;

  TreeNode(int x) {
    val = x;
    left = right = null;
  }
}

/**
 * TreeLinkNode class.
 */
class TreeLinkNode {
  int val;
  TreeLinkNode left, right, next;

  TreeLinkNode(int x) {
    val = x;
    left = right = next = null;
  }
}

/**
 * LinkNode class.
 */
class ListNode {
  int val;
  ListNode next;

  ListNode(int x) {
    val = x;
    next = null;
  }
}

/**
 * Interval class.
 */
class Interval {
  int start;
  int end;

  Interval() {
    start = 0;
    end = 0;
  }

  Interval(int s, int e) {
    start = s;
    end = e;
  }
}

/**
 * TreeNodeReadInfo class. Used for reading TreeNode.
 */
class TreeNodeReadInfo {
  public int token = 0;
  public boolean isNumber = false;
  public int index;

  TreeNodeReadInfo(int t, boolean n, int i) {
    token = t;
    isNumber = n;
    index = i;
  }
}

/**
 * The OJ class.
 * <p>
 * This class is used by the Homecox Online Judge system. It provides these
 * functions:
 * <ol>
 * <li>read input,
 * <li>compare user output and expected output, and
 * <li>dump/write output,
 * <li>some sorting functions are also provided.
 * </ol>
 * 
 * @author Xin Chen
 * @version 0.9
 * @since 8/5/2013 - 8/7/2013
 */
public class OJ {
  private static boolean DEBUG = false;

  //
  // Input methods. Input types include (return ArrayList of these):
  // string - ok
  // double - ok
  // int - ok
  // int[] - ok
  // ListNode - ok
  // string[] - ok
  // TreeLinkNode - ok
  // TreeNode - ok
  // HashSet<string> - ok
  // ArrayList<Interval> - ok
  // ArrayList<String> - ok
  // ArrayList<Integer> - ok
  // ArrayList<int[]> - ok
  // char[][] - ok
  //
  // Note: Cannot overload method only by return type.
  // Since a method does not have to catch the return type.
  //

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

  /**
   * Each string representing a double value is delimited by "|". Empty string
   * is not allowed.
   */
  public static ArrayList<Double> read_AL_Double(String input) {
    String[] v = input.split("[|]");
    ArrayList<Double> w = new ArrayList<Double>();

    for (int i = 0; i < v.length; ++i) {
      // if (v[i].trim().equals("")) continue;
      w.add(Double.parseDouble(v[i].trim()));
    }

    if (DEBUG) {
      System.out.println("Input:  {" + input + "}");
      System.out.print("Output: ");
      dump_AL_Double(w);
      System.out.println("\nsize = " + w.size() + "\n");
    }

    return w;
  }

  /**
   * Each string representing an int value is delimited by "|". Empty string is
   * not allowed.
   */
  public static ArrayList<Integer> read_AL_Integer(String input) {
    String[] v = input.split("[|]");
    ArrayList<Integer> w = new ArrayList<Integer>();

    for (int i = 0; i < v.length; ++i) {
      w.add(Integer.parseInt(v[i].trim()));
    }

    if (DEBUG) {
      System.out.println("Input:  {" + input + "}");
      System.out.print("Output: ");
      dump_AL_Integer(w);
      System.out.println("\nsize = " + w.size() + "\n");
    }

    return w;
  }

  /**
   * Each string representing an int array is delimited by "|". Empty string is
   * allowed, which represents an empty array.
   * <p>
   * Each string representing an int value in an int array is delimited by ",".
   * Here empty string is not allowed.
   * <p>
   * Any space will be trimmed.
   * <p>
   * An example input is: "1,2|3,4,5| |6".
   */
  public static ArrayList<int[]> read_AL_IntegerArray(String input) {
    ArrayList<int[]> w = new ArrayList<int[]>();
    String[] v = input.split("[|]"); // [|] is regular expression of "|".

    for (int i = 0; i < v.length; ++i) {
      String item = v[i].trim();

      if (item.equals("")) {
        int[] x = new int[0];
        w.add(x);
      } else {
        String[] u = item.split(",");
        int[] x = new int[u.length];
        for (int j = 0; j < u.length; ++j) {
          // if (u[j].equals("")) continue;
          x[j] = Integer.parseInt(u[j].trim());
        }
        w.add(x);
      }
    }

    if (DEBUG) {
      System.out.println("Input:  {" + input + "}");
      System.out.print("Output: ");
      dump_AL_IntegerArray(w);
      System.out.println("\nsize = " + w.size() + "\n");
    }

    return w;
  }

  /**
   * Each string representing a String array is delimited by "|". Empty string
   * is allowed, which represents an empty array.
   * <p>
   * Each string representing a String value in a String array is delimited by
   * ",". Here empty string is not allowed.
   * <p>
   * Any space will NOT be trimmed, because a string may start or end with
   * space.
   * <p>
   * An example input is: "a,b|c,de,fgh| |k".
   */
  public static ArrayList<String[]> read_AL_StringArray(String input) {
    String[] v = input.split("[|]");
    ArrayList<String[]> w = new ArrayList<String[]>();

    for (int i = 0; i < v.length; ++i) {
      String item = v[i]; // .trim();

      if (item.equals("")) {
        String[] u = new String[0];
        w.add(u);
      } else {
        String[] u = item.split(",");
        for (int j = 0; j < u.length; ++j) {
          u[j] = u[j]; // .trim();
        }
        w.add(u);
      }
    }

    if (DEBUG) {
      System.out.println("Input:  {" + input + "}");
      System.out.print("Output: ");
      dump_AL_StringArray(w);
      System.out.println("\nsize = " + w.size() + "\n");
    }

    return w;
  }

  /**
   * Each string representing a char[][] 2D array is delimited by "|". Empty
   * string is NOT allowed.
   * <p>
   * Each string representing a char[] value in a char[][] array is delimited by
   * ",". Empty string is not allowed.
   * <p>
   * Any space will NOT be trimmed.
   * <p>
   * An example input is: "10,11|ac,de,fgh|k".
   */
  public static ArrayList<char[][]> read_AL_Char2DArray(String input) {
    String[] v = input.split("[|]");
    ArrayList<char[][]> w = new ArrayList<char[][]>();

    for (int i = 0; i < v.length; ++i) {
      String[] u = v[i].split(",");
      // System.out.println("v["+i+"] = [" + v[i] + "], u.length = " +
      // u.length);

      char[][] x = new char[u.length][];
      for (int j = 0; j < u.length; ++j) {
        // System.out.println("u["+j+"] = [" + u[j] + "], u[j].length = " +
        // u[j].length());

        x[j] = new char[u[j].length()];
        for (int k = 0; k < u[j].length(); ++k) {
          x[j][k] = u[j].charAt(k);
        }
      }
      w.add(x);
    }

    if (DEBUG) {
      System.out.println("Input:  {" + input + "}");
      System.out.print("Output: ");
      dump_AL_Char2DArray(w);
      System.out.println("\nsize=" + w.size() + "\n");
    }

    return w;
  }

  /**
   * Read a list of ListNodes, each node contains an int value. Each string
   * representing an int value of a node in the list is delimited by "|". Empty
   * string is NOT allowed.
   * <p>
   * Any space will be trimmed.
   * <p>
   * An example input is: "10|11|2|3".
   */
  public static ListNode read_ListNode(String input) {
    String[] v = input.split("[|]");
    ListNode w = null, w_tail = null;

    int len = v.length;
    if (len > 0) {
      w = w_tail = new ListNode(Integer.parseInt(v[0].trim()));
      for (int i = 1; i < len; ++i) {
        w_tail.next = new ListNode(Integer.parseInt(v[i].trim()));
        w_tail = w_tail.next;
      }
    }

    if (DEBUG) {
      System.out.println("Input:  {" + input + "}");
      System.out.print("Output: ");
      dump(w);
      System.out.println("");
    }

    return w;
  }

  /**
   * Each string representing an arraylist of ints is delimited by "|". Empty
   * string is allowed, which represents an empty arraylist.
   * <p>
   * Each string representing an int value in an arraylist of ints is delimited
   * by ",". Empty string is NOT allowed.
   * <p>
   * Any space will be trimmed.
   * <p>
   * An example input is: "10,11|3,4,5| |7".
   */
  public static ArrayList<ArrayList<Integer>> read_AL_AL_Integer(String input) {
    ArrayList<ArrayList<Integer>> w = new ArrayList<ArrayList<Integer>>();
    String[] v = input.split("[|]"); // [|] is regular expression of "|".

    for (int i = 0; i < v.length; ++i) {
      String item = v[i].trim();

      if (item.equals("")) { // empty AL_integer.
        ArrayList<Integer> x = new ArrayList<Integer>();
        w.add(x);
        continue;
      }

      String[] u = item.split(",");

      ArrayList<Integer> x = new ArrayList<Integer>();
      for (int j = 0; j < u.length; ++j) {
        // if (u[j].equals("")) continue;
        x.add(Integer.parseInt(u[j].trim()));
      }
      w.add(x);
    }

    if (DEBUG) {
      System.out.println("Input:  " + input);
      System.out.print("Out:   ");
      dump_AL_AL_Integer(w);
      System.out.println("\nsize = " + w.size() + "\n");
    }

    return w;
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

  /**
   * Each string representing a hashset of Strings is delimited by "|". Empty
   * string is allowed, which represents an empty hashset.
   * <p>
   * Each string representing a String value in a hashset of Strings is
   * delimited by ",". Empty string is allowed.
   * <p>
   * Any space will NOT be trimmed.
   * <p>
   * An example input is: "a,bc|e,f,gh||kkk".
   */
  public static ArrayList<HashSet<String>> read_AL_HashSet_String(String input) {
    ArrayList<HashSet<String>> w = new ArrayList<HashSet<String>>();
    String[] v = input.split("[|]"); // [|] is regular expression of "|".

    for (int i = 0; i < v.length; ++i) {
      if (v[i].equals("")) { // empty AL_String.
        HashSet<String> x = new HashSet<String>();
        w.add(x);
        continue;
      }

      String[] u = v[i].split(",");

      HashSet<String> x = new HashSet<String>();
      for (int j = 0; j < u.length; ++j) {
        x.add(u[j]);
      }
      w.add(x);
    }

    if (DEBUG) {
      System.out.println("Input:  " + input);
      System.out.print("Out:   ");
      dump_AL_HashSet_String(w);
      System.out.println("\nsize = " + w.size() + "\n");
    }

    return w;
  }

  /**
   * Each string representing a arraylist of Intervals is delimited by "|".
   * Empty string is allowed, which represents an empty arraylist.
   * <p>
   * Each string representing a series of Intervals "start,end" pairs is
   * delimited by ",". Empty string is allowed.
   * <p>
   * Any space will be trimmed.
   * <p>
   * An example input is: "1,2|3,4, 5,6, 7,8||9,10, 11,12".
   */
  public static ArrayList<ArrayList<Interval>> read_AL_AL_Interval(String input) {
    String[] v = input.split("[|]"); // [|] is regular expression of "|".
    ArrayList<ArrayList<Interval>> w = new ArrayList<ArrayList<Interval>>();

    for (int i = 0; i < v.length; ++i) {
      String item = v[i].trim();

      if (item.equals("")) { // empty AL_Interval.
        ArrayList<Interval> x = new ArrayList<Interval>();
        w.add(x);
        continue;
      }

      String[] u = item.split(",");

      ArrayList<Interval> x = new ArrayList<Interval>();
      for (int j = 0; j < u.length; j += 2) {
        Interval y = new Interval(Integer.parseInt(u[j].trim()),
            Integer.parseInt(u[j + 1].trim()));
        x.add(y);
      }
      w.add(x);
    }

    if (DEBUG) {
      System.out.println("Input:  " + input);
      System.out.print("Out:  ");
      dump_AL_AL_Interval(w);
      System.out.println("\nsize = " + w.size() + "\n");
    }

    return w;
  }

  /**
   * Same as the description of read_AL_TreeNode(String input).
   */
  public static ArrayList<TreeLinkNode> read_AL_TreeLinkNode(String input) {
    String[] v = input.split("[|]");
    ArrayList<TreeLinkNode> w = new ArrayList<TreeLinkNode>();

    for (int i = 0; i < v.length; ++i) {
      String item = v[i].trim();

      if (item.equals("")) {
        w.add(null);
        continue;
      }

      String[] u = item.split(",");

      TreeNodeReadInfo h = new TreeNodeReadInfo(0, false, 0);
      Integer index = 0;
      TreeLinkNode x = readLBT(u, h);
      w.add(x);
    }

    if (DEBUG) {
      System.out.println("Input:  " + input);
      System.out.print("Out:  ");
      dump_AL_TreeLinkNode(w);
      System.out.println("\n");
    }

    return w;
  }

  private static TreeLinkNode readLBT(String[] u, TreeNodeReadInfo h) {
    if (!readNextToken(u, h))
      return null;

    if (h.isNumber) {
      TreeLinkNode p = new TreeLinkNode(h.token);
      p.left = readLBT(u, h);
      p.right = readLBT(u, h);
      return p;
    }

    return null; // is a null leaf node.
  }

  /**
   * Each string representing an arraylist of trees is delimited by "|". Empty
   * string is allowed, which represents an empty tree (a null node).
   * <p>
   * Each string representing a value (either an int or a dummy #) in a tree is
   * delimited by ",". Empty string is NOT allowed.
   * <p>
   * Any space will be trimmed.
   * <p>
   * An example input is: "#|1, #, #||1,2,#,#,#".
   * <p>
   * A "#" indicates a null leaf node in the serialization of the tree.
   */
  public static ArrayList<TreeNode> read_AL_TreeNode(String input) {
    ArrayList<TreeNode> w = new ArrayList<TreeNode>();
    String[] v = input.split("[|]");

    for (int i = 0; i < v.length; ++i) {
      String item = v[i].trim();

      if (item.equals("")) {
        w.add(null);
        continue;
      }

      String[] u = item.split(","); // This trim is needed.

      TreeNodeReadInfo h = new TreeNodeReadInfo(0, false, 0);
      Integer index = 0;
      TreeNode x = readBT(u, h);
      w.add(x);
    }

    if (DEBUG) {
      System.out.println("Input:  " + input);
      System.out.print("Out:  ");
      dump_AL_TreeNode(w);
      System.out.println("\n");
    }

    return w;
  }

  private static TreeNode readBT(String[] u, TreeNodeReadInfo h) {
    if (!readNextToken(u, h))
      return null;

    if (h.isNumber) {
      TreeNode p = new TreeNode(h.token);
      p.left = readBT(u, h);
      p.right = readBT(u, h);
      return p;
    }

    return null; // is a null leaf node.
  }

  private static boolean readNextToken(String[] u, TreeNodeReadInfo h) {
    int i = h.index;
    if (i == u.length)
      return false;

    String item = u[i].trim();
    if (item.equals("#")) {
      h.isNumber = false;
    } else {
      h.isNumber = true;
      h.token = Integer.parseInt(item);
    }

    ++h.index;
    return true;
  }

  //
  // Output methods. Output types include:
  // boolean - ok
  // double - ok
  // int - ok
  // ListNode - ok
  // String - ok
  // TreeNode - ok
  // int[] - ok
  // ArrayList<Integer> - ok
  // ArrayList<int[]> - ok
  // Interval - ok
  // ArrayList<Interval> - ok
  // String[] - ok
  // ArrayList<String> - ok
  // ArrayList<TreeNode> - ok
  // ArrayList<ArrayList<Integer>> - ok
  // int[][] - ok
  // ArrayList<ArrayList<String>> - ok
  // String[][] - ok
  //
  public static void dump(boolean v) {
    System.out.print(v);
  }

  public static void dump(double v) {
    System.out.print(v);
  }

  public static void dump(int v) {
    System.out.print(v);
  }

  public static void dump(String v) {
    System.out.print(v);
  }

  public static void dump(ListNode v) {
    System.out.print("[");

    if (v != null) {
      System.out.print(v.val);
      for (v = v.next; v != null; v = v.next) {
        System.out.print(" " + v.val);
      }
    }

    System.out.print("]");
  }

  public static void dump(int[] v) {
    System.out.print("[");

    for (int i = 0; i < v.length; ++i) {
      if (i > 0)
        System.out.print(", ");
      System.out.print(v[i]);
    }

    System.out.print("]");
  }

  public static void dump(int[][] v) {
    for (int i = 0; i < v.length; ++i) {
      if (i > 0)
        System.out.print(" ");
      dump(v[i]);
    }
  }

  public static void dump_AL_Integer(ArrayList<Integer> v) {
    System.out.print("[");
    for (int i = 0; i < v.size(); ++i) {
      if (i > 0)
        System.out.print(", ");
      System.out.print(v.get(i));
    }
    System.out.print("]");
  }

  public static void dump_AL_Double(ArrayList<Double> v) {
    System.out.print("[");
    for (int i = 0; i < v.size(); ++i) {
      if (i > 0)
        System.out.print(", ");
      System.out.print(v.get(i));
    }
    System.out.print("]");
  }

  public static void dump_AL_IntegerArray(ArrayList<int[]> v) {
    for (int i = 0; i < v.size(); ++i) {
      if (i > 0)
        System.out.print(" ");
      dump(v.get(i));
    }
  }

  public static void dump_AL_AL_Integer(ArrayList<ArrayList<Integer>> v) {
    for (int i = 0; i < v.size(); ++i) {
      if (i > 0)
        System.out.print(" ");
      dump_AL_Integer(v.get(i));
    }
  }

  public static void dump(String[] v) {
    System.out.print("[");
    for (int i = 0; i < v.length; ++i) {
      if (i > 0)
        System.out.print(", ");
      System.out.print(v[i]);
    }
    System.out.print("]");
  }

  public static void dump(String[][] v) {
    for (int i = 0; i < v.length; ++i) {
      if (i > 0)
        System.out.print(" ");
      dump(v[i]);
    }
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

  public static void dump_AL_StringArray(ArrayList<String[]> v) {
    for (int i = 0; i < v.size(); ++i) {
      if (i > 0)
        System.out.print(" ");
      dump(v.get(i));
    }
  }

  public static void dump_AL_AL_String(ArrayList<ArrayList<String>> v) {
    for (int i = 0; i < v.size(); ++i) {
      if (i > 0)
        System.out.print(" ");
      dump_AL_String(v.get(i));
    }
  }

  public static void dump(Interval v) {
    System.out.print("(" + v.start + ", " + v.end + ")");
  }

  public static void dump_AL_Interval(ArrayList<Interval> v) {
    System.out.print("[");
    for (int i = 0; i < v.size(); ++i) {
      if (i > 0)
        System.out.print(" ");
      dump(v.get(i));
    }
    System.out.print("]");
  }

  public static void dump_AL_AL_Interval(ArrayList<ArrayList<Interval>> v) {
    for (int i = 0; i < v.size(); ++i) {
      if (i > 0)
        System.out.print(" ");
      dump_AL_Interval(v.get(i));
    }
  }

  public static void dump(char[] v) {
    System.out.print("(");
    for (int i = 0; i < v.length; ++i) {
      if (i > 0)
        System.out.print("");
      System.out.print(v[i]);
    }
    System.out.print(")");
  }

  public static void dump(char[][] v) {
    System.out.print("[");
    for (int i = 0; i < v.length; ++i) {
      if (i > 0)
        System.out.print("");
      dump(v[i]);
    }
    System.out.print("]");
  }

  public static void dump_AL_Char2DArray(ArrayList<char[][]> v) {
    for (int i = 0; i < v.size(); ++i) {
      if (i > 0)
        System.out.print(" ");
      dump(v.get(i));
    }
  }

  public static void dump(HashSet<String> v) {
    System.out.print("[");
    int ct = 0;
    for (String x : v) {
      if (ct > 0)
        System.out.print(", ");
      ++ct;
      System.out.print(x);
    }
    System.out.print("]");
  }

  public static void dump_AL_HashSet_String(ArrayList<HashSet<String>> v) {
    for (int i = 0; i < v.size(); ++i) {
      if (i > 0)
        System.out.print(" ");
      dump(v.get(i));
    }
  }

  public static void dump(TreeNode v) {
    System.out.print("[ ");
    _tree_preorder(v);
    System.out.print("]");
  }

  private static void _tree_preorder(TreeNode v) {
    if (null == v) {
      System.out.print("# ");
    } else {
      System.out.print(v.val + " ");
      _tree_preorder(v.left);
      _tree_preorder(v.right);
    }
  }

  public static void dump_AL_TreeNode(ArrayList<TreeNode> v) {
    for (int i = 0, len = v.size(); i < len; ++i) {
      if (i > 0)
        System.out.print(" ");
      dump(v.get(i));
    }
  }

  public static void dump_AL_TreeLinkNode(ArrayList<TreeLinkNode> v) {
    for (int i = 0, len = v.size(); i < len; ++i) {
      if (i > 0)
        System.out.print(" ");
      dump(v.get(i));
    }
  }

  public static void dump(TreeLinkNode v) {
    System.out.print("[ ");
    _tree2_preorder(v);
    System.out.print("]");
  }

  private static void _tree2_preorder(TreeLinkNode v) {
    if (null == v) {
      System.out.print("# ");
    } else {
      System.out.print(v.val + " ");
      _tree2_preorder(v.left);
      _tree2_preorder(v.right);
    }
  }

  //
  // Check equality. Output types include:
  // boolean - ok
  // double - ok
  // int - ok
  // ListNode - ok
  // string - ok
  // TreeNode - ok
  // int[] - ok
  // Interval - ok
  // ArrayList<Interval> - ok
  // String[] - ok
  // ArrayList<String> - ok
  // ArrayList<TreeNode> - ok
  // ArrayList<ArrayList<Integer>> - ok
  // int[][] - ok
  // ArrayList<ArrayList<String>> - ok
  // String[][] - ok
  //

  public static boolean equal(boolean a, boolean b) {
    return a == b;
  }

  public static boolean equal(double a, double b) {
    return Math.abs(a - b) < 0.000001;
  }

  public static boolean equal(int a, int b) {
    return a == b;
  }

  public static boolean equal(String a, String b) {
    return a.equals(b);
  }

  public static boolean equal(ListNode a, ListNode b) {
    if (null == a && null == b)
      return true;
    while (a != null && b != null) {
      if (a.val != b.val)
        return false;
    }
    if (null != a || null != b)
      return false;
    return true;
  }

  public static boolean equal(TreeNode a, TreeNode b) {
    if (null == a && null == b)
      return true;
    if (null == a || null == b)
      return false;

    return a.val == b.val && equal(a.left, b.left) && equal(a.right, b.right);
  }

  /**
   * Sort the input arrays before comparing.
   */
  public static boolean equal(int[] a, int[] b) {
    return equal(a, b, true);
  }

  /**
   * If sort is true, sort the input arrays before comparing.
   */
  public static boolean equal(int[] a, int[] b, boolean sort) {
    if (a.length != b.length)
      return false;

    if (sort) {
      Arrays.sort(a);
      Arrays.sort(b);
    }

    for (int i = 0, len = a.length; i < len; ++i) {
      if (a[i] != b[i])
        return false;
    }
    return true;
  }

  /**
   * Sort the input arrays (on first level) before comparing.
   */
  public static boolean equal(int[][] a, int[][] b) {
    return equal(a, b, true);
  }

  /**
   * If sort is true, sort the input arrays (on first level) before comparing.
   */
  public static boolean equal(int[][] a, int[][] b, boolean sort) {
    if (a.length != b.length)
      return false;

    if (sort) {
      sort_int_2D_array(a);
      sort_int_2D_array(b);
    }

    for (int i = 0, len = a.length; i < len; ++i) {
      if (!equal(a[i], b[i], false))
        return false;
    }
    return true;
  }

  /**
   * Sort a 2D array of integers on first level.
   */
  // Reference:
  // http://stackoverflow.com/questions/4158679/sorting-a-2-dimensional-array
  public static void sort_int_2D_array(int[][] a) {
    if (a.length <= 1)
      return;

    Arrays.sort(a, new Comparator<int[]>() {
      public int compare(int[] a, int[] b) {
        for (int i = 0, len = Math.min(a.length, b.length); i < len; ++i) {
          if (a[i] < b[i])
            return -1;
          if (a[i] > b[i])
            return 1;
        }

        if (a.length < b.length)
          return -1;
        if (a.length > b.length)
          return 1;
        return 0;
      }
    });
  }

  public static boolean equal(Interval a, Interval b) {
    return a.start == b.start && a.end == b.end;
  }

  /**
   * Sort the input arraylists before comparing.
   */
  public static boolean equal_AL_Interval(ArrayList<Interval> a,
      ArrayList<Interval> b) {
    return equal_AL_Interval(a, b, true);
  }

  /**
   * If sort is true, sort the input arraylists before comparing.
   */
  public static boolean equal_AL_Interval(ArrayList<Interval> a,
      ArrayList<Interval> b, boolean sort) {
    if (a.size() != b.size())
      return false;

    if (sort) {
      sort_AL_Interval(a);
      sort_AL_Interval(b);
    }

    for (int i = 0, len = a.size(); i < len; ++i) {
      Interval ai = a.get(i);
      Interval bi = b.get(i);
      if (!equal(ai, bi))
        return false;
    }
    return true;
  }

  /**
   * Sort an arraylist of intervals.
   */
  public static void sort_AL_Interval(ArrayList<Interval> a) {
    if (a.size() <= 1)
      return;

    Collections.sort(a, new Comparator<Interval>() {
      public int compare(Interval a, Interval b) {
        if (a.start < b.start)
          return -1;
        else if (a.start > b.start)
          return 1;
        else {
          if (a.end < b.end)
            return -1;
          else if (a.end > b.end)
            return 1;
          else
            return 0;
        }
      }
    });
  }

  /**
   * Sort the input arrays before comparing.
   */
  public static boolean equal(String[] a, String[] b) {
    return equal(a, b, true);
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

  /**
   * Sort the input arrays (on first level) before comparing.
   */
  public static boolean equal(String[][] a, String[][] b) {
    return equal(a, b, true);
  }

  /**
   * If sort is true, sort the input arrays (on first level) before comparing.
   */
  public static boolean equal(String[][] a, String[][] b, boolean sort) {
    if (a.length != b.length)
      return false;

    if (sort) {
      sort_string_2D_array(a);
      sort_string_2D_array(b);
    }

    for (int i = 0, len = a.length; i < len; ++i) {
      if (!equal(a[i], b[i], false))
        return false;
    }
    return true;
  }

  /**
   * Sort a 2D array of strings on first level.
   */
  // Reference:
  // http://stackoverflow.com/questions/4158679/sorting-a-2-dimensional-array
  public static void sort_string_2D_array(String[][] a) {
    if (a.length <= 1)
      return;

    Arrays.sort(a, new Comparator<String[]>() {
      public int compare(String[] a, String[] b) {
        int cmp;
        for (int i = 0, len = Math.min(a.length, b.length); i < len; ++i) {
          cmp = a[i].compareTo(b[i]);
          if (cmp < 0)
            return -1;
          if (cmp > 0)
            return 1;
        }

        if (a.length < b.length)
          return -1;
        if (a.length > b.length)
          return 1;
        return 0;
      }
    });
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
   * Sort the input trees before comparing.
   */
  public static boolean equal_AL_TreeNode(ArrayList<TreeNode> a,
      ArrayList<TreeNode> b) {
    return equal_AL_TreeNode(a, b, true);
  }

  /**
   * If sort is true, sort the input trees before comparing.
   */
  public static boolean equal_AL_TreeNode(ArrayList<TreeNode> a,
      ArrayList<TreeNode> b, boolean sort) {
    if (a.size() != b.size())
      return false;

    if (sort) {
      sort_AL_TreeNode(a);
      sort_AL_TreeNode(b);
    }

    for (int i = 0, len = a.size(); i < len; ++i) {
      if (!equal(a.get(i), b.get(i)))
        return false;
    }

    return true;
  }

  /**
   * Sort a list of trees.
   */
  public static void sort_AL_TreeNode(ArrayList<TreeNode> a) {
    if (a.size() <= 1)
      return;

    Collections.sort(a, new Comparator<TreeNode>() {
      public int compare(TreeNode a, TreeNode b) {
        if (null == a && null == b)
          return 0;
        if (null == a)
          return -1;
        if (null == b)
          return 1;

        if (a.val < b.val)
          return -1;
        if (a.val > b.val)
          return 1;
        int c = compare(a.left, b.left);
        if (c != 0)
          return c;
        else
          return compare(a.right, b.right);
      }
    });
  }

  /**
   * Sort the input arraylists before comparing.
   */
  public static boolean equal_AL_Integer(ArrayList<Integer> a,
      ArrayList<Integer> b) {
    return equal_AL_Integer(a, b, true);
  }

  /**
   * If sort is true, sort the input arraylists before comparing.
   */
  public static boolean equal_AL_Integer(ArrayList<Integer> a,
      ArrayList<Integer> b, boolean sort) {
    if (a.size() != b.size())
      return false;

    if (sort) {
      Collections.sort(a);
      Collections.sort(b);
    }

    for (int i = 0; i < a.size(); ++i) {
      // note "a.get(i) == o.get(i)" compares object refereces and is wrong.
      int x = a.get(i);
      int y = b.get(i);
      if (x != y)
        return false;
    }

    return true;
  }

  /**
   * Sort the input arraylists (on first level) before comparing.
   */
  public static boolean equal_AL_AL_Integer(ArrayList<ArrayList<Integer>> a,
      ArrayList<ArrayList<Integer>> b) {
    return equal_AL_AL_Integer(a, b, true);
  }

  /**
   * If sort is true, sort the input arraylists (on first level) before
   * comparing.
   */
  public static boolean equal_AL_AL_Integer(ArrayList<ArrayList<Integer>> a,
      ArrayList<ArrayList<Integer>> b, boolean sort) {
    if (a.size() != b.size())
      return false;

    if (sort) {
      sort_AL_AL_Integer(a);
      sort_AL_AL_Integer(b);
    }

    for (int i = 0; i < a.size(); ++i) {
      if (!equal_AL_Integer(a.get(i), b.get(i), false))
        return false;
    }

    return true;
  }

  /**
   * Sort a 2D array of integers on first level.
   */
  // Sort elements (ArrayList<Integer>) by int values in the lists.
  public static void sort_AL_AL_Integer(ArrayList<ArrayList<Integer>> a) {
    if (a.size() <= 1)
      return;

    Collections.sort(a, new Comparator<ArrayList<Integer>>() {
      public int compare(ArrayList<Integer> a, ArrayList<Integer> b) {
        int tmp, len = Math.min(a.size(), b.size());
        for (int i = 0; i < len; ++i) {
          tmp = a.get(i) - b.get(i);
          if (tmp < 0)
            return -1;
          if (tmp > 0)
            return 1;
        }
        if (a.size() < b.size())
          return -1;
        else if (a.size() > b.size())
          return 1;
        return 0;
      }
    });
  }

  /**
   * Sort the input arraylists (on first level) before comparing.
   */
  public static boolean equal_AL_AL_String(ArrayList<ArrayList<String>> a,
      ArrayList<ArrayList<String>> b) {
    return equal_AL_AL_String(a, b, true);
  }

  /**
   * If sort is true, sort the input arraylists (on first level) before
   * comparing.
   */
  public static boolean equal_AL_AL_String(ArrayList<ArrayList<String>> a,
      ArrayList<ArrayList<String>> b, boolean sort) {
    if (a.size() != b.size())
      return false;

    if (sort) {
      sort_AL_AL_String(a);
      sort_AL_AL_String(b);
    }

    for (int i = 0; i < a.size(); ++i) {
      if (!equal_AL_String(a.get(i), b.get(i), false))
        return false;
    }

    return true;
  }

  /**
   * Sort a 2D arraylist of strings on first level.
   */
  public static void sort_AL_AL_String(ArrayList<ArrayList<String>> a) {
    if (a.size() <= 1)
      return;

    Collections.sort(a, new Comparator<ArrayList<String>>() {
      public int compare(ArrayList<String> a, ArrayList<String> b) {
        int tmp, len = Math.min(a.size(), b.size());
        for (int i = 0; i < len; ++i) {
          String ai = a.get(i);
          String bi = b.get(i);

          tmp = ai.compareTo(bi);
          if (tmp < 0)
            return -1;
          if (tmp > 0)
            return 1;
        }
        if (a.size() < b.size())
          return -1;
        else if (a.size() > b.size())
          return 1;
        return 0;
      }
    });
  }

  /**
   * Sort a 2D arraylist of integers on both first and second levels.
   */
  public static void sort_deep_int_2D_array(int[][] a) {
    for (int i = 0; i < a.length; ++i) {
      Arrays.sort(a[i]);
    }
    sort_int_2D_array(a);
  }

  /**
   * Sort a 2D arraylist of strings on both first and second levels.
   */
  public static void sort_deep_string_2D_array(String[][] a) {
    for (int i = 0; i < a.length; ++i) {
      Arrays.sort(a[i]);
    }
    sort_string_2D_array(a);
  }

  /**
   * Sort an arraylist of arraylist of integers on both first and second levels.
   */
  public static void sort_deep_AL_AL_Integer(ArrayList<ArrayList<Integer>> a) {
    for (int i = 0; i < a.size(); ++i) {
      Collections.sort(a.get(i));
    }
    sort_AL_AL_Integer(a);
  }

  /**
   * Sort an arraylist of arraylist of strings on both first and second levels.
   */
  public static void sort_deep_AL_AL_String(ArrayList<ArrayList<String>> a) {
    for (int i = 0; i < a.size(); ++i) {
      Collections.sort(a.get(i));
    }
    sort_AL_AL_String(a);
  }

  //
  // Test functions. START.
  //
  // Can remove this section in production version.
  //

  // test dump tree
  private static void test_dump_TreeNode() {
    System.out.println("\n==test_dump_TreeNode()==");
    TreeNode r = new TreeNode(1);
    r.left = new TreeNode(2);
    r.left.right = new TreeNode(3);

    ArrayList<TreeNode> forest = new ArrayList<TreeNode>();
    forest.add(r);
    dump_AL_TreeNode(forest);
  }

  // test read TreeNode.
  private static void test_read_TreeNode() {
    System.out.println("\n==test_read_TreeNode()==");
    read_AL_TreeNode("#");
    read_AL_TreeNode("1,#,#");
    read_AL_TreeNode("1,2,#,#,#");
    read_AL_TreeNode("1,2,#,3,#,#,#");
    read_AL_TreeNode("1,#,2,#,#");
    read_AL_TreeNode("1,2,4,#,#,5,7,#,#,#,3,#,6,8,#,9,#,#,# || 1,2,#,#,#");
  }

  private static void test_read_TreeLinkNode() {
    System.out.println("\n==test_read_TreeLinkNode()==");
    read_AL_TreeLinkNode("#");
    read_AL_TreeLinkNode("1,#,#");
    read_AL_TreeLinkNode("1,2,#,#,#");
    read_AL_TreeLinkNode("1,2,#,3,#,#,#");
    read_AL_TreeLinkNode("1,#,2,#,#");
    read_AL_TreeLinkNode("1,2,4,#,#,5,7,#,#,#,3,#,6,8,#,9,#,#,# || 1,2,#,#,#");
  }

  private static void test_read_AL_String() {
    System.out.println("\n==test_read_AL_String()==");
    read_AL_String("");
    read_AL_String("  ");
    read_AL_String("|");
    read_AL_String("| ");
    read_AL_String("abc");
    read_AL_String("|abc|def");
  }

  private static void test_read_AL_Double() {
    System.out.println("\n==test_read_AL_Double()==");
    read_AL_Double("");
    read_AL_Double("0.1");
    read_AL_Double("|0.2");
    read_AL_Double("0.3|1.4");
    read_AL_Double("5 | 6 ");
    read_AL_Double("7 |8|9.2");
  }

  private static void test_read_AL_IntegerArray() {
    System.out.println("\n==test_read_AL_IntegerArray()==");
    read_AL_IntegerArray(" ");
    read_AL_IntegerArray(" 1 ");
    read_AL_IntegerArray("|2,1");
    read_AL_IntegerArray("0|1,2,3| 4 , 5 , 6");
  }

  private static void test_read_ListNode() {
    System.out.println("\n==test_read_ListNode()==");
    read_ListNode(" 0 ");
    read_ListNode(" 1 ");
    read_ListNode("2|1");
    read_ListNode("0|1|2|3| 4 | 5 | 6");
  }

  private static void test_read_AL_StringArray() {
    System.out.println("\n==test_read_AL_StringArray()==");
    read_AL_StringArray("");
    read_AL_StringArray("  ");
    read_AL_StringArray(" 1 ");
    read_AL_StringArray("2|1");
    read_AL_StringArray("0,2|1 , a , b,c,d , e |2|3| 4 | 5 | 6");
  }

  private static void test_read_AL_AL_Interval() {
    System.out.println("\n==test_read_AL_AL_Interval()==");
    read_AL_AL_Interval("");
    read_AL_AL_Interval("1,2");
    read_AL_AL_Interval("1,2, 3, 4");
    read_AL_AL_Interval("1,2, 3, 4 | 5,6, 7,8 ");
  }

  private static void test_read_AL_AL_Integer() {
    System.out.println("\n==test_read_AL_AL_Integer()==");
    read_AL_AL_Integer("");
    read_AL_AL_Integer("1,2");
    read_AL_AL_Integer("1,2, 3, 4");
    read_AL_AL_Integer("1,2, 3, 4 | 5,6, 7,8 ");
  }

  private static void test_read_AL_AL_String() {
    System.out.println("\n==test_read_AL_AL_String()==");
    read_AL_AL_String("");
    read_AL_AL_String("1,2");
    read_AL_AL_String("1,2, 3, 4");
    read_AL_AL_String("1,2, 3, 4 | 5,6, 7,8 ");
  }

  private static void test_read_AL_Char2DArray() {
    System.out.println("\n==test_read_AL_Char2DArray()==");
    read_AL_Char2DArray(" ");
    read_AL_Char2DArray("1,2");
    read_AL_Char2DArray("1,2, 3, 4");
    read_AL_Char2DArray("1,2, 3, 4 | 5,6, 7,8 ");
    read_AL_Char2DArray("1111,1001,1011,1111");
  }

  private static void test_read_AL_HashSet_String() {
    System.out.println("\n==test_read_AL_Char2DArray()==");
    read_AL_HashSet_String(" ");
    read_AL_HashSet_String("1,2");
    read_AL_HashSet_String("1,2, 3, 4");
    read_AL_HashSet_String("1,2, 3, 4 | 5,6, 7,8 ");
    read_AL_HashSet_String("1111,1001,1011,1111");
  }

  private static void test_sort_int_array() {
    System.out.println("\n==test_sort_int_array()==");
    int[] a = { 3, 1, 2, 4, 2, 5 };
    System.out.print("before: ");
    dump(a);
    System.out.println("");
    Arrays.sort(a);
    System.out.print("after:  ");
    dump(a);
    System.out.println("");
  }

  private static void test_sort_string_array() {
    System.out.println("\n==test_sort_string_array()==");
    String[] a = { "d", "x", "a", "t", "e", "f" };
    System.out.print("before: ");
    dump(a);
    System.out.println("");
    Arrays.sort(a);
    System.out.print("after:  ");
    dump(a);
    System.out.println("");
  }

  private static void test_sort_int_2D_array() {
    System.out.println("\n==test_sort_int_2D_array()==");
    int[][] a = { { 3, 2, 2, 4, 2, 5 }, { 3, 2, 1 }, { 1, 2, 4 } };
    System.out.print("before: ");
    dump(a);
    System.out.println("");
    // Arrays.sort(a);
    sort_int_2D_array(a);
    System.out.print("after:  ");
    dump(a);
    System.out.println("");
  }

  private static void test_sort_string_2D_array() {
    System.out.println("\n==test_sort_string_2D_array()==");
    String[][] a = { { "a" }, { "a", "d", "c" }, { "c", "a" }, { "a", "b" } };
    System.out.print("before: ");
    dump(a);
    System.out.println("");
    sort_string_2D_array(a);
    System.out.print("after:  ");
    dump(a);
    System.out.println("");
  }

  private static void test_sort_TreeNodes() {
    System.out.println("\n==test_sort_TreeNodes()==");
    ArrayList<TreeNode> f = read_AL_TreeNode("1 , 2 ,3 , #,#,#,# | 1,#,2,#,#|#|1,#,#|1,2,#,3,#,#,#|1,2,#,#,#");
    sort_AL_TreeNode(f);
    System.out.println("after sort: ");
    dump_AL_TreeNode(f);
  }

  private static void test_sort_AL_Interval() {
    System.out.println("\n==test_sort_AL_Interval()==");
    ArrayList<ArrayList<Interval>> f = read_AL_AL_Interval("1,2, 4,5 | 6,3, 4,8, 4,7 | 3,4, 1,4");
    for (int i = 0; i < f.size(); ++i) {
      sort_AL_Interval(f.get(i));
    }
    System.out.println("after sort: ");
    dump_AL_AL_Interval(f);
  }

  private static void test_sort_AL_Integer() {
    System.out.println("\n==test_sort_AL_Integer()==");
    ArrayList<Integer> a = read_AL_Integer("3|1|2|4|2|5");
    System.out.print("before: ");
    dump_AL_Integer(a);
    System.out.println("");
    Collections.sort(a);
    System.out.print("after:  ");
    dump_AL_Integer(a);
    System.out.println("");
  }

  private static void test_sort_AL_String() {
    System.out.println("\n==test_sort_AL_String()==");
    ArrayList<String> a = read_AL_String("a3|c1|b2|u4|f2|e5");
    System.out.print("before: ");
    dump_AL_String(a);
    System.out.println("");
    Collections.sort(a);
    System.out.print("after:  ");
    dump_AL_String(a);
    System.out.println("");
  }

  private static void test_sort_AL_AL_Integer() {
    System.out.println("\n==test_sort_AL_AL_Integer()==");
    ArrayList<ArrayList<Integer>> a = read_AL_AL_Integer("3,1|1,4|2,3|4|2,4,5|5,2");
    System.out.print("before: ");
    dump_AL_AL_Integer(a);
    System.out.println("");
    sort_AL_AL_Integer(a);
    System.out.print("after:  ");
    dump_AL_AL_Integer(a);
    System.out.println("");
  }

  private static void test_sort_deep_AL_AL_Integer() {
    System.out.println("\n==test_sort_deep_AL_AL_Integer()==");
    ArrayList<ArrayList<Integer>> a = read_AL_AL_Integer("3,1|1,4|2,3|4|2,4,5|5,2");
    System.out.print("before: ");
    dump_AL_AL_Integer(a);
    System.out.println("");
    sort_deep_AL_AL_Integer(a);
    System.out.print("after:  ");
    dump_AL_AL_Integer(a);
    System.out.println("");
  }

  private static void test_sort_AL_AL_String() {
    System.out.println("\n==test_sort_AL_AL_String()==");
    ArrayList<ArrayList<String>> a = read_AL_AL_String("a3,c1|d1,a4|b2,a3|e4|c2,d4,a5|b5,e2");
    System.out.print("before: ");
    dump_AL_AL_String(a);
    System.out.println("");
    sort_AL_AL_String(a);
    System.out.print("after:  ");
    dump_AL_AL_String(a);
    System.out.println("");
  }

  private static void test_sort_deep_AL_AL_String() {
    System.out.println("\n==test_sort_deep_AL_AL_String()==");
    ArrayList<ArrayList<String>> a = read_AL_AL_String("a3,c1|d1,a4|b2,a3|e4|c2,d4,a5|b5,e2");
    System.out.print("before: ");
    dump_AL_AL_String(a);
    System.out.println("");
    sort_deep_AL_AL_String(a);
    System.out.print("after:  ");
    dump_AL_AL_String(a);
    System.out.println("");
  }

  /**
   * Entry function for testing function in this class.
   */
  public static void test() {
    DEBUG = true;

    //
    // Test read and dump functions.
    //

    // test_dump_TreeNode();
    test_read_TreeNode();
    test_read_TreeLinkNode();
    // test_read_AL_String();
    // test_read_AL_Double();
    // test_read_AL_IntegerArray();
    // test_read_ListNode();
    // test_read_AL_StringArray();
    // test_read_AL_AL_Interval();
    // test_read_AL_AL_Integer();
    // test_read_AL_AL_String();
    // test_read_AL_Char2DArray();
    // test_read_AL_HashSet_String();

    //
    // Test sorting functions.
    //

    // test_sort_int_array();
    // test_sort_string_array();
    // test_sort_int_2D_array();
    // test_sort_string_2D_array();
    // test_sort_AL_Integer();
    // test_sort_AL_String();

    // test_sort_TreeNodes();
    // test_sort_AL_Interval();

    // test_sort_AL_AL_Integer();
    // test_sort_deep_AL_AL_Integer();

    // test_sort_AL_AL_String();
    // test_sort_deep_AL_AL_String();
  }

  //
  // Test functions. END.
  //
}
