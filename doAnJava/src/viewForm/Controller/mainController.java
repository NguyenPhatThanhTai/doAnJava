package viewForm.Controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;


import java.net.URL;
import java.util.Date;
import java.util.ResourceBundle;

public class mainController implements Initializable {
    @FXML
    public Label lbUserName;

    public void showInfomation(String name){
        Date date = new Date();
        lbUserName.setText("Xin chào: " + name + " ,bây giờ là: " + date.getTime());
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        // khi load form sẽ hiển thị luôn
    }
}
