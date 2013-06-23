package algorithm.cc150.chapter9;

import java.util.List;

/**
 * You have a stack of n boxes, with widths w_i, heights h_i and depths d_i. The
 * boxes cannot be rotated and can only be stacked on top of one another if each
 * box in the stack is strictly larger than the box above it in width, height,
 * and depth. Implement a method to build the tallest stack possible, where the
 * height of a stack is the sum of the heights of each box.
 * 
 */
public class Question10 {
  
  public long talleast(List<Box> boxes) {
    //  write implementaion here
    
    return 0;
  }
  
  public static class Box {
    public int width;
    public int height;
    public int depth;
    
    public Box(int width, int height, int depth) {
      this.width = width;
      this.height = height;
      this.depth = depth;
    }
  }

}
