package sudoku.containers;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import static sudoku.board.SudokuBoard.MAX_INDEX;
import static sudoku.board.SudokuBoard.MIN_INDEX;

public class ZoneContainer {
    private List<List<Integer>> zones = new ArrayList<>();

    public ZoneContainer() {
        for (int i = MIN_INDEX; i < MAX_INDEX; i++) {
            List<Integer> availableInZones = new LinkedList<>();
            for(Integer x = 1; x < 10; x++){
                availableInZones.add(x);
            }
            zones.add(availableInZones);
        }
    }

    public List<List<Integer>> getZones() {
        return zones;
    }

    public void setZones(List<List<Integer>> zones) {
        this.zones = zones;
    }
}