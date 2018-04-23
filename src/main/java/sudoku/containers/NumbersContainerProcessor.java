package sudoku.containers;

public class NumbersContainerProcessor {
    private RowContainer rowContainer;
    private ColumnContainer columnContainer;
    private ZoneContainer zoneContainer;

    public NumbersContainerProcessor(RowContainer rowContainer, ColumnContainer columnContainer, ZoneContainer zoneContainer) {
        this.rowContainer = rowContainer;
        this.columnContainer = columnContainer;
        this.zoneContainer = zoneContainer;
    }

    public RowContainer getRowContainer() {
        return rowContainer;
    }

    public ColumnContainer getColumnContainer() {
        return columnContainer;
    }

    public ZoneContainer getZoneContainer() {
        return zoneContainer;
    }

    public void removeFromAvailableNumbers(int coordX, int coordY, int zone, Integer value) {
        rowContainer.getRows().get(coordY - 1).remove(value);
        columnContainer.getColumns().get(coordX - 1).remove(value);
        zoneContainer.getZones().get(zone - 1).remove(value);
    }

    public void addToAvailableNumbers(int coordX, int coordY, int zone, Integer value) {
        rowContainer.getRows().get(coordY - 1).add(value);
        columnContainer.getColumns().get(coordX - 1).add(value);
        zoneContainer.getZones().get(zone - 1).add(value);
    }
}