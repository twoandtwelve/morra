package nz.ac.auckland.se281;

public abstract class NonEasyAiDifficulty {

  // instance variables
  protected GameDatabase database;

  // constructor
  public NonEasyAiDifficulty(GameDatabase database) {
    this.database = database;
  }

  // method to be implemented by child difficulty classes excluding EasyAiDifficulty
  protected abstract void setStrategy();
}
