package sudoku.backtrack;

import sudoku.board.SudokuBoard;
import sudoku.board.SudokuElement;
import sudoku.board.SudokuRow;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import static sudoku.board.SudokuBoard.MAX_INDEX;
import static sudoku.board.SudokuBoard.MIN_INDEX;

public class BacktrackBoard {
    private List<SudokuRow> clonedBoard = new LinkedList<>();

    public void createDeepClonedBoard(SudokuBoard sudokuBoard) {
        for (int y = MIN_INDEX; y < MAX_INDEX; y++) {
            SudokuRow deepClonedSudokuRow = new SudokuRow();
            clonedBoard.add(deepClonedSudokuRow);
            for (int x = MIN_INDEX; x < MAX_INDEX; x++) {
                SudokuElement deepClonedSudokuElement = new SudokuElement();
                int shallowClonedZone = sudokuBoard.getBoard().get(y).getElements().get(x).getZone();
                deepClonedSudokuElement.setZone(shallowClonedZone);
                int shallowClonedValue = sudokuBoard.getBoard().get(y).getElements().get(x).getValue();
                deepClonedSudokuElement.setValue(shallowClonedValue);
                int shallowClonedPosX = sudokuBoard.getBoard().get(y).getElements().get(x).getPositionX();
                deepClonedSudokuElement.setPositionX(shallowClonedPosX);
                int shallowClonedPosY = sudokuBoard.getBoard().get(y).getElements().get(x).getPositionY();
                deepClonedSudokuElement.setPositionY(shallowClonedPosY);
                List<Integer> availableListToBeCloned = sudokuBoard.getBoard().get(y).getElements().get(x).getAvailableForPosition();
                List<Integer> deepClonedAvailableList = new ArrayList<>();
                for(Integer availableElements : availableListToBeCloned) {
                    deepClonedAvailableList.add(availableElements);
                }
                deepClonedSudokuElement.setAvailableForPosition(deepClonedAvailableList);
                deepClonedSudokuRow.getElements().add(deepClonedSudokuElement);
            }
        }
    }
    public List<SudokuRow> getClonedBoard() {
        return clonedBoard;
    }
}
