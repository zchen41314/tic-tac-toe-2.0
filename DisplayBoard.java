//importing different classes in order to utilize the different methods that are only accessible from that class
import java.util.Scanner;
import java.util.Arrays;  
import java.util.ArrayList;

//this class contains methods to display the TicTacToe board
public class DisplayBoard {


    /**
     *@ prints the starting board of the TicTacToe game
     *@ parameters: takes in two int variables called boardSize and playerAmount
     *@ returns nothing
     */
    public static void printStartingBoard(int boardSize, int playerAmount) {
        int lengthOfBoard = (playerAmount + 1) * 5 + playerAmount;  //creating and initializing a variable to store the length of the board
        int rowOfboard = playerAmount * 2 + 1;                      //creating and initializing a variable to store the width of the board
        
        //printing out the a message indicating that this is the initial board
        System.out.println("This is the initial board for the TicTacToe2.0 game");
        System.out.println();

        //using two for loops to iterate through the length and the width of the board
        for(int i = 1; i <= rowOfboard; i++) {
            for(int j = 1; j <= lengthOfBoard; j++) {
                
                //checking to see if the width is an even number and not 1
                if(i != 1 && i % 2 == 0) {

                    //checking to see if the length is a factor of 6 and not 1 of it is
                    if(j != 1 && j % 6 == 0) {

                        //printing out the proper board piece if it is
                        System.out.print("|");
                    }

                    else {

                        //printing out the proper board piece if it is not
                        System.out.print("-");
                    }
                }

                else {

                    //checking to see if the length of the board is a factor of 3 and not a factor of 6
                    if(j % 3 == 0 && j % 6 != 0) {

                        //printing out the proper board piece if it is
                        System.out.print("*");
                    }

                    //checking to see if the length of the board is a factor of 6
                    else if(j % 6 == 0) {

                        //printing out the proper board piece if it is
                        System.out.print("|");
                    }

                    else {

                        //printing out the proper board piece if it is not
                        System.out.print(" ");
                    }
                }
            }

            System.out.println();
        }

        System.out.println();
        System.out.println();
    }

    /**
     *@ prints the board with the players' moves
     *@ parameters: takes in two int variables called boardSize and playerAmount, and a char array called board
     *@ returns nothing
     */
    public static void printCurrentBoard(int boardSize, int playerAmount, char[] board) {
        int boardPosition = 0;                                          //creating and initializing a variable to 0 for the first position of the board
        int lengthOfBoard = (playerAmount + 1) * 5 + playerAmount;      //creating and initializing a variable for the length of the board
        int rowOfboard = playerAmount * 2 + 1;                          //creating and initializing a variable for the rows of the board
        
        //printing out the a message indicating that this is the current board
        System.out.println("This is the current board for the TicTacToe2.0 game");
        System.out.println();

        //using two for loops to iterate through the length and the width of the board
        for(int i = 1; i <= rowOfboard; i++) {
            for(int j = 1; j <= lengthOfBoard; j++) {

                //checking to see if the width is an even number and not 1
                if(i != 1 && i % 2 == 0) {

                    //checking to see if the length is a factor of 6 and not 1 of it is
                    if(j != 1 && j % 6 == 0) {

                        //printing out the proper board piece if it is
                        System.out.print("|");
                    }

                    else {

                        //printing out the proper board piece if it is not
                        System.out.print("-");
                    }
                }

                else {

                    //checking to see if the length of the board is a factor of 3 and not a factor of 6
                    if(j % 3 == 0 && j % 6 != 0) {

                        //printing out the player's symbol
                        System.out.print(board[boardPosition]);

                        //incrementing the position of the board to the next position
                        boardPosition = boardPosition + 1;
                    }

                    //checking to see if the length of the board is a factor of 6
                    else if(j % 6 == 0) {

                        //printing out the proper board piece if it is
                        System.out.print("|");
                    }

                    else {

                        //printing out the proper board piece if it is not
                        System.out.print(" ");
                    }
                }
            }

            System.out.println();
        }

        System.out.println();
        System.out.println();
    }

    /**
     *@ prints out the available positions for the players to choose from
     *@ parameters: takes in two int variables called boardSize and playerAmount and a String array called positions
     *@ returns true if a player has won and false if not
     */
    public static void printBoardPositions(int boardSize, int playerAmount, String[] positions) {

        //printing out a message indicating these are the playable position
        System.out.println("List of playable positions");
        System.out.println();

        //used to iterate through the array
        for(int i = 0; i < boardSize; i++) {
            
            //checking to see if the loop reached the end of a row
            if((i+1) % (playerAmount + 1) == 0) {

                //prints out the appropriate information if it is
                System.out.print(positions[i] + "  ");
                System.out.println();
                System.out.println();
            }

            else {

                //prints out the appropriate for information if it is not
                System.out.print(positions[i] + "  ");
            }
        }
    }
}