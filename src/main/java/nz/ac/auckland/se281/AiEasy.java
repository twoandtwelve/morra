package nz.ac.auckland.se281;

import java.util.ArrayList;

public class AiEasy implements AiDifficulty {

  // instance variables
  private Strategy strategy;

  // constructor
  public AiEasy() {
    this.strategy = new RandomStrategy();
  }

  // returns an array list of two integers, finger and sum, which are calculated using the strategy
  @Override
  public ArrayList<Integer> play() {

    ArrayList<Integer> move = new ArrayList<Integer>(strategy.decideMove());
    return move;
  }
}
