package ru.vasilev_s.vasilev_s_task4;

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
    private TextField xText;

    @FXML
    void resOnAction(ActionEvent event) {
        double x = Double.parseDouble(xText.getText());
        int n = Integer.parseInt(nText.getText());

        if (n <= 0) {
            resLabel.setText("N должно быть больше 0.");
        }
        double result = 0.0;
        for (int i = 0; i <= n; i++) {
            double term = pow(-1, i) * pow(x, 2 * i);
            double denominator = factorial(2 * i);
            result += term / denominator;

    }
        resLabel.setText(String.format("Приближенное значение cos(%.2f) = %.5f", x, result));
}
    private long factorial(int number) {
        long result = 1;
        for (int i = 1; i <= number; i++) {
            result *= i;
        }
        return result;
    }
}
