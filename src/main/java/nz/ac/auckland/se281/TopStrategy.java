package nz.ac.auckland.se281;

import java.util.ArrayList;

public class TopStrategy extends AdvancedStrategy implements Strategy {

  // constructor
  public TopStrategy(GameDatabase database) {

    super(database);
  }

  // calculates two integers, finger and sum using the top strategy and returns them as an array
  // list
  @Override
  public ArrayList<Integer> decideMove() {

    ArrayList<Integer> move = new ArrayList<Integer>();
    int randomFinger = Utils.getRandomNumber(1, 5);
    move.add(randomFinger);
    move.add(topSum(randomFinger));
    return move;
  }

  // calculates the sum the ai will play using the top strategy
  private int topSum(int randomFinger) {

    int matchCount = 0;
    int previousMatchCount = 0;
    int top = super.database.getHumanFingerList().get(0);

    // finds the most frequent number in the array list of human finger inputs
    for (int i : super.database.getHumanFingerList()) {
      for (int j : super.database.getHumanFingerList()) {
        if (i == j) {
          matchCount++;
        }
      }
      if (matchCount > previousMatchCount) {
        top = i;
        previousMatchCount = matchCount;
      }
      matchCount = 0;
    }

    int sum = randomFinger + top;

    return sum;
  }
}
