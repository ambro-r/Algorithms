package objects;

import lombok.Getter;
import lombok.Setter;

public class Range {

  @Getter @Setter
  private int min;

  @Getter @Setter
  private int max;

  @Getter @Setter
  private String variable;

  public Range(String variable, int min, int max) {
    this.variable = variable;
    this.min = min;
    this.max = max;
  }

  @Override
  public String toString() {
    return String.format("%s[%d,%d]",variable,min,max);
  }

}
