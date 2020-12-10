package ru.xo.controller;

import ru.xo.model.Cell;
import ru.xo.model.Coordinate;
import ru.xo.model.Field;

public class FieldController {

    private Field field;
    private FinishGameAction finishGameAction;

    public FieldController(){
        field = new Field();
    }

    public void reset(){
        field = new Field();
    }

    public void markCell(Coordinate position, Cell.CellMark player){
        field.getCells()[position.getX()][position.getY()].setMark(player);
        checkFieldForMatching();
    }

    private void checkFieldForMatching(){
        Cell[][] cells = field.getCells();
        if (checkLine(cells, 0, 0, 0, 1, 0, 2)){
            this.finishGameAction.matchFound(cells[0][0].getMark());
            return;
        } else if (checkLine(cells, 0, 0, 1, 0, 2, 0)){
            this.finishGameAction.matchFound(cells[0][0].getMark());
            return;
        } else if (checkLine(cells, 0, 2, 1, 2, 2, 2)){
            this.finishGameAction.matchFound(cells[0][2].getMark());
            return;
        } else if (checkLine(cells, 2, 0, 2, 1, 2, 2)){
            this.finishGameAction.matchFound(cells[2][0].getMark());
            return;
        } else if (checkLine(cells, 0, 0, 1, 1, 2, 2)){
            this.finishGameAction.matchFound(cells[0][0].getMark());
            return;
        } else if (checkLine(cells, 0, 2, 1, 1, 2, 0)){
            this.finishGameAction.matchFound(cells[0][2].getMark());
            return;
        } else if (checkLine(cells, 0, 1, 1, 1, 2, 1)){
            this.finishGameAction.matchFound(cells[0][1].getMark());
            return;
        } else if (checkLine(cells, 1, 0, 1, 1, 1, 2)){
            this.finishGameAction.matchFound(cells[1][0].getMark());
            return;
        }
        for (int i = 0; i < Field.SIZE; i++){
            for (int j = 0; j < Field.SIZE; j++){
                if (cells[i][j].getMark() == Cell.CellMark.EMPTY){
                    return;
                }
            }
        }
        this.finishGameAction.isDraw();
    }

    private boolean checkLine(Cell[][] cells, int... indexes){
        return cells[indexes[0]][indexes[1]].getMark() != Cell.CellMark.EMPTY
                && cells[indexes[2]][indexes[3]].getMark() != Cell.CellMark.EMPTY
                && cells[indexes[4]][indexes[5]].getMark() != Cell.CellMark.EMPTY
                && cells[indexes[0]][indexes[1]].getMark() == cells[indexes[2]][indexes[3]].getMark()
                && cells[indexes[2]][indexes[3]].getMark() == cells[indexes[4]][indexes[5]].getMark();
    }

    public Cell[][] getCells(){
        return field.getCells();
    }

    public void setFinishGameAction(FinishGameAction finishGameAction) {
        this.finishGameAction = finishGameAction;
    }

    public interface FinishGameAction{
        public void matchFound(Cell.CellMark winner);
        public void isDraw();
    }
}
