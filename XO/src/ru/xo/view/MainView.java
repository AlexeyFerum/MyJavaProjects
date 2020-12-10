package ru.xo.view;

import ru.xo.controller.FieldController;
import ru.xo.model.Cell;

import javax.swing.*;
import java.awt.*;

public class MainView extends JFrame {

    public FieldView fieldView;
    public ResetView resetView;

    public MainView(String title) throws HeadlessException {
        super(title);
        setResizable(false);
        setSize(200, 222);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        showGameView();
    }

    public void showResetView(Cell.CellMark winner){
        resetView = new ResetView(winner);
        showResetView(resetView);
    }

    public void showResetView(String title){
        resetView = new ResetView(title);
        showResetView(resetView);
    }

    private void showResetView(ResetView resetView){
        resetView.setResetAction(new ResetView.ResetAction() {
            @Override
            public void onReset() {
                showGameView();
            }
        });
        add(resetView);
        fieldView.setVisible(false);
    }

    public void showGameView(){
        FieldController controller = new FieldController();
        controller.setFinishGameAction(new FieldController.FinishGameAction() {
            @Override
            public void matchFound(Cell.CellMark winner) {
                showResetView(winner);
            }

            @Override
            public void isDraw() {
                showResetView("Ничья");
            }
        });
        fieldView = new FieldView(controller);
        add(fieldView);
        if (resetView != null) {
            resetView.setVisible(false);
        }
    }
}
