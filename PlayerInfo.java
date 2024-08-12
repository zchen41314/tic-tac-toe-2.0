//importing different classes in order to utilize the different methods that are only accessible from that class
import java.util.Scanner;
import java.util.Arrays;  
import java.util.ArrayList;

//this class contains info about the player and the how much a player needs in a row to win
public class PlayerInfo {

    //creating instance variables to store the players' information
    private String playerName;              //storing the name of the player's name
    private char playerSymbol;              //storing the player's symbol
    private static int amountInARow;        //storing the amount in a row needed for the players in order to win

    //setters-mutators

    /**
     *@ sets the player's name
     *@ parameters: takes in a String variable called name
     *@ returns nothing
     */
    public void setPlayerName(String name) {
        playerName = name;
    }
    
    /**
     *@ sets the player's symbol
     *@ parameters: takes in a char variable called symbol
     *@ returns nothing
     */
    public void setPlayerSymbol(char symbol) {
        playerSymbol = symbol;
    }

    /**
     *@ sets the amount in a row needed by the players to win
     *@ parameters: takes in an int variable called amount
     *@ returns nothing
     */
    public void setAmountInARow(int amount) {
        amountInARow = amount;
    }

    //getters-accessors

    /**
     *@ gets the player's name
     *@ parameters: none
     *@ returns the name of the player
     */
    public String getPlayerName() {
        return playerName;
    }

    /**
     *@ gets the player's symbol
     *@ parameters: none
     *@ returns the symbol for the player
     */
    public char getPlayerSymbol() {
        return playerSymbol;
    }
    
    /**
     *@ gets the amount needed by the players in order to win
     *@ parameters: none
     *@ returns the amount needed by the players in order to win
     */
    public int getAmountInARow() {
        return amountInARow;
    }
}