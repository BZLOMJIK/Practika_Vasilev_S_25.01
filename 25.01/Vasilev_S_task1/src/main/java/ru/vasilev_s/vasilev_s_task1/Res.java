package ru.vasilev_s.vasilev_s_task1;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.util.ArrayList;
import java.util.List;

public class Res {

    @FXML
    private TextField NumText;

    @FXML
    private Button addButton;

    @FXML
    private Button cancelButton;

    @FXML
    private ListView<Integer> dataList;

    @FXML
    private Button okButton;

    @FXML
    private Label resLabel;

    @FXML
    void OkOnAction(ActionEvent event) {
        List<Integer> data = dataList.getItems();
        int sum = 0;
        int count = 0;

        
            for (int number : data) {
                if (number >= 10 && number <= 99) {
                    sum += number;
                    count++;
                }
            }

        if (count > 0) {
            double average = (double) sum / count;
            resLabel.setText(String.valueOf(average));
        } else {
            resLabel.setText("NO");
        }

    }

    @FXML
    void CancelOnAction(ActionEvent event) {
        Platform.exit();
    }

    @FXML
    void addOnAction(ActionEvent event) {
        if (NumText.getText().isEmpty()) {
            return;
        }
        try {
            int x = Integer.parseInt(NumText.getText());
            dataList.getItems().add(x);
        } catch (NumberFormatException ex) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("Введены некорректные данные");
            alert.showAndWait();
        } finally {
            NumText.setText("");
        }
    }

}
