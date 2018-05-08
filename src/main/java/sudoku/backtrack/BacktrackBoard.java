package sudoku.backtrack;

import sudoku.board.SudokuBoard;
import sudoku.board.SudokuElement;
import sudoku.board.SudokuRow;

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
                int deepClonedZone = sudokuBoard.getBoard().get(y).getElements().get(x).getZone();
                deepClonedSudokuElement.setZone(deepClonedZone);
                int deepClonedValue = sudokuBoard.getBoard().get(y).getElements().get(x).getValue();
                deepClonedSudokuElement.setValue(deepClonedValue);
                int deepClonedPosX = sudokuBoard.getBoard().get(y).getElements().get(x).getPositionX();
                deepClonedSudokuElement.setPositionX(deepClonedPosX);
                int deepClonedPosY = sudokuBoard.getBoard().get(y).getElements().get(x).getPositionY();
                deepClonedSudokuElement.setPositionY(deepClonedPosY);
                deepClonedSudokuRow.getElements().add(deepClonedSudokuElement);

            }
        }
    }
    public List<SudokuRow> getClonedBoard() {
        return clonedBoard;
    }
}
