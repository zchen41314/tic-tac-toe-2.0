//importing different classes in order to utilize the different methods that are only accessible from that class
import java.util.Scanner;
import java.util.Arrays;  
import java.util.ArrayList;


//this class has methods that check whether or not the players' inputs are valid
public class InputValidation {
    
    /**
     *@ checks if a player's input is a number or not
     *@ parameters: takes in a String variable called input
     *@ returns true if it is a number and false if not
     */
    public static boolean isNumber(String input) {

        //converts the input to a number
        try {

            //returns true if it worked
            Integer.parseInt(input);
            return true;
        }

        //returns false if it did not work
        catch(Exception E) {
            return false;
        }
    }

    /**
     *@ checks if a player's input is a valid number of players 
     *@ parameters: takes in a String variable called input
     *@ returns true if it is valid and false if not
     */
    public static boolean isValidNumberOfPlayers(String input) {

        //converting the input into a number
        int number = Integer.parseInt(input);

        //checking to see if the number is less than 3 or greater than 10
        if(number < 3 || number > 10) {

            //returns false if it is
            return false;
        }
        
        //returns true otherwise
        return true;
    }

    /**
     *@ checks if a player's input is a valid number of symbols in a row needed to win
     *@ parameters: takes in a String variable called input and an int called playerAmount
     *@ returns true if it is valid and false if not
     */
    public static boolean isValidAmountInARow(String input, int playerAmount) {

        //converting the input to a number
        int number = Integer.parseInt(input);

        //checking if the number is less than 3 or greater than the player amount + 1
        if(number < 3 || number > (playerAmount + 1)) {
            
            //returning false if it is
            return false;
        }

        //returing true otherwise
        return true;
    }

    /**
     *@ checks if a player's input is a valid symbol
     *@ parameters: takes in a char variable called symbol, an PlayerInfo object called players, and an int called playerAmount
     *@ returns true if it is valid and false if not
     */
    public static boolean isValidSymbol(char symbol, PlayerInfo[] players, int playerAmount) {

        //checking to see if the player's symbol is '*'
        if(symbol == '*') {

            //returning false if it is
            return false;
        }

        //checking to see if any other player has chosen that symbol
        for(int i = 0; i < playerAmount; i++) {
            
            //checking to see if the a player has already chosen the other player's symbol
            if(players[i].getPlayerSymbol() == symbol) {

                //returning false if it is
                return false;
            }
        }

        //returing true if it is
        return true;
    }

    /**
     *@ checks if a player's input is a valid position on the board
     *@ parameters: takes in a String variable called input, an int called boardSize, a String array called availablePositions
     *@ returns true if it is valid and false if not
     */
    public static boolean isValidPosition(String input, int boardSize, String[] availablePositions) {

        //converting the input to a number
        int position = Integer.parseInt(input);

        //checking to see if they entered a position that is less than one or greater than the board's size
        if(position < 1 || position > boardSize) {

            //returning false if it is
            return false;
        }

        //checking to see if the position is already taken
        if(availablePositions[position - 1] == "*") {

            //returning false if it is
            return false;
        }

        //returning true otherwise
        return true;
    }
}