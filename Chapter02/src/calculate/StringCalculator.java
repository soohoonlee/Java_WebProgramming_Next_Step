package calculate;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringCalculator {

  int add(final String text) {
    if (isBlank(text)) {
      return 0;
    }
    return sum(toInts(split(text)));
  }

  private String[] split(final String text) {
    final Matcher matcher = Pattern.compile("//(.)\n(.*)").matcher(text);
    if (matcher.find()) {
      final String customDelimeter = matcher.group(1);
      return matcher.group(2).split(customDelimeter);
    }
    return text.split(",|:");
  }

  private boolean isBlank(final String text) {
    return text == null || text.isEmpty();
  }

  private int sum(final int[] numbers) {
    int sum = 0;
    for (final int number : numbers) {
      sum += number;
    }
    return sum;
  }

  private int[] toInts(final String[] values) {
    final int[] numbers = new int[values.length];
    for (int i = 0; i < values.length; i++) {
      numbers[i] = toPositive(values[i]);
    }
    return numbers;
  }

  private int toPositive(final String value) {
    final int number = Integer.parseInt(value);
    if (number < 0) {
      throw new RuntimeException();
    }
    return number;
  }
}
