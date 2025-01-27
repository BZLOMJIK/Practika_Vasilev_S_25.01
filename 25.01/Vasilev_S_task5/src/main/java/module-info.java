module ru.vasilev_s.vasilev_s_task5 {
    requires javafx.controls;
    requires javafx.fxml;


    opens ru.vasilev_s.vasilev_s_task5 to javafx.fxml;
    exports ru.vasilev_s.vasilev_s_task5;
}