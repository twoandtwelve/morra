package nz.ac.auckland.se281;

public abstract class Player {

  // instance variables
  protected String name;

  // constructor
  public Player(String name) {
    this.name = name;
  }

  // methods
  public void play() {}

  // gets name of either player
  public String getName() {
    return this.name;
  }
}
