package sudoku.backtrack.containers;

import sudoku.containers.NumbersContainerProcessor;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import static sudoku.board.SudokuBoard.MAX_INDEX;
import static sudoku.board.SudokuBoard.MIN_INDEX;

public class BacktrackRowContainer {
    private List<List<Integer>> deepClonedRows = new ArrayList<>();

    public List<List<Integer>> getDeepClonedRows() {
        return deepClonedRows;
    }

    public void createDeepClonedRowContainer(NumbersContainerProcessor numbersContainerProcessor){
        for (int i = MIN_INDEX; i < MAX_INDEX; i++) {
            List<Integer> deepClonedAvailableInRows = new LinkedList<>();
            int sizeOfAvailableInRows = numbersContainerProcessor.getRowContainer().getRows().get(i).size();
            if(!numbersContainerProcessor.getRowContainer().getRows().get(i).isEmpty()) {
                for (int x = MIN_INDEX; x < sizeOfAvailableInRows; x++) {
                    Integer deepClonedAvailableValue = numbersContainerProcessor.getRowContainer().getRows().get(i).get(x);
                    deepClonedAvailableInRows.add(deepClonedAvailableValue);
                }
                deepClonedRows.add(deepClonedAvailableInRows);
            } else {
                continue;
            }
        }
    }
}

