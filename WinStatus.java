//importing different classes in order to utilize the different methods that are only accessible from that class
import java.util.Scanner;
import java.util.Arrays;  
import java.util.ArrayList;


//this class contains a method to check if a player has won or not
//and it also checks if the board is full of moves or not
public class WinStatus {
    
    /**
     *@ checks if a player has won the game or not
     *@ parameters: takes in a char array called board, a char called symbol, an int called playerAmount, and an int called amountInARow
     *@ returns true if a player has won and false if not
     */
    public static boolean hasWon(char[] board, char symbol, int playerAmount, int amountInARow) {
        int lengthOfBoard = playerAmount + 1;   //creating and initializing a variable that stores the amount of columns of the board
        int rowOfboard = playerAmount + 1;      //creating and initializing a variable that stores the amount of rows of the board
        int amountInARowCounter = 0;            //creating and initializing a variable that keeps track of how many symbols are found in a row
        int maxDiagonal;                        //creating a variable that keeps track of the lengths of the different diagonals on the board
        int boardTracker = 0;                   //creating and initializing a variable that keeps track of which board position that is being checked
        
        //checking for horizontal wins
        for(int i = 0; i < rowOfboard; i++) {
            for(int j = 0; j < lengthOfBoard; j++) {
                
                //checking to see if the program is checking the first position of the board
                if(boardTracker == 0) {

                    //checking to see if the position has the player's symbol and checking if the next horizontal position has the symbol
                    if(board[boardTracker] == symbol && board[boardTracker + 1] == symbol) {

                        //adding one to the variable that keeps track of the how many symbols are in a row if the positions have the symbol
                        amountInARowCounter = amountInARowCounter + 1;
                    }

                    //setting the variable that keeps track of the how many symbols are in a row to 0 if the position does not have a symbol
                    else {
                        amountInARowCounter = 0;
                    }
                }

                //checking to see if the program is checking the last position of the board
                else if(boardTracker == (lengthOfBoard * rowOfboard) - 1) {

                    //checking to see if the position has the player's symbol and checking if the previous horizontal position has the symbol
                    if(board[boardTracker] == symbol && board[boardTracker - 1] == symbol) {

                        //adding one to the variable that keeps track of the how many symbols are in a row if the positions have the symbol
                        amountInARowCounter = amountInARowCounter + 1;
                    }

                    //setting the variable that keeps track of the how many symbols are in a row to 0 if the position does not have a symbol
                    else {
                        amountInARowCounter = 0;
                    }
                }

                else {

                    //checking to see if the position has the player's symbol and checking if the next horizontal position has the symbol or if the previous horizontal 
                    //position has the symbol
                    if((board[boardTracker] == symbol && board[boardTracker - 1] == symbol) || (board[boardTracker] == symbol && board[boardTracker + 1] == symbol)) {
                        
                        //adding one to the variable that keeps track of the how many symbols are in a row if the positions have the symbol
                        amountInARowCounter = amountInARowCounter + 1;
                    }

                    //setting the variable that keeps track of the how many symbols are in a row to 0 if the position does not have a symbol
                    else {
                        amountInARowCounter = 0;
                    }
                }

                //checking if the amount of symbols found in a row is equal to the amount of symbols needed for winning
                if(amountInARowCounter == amountInARow) {

                    //returns true if it is
                    return true;
                }

                //incrementing the boardTracker to the next horizontal position
                boardTracker = boardTracker + 1;
            }

            //resetting the amount of symbols found in a row when checking a new row
            amountInARowCounter = 0;
        }

        //resetting the position of the board before checking another way of winning
        boardTracker = 0;

        //checking for vertical wins
        for(int i = 0; i < rowOfboard; i++) {
            for(int j = 0; j < lengthOfBoard; j++) {
                
                //checking to see if the program is checking the first position of the board
                if(boardTracker + i == 0) {
                    
                    //checking to see if the position has the player's symbol and if the next vertical position has the symbol
                    if(board[boardTracker + i] == symbol && board[boardTracker + i + playerAmount + 1] == symbol) {

                        //adding one to the variable that keeps track of the how many symbols are in a row if the positions have the symbol
                        amountInARowCounter = amountInARowCounter + 1;
                    }
                    
                    //setting the variable that keeps track of the how many symbols are in a row to 0 if the position does not have a symbol
                    else {
                        amountInARowCounter = 0;
                    }
                }

                //checking to see if the program is checking the last position of the board
                else if(boardTracker + i == (lengthOfBoard * rowOfboard) - 1) {

                    //checking to see if the position has the player's symbol and if the previous vertical position has the symbol
                    if(board[boardTracker + i] == symbol && board[boardTracker + i - playerAmount - 1] == symbol) {

                        //adding one to the variable that keeps track of the how many symbols are in a row if the positions have the symbol
                        amountInARowCounter = amountInARowCounter + 1;
                    }

                    //setting the variable that keeps track of the how many symbols are in a row to 0 if the position does not have a symbol
                    else {
                        amountInARowCounter = 0;
                    }
                }

                //checking to see if the program is checking the first row of the board
                else if(boardTracker + i <= playerAmount) {

                    //checking to see if the position has the player's symbol and if the next vertical position has the symbol
                    if(board[boardTracker + i] == symbol && board[boardTracker + i + playerAmount + 1] == symbol) {

                        //adding one to the variable that keeps track of the how many symbols are in a row if the positions have the symbol
                        amountInARowCounter = amountInARowCounter + 1;
                    }

                    //setting the variable that keeps track of the how many symbols are in a row to 0 if the position does not have a symbol
                    else {
                        amountInARowCounter = 0;
                    }
                }

                //checking to see if the program is checking the last row of the board
                else if(boardTracker + i >= playerAmount * (playerAmount + 1)) {

                    //checking to see if the position has the player's symbol and if the previous vertical position has the symbol
                    if(board[boardTracker + i] == symbol && board[boardTracker + i - playerAmount - 1] == symbol) {

                        //adding one to the variable that keeps track of the how many symbols are in a row if the positions have the symbol
                        amountInARowCounter = amountInARowCounter + 1;
                    }

                    //setting the variable that keeps track of the how many symbols are in a row to 0 if the position does not have a symbol
                    else {
                        amountInARowCounter = 0;
                    }
                }

                
                else {

                    //checking to see if the position has the player's symbol and if the next vertical position has the symbol or if the previous 
                    //vertical position has the symbol
                    if((board[boardTracker + i] == symbol && board[boardTracker + i - playerAmount - 1] == symbol) || (board[boardTracker + i] == symbol && board[boardTracker + i + playerAmount + 1] == symbol)) {
                        
                        //adding one to the variable that keeps track of the how many symbols are in a row if the positions have the symbol
                        amountInARowCounter = amountInARowCounter + 1;
                    }

                    //setting the variable that keeps track of the how many symbols are in a row to 0 if the position does not have a symbol
                    else {
                        amountInARowCounter = 0;
                    }
                }

                //checking if the amount of symbols found in a row is equal to the amount of symbols needed for winning
                if(amountInARowCounter == amountInARow) {

                    //returns true if it is
                    return true;
                }

                //incrementing the position of the board to the next vertical position
                boardTracker = boardTracker + playerAmount + 1;
            }
            
            //resetting the board position to 0 after checking an entire column
            boardTracker = 0;

            //resetting the amount of symbols found in a row after checking an entire column
            amountInARowCounter = 0;
        }
        
        //resetting the position of the board before checking another way of winning
        boardTracker = 0;

        //checking for backward diagonal wins
        for(int i = 0; i < rowOfboard; i++) {
            for(int j = 0; j < lengthOfBoard; j++) {

                //settting the position of the board to the proper starting position for each row
                boardTracker = i * (playerAmount + 1);

                //checking to see if the program is checking the first row
                if(i == 0) {

                    //setting the diagonal to the appropriate length if it is
                    maxDiagonal = playerAmount + 1 - j;
                }
                
                //checking to see if the row is an even number 
                //and that the number of the column the program is at is less than the row the program is at
                else if((i + 1) % 2 == 0 && (j <= i)) {

                    ////setting the diagonal to the appropriate length if it is
                    maxDiagonal = playerAmount;
                }

                //setting the diagonal to the appropriate length 
                else {
                    maxDiagonal = playerAmount + 1 - i - j;
                }

                //used to through each diagonal position
                for(int k = 0; k < maxDiagonal; k++) {
                    
                    //checking to see if position of the board is greater than the amount of positions on the board
                    if(boardTracker > (lengthOfBoard * rowOfboard) - 1) {
                        
                        //setting the amount of symbols found in a row to 0 if it is
                        amountInARowCounter = 0;

                        //skipping this iteration of the loop
                        continue;
                    }
                    
                    //checking to see if the program is checking the first position of the board
                    if(boardTracker + j == 0) {
                        
                        //checking if that position has the player's symbol and if the next diagonal position has the symbol
                        if(board[boardTracker + j] == symbol && board[boardTracker + j + playerAmount + 2] == symbol) {
                            
                            //adding one to the variable that keeps track of the how many symbols are in a row if the positions have the symbol
                            amountInARowCounter = amountInARowCounter + 1;
                        }

                        //setting the variable that keeps track of the how many symbols are in a row to 0 if the position does not have a symbol
                        else {
                            amountInARowCounter = 0;
                        }
                    }

                    //checking to see if the program is checking the last position of the board
                    else if(boardTracker + j == (lengthOfBoard * rowOfboard) - 1) {

                        //checking if that position has the player's symbol and if the previous diagonal position has the symbol if it is
                        if(board[boardTracker + j] == symbol && board[boardTracker + j - playerAmount - 2] == symbol) {
                            
                            //adding one to the variable that keeps track of the how many symbols are in a row if the positions have the symbol
                            amountInARowCounter = amountInARowCounter + 1;
                        }

                        //setting the variable that keeps track of the how many symbols are in a row to 0 if the position does not have a symbol
                        else {
                            amountInARowCounter = 0;
                        }
                    }

                    //checking if the next diagonal position exceeds the total positions there are
                    else if(boardTracker + j + playerAmount + 2 > (lengthOfBoard * rowOfboard) - 1) {

                        //checking if that position has the player's symbol and if the previous diagonal position has the symbol if it is
                        if(board[boardTracker + j] == symbol && board[boardTracker + j - playerAmount - 2] == symbol) {
                            
                            //adding one to the variable that keeps track of the how many symbols are in a row if the positions have the symbol
                            amountInARowCounter = amountInARowCounter + 1;
                        }

                        //setting the variable that keeps track of the how many symbols are in a row to 0 if the position does not have a symbol
                        else {
                            amountInARowCounter = 0;
                        }
                    }

                    //checking if the starting positions are in the first row
                    else if(boardTracker + j - playerAmount - 2 < playerAmount + 1) {

                        //checking if that position has the player's symbol and if the next diagonal position has the symbol if it is
                        if(board[boardTracker + j] == symbol && board[boardTracker + j + playerAmount + 2] == symbol) {
                            
                            //adding one to the variable that keeps track of the how many symbols are in a row if the positions have the symbol
                            amountInARowCounter = amountInARowCounter + 1;
                        }

                        //setting the variable that keeps track of the how many symbols are in a row to 0 if the position does not have a symbol
                        else {
                            amountInARowCounter = 0;
                        }
                    }

                    else {
                        //checking if that position has the player's symbol and if the next diagonal position has the symbol or if the previous diagonal position has the symbol
                        if((board[boardTracker + j] == symbol && board[boardTracker + j + playerAmount + 2] == symbol) || (board[boardTracker + j] == symbol && board[boardTracker + j - playerAmount - 2] == symbol)) {
                            
                            //adding one to the variable that keeps track of the how many symbols are in a row if the positions have the symbol
                            amountInARowCounter = amountInARowCounter + 1;
                        }

                        //setting the variable that keeps track of the how many symbols are in a row to 0 if the position does not have a symbol
                        else {
                            amountInARowCounter = 0;
                        }
                    }

                    //checking if the amount of symbols found in a row is equal to the amount of symbols needed for winning
                    if(amountInARowCounter == amountInARow) {

                        //returns true if it is
                        return true;
                    }

                    //incrementing the position to the next diagonal position
                    boardTracker = boardTracker + playerAmount + 2;

                }

                //setting the position to 0 after checking a diagonal
                boardTracker = 0;

                //resetting the amount of symbols found in a row when checking a diagonal
                amountInARowCounter = 0;
            }
        }

        //resetting the position of the board before checking another way of winning
        boardTracker = 0;

        //checking forward facing diagonal
        for(int i = 0; i < rowOfboard; i++) {
            for(int j = 0; j < lengthOfBoard; j++) {
                
                //checking if the starting row and column is the first of the board
                if(i == 0 && j == 0) {

                    //setting the board position to the last position of the first row if it is
                    boardTracker = playerAmount;
                }

                else {
                    //setting the board position to the next last position of the next row
                    boardTracker = (i + 1) * playerAmount + i;
                }
                
                //checking to see if the row number is even and that the column number is less than or equal to the row number
                if((i + 1) % 2 == 0 && (j <= i)) {
                    
                    //setting the diagonal length to the appropriate length for the case
                    maxDiagonal = playerAmount - j;
                }

                else {
                    
                    //setting the diagonal length to the appropriate length
                    maxDiagonal = playerAmount + 1 - i - j;
                }

                //iterating through the diagonals
                for(int k = 0; k < maxDiagonal; k++) {
                    
                    //checking to see if position of the board is greater than the amount of positions on the board
                    if(boardTracker - j > (lengthOfBoard * rowOfboard) - 1) {

                        //setting the amount of symbols found in a row to 0
                        amountInARowCounter = 0;

                        //skipping this iteration
                        continue;
                    }

                    //checking to see if the position of the board is at last position of the first row
                    if(boardTracker - j == playerAmount) {

                        //checking if that position has the player's symbol and if the next diagonal position has the symbol if it is
                        if(board[boardTracker - j] == symbol && board[boardTracker + playerAmount - j] == symbol) {
                            
                            //adding one to the variable that keeps track of the how many symbols are in a row if the positions have the symbol
                            amountInARowCounter = amountInARowCounter + 1;
                        }

                        //setting the variable that keeps track of the how many symbols are in a row to 0 if the position does not have a symbol
                        else {
                            amountInARowCounter = 0;
                        }
                    } 
                    
                    //checking to see if the position of the board is at the first position of the last row
                    else if(boardTracker - j == playerAmount * rowOfboard) {

                        //checking if that position has the player's symbol and if the previous diagonal position has the symbol if it is
                        if(board[boardTracker - j] == symbol && board[boardTracker - j - playerAmount] == symbol) {
                            
                            //adding one to the variable that keeps track of the how many symbols are in a row if the positions have the symbol
                            amountInARowCounter = amountInARowCounter + 1;
                        }

                        //setting the variable that keeps track of the how many symbols are in a row to 0 if the position does not have a symbol
                        else {
                            amountInARowCounter = 0;
                        }
                    }

                    //checking to see if the next diaognal exceeds the amount of positions of the board
                    else if(boardTracker + playerAmount - j > (lengthOfBoard * rowOfboard) - 1) {

                        //checking if that position has the player's symbol and if the preevious diagonal position has the symbol if it is
                        if(board[boardTracker - j] == symbol && board[boardTracker - j - playerAmount] == symbol) {
                            
                            //adding one to the variable that keeps track of the how many symbols are in a row if the positions have the symbol
                            amountInARowCounter = amountInARowCounter + 1;
                        }

                        //setting the variable that keeps track of the how many symbols are in a row to 0 if the position does not have a symbol
                        else {
                            amountInARowCounter = 0;
                        }
                    }

                    //checking to see if the position of the board is in the first row
                    else if(boardTracker - j - playerAmount < playerAmount + 1) {

                        //checking if that position has the player's symbol and if the next diagonal position has the symbol if it is
                        if(board[boardTracker - j] == symbol && board[boardTracker + playerAmount - j] == symbol) {
                            
                            //adding one to the variable that keeps track of the how many symbols are in a row if the positions have the symbol
                            amountInARowCounter = amountInARowCounter + 1;
                        }

                        //setting the variable that keeps track of the how many symbols are in a row to 0 if the position does not have a symbol
                        else {
                            amountInARowCounter = 0;
                        }
                    }

                    else {

                        //checking if that position has the player's symbol and if the next diagonal position has the symbol if it is or if the previous diagonal position has the symbol
                        if((board[boardTracker - j] == symbol && board[boardTracker + playerAmount - j] == symbol) || (board[boardTracker - j] == symbol && board[boardTracker - j - playerAmount] == symbol)) {
                            amountInARowCounter = amountInARowCounter + 1;
                        }

                        //setting the variable that keeps track of the how many symbols are in a row to 0 if the position does not have a symbol
                        else {
                            amountInARowCounter = 0;
                        }
                    }

                    //checking if the amount of symbols found in a row is equal to the amount of symbols needed for winning
                    if(amountInARowCounter == amountInARow) {

                        //returns true if it is
                        return true;
                    }

                    //incrementing the position to the next diagonal position
                    boardTracker = boardTracker + playerAmount;
                }

                //setting the position back to 0 after checking a diagonal
                boardTracker = 0;

                //resetting the amount of symbols found in a row when checking a diagonal
                amountInARowCounter = 0;
            }
        }

        //returns false if it fails all those checks for wins
        return false;
    }

    /**
     *@ checks if the board is full of players' move
     *@ parameters: takes in a String array called boardAvailablePositions and an int called boardSize
     *@ returns true if the second array is a subset of the first, false otherwise
     */
    public static boolean isBoardFull(String[] boardAvailablePositions, int boardSize) {
        int counter = 0;    //creating and initializing a variable to keep track of how many positions have been taken up

        //iterating through the array 
        for(int i = 0; i < boardSize; i++) {

            //checking if the symbol at the position is an asterisk.
            //the asterisk means it has been taken up
            if(boardAvailablePositions[i].equals("*")) {

                //adding one to the counter if it is
                counter = counter + 1;
            }
        }

        //checking to see if the total positions used by the players is equal to the total positions of the board
        if(counter == boardSize) {

            //returning true if it is
            return true;
        }

        //returning ffalse otherwise
        return false;
    }
}