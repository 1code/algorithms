package algorithm.basic;

import org.junit.Test;

public class TestConstantTimeDS {
  
  @Test
  public void testConstantTimeDS() {
    ConstantTimeDS ds = new ConstantTimeDS();
    
    ds.add(1);
    System.out.println(ds.getRandom());
    ds.add(2);
    System.out.println(ds.getRandom());
    ds.del(2);
    System.out.println(ds.getRandom());
    ds.add(3);
    ds.del(1);
    System.out.println(ds.getRandom());
  }

}
