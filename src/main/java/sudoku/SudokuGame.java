package sudoku;

import sudoku.board.SudokuBoard;
import sudoku.processors.GamePreparer;
import sudoku.processors.GameResolver;
import sudoku.processors.NumbersValidator;

import java.util.Scanner;


public class SudokuGame {

    public static void main(String[] args) {
        boolean isGameFinished = false;

        System.out.println("Sudoku Solver welcomes you, Traveler.");
        System.out.println("It appears you'd like to solve some puzzles, wouldn't you?\n");

        while (!isGameFinished) {
            SudokuBoard sudokuBoard = new SudokuBoard();
            NumbersValidator numbersValidator = new NumbersValidator(sudokuBoard);
            GameResolver gameResolver = new GameResolver(numbersValidator);

            System.out.println("Empty board looks like this: \n");
            System.out.println(sudokuBoard);

            GamePreparer gamePreparer = new GamePreparer(numbersValidator);

            do {
                gamePreparer.prepareGame();
            }
            while (!gamePreparer.getPlayerSettingUpCoords().toLowerCase().equals("solve"));

            gameResolver.solveSudoku();
            System.out.println(sudokuBoard);
            System.out.println("Done. Do you want to solve another sudoku? Y/N");
            String playerInput = new Scanner(System.in).nextLine();
            if (playerInput.toLowerCase().equals("y")) {
                isGameFinished = false;
            } else if (playerInput.toLowerCase().equals("n")) {
                isGameFinished = true;
            } else {
                System.out.println("Please type Y or N.");
            }
        }
    }
}