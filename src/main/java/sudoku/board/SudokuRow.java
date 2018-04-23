package sudoku.board;

import java.util.LinkedList;
import java.util.List;


public class SudokuRow {
    private List<SudokuElement> elements = new LinkedList<>();

    public List<SudokuElement> getElements() {
        return elements;
    }
}
