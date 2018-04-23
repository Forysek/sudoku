package sudoku.backtrack.processors;


import java.util.ArrayDeque;
import java.util.Deque;

public class BacktrackProcessor {
    private static BacktrackProcessor backtrackProcessor = null;
    private Deque<SavedGame> allSavedGames = new ArrayDeque<>();

    private BacktrackProcessor(){
    }

    public Deque<SavedGame> getAllSavedGames() {
        return allSavedGames;
    }

    public static BacktrackProcessor getInstance(){
        if(backtrackProcessor == null){
            backtrackProcessor = new BacktrackProcessor();
        }
        return backtrackProcessor;
    }

    public void saveGame(SavedGame savedGame){
        allSavedGames.push(savedGame);
    }
}
