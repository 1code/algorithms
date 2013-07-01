package algorithm.cc150.chapter9;

import static org.junit.Assert.assertArrayEquals;

import java.util.Arrays;

import org.junit.Test;

import algorithm.TestBase;

public class TestQuestion7 extends TestBase {

  private Question7 question;

  @Override
  protected void initInstance() {
    question = new Question7();
  }

  @Override
  @Test
  public void testPosCase() {
    char[][] screen1 = new char[][] { "rrrrrrrrrr".toCharArray(),
        "rwwwwwwwwr".toCharArray(), "rwrrwrrrwr".toCharArray(),
        "rwrrrrrrwr".toCharArray(), "rwwwrrrrwr".toCharArray(),
        "rwrwwwwwwr".toCharArray(), "rwwwrrrrrw".toCharArray(),
        "rwwrrrrrww".toCharArray(), "rwwwrrrrrr".toCharArray(),
        "rrrwwwwrrr".toCharArray() };

    char[][] result1 = new char[][] { "rrrrrrrrrr".toCharArray(),
        "rrrrrrrrrr".toCharArray(), "rrrrrrrrrr".toCharArray(),
        "rrrrrrrrrr".toCharArray(), "rrrrrrrrrr".toCharArray(),
        "rrrrrrrrrr".toCharArray(), "rrrrrrrrrr".toCharArray(),
        "rrrrrrrrrr".toCharArray(), "rrrrrrrrrr".toCharArray(),
        "rrrrrrrrrr".toCharArray() };

    char[][] copy1 = null;
    cloneArray(copy1, screen1);
    question.fill(copy1, 1, 1, 'r');
    assertArrayEquals(result1, copy1);

    char[][] result2 = new char[][] { "rrrrrrrrrr".toCharArray(),
        "rbbbbbbbbr".toCharArray(), "rbrrbrrrbr".toCharArray(),
        "rbrrrrrrbr".toCharArray(), "rbbbrrrrbr".toCharArray(),
        "rbrbbbbbbr".toCharArray(), "rbbbrrrrrb".toCharArray(),
        "rbbrrrrrbb".toCharArray(), "rbbbrrrrrr".toCharArray(),
        "rrrbbbbrrr".toCharArray() };

    char[][] copy2 = null;
    cloneArray(copy2, screen1);
    question.fill(copy2, 1, 1, 'b');
    assertArrayEquals(result2, copy2);

  }

  @Override
  @Test
  public void testNegCase() {
    // no negative cases
  }

  private static void cloneArray(char[][] dest, char[][] source) {
    if (dest == null) {
      dest = new char[source.length][source[0].length];
    }
    for (int i = 0; i < source.length; ++i) {
      dest[i] = Arrays.copyOf(source[i], source[i].length);
    }
  }

}
