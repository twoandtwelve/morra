package nz.ac.auckland.se281;

public abstract class AdvancedStrategy {

  // instance variables
  protected GameDatabase database;

  // constructor
  public AdvancedStrategy(GameDatabase database) {
    this.database = database;
  }
}
