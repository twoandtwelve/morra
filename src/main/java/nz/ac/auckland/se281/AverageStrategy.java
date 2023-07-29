package nz.ac.auckland.se281;

import java.util.ArrayList;

public class AverageStrategy extends AdvancedStrategy implements Strategy {

  // constructor
  public AverageStrategy(GameDatabase database) {

    super(database);
  }

  // calculates two integers, finger and sum using the average strategy and returns them as an array
  // list
  @Override
  public ArrayList<Integer> decideMove() {

    ArrayList<Integer> move = new ArrayList<Integer>();
    int randomFinger = Utils.getRandomNumber(1, 5);
    move.add(randomFinger);
    move.add(averageSum(randomFinger));
    return move;
  }

  // determines the ai's sum by calculating the average of the sum of the human's previous fingers
  private int averageSum(int randomFinger) {

    int humanFingersSum = 0;

    // calculates the sum of the human's previous fingers
    for (int i : super.database.getHumanFingerList()) {
      humanFingersSum += i;
    }

    // calculates the average of the sum of the human's previous fingers
    int sum =
        (int)
            (randomFinger
                + Math.round(
                    (double) humanFingersSum / super.database.getHumanFingerList().size()));

    return sum;
  }
}
