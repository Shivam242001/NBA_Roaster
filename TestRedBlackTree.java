// --== CS400 File Header Information ==--
// Name: Aayush Ritesh Dani
// Email: ardani@wisc.edu
// Team: Red Team
// Group: EF
// TA: Yelun Bao
// Lecturer: Florian Heimerl
// Notes to Grader: None

import org.junit.Test;
import static org.junit.Assert.*;

/**
 * The TestRedBlackTree class defines the methods that test the implementation
 * of the RedBlackTree class.
 * 
 * @author aayush dani
 */
public class TestRedBlackTree {

  /**
   * This method tests the insertion of a root node, verifies that the value is
   * correctly stored, and its color meets the Root Property of a Red Black Tree.
   */
  @Test
  public void testInsertionOfRootNode() {

    // initializes Red Black Tree
    RedBlackTree<Integer> tree = new RedBlackTree<Integer>();

    // inserts node with root as 6
    tree.insert(6);

    // verifies that root value and root property are met
    assertEquals((Integer) 6, (Integer) tree.root.data);
    assertEquals(true, tree.root.isBlack);
  }

  /**
   * This method tests the left rotation of our Red Black Tree, and verifies that
   * the tree maintains its properties post rotation.
   */
  @Test
  public void testLeftRotation() {

    // initializes Red Black Tree
    RedBlackTree<Integer> tree = new RedBlackTree<Integer>();

    // insert values that force a left rotation to maintain RBT properties
    tree.insert(6);
    tree.insert(9);
    tree.insert(12);

    // verifies that the right rotation has correctly occurred
    assertEquals("Expected Output: [9, 6, 12]\nActual Output: " + tree.root.toString(), "[9, 6, 12]",
        tree.root.toString());

    // insert values that force another right rotation to maintain RBT properties
    tree.insert(14);
    tree.insert(18);

    // verifies that the right rotation has correctly occurred
    assertEquals("Expected Output: [9, 6, 14, 12, 18]\nActual Output: " + tree.root.toString(), "[9, 6, 14, 12, 18]",
        tree.root.toString());
  }

  /**
   * This method tests the right rotation of our Red Black Tree, and verifies that
   * the tree maintains its properties post rotation.
   */
  @Test
  public void testRightRotation() {

    // initializes Red Black Tree
    RedBlackTree<Integer> tree = new RedBlackTree<Integer>();

    // insert values that force a right rotation to maintain RBT properties
    tree.insert(8);
    tree.insert(6);
    tree.insert(4);

    // verifies that the right rotation has correctly occurred
    assertEquals("Expected Output: [6, 4, 8]\nActual Output: " + tree.root.toString(), "[6, 4, 8]",
        tree.root.toString());

    // insert values that force another right rotation to maintain RBT properties
    tree.insert(3);
    tree.insert(2);

    // verifies that the right rotation has correctly occurred
    assertEquals("Expected Output: [6, 3, 8, 2, 4]\nActual Output: " + tree.root.toString(), "[6, 3, 8, 2, 4]",
        tree.root.toString());
  }

  /**
   * This method tests the recursive color swap up the RBT, and verifies that the
   * tree maintains its properties post recursive process..
   */
  @Test
  public void testRecursiveColorSwap() {

    // initializes Red Black Tree
    RedBlackTree<Integer> tree = new RedBlackTree<Integer>();

    // insert values that force a recursive color swap up the RBT to maintain its
    // properties
    tree.insert(8);
    tree.insert(4);
    tree.insert(12);
    tree.insert(6);

    // verifies that the recursive color swap has correctly occurred
    assertEquals("Expected Output: [8, 4, 12, 6]\nActual Output: " + tree.root.toString(), "[8, 4, 12, 6]",
        tree.root.toString());

    // insert values that force another recursive color swap up the RBT to maintain
    // its properties
    tree.insert(3);
    tree.insert(1);

    // verifies that the recursive color swap has correctly occurred
    assertEquals("Expected Output: [8, 4, 12, 3, 6, 1]\nActual Output: " + tree.root.toString(), "[8, 4, 12, 3, 6, 1]",
        tree.root.toString());
  }
}
