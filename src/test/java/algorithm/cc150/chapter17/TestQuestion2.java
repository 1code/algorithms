package algorithm.cc150.chapter17;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import algorithm.TestBase;

/**
 * Design an algorithm to figure out if someone has won a game of tic-tac-toe.
 * The input is a NxN board with type char[][], where '.' denotes the slot that
 * has not been occupied, '+' denotes the slot that is occupied by player 1, and
 * '-' denotes the slot that is occupied by player 2.
 * 
 */
public class TestQuestion2 extends TestBase {

  private Question2 question;

  @Override
  protected void initInstance() {
    question = new Question2();
  }

  @Override
  @Test
  public void testPosCase() {
    char[][] board = new char[][] { 
        { '.', '.', '.', '+' },
        { '.', '.', '+', '-' }, 
        { '-', '+', '.', '-' }, 
        { '+', '-', '.', '.' } };
    assertTrue(question.won(board));

    char[][] board2 = new char[][] { 
        { '.', '.', '.', '+', '-' },
        { '.', '.', '+', '.', '-' }, 
        { '-', '+', '.', '.', '-' }, 
        { '+', '-', '.', '.', '-' },
        { '+', '.', '.', '.', '-' }};
    assertTrue(question.won(board2));
    
    char[][] board3 = new char[][] {
        { '+', '.', '.', '.', '-', '.' },
        { '.', '+', '.', '-', '.', '.' }, 
        { '-', '.', '+', '.', '-', '.' }, 
        { '+', '-', '.', '+', '-', '.' },
        { '+', '.', '.', '-', '+', '.' } ,
        { '.', '.', '.', '-', '.', '+'}
    };
    assertTrue(question.won(board3));
  }

  @Override
  @Test
  public void testNegCase() {
    char[][] board = new char[][] { 
        { '.', '.', '.', '+' },
        { '.', '.', '+', '-' }, 
        { '-', '+', '.', '-' }, 
        { '.', '-', '+', '.' } };
    assertFalse(question.won(board));
    
    char[][] board2 = new char[][] { 
        { '.', '.', '.', '+', '-' },
        { '.', '.', '+', '.', '-' }, 
        { '-', '+', '.', '.', '-' }, 
        { '+', '-', '.', '.', '-' },
        { '+', '.', '.', '-', '.' }};
    assertFalse(question.won(board2));
    
    char[][] board3 = new char[][] {
        { '+', '.', '.', '.', '-', '.' },
        { '.', '+', '.', '-', '.', '.' }, 
        { '-', '.', '+', '.', '-', '.' }, 
        { '+', '-', '.', '+', '-', '.' },
        { '+', '.', '.', '-', '+', '.' } ,
        { '.', '.', '.', '-', '+', '.'}
    };
    assertFalse(question.won(board3));
  }

}
