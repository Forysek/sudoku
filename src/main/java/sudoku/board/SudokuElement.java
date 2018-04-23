package sudoku.board;

import java.util.ArrayList;
import java.util.List;

public class SudokuElement {
    public static final int EMPTY_VALUE = -1;
    private int value = EMPTY_VALUE;
    private int zone;
    private int positionX = -1;
    private int positionY = -1;
    private List<Integer> availableForPosition = new ArrayList<>();

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public int getZone() {
        return zone;
    }

    public void setZone(int zone) {
        this.zone = zone;
    }

    public void setPositionX(int positionX) {
        this.positionX = positionX;
    }

    public void setPositionY(int positionY) {
        this.positionY = positionY;
    }

    public List<Integer> getAvailableForPosition() {
        return availableForPosition;
    }

    public int getPositionX() {
        return positionX;
    }

    public int getPositionY() {
        return positionY;
    }
}
