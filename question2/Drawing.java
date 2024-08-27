package question2;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Drawing {
  public String[] colours;
  public String[] shapes;

  public static class Art {
    public String colour;
    public String shape;

    public Art(String colour, String shape) {
      this.colour = colour;
      this.shape = shape;
    }
  }

  public Drawing(String[] colours, String[] shapes) {
    this.colours = colours;
    this.shapes = shapes;
  }

  public List<Art> mix() {
    return Arrays.stream(colours)
        .flatMap(colour -> Arrays.stream(shapes)
            .map(shape -> new Art(colour, shape)))
        .collect(Collectors.toList());
  }

  public static void main(String[] args) {
    Drawing draw = new Drawing(new String[] {
        "red", "blue"
    }, new String[] {
        "circle"
    });
    List<Art> mixes = draw.mix();
    /*
     * Should print:
     * red, circle
     * blue, circle
     */
    for (Art art : mixes) {
      System.out.println(art.colour + ", " + art.shape);
    }
  }
}
