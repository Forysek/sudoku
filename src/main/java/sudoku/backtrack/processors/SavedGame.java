package sudoku.backtrack.processors;

import sudoku.backtrack.BacktrackBoard;


public class SavedGame {
    private BacktrackBoard backtrackBoard;

    public SavedGame(BacktrackBoard backtrackBoard) {
        this.backtrackBoard = backtrackBoard;
    }

    public BacktrackBoard getBacktrackBoard() {
        return backtrackBoard;
    }
}
