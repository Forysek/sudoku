package sudoku.containers;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import static sudoku.board.SudokuBoard.MAX_INDEX;
import static sudoku.board.SudokuBoard.MIN_INDEX;

public class RowContainer {
    private List<List<Integer>> rows = new ArrayList<>();

    public RowContainer() {
        for (int i = MIN_INDEX; i < MAX_INDEX; i++) {
            List<Integer> availableInRows = new LinkedList<>();
            for(Integer x = 1; x < 10; x++){
                availableInRows.add(x);
            }
            rows.add(availableInRows);
        }
    }

    public List<List<Integer>> getRows() {
        return rows;
    }

    public void setRows(List<List<Integer>> rows) {
        this.rows = rows;
    }
}
