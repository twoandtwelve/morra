package nz.ac.auckland.se281;

import java.util.ArrayList;

public class AiHard extends NonEasyAiDifficulty implements AiDifficulty {

  // instance variables
  private Strategy strategy;

  // constructor
  public AiHard(GameDatabase database) {

    super(database);
    this.strategy = new RandomStrategy();
  }

  // returns an array list of two integers, finger and sum, which are calculated using the strategy
  @Override
  public ArrayList<Integer> play() {

    setStrategy();
    ArrayList<Integer> move = new ArrayList<Integer>(strategy.decideMove());
    return move;
  }

  // sets the strategy to be used by the ai
  @Override
  protected void setStrategy() {

    if (super.database.getRoundNumber() > 3) {
      this.strategy = new TopStrategy(super.database);
    }
  }
}
