package sudoku.processors;

import sudoku.containers.NumbersContainerProcessor;

import java.util.Scanner;

public class GamePreparer {
    private NumbersValidator numbersValidator;
    private NumbersContainerProcessor numbersContainerProcessor;
    private String playerSettingUpCoords = "";

    public GamePreparer(NumbersValidator numbersValidator, NumbersContainerProcessor numbersContainerProcessor) {
        this.numbersValidator = numbersValidator;
        this.numbersContainerProcessor = numbersContainerProcessor;
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


            if (tempX > 0 && tempX < 10 && tempY > 0 && tempY < 10 && tempValue > 0 && tempValue < 10) {
                int coordsZone = numbersValidator.getSudokuBoard().getBoard().get(tempY - 1).getElements().get(tempX - 1).getZone();

                if (numbersValidator.coordsValidator(tempX, tempY, tempValue)) {
                    numbersValidator.getSudokuBoard().getBoard().get(tempY - 1).getElements().get(tempX - 1).setValue(tempValue);
                    numbersContainerProcessor.removeFromAvailableNumbers(tempX, tempY, coordsZone, tempValue);
                    System.out.println(numbersValidator.getSudokuBoard());
                } else {
                    System.out.println("Can't have two same numbers in one row/column/zone, please change coordinates or value.");
                }
            } else if((tempX > 0 && tempX < 10 && tempY > 0 && tempY < 10 && tempValue == 0)){
                int coordsZone = numbersValidator.getSudokuBoard().getBoard().get(tempY - 1).getElements().get(tempX - 1).getZone();

                if(numbersValidator.getSudokuBoard().getBoard().get(tempY - 1).getElements().get(tempX - 1).getValue() == -1){
                    System.out.println("Nothing to delete.");
                } else {
                    int valueDeleted = numbersValidator.getSudokuBoard().getBoard().get(tempY - 1).getElements().get(tempX - 1).getValue();
                    numbersContainerProcessor.addToAvailableNumbers(tempX, tempY, coordsZone, valueDeleted);
                    numbersValidator.getSudokuBoard().getBoard().get(tempY - 1).getElements().get(tempX - 1).setValue(-1);
                    System.out.println("Value deleted.");
                    System.out.println(numbersValidator.getSudokuBoard());
                }
            } else {
                System.out.println("Coordinates and number to be inserted should be between 1 and 9, separated by commas.");
            }

        }
    }
}
