package ru.vasilev_s.vasilev_s_task3;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class Res {

    @FXML
    private TextField NumText;

    @FXML
    private Button addButton;

    @FXML
    private Button cancelButton;

    @FXML
    private ListView<String> dataList;

    @FXML
    private Button okButton;

    @FXML
    private Label resLabel;

    @FXML
    void CancelOnAction(ActionEvent event) {
        Platform.exit();
    }

    @FXML
    void OkOnAction(ActionEvent event) {
        dataList.getItems().clear(); // Очищаем список перед новым выводом
        try {
            double pricePerKg = Double.parseDouble(NumText.getText());
            for (double i = 0.1; i <= 1.0; i += 0.1) {
                double cost = pricePerKg * i;
                dataList.getItems().add(String.format("%.1f кг = %.2f", i, cost));
            }
        } catch (NumberFormatException ex) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("Введены некорректные данные. Пожалуйста, введите вещественное число.");
            alert.showAndWait();
        }
    }


    @FXML
    void addOnAction(ActionEvent event) {
        if (NumText.getText().isEmpty()) {
            return;
        }
        try {
            double x = Double.parseDouble(NumText.getText());
            dataList.getItems().add(String.valueOf(x));
        } catch (NumberFormatException ex) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("Введены некорректные данные");
            alert.showAndWait();
        } finally {
            NumText.setText("");
        }
    }

}


