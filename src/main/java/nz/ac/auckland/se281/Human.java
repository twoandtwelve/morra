package nz.ac.auckland.se281;

import java.util.ArrayList;
import java.util.Arrays;

public class Human extends Player {

  // instance variables
  private GameDatabase database;
  private ArrayList<String> humanInput;

  // constructor
  public Human(GameDatabase database, String[] options) {
    super(options[0]);
    this.database = database;
  }

  /*************************/
  /**** PUBLIC METHODS *****/
  /*************************/

  // asks for human input, checks it is valid and stores it in an array list
  @Override
  public void play() {

    // asks for human input
    MessageCli.START_ROUND.printMessage(Integer.toString(database.getRoundNumber()));
    MessageCli.ASK_INPUT.printMessage();
    String humanInput = Utils.scanner.nextLine();

    // ensures human input is correct
    while (!checkHumanInput(humanInput)) {
      MessageCli.INVALID_INPUT.printMessage();
      MessageCli.ASK_INPUT.printMessage();
      humanInput = Utils.scanner.nextLine();
    }

    // stores human input in an array list
    this.humanInput = listHumanInput(humanInput);
    MessageCli.PRINT_INFO_HAND.printMessage(
        this.name, this.humanInput.get(0), this.humanInput.get(1));

    // updates game database's humanFingerList by adding the current round's human finger input
    database.setHumanFingers(Integer.parseInt(this.humanInput.get(0)));
  }

  // gets current human input
  public ArrayList<String> getInput() {
    return this.humanInput;
  }

  /*************************/
  /**** PRIVATE METHODS ****/
  /*************************/

  // checks human input is valid
  private boolean checkHumanInput(String humanInput) {

    ArrayList<String> inputList = listHumanInput(humanInput);

    // ensure input is an integer
    for (String input : inputList) {
      if (!Utils.isInteger(input)) {
        return false;
      }
    }

    // ensure inputList contains 2 integers and that they are positive
    if ((inputList.size() != 2)
        || (Integer.parseInt(inputList.get(0)) < 0)
        || (Integer.parseInt(inputList.get(1)) < 0)) {
      return false;
    }

    // ensure the first integer is between 1 and 5 and the second integer is between 1 and 10 (both
    // inclusive)
    if ((Integer.parseInt(inputList.get(0)) >= 1)
        && (Integer.parseInt(inputList.get(0)) <= 5)
        && (Integer.parseInt(inputList.get(1)) >= 1)
        && (Integer.parseInt(inputList.get(1)) <= 10)) {
      return true;
    }
    return false;
  }

  // stores human input in an array list
  private ArrayList<String> listHumanInput(String humanInput) {

    String[] inputString = humanInput.split(" ");
    ArrayList<String> inputList = new ArrayList<String>(Arrays.asList(inputString));

    return inputList;
  }
}
