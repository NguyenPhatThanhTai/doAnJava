package viewForm.Controller;

import DAO.doDao;
import Model.customerModel;
import com.jfoenix.controls.JFXButton;
import javafx.application.Platform;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import viewForm.Main;


import java.io.FileNotFoundException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Optional;
import java.util.ResourceBundle;

public class mainController implements Initializable {


    @FXML
    private Label lbUserName;

    @FXML
    private BorderPane paneLoad;

    @FXML
    private JFXButton btnMinimized;

    public void showInfomation(String name){
        SimpleDateFormat formatter= new SimpleDateFormat("HH:mm 'ngày' dd-MM-yyyy ");
        Date date = new Date(System.currentTimeMillis());
        System.out.println(formatter.format(date));
        lbUserName.setText("Xin chào: " + name + ", bây giờ là: " + formatter.format(date));
    }

    public void showCustomerPage(){
//        pageLoad object = new pageLoad();
//        Pane view = object.getPage("customerInf.fxml");
//        paneLoad.setCenter(view);
        new Thread(()->{
                Platform.runLater(()->{
                    pageLoad object = new pageLoad();
                    Pane view = object.getPage("customerInf.fxml");
                    paneLoad.setCenter(view);
                });
            try {
                Thread.sleep(60);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start(); 
    }

    public void Quit(){
        ButtonType foo = new ButtonType("Ok tôi thoát", ButtonBar.ButtonData.OK_DONE);
        ButtonType bar = new ButtonType("Không tôi nhấn nhầm", ButtonBar.ButtonData.CANCEL_CLOSE);
        Alert alert = new Alert(Alert.AlertType.WARNING,
                "Bạn có chắc chắn muốn thoát",
                foo, bar);

        alert.setTitle("Xác nhận thoát chương trình");
        Optional<ButtonType> result = alert.showAndWait();

        if (result.orElse(bar) == foo) {
            System.exit(1);
        }
    }

    public void Minimized(){
        btnMinimized.setOnMouseClicked( event -> {
            Stage obj = (Stage) btnMinimized.getScene().getWindow();
            obj.setIconified(true);
        });
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
