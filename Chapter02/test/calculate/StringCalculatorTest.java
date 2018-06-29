package calculate;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class StringCalculatorTest {

  private StringCalculator calculator;

  @Before
  public void setUp() throws Exception {
    calculator = new StringCalculator();
  }

  @Test
  public void add_null_또는_빈문자() {
    assertEquals(0, calculator.add(null));
    assertEquals(0, calculator.add(""));
  }

  @Test
  public void add_숫자하나() {
    assertEquals(1, calculator.add("1"));
  }

  @Test
  public void add_쉼표구분자() {
    assertEquals(3, calculator.add("1,2"));
  }

  @Test
  public void add_쉼표_또는_콜론_구분자() {
    assertEquals(6, calculator.add("1,2:3"));
  }

  @Test
  public void add_custom_구분자() {
    assertEquals(6, calculator.add("//;\n1;2;3"));
  }

  @Test(expected = RuntimeException.class)
  public void add_negative() {
    calculator.add("-1, 2, 3");
  }
}