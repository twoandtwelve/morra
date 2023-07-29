package nz.ac.auckland.se281;

import java.util.ArrayList;

public interface Strategy {

  // method to be implemented by child strategy classes
  ArrayList<Integer> decideMove();
}
