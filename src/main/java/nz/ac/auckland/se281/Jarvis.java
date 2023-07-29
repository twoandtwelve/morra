package nz.ac.auckland.se281;

import java.util.ArrayList;
import nz.ac.auckland.se281.Main.Difficulty;

public class Jarvis extends Player {

  // instance variables
  private AiDifficulty currentAiDifficulty;
  private ArrayList<Integer> aiInput;
  private AiFactory aiFactory = new AiFactory();

  // constructor
  public Jarvis(GameDatabase database, Difficulty difficulty, String name) {

    super(name);

    // creates new instance of an ai with the specified difficulty
    this.currentAiDifficulty = aiFactory.createDifficulty(difficulty, database);
  }

  /*************************/
  /**** PUBLIC METHODS *****/
  /*************************/

  // decides ai's move
  @Override
  public void play() {

    this.aiInput = new ArrayList<Integer>(currentAiDifficulty.play());
  }

  // prints ai's move
  public void printMove() {

    MessageCli.PRINT_INFO_HAND.printMessage(
        name, Integer.toString(this.aiInput.get(0)), Integer.toString(this.aiInput.get(1)));
  }

  // gets ai's input
  public ArrayList<Integer> getInput() {
    return this.aiInput;
  }
}
