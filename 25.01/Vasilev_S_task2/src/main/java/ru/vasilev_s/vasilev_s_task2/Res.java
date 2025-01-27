package ru.vasilev_s.vasilev_s_task2;

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
    private ListView<Integer> dataList;

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
        int countUnsatisfactory = 0;
        boolean allSolved = false;

        for (Integer correctAnswers : dataList.getItems()) {
            if (correctAnswers < 5) { 
                countUnsatisfactory++;
            }
            if (correctAnswers == 10) {
                allSolved = true;
            }
        }

        resLabel.setText("Неудовлетворительные оценки: " + countUnsatisfactory + ". Все решены: " + (allSolved ? "YES" : "NO"));
    }


    @FXML
    void addOnAction(ActionEvent event) {
        if (NumText.getText().isEmpty()) {
            return;
        }
        try {
            int x = Integer.parseInt(NumText.getText());
            if (x < 0 || x > 10) {
                throw new NumberFormatException("Количество правильных ответов должно быть в пределах от 0 до 10.");
            }
            dataList.getItems().add(x);
        } catch (NumberFormatException ex) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("Введены некорректные данные: " + ex.getMessage());
            alert.showAndWait();
        } finally {
            NumText.setText("");
        }
    }
}


