package DotComGame;

import java.io.*;
import java.util.*;

public class GameHelper {

  private static final String alphabet = "abcdefg";
  private int gridLength = 7;
  private int gridSize = 49;
  private int [] grid = new int[gridSize];
  private int comCount = 0;
  private ArrayList<String> gridAlpha = createGrid();


  public String getUserInput(String prompt) {
     String inputLine = null;
     System.out.print(prompt + "  ");
     try {
       BufferedReader is = new BufferedReader(
	 new InputStreamReader(System.in));
       inputLine = is.readLine();
       if (inputLine.length() == 0 )  return null; 
     } catch (IOException e) {
       System.out.println("IOException: " + e);
     }
      return inputLine.toLowerCase();
  }

  public boolean checkTheInput(String input){
      return gridAlpha.contains(input.toLowerCase());
  }

  private ArrayList<String> createGrid(){
      String temp;
      ArrayList<String> result = new ArrayList<>();
      for (int i = 0; i < gridLength; i++) {
          for (int j = 1; j < gridLength + 1; j++) {
              temp = String.valueOf(alphabet.charAt(i));
              result.add(temp.concat(Integer.toString(j)));
          }
      }
      return result;
  }

  
  
 public ArrayList<String> placeDotCom(int comSize) {                 // line 19
    ArrayList<String> alphaCells = new ArrayList<>();
    String [] alphacoords = new String [comSize];      // holds 'f6' type coords
    String temp;                                // temporary String for concat
    int [] coords = new int[comSize];                  // current candidate coords
    int attempts = 0;                                  // current attempts counter
    boolean success = false;                           // flag = found a good location ?
    int location;                                  // current starting location
    
    comCount++;                                        // nth dot com to place
    int incr = 1;                                      // set horizontal increment
    if ((comCount % 2) == 1) {                         // if odd dot com  (place vertically)
      incr = gridLength;                               // set vertical increment
    }

    while ( !success & attempts++ < 200 ) {             // main search loop  (32)
	location = (int) (Math.random() * gridSize);      // get random starting point
        //System.out.print(" try " + location);
	int x = 0;                                        // nth position in dotcom to place
        success = true;                                 // assume success
        while (success && x < comSize) {                // look for adjacent unused spots
          if (grid[location] == 0) {                    // if not already used
             coords[x++] = location;                    // save location
             location += incr;                          // try 'next' adjacent
             if (location >= gridSize){                 // out of bounds - 'bottom'
               success = false;                         // failure
             }
             if (location % gridLength == 0) {  // out of bounds - right edge
               success = false;                         // failure
             }
          } else {                                      // found already used location
              // System.out.print(" used " + location);
              success = false;                          // failure
          }
        }
    }                                                   // end while

    int x = 0;                                          // turn good location into alpha coords
    int row;
    int column;
    // System.out.println("\n");
    while (x < comSize) {
      grid[coords[x]] = 1;                              // mark master grid pts. as 'used'
      row = coords[x] / gridLength;             // get row value
      column = coords[x] % gridLength;                  // get numeric column value
      temp = String.valueOf(alphabet.charAt(column));   // convert to alpha
      alphaCells.add(temp.concat(Integer.toString(row)));
      x++;

      // System.out.print("  coord "+x+" = " + alphaCells.get(x-1));
      
    }
    // System.out.println("\n");
    
    return alphaCells;
   }
}