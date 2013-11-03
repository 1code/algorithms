package algorithm.imagong;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import algorithm.recursive.LowestCommonAncestor;
import algorithm.recursive.LowestCommonAncestor.NodeWithParent;
import algorithm.recursive.LowestCommonAncestor.TreeNode;


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
  public void testLCAWithParent() {
    NodeWithParent one = new NodeWithParent(1);
    NodeWithParent two = new NodeWithParent(2);
    NodeWithParent three = new NodeWithParent(3);
    NodeWithParent four = new NodeWithParent(4);
    NodeWithParent five = new NodeWithParent(5);
    NodeWithParent six = new NodeWithParent(6);
    NodeWithParent seven = new NodeWithParent(7);
    NodeWithParent eight = new NodeWithParent(8);
    NodeWithParent nine = new NodeWithParent(9);
    
    two.parent = one;
    three.parent = one;
    four.parent = two;
    five.parent = two;
    six.parent = three;
    seven.parent = three;
    eight.parent = seven;
    nine.parent = seven;
    
    LowestCommonAncestor lca = new LowestCommonAncestor();
    assertEquals(one, lca.lca(one, two));
    assertEquals(one, lca.lca(one, five));
    assertEquals(one, lca.lca(one, nine));
    assertEquals(one, lca.lca(two, six));
    assertEquals(one, lca.lca(two, seven));
    
    assertEquals(two, lca.lca(four, five));
    assertEquals(four, lca.lca(four, four));
    assertEquals(three, lca.lca(three, six));
    
    assertEquals(three, lca.lca(six, eight));
    assertEquals(three, lca.lca(six, nine));
    assertEquals(one, lca.lca(four, nine));
  }

}
