package algorithm.lc;

import java.util.ArrayList;

public class GrayCode {
  
  public static class Solution {
    public static ArrayList<Integer> grayCode(int n) {
          // Start typing your Java solution below
          // DO NOT write main() function
      ArrayList<StringBuilder> res = new ArrayList<StringBuilder>();
      if (n == 0) {
        ArrayList<Integer> zero = new ArrayList<Integer>();
        zero.add(0);
        return zero;
      }
      
      res.add(new StringBuilder().append(0));
      res.add(new StringBuilder().append(1));
      
      // generate gray codes
      for (int i = 0; i < n - 1; ++i) {
        ArrayList<StringBuilder> reflectListWithOne = new ArrayList<StringBuilder>();
        for (int j = res.size() - 1; j >= 0; --j) {
          StringBuilder sb = new StringBuilder(res.get(j).toString());
          reflectListWithOne.add(sb.append('1'));
        }
        for (int j = 0; j < res.size(); ++j) {
          StringBuilder sb = res.get(j);
          sb.append('0');
        }
        res.addAll(reflectListWithOne);
      }
      // convert to integer
      ArrayList<Integer> grayCodes = new ArrayList<Integer>();
      for (int i = 0; i < res.size(); ++i) {
        String str = res.get(i).toString();
        int val = 0;
        int base = 1;
        for (int d = 0; d < str.length(); ++d) {
          val += base * (str.charAt(d) - '0');
          base <<= 1;
        }
        grayCodes.add(val);
        System.out.println(val);
      }
      
      return grayCodes;
    }
  }
  
  public static void main(String[] args) {
    Solution.grayCode(3);
  }

}
