public class GamePlatform {
  public static double getFinalSpeed(double initialSpeed, int[] inclinations) {
    for (int i : inclinations) {
      if (initialSpeed <= 0) {
        break;
      }
      initialSpeed -= i;
    }
    return Math.max(initialSpeed, 0);
  }

  public static void main(String[] args) {
    System.out.println(getFinalSpeed(60.0, new int[] { 0, -30, 0, 45, 0 })); // should print 45
    System.out.println(getFinalSpeed(60.0, new int[] { 0, -30, 0, 100, -40 })); // should print 0
  }
}
