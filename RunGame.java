//importing different classes in order to utilize the different methods that are only accessible from that class
import java.util.Scanner;
import java.util.Arrays;  
import java.util.ArrayList;

//this class utilizes all the other classes and its methods to run a fully functioning
//game of TicTacToe
public class RunGame {

    public static void main(String [] args) {
        Scanner scnrInput = new Scanner(System.in);             //creating a scanner object for general input
        Scanner scnrPlayerName = new Scanner(System.in);        //creating a scanner object for the players' name
        Scanner scnrPlayerCharacter = new Scanner(System.in);   //creating a scanner object for the players' symbol

        String input;                   //creating a String variable to store the players' inputs
        String playerName;              //creating a String variable to store the players' names
        int amountInARow;               //creating an int variable to store the amount in a row needed to win
        int playerAmount;               //creating an int variable to store the amount of players there are
        int boardSize;                  //creating an int variable to store the size of the board
        int playerTurn = 0;             //creating and initializing an int variable to keep track of the players' turn
        int position;                   //creating an int variable to store the position on the board that the player chose                  
        char playerSymbol;              //creating a char variable to store the players' symbol
        boolean gameStatus = false;     //creating and initializing a boolean variable that keeps track of the game's status

        //printing out a welcome message
        System.out.println("Welcome to TicTacToe2.0");

        //prompting the user to enter the amount of players
        System.out.println("To get started, enter the amount of players.");
        System.out.println("The maximum amount of players is 10. The minimum amount of players is 3.");

        //saving the input in a variable called input
        input = scnrInput.nextLine();

        //reprompting the user to enter an input if the input is invalid until the input is valid
        //using the methods from the InputValidationn class to check for validity
        while (InputValidation.isNumber(input) == false || InputValidation.isValidNumberOfPlayers(input) == false) {
            System.out.println("Invalid Input");
            System.out.println("Please ensure that you enter only a single whole number between 3 and 10 with 3 and 10 included.");
            System.out.println("Enter the amount of players.");
            input = scnrInput.nextLine();
        }

        //converting the amount of players to a number and saving it to the playerAmount variable
        playerAmount = Integer.parseInt(input);

        //calculating the size of the board based off of the amount of players there are
        boardSize = (playerAmount + 1) * (playerAmount + 1);

        System.out.println();
        System.out.println();

        //prompting the user to enter the amount of symbols that is needed in a row to win
        System.out.println("Enter the amount of positions in a row a player needs in order to win.");
        System.out.println("The maximum amount of positions in a row needed to win is " + (playerAmount + 1) + ". The minimum is 3.");

        //saving the input into a variable called input
        input = scnrInput.nextLine();

        //reprompting the user to enter the amount of symbols that is needed in a row to win if the input is invalid until a valid input has been entered
        //using the methods from the InputValidationn class to check for validity
        while (InputValidation.isNumber(input) == false || InputValidation.isValidAmountInARow(input, playerAmount) == false) {
            System.out.println("Invalid Input");
            System.out.println("Please ensure that you enter only a single whole number between " + (playerAmount + 1) + " and 3 with " + (playerAmount + 1) + " and 3 included." );
            System.out.println("Enter the amount of players.");
            input = scnrInput.nextLine();
        }

        //converting the input to a number and saving it in amountInARow
        amountInARow = Integer.parseInt(input);

        System.out.println();
        System.out.println();

        PlayerInfo[] players = new PlayerInfo[playerAmount];        //creating an array of PlayerInfo objects with the size of the amount of players there are
        char[] board = new char[boardSize];                         //creating a char array called board with the size of the board's size
        String[] boardAvailablePositions = new String[boardSize];   //creating a String array called boardAvailablePositions with the size of the board's size
        
        
        //initializing the available board positions and the board
        for(int i = 0; i < boardSize; i++) {
            boardAvailablePositions[i] = Integer.toString(i + 1);
            board[i] = '*'; 
        }

        //creating the individual PlayerInfo objects
        for(int i = 0; i < playerAmount; i++) {
            players[i] = new PlayerInfo();
        }

        //calling the setAmountInARow method from the PlayerInfo class to store amount of symbols that
        //are needed in a row to win in the players object
        players[0].setAmountInARow(amountInARow);

        //used to prompt all the players for their information
        for(int i = 0; i < playerAmount; i++) {

            //prompting the respective players to enter their name
            System.out.println("Enter player number " + (i+1) + "'s name.");

            //saving the input into playerName
            playerName = scnrPlayerName.nextLine();

            //using the method from the PlayerInfo class to set the player's name
            players[i].setPlayerName(playerName);

            //prompting the respective players to enter their symbol
            System.out.println("Enter player number " + (i+1) + "'s character.");

            //saving the input into playereSymbol
            //if you enter a string, it take the first character of that string
            playerSymbol = scnrPlayerCharacter.next().charAt(0);

            //keeps prompting the user to reenter a character if they chose an invalid character
            //using the methods from the InputValidationn class to check for validity
            while(InputValidation.isValidSymbol(playerSymbol, players, playerAmount) == false) {
                System.out.println("You cannot use '*' as a symbol, and you cannot use a symbol that has already been taken.");
                System.out.println("Enter player number " + (i+1) + "'s character again.");
                playerSymbol = scnrPlayerCharacter.next().charAt(0);
            }

            //using the method from the PlayerInfo class to store the player's character
            players[i].setPlayerSymbol(playerSymbol);
        }

        System.out.println();

        //listing out all the player's information
        System.out.println("List of players and their chosen symbols:");

        for(int i = 0; i < playerAmount; i++) {
            System.out.println("Player #" + (i + 1) + "'s name: " + players[i].getPlayerName());
            System.out.println("Player #" + (i + 1) + "'s symbol: " + players[i].getPlayerSymbol());
            System.out.println();
        }

        System.out.println();
        
        //displaying the starting board and all the available positions the players can choose from
        //using methods from the DisplayBoard to do so
        DisplayBoard.printStartingBoard(boardSize, playerAmount);
        DisplayBoard.printBoardPositions(boardSize, playerAmount, boardAvailablePositions);

        //keeps playing the game until a player wins or until the board is full
        while(gameStatus == false) {

            //prompting the player to enter a position that they want to play on
            System.out.println("Player #" + (playerTurn + 1) + ", " + players[playerTurn].getPlayerName() + ", pick a position to play on.");
            input = scnrInput.nextLine();

            //checking if the position they pick is valid
            //using the methods from the InputValidationn class to check for validity
            while(InputValidation.isNumber(input) == false || InputValidation.isValidPosition(input, boardSize, boardAvailablePositions) == false) {
                System.out.println("Player #" + (playerTurn + 1) + " please pick a valid position listed.");
                input = scnrInput.nextLine();
            }

            System.out.println();

            //converting the input to a number and saving it to position
            position = Integer.parseInt(input);

            //placing the player's symbol on the position they chose
            board[position - 1] = players[playerTurn].getPlayerSymbol();

            //changing the availability of that position to unavailable
            boardAvailablePositions[position - 1] = "*";

            //displaying the updated board and playable positions
            DisplayBoard.printCurrentBoard(boardSize, playerAmount, board);
            DisplayBoard.printBoardPositions(boardSize, playerAmount, boardAvailablePositions);

            //checking if a player has won using the hasWon method from the WinStatus class
            if(WinStatus.hasWon(board, players[playerTurn].getPlayerSymbol(), playerAmount, players[playerTurn].getAmountInARow()) == true) {
                
                //outputting a message saying that the player has won if a player has won
                System.out.println("Congratulations!"); 
                System.out.println("Player #" + (playerTurn + 1) + ", " + players[playerTurn].getPlayerName() + ", has won!");
                
                //changing the gameStatus to true to end the game
                gameStatus = true;
                continue;
            }

            //checking if the board is full using the isBoardFull method from the WinStatus class
            if(WinStatus.isBoardFull(boardAvailablePositions, boardSize) == true) {

                //printing out a message saying it is full if it
                System.out.println("The board is full!");
                System.out.println("The players can make no more moves.");
                System.out.println("The game has ended.");

                //changing the gameStatus to true to end the game
                gameStatus = true;
            }

            //checking if it is last player's turn
            if(playerTurn == playerAmount - 1) {

                //setting it back to the first player if it is
                playerTurn = 0;
            }

            else {
                
                //changing it to the next player's turn
                playerTurn = playerTurn + 1;
            }
        }
    }
}