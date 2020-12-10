package ru.xo.model;

public class Cell {

    public enum CellMark { X, O, EMPTY };

    private Coordinate coordinate;
    private CellMark mark;

    public Coordinate getCoordinate() {
        return coordinate;
    }

    public void setCoordinate(Coordinate coordinate) {
        this.coordinate = coordinate;
    }

    public CellMark getMark() {
        return mark;
    }

    public void setMark(CellMark mark) {
        this.mark = mark;
    }
}
