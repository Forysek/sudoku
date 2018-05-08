package sudoku.board;

import java.util.LinkedList;
import java.util.List;


public class SudokuBoard {
    public static final int MIN_INDEX = 0;
    public static final int MAX_INDEX = 9;
    private List<SudokuRow> board = new LinkedList<>();

    public SudokuBoard() {
        for (int y = MIN_INDEX; y < MAX_INDEX; y++) {
            SudokuRow sudokuRow = new SudokuRow();
            board.add(sudokuRow);
            for (int x = MIN_INDEX; x < MAX_INDEX; x++){
                SudokuElement sudokuElement = new SudokuElement();
                if(y >= 0 && y < 3 && x >= 0 && x < 3) {
                    sudokuElement.setZone(1);
                }else if(y >= 0 && y < 3 && x >= 3 && x < 6) {
                    sudokuElement.setZone(2);
                } else if(y >= 0 && y < 3 && x >= 6 && x < 9) {
                    sudokuElement.setZone(3);
                } else if(y >= 3 && y < 6 && x >= 0 && x < 3) {
                    sudokuElement.setZone(4);
                } else if(y >= 3 && y < 6 && x >= 3 && x < 6) {
                    sudokuElement.setZone(5);
                } else if(y >= 3 && y < 6 && x >= 6 && x < 9) {
                    sudokuElement.setZone(6);
                } else if(y >= 6 && y < 9 && x >= 0 && x < 3) {
                    sudokuElement.setZone(7);
                } else if(y >= 6 && y < 9 && x >= 3 && x < 6) {
                    sudokuElement.setZone(8);
                } else if(y >= 6 && y < 9 && x >= 6 && x < 9) {
                    sudokuElement.setZone(9);
                }
                sudokuRow.getElements().add(sudokuElement);
            }
        }
        fillSudokuElementCoords();
        fillSudokuElementAvailableForPosition();
    }

    public List<SudokuRow> getBoard() {
        return board;
    }

    public void setBoard(List<SudokuRow> board) {
        this.board = board;
    }

    public String toString() {
        String result = "    1   2   3    4   5   6    7   8   9" + "\n";
        for(int y = MIN_INDEX; y < MAX_INDEX; y++) {
            if(y == 3 || y == 6) {
                result +="  =======================================" + "\n" + (y + 1) + " |";
            } else {
                result += (y + 1) + " |";
            }
            for(int x = MIN_INDEX; x < MAX_INDEX; x++) {
                if(board.get(y).getElements().get(x).getValue() == (SudokuElement.EMPTY_VALUE)) {
                    result += "   ";
                } else {
                    result += " " + board.get(y).getElements().get(x).getValue() + " ";
                }
                if(x == 2 || x == 5){
                    result += "||";
                } else {
                    result += "|";
                }
            }
            result += "\n";
        }
        return result;
    }

    private void fillSudokuElementCoords() {
        for (int y = MIN_INDEX; y < MAX_INDEX; y++) {
            for (int x = MIN_INDEX; x < MAX_INDEX; x++) {
                board.get(y).getElements().get(x).setPositionX(x);
                board.get(y).getElements().get(x).setPositionY(y);
            }
        }
    }

    private void fillSudokuElementAvailableForPosition() {
        for (int y = MIN_INDEX; y < MAX_INDEX; y++) {
            SudokuRow sudokuRow = board.get(y);
            for (int x = MIN_INDEX; x < MAX_INDEX; x++) {
                SudokuElement sudokuElement =  sudokuRow.getElements().get(x);
                for (int i = 1; i < 10; i++){
                    sudokuElement.getAvailableForPosition().add(i);
                }
            }
        }
    }
}
