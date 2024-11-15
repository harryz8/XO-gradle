package com.zs1.oxgradle;

import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;


public class OXController {
    String turnLetter = "X";
    Button[] buttons = new Button[9];
    boolean gameOver = false;
    int turnCounter = 0;
    Alert endConf = new Alert(Alert.AlertType.INFORMATION);
    @FXML Label turn;
    //@FXML Label status;
    @FXML Button lt, lm, lb, mt, mm, mb, rt, rm, rb;
    @FXML void initialize() {
        lt.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                move(lt);
            }
        });
        mt.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                move(mt);
            }
        });
        rt.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                move(rt);
            }
        });
        lm.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                move(lm);
            }
        });
        mm.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                move(mm);
            }
        });
        rm.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                move(rm);
            }
        });
        lb.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                move(lb);
            }
        });
        mb.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                move(mb);
            }
        });
        rb.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                move(rb);
            }
        });
        turn.setText("Turn: "+turnLetter);
        Button[] newBt = {lt, lm, lb, mt, mm, mb, rt, rm, rb};
        for (int i=0; i<9; i++) {
            buttons[i] = newBt[i];
        }
        endConf.setTitle("Game Over");
        endConf.setHeaderText("Game Over");
    }
    public void move(Button i) {
        if (!gameOver && i.getText().equals("-")) {
            turnCounter++;
            i.setText(turnLetter);
            AutoMarker currentGrid = new AutoMarker(buttons);
            if (currentGrid.fullCheck()) {
                endConf.setContentText("Status: " + turnLetter + " has won in " + String.valueOf(turnCounter) + " turns.");
                endConf.show();
                gameOver = true;
            }
            else {
                if (turnCounter >= 9) {
                    endConf.setContentText("Status: Game is a Tie.");
                    endConf.show();
                    //status.setText("Status: Game is a Tie.");
                    gameOver = true;
                }
                else {
                    switch (turnLetter) {
                        case "X":
                            turnLetter = "O";
                            break;
                        case "O":
                            turnLetter = "X";
                            break;
                    }
                    turn.setText("Turn: " + turnLetter);
                }
            }
        }
    }
    @FXML public void reset() {
        turnLetter = "X";
        turnCounter = 0;
        turn.setText("Turn: "+turnLetter);
        for (Button b : buttons) {
            b.setText("-");
        }
        gameOver = false;
        //status.setText("Status: Game Ongoing");
    }
}