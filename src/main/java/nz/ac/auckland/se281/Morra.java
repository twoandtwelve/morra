package nz.ac.auckland.se281;

import nz.ac.auckland.se281.Main.Difficulty;

public class Morra {

  // instance variables
  private Human currentHuman;
  private Jarvis jarvis;
  private GameDatabase database;

  // constructor
  public Morra() {}

  /*************************/
  /**** PUBLIC METHODS *****/
  /*************************/

  public void newGame(Difficulty difficulty, int pointsToWin, String[] options) {

    // creates new instance of a game database to store all game related information
    this.database = new GameDatabase(pointsToWin, options);

    // creates new instance of a player
    this.currentHuman = new Human(database, options);

    // creates new instance of jarvis
    this.jarvis = new Jarvis(database, difficulty, "Jarvis");

    MessageCli.WELCOME_PLAYER.printMessage(currentHuman.getName());
  }

  public void play() {

    // checks if game is active and there is an instance of database class
    if (!ensureGameActive()) {
      return;
    }

    // retrieves ai's move
    jarvis.play();

    // retrieves and prints human's move
    currentHuman.play();

    // prints ai's move
    jarvis.printMove();

    // prints round result
    roundResult(
        Integer.valueOf(currentHuman.getInput().get(0)),
        Integer.valueOf(currentHuman.getInput().get(1)),
        jarvis.getInput().get(0),
        jarvis.getInput().get(1));

    // checks if either player or ai has won
    checkIfWin();

    // increments round number
    database.incrementRoundNumber();
  }

  public void showStats() {

    // checks if game is active and there is an instance of database class
    if (!ensureGameActive()) {
      return;
    }

    // prints current state of game
    printGameState();
  }

  /*************************/
  /**** PRIVATE METHODS ****/
  /*************************/

  // adds points to the round winner (if there is one) and prints round results
  private void roundResult(int humanFingers, int humanSum, int aiFingers, int aiSum) {

    String outcome;
    // player wins
    if ((humanFingers + aiFingers == humanSum) && (humanSum != aiSum)) {
      outcome = "HUMAN_WINS";
      database.incrementPlayerPoints();

      // ai wins
    } else if ((humanFingers + aiFingers == aiSum) && (humanSum != aiSum)) {
      outcome = "AI_WINS";
      database.incrementAiPoints();

      // either both player and ai wins or both lose
    } else {
      outcome = "DRAW";
    }

    MessageCli.PRINT_OUTCOME_ROUND.printMessage(outcome);
  }

  // checks if either player or ai has won the game
  private void checkIfWin() {

    String winner;
    String round;

    // player points equal to points to win, thus player wins
    if (database.getHumanPoints() == database.getPointsToWin()) {
      winner = currentHuman.getName();
      round = Integer.toString(database.getRoundNumber());
      database.setGameInactive();

      // ai points equal to points to win, thus ai wins
    } else if (database.getAiPoints() == database.getPointsToWin()) {
      winner = jarvis.getName();
      round = Integer.toString(database.getRoundNumber());
      database.setGameInactive();

      // no one wins
    } else {
      return;
    }
    MessageCli.END_GAME.printMessage(winner, round);
  }

  // ensures game is active and there is an instance of database class
  private boolean ensureGameActive() {

    // checks if game is inactive
    try {
      if (!database.getGameActive()) {
        MessageCli.GAME_NOT_STARTED.printMessage();
        return false;
      }
      // checks if there is no instance of database class
    } catch (Exception e) {
      MessageCli.GAME_NOT_STARTED.printMessage();
      return false;
    }
    return true;
  }

  // prints current state of game
  private void printGameState() {

    // player's state
    MessageCli.PRINT_PLAYER_WINS.printMessage(
        currentHuman.getName(),
        Integer.toString(database.getHumanPoints()),
        Integer.toString(database.getPointsToWin() - database.getHumanPoints()));
    // ai's state
    MessageCli.PRINT_PLAYER_WINS.printMessage(
        jarvis.getName(),
        Integer.toString(database.getAiPoints()),
        Integer.toString(database.getPointsToWin() - database.getAiPoints()));
  }
}
