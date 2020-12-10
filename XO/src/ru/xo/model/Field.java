package ru.xo.model;

public class Field {

    public static final int SIZE = 3;

    private Cell[][] cells;

    public Field() {
        cells = new Cell[SIZE][SIZE];
        for (int i = 0; i < SIZE; i++){
            for (int j = 0; j < SIZE; j++){
                cells[i][j] = new Cell();
                cells[i][j].setMark(Cell.CellMark.EMPTY);
            }
        }
    }

    public Cell[][] getCells() {
        return cells;
    }


}
