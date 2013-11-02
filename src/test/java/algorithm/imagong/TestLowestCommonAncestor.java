package algorithm.imagong;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import algorithm.imagong.LowestCommonAncestor.TreeNode;


public class TestLowestCommonAncestor {
  
  /**
   *         1
   *       /   \
   *      2     3
   *     / \   / \
   *    4   5 6   7
   *             / \
   *            8   9
   */
  @Test
  public void testLCARecursive() {
    
    TreeNode one = new TreeNode(1);
    TreeNode two = new TreeNode(2);
    TreeNode three = new TreeNode(3);
    TreeNode four = new TreeNode(4);
    TreeNode five = new TreeNode(5);
    TreeNode six = new TreeNode(6);
    TreeNode seven = new TreeNode(7);
    TreeNode eight = new TreeNode(8);
    TreeNode nine = new TreeNode(9);
    
    one.left = two;
    one.right = three;
    two.left = four;
    two.right = five;
    three.left = six;
    three.right = seven;
    seven.left = eight;
    seven.right = nine;
    
    LowestCommonAncestor lca = new LowestCommonAncestor();
    
    assertEquals(one, lca.lcaRecursive(one, four, eight));
    assertEquals(one, lca.lcaRecursive(one, five, eight));
    assertEquals(one, lca.lcaRecursive(one, four, nine));
    assertEquals(one, lca.lcaRecursive(one, five, nine));
    assertEquals(one, lca.lcaRecursive(one, four, six));
    assertEquals(one, lca.lcaRecursive(one, four, seven));
    
    assertEquals(two, lca.lcaRecursive(one, four, five));
    assertEquals(three, lca.lcaRecursive(one, six, eight));
    
    assertEquals(three, lca.lcaRecursive(one, three, nine));
  }

}
