package nz.ac.auckland.se281;

import java.util.ArrayList;

public class AiMaster extends NonEasyAiDifficulty implements AiDifficulty {

  // instance variables
  private Strategy strategy;

  // constructor
  public AiMaster(GameDatabase database) {

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

    // if the game has been played for more than 3 rounds and the number of rounds is even, use the
    // average strategy
    if ((super.database.getRoundNumber() > 3) && (super.database.getRoundNumber() % 2 == 0)) {
      this.strategy = new AverageStrategy(super.database);

      // if the game has been played for more than 3 rounds and the number of rounds is odd, use
      // the top strategy
    } else if ((super.database.getRoundNumber() > 3)
        && (super.database.getRoundNumber() % 2 == 1)) {
      this.strategy = new TopStrategy(super.database);
    }
  }
}
