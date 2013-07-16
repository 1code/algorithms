package algorithm.cc150.chapter18;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;

import org.junit.Test;

import algorithm.TestBase;

/**
 * Given a list of words, write a program to find the longest word made of other
 * words in the list.
 * 
 */
public class TestQuestion7 extends TestBase {

  private Question7 question;

  @Override
  protected void initInstance() {
    question = new Question7();
  }

  @Override
  @Test
  public void testPosCase() {
    String[] words1 = {"cat", "banana", "dog", "nana", "walk", "walker", "dogwalker"};
    assertEquals("dogwalker", question.longestWord(Arrays.asList(words1)));
    
    String[] words2 = {"a", "b", "c", "d", "ab", "ad", "ac", "bd", "bdc", "bcd", "abcd"};
    assertEquals("abcd", question.longestWord(Arrays.asList(words2)));
    
    String[] words3 = {"1", "2", "3", "4", "5", "6", "7", "8", "12345678", "123456789"};
    assertEquals("12345678", question.longestWord(Arrays.asList(words3)));
    
    String[] words4 = {"abddse", "bdews", "dfadsfre", "adsfasdesdik", "zzdfsiww"};
    assertEquals("", question.longestWord(Arrays.asList(words4)));
    
    String[] words5 = {"daidsfsd", "adfsdfs", "adsdfd", "daidsfsdadsdfdadfsdfs", "dfiek,cidfsd"};
    assertEquals("daidsfsdadsdfdadfsdfs", question.longestWord(Arrays.asList(words5)));
  }

  @Override
  @Test
  public void testNegCase() {
    // no negative case
  }

}
