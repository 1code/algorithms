package algorithm.homecox.sort;

//package algorithm.homecox.sort;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * 排序，实现任意排序算法对数组进行排序.
 * 
 */
class Solution {

  public int[] sort(int[] nums) {
    Arrays.sort(nums);
    return nums;
  }

}

class OJ {
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
          x[j] = Integer.parseInt(u[j].trim());
        }
        w.add(x);
      }
    }

    return w;
  }

  public static boolean equal(int[] a, int[] b) {
    return equal(a, b, true);
  }

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

  public static boolean equal(int a, int b) {
    return a == b;
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

}

/**
 * The test class.
 */
public class Test {
  private String input_small;
  private String input_large;
  private boolean DEBUG;

  Test() { // 1) Initialization.
    DEBUG = true;
    input_small = "3,1,5,-2,3,0,3|0,3,2,1,3,4,0,0,0|0,3,2,1,33,-19,2|1,1,1,1,1,1,1,1|9999999,9999999,9999999,9999999,9999999,9999999,9999999,9999999";
    StringBuilder sb = new StringBuilder(input_small);
    sb.append("|32,13,-231,32,3221,32,3,56,353,-3421,3568,523,5326,32456,23673,34532");
    sb.append("|32,15,329,5382,34,-322,1349532,23415,321,-342342,1345,432134,5323532,531,-2351235,232,-35");
    sb.append("|99,98,97,96,95,94,93,92,91,90,89,88,87,86,85,84,83,82,81,80,79,78,77,76,75,74,73,72,71,70,69,68,67,66,65,64,63,62,61");
    sb.append("|0,0,0,0,0,0,0,0,0,0,0,0,0,0,0");
    input_large = sb.toString();
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
    ArrayList<int[]> in = OJ.read_AL_IntegerArray(input);

    int good_ct = 0, total_ct = in.size();
    for (int i = 0; i < total_ct; ++i) {
      // 3) For each input, get output.
      int[] a = in.get(i);
      int[] copy = Arrays.copyOf(a, a.length);
      int[] answer = so.sort(copy);
      int[] expect = this.sort(a); // expected
                                   // result.

      if (OJ.equal(answer, expect)) {
        System.out.print("good:");
        ++good_ct;
      } else {
        System.out.print("bad:");
      }

      // 4). Give feedback.
      System.out.print("input:{");
      OJ.dump(in.get(i));
      System.out.print("}output:{");
      OJ.dump(answer);
      System.out.print("}expected:{");
      OJ.dump(expect);
      System.out.print("}");

      System.out.println("");
    }
    System.out.println("correct:" + good_ct + "/" + total_ct);
  }

  //
  // 5) Correct algorithm for the question. START.
  //
  public int[] sort(int[] num) {
    Arrays.sort(num);
    return num;
  }

  //
  // Correct algorithm for the question. END.
  //
  public static void main(String[] args) {
    Test t = new Test();
    t.test_small();
    t.test_large();
  }
}
