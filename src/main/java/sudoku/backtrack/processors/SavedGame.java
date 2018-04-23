package sudoku.backtrack.processors;

import sudoku.backtrack.BacktrackBoard;
import sudoku.backtrack.containers.BacktrackContainersDto;


public class SavedGame {
    private BacktrackBoard backtrackBoard;
    private BacktrackContainersDto backtrackContainersDto;
    private int counter = 0;

    public SavedGame(BacktrackBoard backtrackBoard, BacktrackContainersDto backtrackContainersDto) {
        this.backtrackBoard = backtrackBoard;
        this.backtrackContainersDto = backtrackContainersDto;
    }

    public BacktrackBoard getBacktrackBoard() {
        return backtrackBoard;
    }

    public BacktrackContainersDto getBacktrackContainersDto() {
        return backtrackContainersDto;
    }

    public int getCounter() {
        return counter;
    }

    public void addCounter(){
        counter++;
    }
}