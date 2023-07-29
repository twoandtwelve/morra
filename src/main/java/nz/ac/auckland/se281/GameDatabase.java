package nz.ac.auckland.se281;

import java.util.ArrayList;

public class GameDatabase {

  // instance variables
  private int roundNumber;
  private boolean gameActive;
  private int pointsToWin;
  private int humanPoints;
  private int aiPoints;
  private ArrayList<Integer> humanFingerList = new ArrayList<Integer>();

  // constructor
  public GameDatabase(int pointsToWin, String[] options) {

    this.roundNumber = 1;
    this.gameActive = true;
    this.pointsToWin = pointsToWin;
    this.humanPoints = 0;
    this.aiPoints = 0;
  }

  /*****************/
  /* GET METHODS ***/
  /*****************/

  // gets list of human finger inputs
  public ArrayList<Integer> getHumanFingerList() {

    return this.humanFingerList;
  }

  // gets round number
  public int getRoundNumber() {
    return this.roundNumber;
  }

  // gets game activity
  public boolean getGameActive() {
    return this.gameActive;
  }

  // gets points to win
  public int getPointsToWin() {
    return this.pointsToWin;
  }

  // gets Ai points
  public int getAiPoints() {
    return this.aiPoints;
  }

  // gets human points
  public int getHumanPoints() {
    return this.humanPoints;
  }

  /*****************/
  /* SET METHODS ***/
  /*****************/

  // adds human finger input to array list
  public void setHumanFingers(int playerFinger) {
    this.humanFingerList.add(playerFinger);
  }

  // sets game activity to false
  public void setGameInactive() {
    this.gameActive = false;
  }

  // increments round number
  public void incrementRoundNumber() {
    this.roundNumber++;
  }

  // increments Ai points
  public void incrementAiPoints() {
    this.aiPoints++;
  }

  // increments human points
  public void incrementPlayerPoints() {
    this.humanPoints++;
  }
}
