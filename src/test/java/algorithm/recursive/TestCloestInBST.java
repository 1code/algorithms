package algorithm.recursive;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import algorithm.recursive.CloestInBST;
import algorithm.recursive.CloestInBST.TreeNode;

/**
 * 
 *
 */
public class TestCloestInBST {
  
  @Test
  public void testCloestInBST() {
    /*
     *                10
     *               /  \
     *              5    20
     *             /    /  \
     *            3    15   30
     *             \     \
     *              4     17
     */
    TreeNode ten = new TreeNode(10);
    TreeNode five = new TreeNode(5);
    TreeNode twenty = new TreeNode(20);
    TreeNode seven = new TreeNode(7);
    TreeNode three = new TreeNode(3);
    TreeNode four = new TreeNode(4);
    TreeNode fifteen = new TreeNode(15);
    TreeNode thirty = new TreeNode(30);
    TreeNode seventeen = new TreeNode(17);
    ten.left = five;
    ten.right = twenty;
    five.left = three;
    three.right = four;
    twenty.left = fifteen;
    twenty.right = thirty;
    fifteen.right = seventeen;
    
    CloestInBST closest = new CloestInBST();
    
    assertEquals(20, closest.closest(ten, 20));
    assertEquals(20, closest.closest(ten, 19));
    assertEquals(15, closest.closest(ten, 16));
    assertEquals(30, closest.closest(ten, 100));
    assertEquals(3, closest.closest(three, -100));
    assertEquals(4, closest.closest(three, 4));
  }

}
