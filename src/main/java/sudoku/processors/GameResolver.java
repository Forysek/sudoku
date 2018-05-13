package sudoku.processors;

import sudoku.backtrack.BacktrackBoard;
import sudoku.backtrack.processors.BacktrackProcessor;
import sudoku.backtrack.processors.SavedGame;
import sudoku.board.SudokuBoard;
import sudoku.board.SudokuElement;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

import static sudoku.board.SudokuBoard.MAX_INDEX;
import static sudoku.board.SudokuBoard.MIN_INDEX;
import static sudoku.board.SudokuElement.EMPTY_VALUE;


public class GameResolver {
    private NumbersValidator numbersValidator;

    public GameResolver(NumbersValidator numbersValidator) {
        this.numbersValidator = numbersValidator;
    }

    public void solveSudoku() {
        updateBoard();
        do {
            if(isSudokuPossibleToSolve()) {
                System.out.println(numbersValidator.getSudokuBoard());
                checkBoardElementsForAvailableValues();
            } else {
                loadGame();
            }
        } while (!isSudokuFinished(numbersValidator.getSudokuBoard()));
    }

    private void checkBoardElementsForAvailableValues() {
        Integer smallestListOfAvailableInPosition = numbersValidator.getSudokuBoard().getBoard().stream()
                .flatMap(row -> row.getElements().stream())
                .filter((f -> f.getValue() == EMPTY_VALUE))
                .filter(f -> f.getAvailableForPosition().size() > 0)
                .mapToInt(m -> m.getAvailableForPosition().size())
                .min().orElseThrow(NoSuchElementException::new);

        List<SudokuElement> elementWithSmallestAvailableList = numbersValidator.getSudokuBoard().getBoard().stream()
                .flatMap(row -> row.getElements().stream())
                .filter(f -> f.getAvailableForPosition().size() == smallestListOfAvailableInPosition)
                .collect(Collectors.toList());

        boolean isValid = false;
        SudokuElement sudokuElement;
        int listIndex = 0;
        Integer valueToInsert;
        int posX;
        int posY;
        int zone;

        do {
            sudokuElement = elementWithSmallestAvailableList.get(0);
            posX = sudokuElement.getPositionX();
            posY = sudokuElement.getPositionY();
            zone = sudokuElement.getZone();
            valueToInsert = sudokuElement.getAvailableForPosition().get(listIndex);
            isValid = numbersValidator.coordsValidator(posX + 1, posY + 1, valueToInsert);
            listIndex++;
        } while (!isValid && sudokuElement.getAvailableForPosition().size() > listIndex);
        if (isValid) {
            sudokuElement.getAvailableForPosition().remove(valueToInsert);
            createSnapshotOfBoard();
            sudokuElement.setValue(valueToInsert);
            removeFromCoordsAvailableValues(posX, posY, zone, valueToInsert);
            sudokuElement.getAvailableForPosition().clear();
        } else {
            loadGame();
        }
    }

    private void removeFromCoordsAvailableValues(int x, int y, int zone, Integer value) {
        numbersValidator.getSudokuBoard().getBoard().stream()
                .flatMap(row -> row.getElements().stream())
                .filter(f -> f.getPositionX() == x)
                .forEach(list -> list.getAvailableForPosition().remove(value));

        numbersValidator.getSudokuBoard().getBoard().stream()
                .flatMap(row -> row.getElements().stream())
                .filter(f -> f.getPositionY() == y)
                .forEach(list -> list.getAvailableForPosition().remove(value));

        numbersValidator.getSudokuBoard().getBoard().stream()
                .flatMap(row -> row.getElements().stream())
                .filter(f -> f.getZone() == zone)
                .forEach(list -> list.getAvailableForPosition().remove(value));
    }

    private void updateBoard() {
        for (int y = MIN_INDEX; y < MAX_INDEX; y++) {
            for (int x = MIN_INDEX; x < MAX_INDEX; x++) {
                SudokuElement sudokuElement =  numbersValidator.getSudokuBoard().getBoard().get(y).getElements().get(x);
                int tempValue = sudokuElement.getValue();
                if (tempValue == EMPTY_VALUE) {
                    for (int availableValue = 1; availableValue < 10; availableValue++) {
                        boolean isValid = numbersValidator.coordsValidator(x + 1, y + 1, availableValue);
                        if (isValid && !sudokuElement.getAvailableForPosition().contains(availableValue)) {
                            sudokuElement.getAvailableForPosition().add(availableValue);
                        }
                    }
                }
            }
        }
    }


    private boolean isSudokuPossibleToSolve() {
        List<SudokuElement> invalidElementsList = numbersValidator.getSudokuBoard().getBoard().stream()
                .flatMap(row -> row.getElements().stream())
                .filter(f -> (f.getAvailableForPosition().size() == 0) && (f.getValue() == EMPTY_VALUE))
                .collect(Collectors.toList());

        boolean isSolvable = false;
        if (invalidElementsList.size() == 0) {
            isSolvable = true;
        }
        return isSolvable;
    }

    private void createSnapshotOfBoard(){
        BacktrackBoard backtrackBoard = new BacktrackBoard();
        backtrackBoard.createDeepClonedBoard(numbersValidator.getSudokuBoard());
        SavedGame savedGame = new SavedGame(backtrackBoard);
        BacktrackProcessor.getInstance().saveGame(savedGame);
    }

    private void loadGame() {
        SavedGame loadedGame = BacktrackProcessor.getInstance().getAllSavedGames().peekFirst();
        numbersValidator.getSudokuBoard().setBoard(loadedGame.getBacktrackBoard().getClonedBoard());
        BacktrackProcessor.getInstance().getAllSavedGames().poll();
    }

    private boolean isSudokuFinished(SudokuBoard sudokuBoard){
        boolean isSudokuDone = sudokuBoard.getBoard().stream()
                .flatMap(row -> row.getElements().stream())
                .noneMatch(v -> v.getValue() == EMPTY_VALUE);
        return isSudokuDone;
    }
}