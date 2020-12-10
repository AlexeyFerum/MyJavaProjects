package ru.xo.view;

import ru.xo.model.Cell;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ResetView extends JPanel {

    private ResetAction resetAction;

    public ResetView(Cell.CellMark winner) {
        setBackground(winner == Cell.CellMark.X ? Color.GREEN : Color.RED);

        JLabel message = new JLabel();
        message.setText("Победил игрок " + winner);
        message.setFont(new Font("Arial", Font.PLAIN, 20));
        message.setHorizontalAlignment(SwingConstants.CENTER);

        this.add(message);

        setupBaseUI();
    }

    public ResetView(String title) {
        setBackground(Color.YELLOW);

        JLabel message = new JLabel();
        message.setText(title);
        message.setFont(new Font("Arial", Font.PLAIN, 20));
        message.setHorizontalAlignment(SwingConstants.CENTER);

        this.add(message);

        setupBaseUI();
    }

    private void setupBaseUI(){
        setLayout(new GridLayout(2, 1, 10, 10));

        JButton resetButton = new JButton();
        resetButton.setFont(new Font("Arial", Font.PLAIN, 20));
        resetButton.setText("Еще раз");
        resetButton.setFocusable(false);
        resetButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                resetAction.onReset();
            }
        });

        this.add(resetButton);
    }

    public void setResetAction(ResetAction resetAction) {
        this.resetAction = resetAction;
    }

    public interface ResetAction{

        public void onReset();

    }
}
