package algorithm.lc;

import java.util.ArrayList;
import java.util.Comparator;

/**
 * Given a set of non-overlapping intervals, insert a new interval into the
 * intervals (merge if necessary).
 * 
 * You may assume that the intervals were initially sorted according to their
 * start times.
 * 
 * Example 1: Given intervals [1,3],[6,9], insert and merge [2,5] in as
 * [1,5],[6,9].
 * 
 * Example 2: Given [1,2],[3,5],[6,7],[8,10],[12,16], insert and merge [4,9] in
 * as [1,2],[3,10],[12,16].
 * 
 * This is because the new interval [4,9] overlaps with [3,5],[6,7],[8,10]. *
 */
public class InsertInterval {

  public class Interval {
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

  // only one scan
  public class Solution {
    public ArrayList<Interval> insert(ArrayList<Interval> intervals, Interval newInterval) {
          // Start typing your Java solution below
          // DO NOT write main() function
      ArrayList<Interval> res = new ArrayList<Interval>();
      int start = newInterval.start;
      int end = newInterval.end;
      boolean finished = false;
      for (int i = 0; i < intervals.size(); ++i) {
        Interval interval = intervals.get(i);
        if (interval.end < start) {
          res.add(interval);
        }
        else if (interval.start > end) { 
          if (finished == false) { // new interval has not been added
            res.add(new Interval(start, end));
            finished = true;
          }
          res.add(interval);
        }
        else {
          start = Math.min(interval.start, start);
          end = Math.max(interval.end, end);
        }
      }
      
      if (finished == false) {
        res.add(new Interval(start, end));
      }
      
      return res;
    }
  }

}
