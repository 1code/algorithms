package algorithm.homecox.permutation;

//
// OJ class. Java version.
//
// Author: Xin Chen
// Created on: 8/5/2013
// Last modified: 8/6/2013
//

//import Homecox.OJ;

import java.util.ArrayList;

import algorithm.homecox.OJ;

class Solution {
  public ArrayList<ArrayList<Integer>> permute(int[] num) {
    ArrayList<ArrayList<Integer>> vs = new ArrayList<ArrayList<Integer>>();

    int[] s = new int[num.length];
    for (int i = 0; i < num.length; ++i)
      s[i] = 0;
    permutation(vs, num, s, 0, num.length);
    return vs;
  }

  void permutation(ArrayList<ArrayList<Integer>> vs, int[] num, int[] s,
      int pos, int len) {
    if (pos == len) {
      output(vs, num, s);
    }

    for (int i = 0; i < len; i++) {
      if (s[i] == 0) {
        s[i] = pos + 1;
        permutation(vs, num, s, pos + 1, len);
        s[i] = 0;
      }
    }
  }

  void output(ArrayList<ArrayList<Integer>> vs, int[] num, int[] s) {
    ArrayList<Integer> v = new ArrayList<Integer>();
    for (int j = 0; j < num.length; j++)
      v.add(num[s[j] - 1]); // NOTE: s[j] - 1, not s[j]!!!
    vs.add(v);
  }
}

//
// Below is all that's needed for a new question. 5 places need change.
//

/**
 * The test class.
 */
public class Test {
  private String input_small;
  private String input_large;
  private boolean DEBUG;

  Test() { // 1) Initialization.
    DEBUG = true;
    input_small = "|-1|0|1|-1,0|0,1|1,2|-1,0,1|1,2,3";
    input_large = input_small + "|" + "-2,-1,0,1,2|" + "1,2,3,4,5|"
        + "2,4,7,9,8,-1|" + "2,64,555,9,20,8|" + "-22,354,0,234,1000,3|"
        + "-299,90,-456,-4,-88,0";
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
      ArrayList<ArrayList<Integer>> answer = so.permute(a);
      ArrayList<ArrayList<Integer>> expect = this.permute(a); // expected
                                                              // result.

      if (OJ.equal_AL_AL_Integer(answer, expect)) {
        System.out.print("good:");
        ++good_ct;
      } else {
        System.out.print("bad:");
      }

      // 4). Give feedback.
      System.out.print("input:{");
      OJ.dump(in.get(i));
      System.out.print("}output:{");
      OJ.dump_AL_AL_Integer(answer);
      System.out.print("}expected:{");
      OJ.dump_AL_AL_Integer(expect);
      System.out.print("}");

      System.out.println("");
    }
    System.out.println("correct:" + good_ct + "/" + total_ct);
  }

  //
  // 5) Correct algorithm for the question. START.
  //
  public ArrayList<ArrayList<Integer>> permute(int[] num) {
    ArrayList<ArrayList<Integer>> vs = new ArrayList<ArrayList<Integer>>();

    int[] s = new int[num.length];
    for (int i = 0; i < num.length; ++i)
      s[i] = 0;
    permutation(vs, num, s, 0, num.length);
    return vs;
  }

  void permutation(ArrayList<ArrayList<Integer>> vs, int[] num, int[] s,
      int pos, int len) {
    if (pos == len) {
      output(vs, num, s);
    }

    for (int i = 0; i < len; i++) {
      if (s[i] == 0) {
        s[i] = pos + 1;
        permutation(vs, num, s, pos + 1, len);
        s[i] = 0;
      }
    }
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
    // t.test_large();

    OJ.test();
  }
}
