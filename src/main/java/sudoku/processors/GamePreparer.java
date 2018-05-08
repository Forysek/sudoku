package sudoku.processors;

import sudoku.board.SudokuElement;

import java.util.Scanner;

public class GamePreparer {
    private NumbersValidator numbersValidator;
    private String playerSettingUpCoords = "";

    public GamePreparer(NumbersValidator numbersValidator) {
        this.numbersValidator = numbersValidator;
    }

    public String getPlayerSettingUpCoords() {
        return playerSettingUpCoords;
    }

    public void prepareGame() {
        System.out.println("Please type column(x) and row(y) number you'd like to insert number into, separated by commas:");
        System.out.println("If you wish to delete value from certain coordinates please type those and as a value: 0.");
        System.out.println("If you wish to solve the sudoku please type: solve.");
        playerSettingUpCoords = new Scanner(System.in).nextLine();

        if (!playerSettingUpCoords.toLowerCase().equals("solve")){
            while (playerSettingUpCoords.length() < 5) {
                System.out.println("Coordinates and number to be inserted should be between 1 and 9, separated by commas.");
                System.out.println("Starting from the top left corner, please type column(x) and row(y) number" +
                        " you'd like to insert number into, separated by commas:");
                playerSettingUpCoords = new Scanner(System.in).nextLine();
            }
            Scanner playerTypedCoords = new Scanner(playerSettingUpCoords).useDelimiter("\\s*,\\s*|\\s*\\.\\s*|\\s* \\s*");
            int tempX = playerTypedCoords.nextInt();
            int tempY = playerTypedCoords.nextInt();
            int tempValue = playerTypedCoords.nextInt();
            SudokuElement sudokuElement =  numbersValidator.getSudokuBoard().getBoard().get(tempY - 1).getElements().get(tempX - 1);



            if (tempX > 0 && tempX < 10 && tempY > 0 && tempY < 10 && tempValue > 0 && tempValue < 10) {

                if (numbersValidator.coordsValidator(tempX, tempY, tempValue)) {
                   sudokuElement.setValue(tempValue);
                   sudokuElement.getAvailableForPosition().clear();

                    System.out.println(numbersValidator.getSudokuBoard());
                } else {
                    System.out.println("Can't have two same numbers in one row/column/zone, please change coordinates or value.");
                }
            } else if((tempX > 0 && tempX < 10 && tempY > 0 && tempY < 10 && tempValue == 0)){

                if(sudokuElement.getValue() == SudokuElement.EMPTY_VALUE){
                    System.out.println("Nothing to delete.");
                } else {
                    int valueDeleted = numbersValidator.getSudokuBoard().getBoard().get(tempY - 1).getElements().get(tempX - 1).getValue();
                    sudokuElement.getAvailableForPosition().add(valueDeleted);
                    sudokuElement.setValue(-1);
                    System.out.println("Value deleted.");
                    System.out.println(numbersValidator.getSudokuBoard());
                }
            } else {
                System.out.println("Coordinates and number to be inserted should be between 1 and 9, separated by commas.");
            }
        }
    }
}
