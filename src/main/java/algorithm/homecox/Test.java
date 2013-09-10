package algorithm.homecox;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Include the real solution.
 *
 */
class Solution {
  
  public int[] sort(int[] nums) {
    Arrays.sort(nums);
    return nums;
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
    input_small = "3,1,5,-2,3,0,3|0,3,2,1,3,4,0,0,0|0,3,2,1,33,-19,2";
    input_large = input_small + "|32,13,-231,32,3221,32,3,56,353,-3421,3568,523,5326,32456,23673,34532";
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
      int[] answer = so.sort(a);
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

  void output(ArrayList<ArrayList<Integer>> vs, int[] num, int[] s) {
    ArrayList<Integer> v = new ArrayList<Integer>();
    for (int j = 0; j < num.length; j++)
      v.add(num[s[j] - 1]); // NOTE: s[j] - 1, not s[j]!!!
    vs.add(v);
  }

  //
  // Correct algorithm for the question. END.
  //

  public static void main(String[] args) {
    Test t = new Test();
    t.test_small();
    t.test_large();

    OJ.test();
  }
}
