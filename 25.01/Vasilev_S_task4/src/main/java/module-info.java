module ru.vasilev_s.vasilev_s_task4 {
    requires javafx.controls;
    requires javafx.fxml;


    opens ru.vasilev_s.vasilev_s_task4 to javafx.fxml;
    exports ru.vasilev_s.vasilev_s_task4;
}