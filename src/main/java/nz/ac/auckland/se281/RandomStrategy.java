package nz.ac.auckland.se281;

import java.util.ArrayList;

public class RandomStrategy implements Strategy {

  // calculates two integers, finger and sum using the random strategy and returns them as an array
  // list
  @Override
  public ArrayList<Integer> decideMove() {

    ArrayList<Integer> move = new ArrayList<Integer>();
    move.add(Utils.getRandomNumber(1, 5));
    move.add(Utils.getRandomNumber((move.get(0) + 1), (move.get(0) + 5)));
    return move;
  }
}
