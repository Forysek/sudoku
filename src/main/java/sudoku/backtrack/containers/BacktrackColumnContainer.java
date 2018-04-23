package sudoku.backtrack.containers;

import sudoku.containers.NumbersContainerProcessor;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import static sudoku.board.SudokuBoard.MAX_INDEX;
import static sudoku.board.SudokuBoard.MIN_INDEX;

public class BacktrackColumnContainer {
    private List<List<Integer>> deepClonedColumns = new ArrayList<>();

    public List<List<Integer>> getDeepClonedColumns() {
        return deepClonedColumns;
    }

    public void createDeepClonedColumnContainer(NumbersContainerProcessor numbersContainerProcessor){
        for (int i = MIN_INDEX; i < MAX_INDEX; i++) {
            List<Integer> deepClonedAvailableInColumns = new LinkedList<>();
            if(!numbersContainerProcessor.getColumnContainer().getColumns().get(i).isEmpty()) {
                int sizeOfAvailableInColumns = numbersContainerProcessor.getColumnContainer().getColumns().get(i).size();
                for (int x = MIN_INDEX; x < sizeOfAvailableInColumns; x++) {
                    Integer deepClonedAvailableValue = numbersContainerProcessor.getColumnContainer().getColumns().get(i).get(x);
                    deepClonedAvailableInColumns.add(deepClonedAvailableValue);
                }
                deepClonedColumns.add(deepClonedAvailableInColumns);
            } else {
                continue;
            }
        }
    }
}
