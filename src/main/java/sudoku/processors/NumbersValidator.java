package sudoku.processors;

import sudoku.board.SudokuBoard;

public class NumbersValidator {
    private SudokuBoard sudokuBoard;

    public NumbersValidator(SudokuBoard sudokuBoard) {
        this.sudokuBoard = sudokuBoard;
    }

    public SudokuBoard getSudokuBoard() {
        return sudokuBoard;
    }

    public boolean coordsValidator(int tempX, int tempY, int tempValue) {
        long countInRow = sudokuBoard.getBoard().stream()
                .map(y -> sudokuBoard.getBoard().get(tempY - 1))
                .flatMap(row -> row.getElements().stream())
                .filter(element -> element.getValue() == tempValue)
                .count();
        long countInColumn = sudokuBoard.getBoard().stream()
                .map(row -> row.getElements().get(tempX - 1))
                .filter(element -> element.getValue() == tempValue)
                .count();
        long countInZone = sudokuBoard.getBoard().stream()
                .flatMap(row -> row.getElements().stream())
                .filter(zone -> zone.getZone() == sudokuBoard.getBoard().get(tempY - 1).getElements().get(tempX - 1).getZone())
                .filter(element -> element.getValue() == tempValue)
                .count();
        if (countInRow < 1 && countInColumn < 1 && countInZone < 1) {
            return true;
        } else {
            return false;
        }
    }
}
