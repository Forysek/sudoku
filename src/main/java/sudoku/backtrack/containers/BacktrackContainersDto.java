package sudoku.backtrack.containers;

public class BacktrackContainersDto {
    private BacktrackColumnContainer backtrackColumnContainer;
    private BacktrackRowContainer backtrackRowContainer;
    private BacktrackZoneContainer backtrackZoneContainer;

    public BacktrackContainersDto(BacktrackColumnContainer backtrackColumnContainer, BacktrackRowContainer backtrackRowContainer, BacktrackZoneContainer backtrackZoneContainer) {
        this.backtrackColumnContainer = backtrackColumnContainer;
        this.backtrackRowContainer = backtrackRowContainer;
        this.backtrackZoneContainer = backtrackZoneContainer;
    }

    public BacktrackColumnContainer getBacktrackColumnContainer() {
        return backtrackColumnContainer;
    }

    public BacktrackRowContainer getBacktrackRowContainer() {
        return backtrackRowContainer;
    }

    public BacktrackZoneContainer getBacktrackZoneContainer() {
        return backtrackZoneContainer;
    }
}
