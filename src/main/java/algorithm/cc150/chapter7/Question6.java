package algorithm.cc150.chapter7;

import java.util.List;

/**
 * Given a two-dimensional graph with points on it, find a line which passes the
 * most number of points.
 * 
 */
public class Question6 {

  public static class Point {
    public double x;
    public double y;

    public Point(int x, int y) {
      this.x = x;
      this.y = y;
    }
  }

  public static class Line {
    public enum Type {NORMAL, VERTICAL, HORIZONTAL};
    public Type type;
    public double a;
    public double b;
    public Line(Type type) {
      this.type = type;
    }
    public boolean equals(Object other) {
      if (other instanceof Line) {
        
      }
      return false;
    }
  }

  /**
   * 
   * @param points The points in the graph.
   * @return An array list containing two integers, the slope and the intercept of the line. 
   *                if line is vertical (x = c) and horizontal (y = c), return the constant only, 
   *                if two square coincides, return the x, y of the points.
   */
  public double[] findLine(List<Point> points) {
    // write implementation here
    double[] arr = null;
    
    return arr;
  }

}




