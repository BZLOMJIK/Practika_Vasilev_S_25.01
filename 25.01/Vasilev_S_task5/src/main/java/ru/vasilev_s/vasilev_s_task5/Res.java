package ru.vasilev_s.vasilev_s_task5;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import static java.lang.Math.*;

public class Res {

    @FXML
    private TextField nText;

    @FXML
    private Label resLabel;

    @FXML
    void resOnAction(ActionEvent event) {
        int n = Integer.parseInt(nText.getText());

        if (n < 4) {
            resLabel.setText("Ошибка: n должно быть >= 4.");
            return;
        }
        double[] V = new double[n + 1];
        V[0] = 0;
        V[1] = 0;
        V[2] = 1.5;
        for (int i = 3; i < n; i++) {
            V[i + 1] = ((i + 1.0)/(pow(i + 1, 2) + 1)) * V[i] - 1 - V[i - 1] - V[i - 2];
        }
        resLabel.setText(String.format("V_%d = %.5f", n, V[n]));
    }
}