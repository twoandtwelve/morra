package nz.ac.auckland.se281;

public class AiFactory {

  // creates an ai difficulty based on the difficulty passed in
  public AiDifficulty createDifficulty(Main.Difficulty difficulty, GameDatabase gameHistory) {

    // switch statement to create the correct difficulty instance
    switch (difficulty) {
      case EASY:
        return new AiEasy();
      case MEDIUM:
        return new AiMedium(gameHistory);
      case HARD:
        return new AiHard(gameHistory);
      case MASTER:
        return new AiMaster(gameHistory);
      default:
        break;
    }
    return null;
  }
}
