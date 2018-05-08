package sudoku.backtrack.containers;

import sudoku.containers.NumbersContainerProcessor;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import static sudoku.board.SudokuBoard.MAX_INDEX;
import static sudoku.board.SudokuBoard.MIN_INDEX;

public class BacktrackZoneContainer {
    private List<List<Integer>> deepClonedZones = new ArrayList<>();

    public List<List<Integer>> getDeepClonedZones() {
        return deepClonedZones;
    }

    public void createDeepClonedZoneContainer(NumbersContainerProcessor numbersContainerProcessor){
        for (int i = MIN_INDEX; i < MAX_INDEX; i++) {
            List<Integer> deepClonedAvailableInZones = new LinkedList<>();
            int sizeOfAvailableInZones = numbersContainerProcessor.getZoneContainer().getZones().get(i).size();
            if(!numbersContainerProcessor.getZoneContainer().getZones().get(i).isEmpty()) {
                for (int x = MIN_INDEX; x < sizeOfAvailableInZones; x++) {
                    Integer deepClonedAvailableValue = numbersContainerProcessor.getZoneContainer().getZones().get(i).get(x);
                    deepClonedAvailableInZones.add(deepClonedAvailableValue);
                }
                deepClonedZones.add(deepClonedAvailableInZones);
            } else {
                deepClonedZones.add(deepClonedAvailableInZones);
                continue;
            }
        }
    }
}