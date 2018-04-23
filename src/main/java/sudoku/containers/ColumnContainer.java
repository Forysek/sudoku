package sudoku.containers;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import static sudoku.board.SudokuBoard.MAX_INDEX;
import static sudoku.board.SudokuBoard.MIN_INDEX;

public class ColumnContainer {
    private List<List<Integer>> columns = new ArrayList<>();

    public ColumnContainer() {
        for (int i = MIN_INDEX; i < MAX_INDEX; i++) {
            List<Integer> availableInColumns = new LinkedList<>();
            for(Integer x = 1; x < 10; x++){
                availableInColumns.add(x);
            }
            columns.add(availableInColumns);
        }
    }

    public List<List<Integer>> getColumns() {
        return columns;
    }

    public void setColumns(List<List<Integer>> columns) {
        this.columns = columns;
    }
}