package viewForm.Controller;

import DAO.doDao;
import Model.customerModel;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import viewForm.Main;


import java.io.FileNotFoundException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Date;
import java.util.ResourceBundle;

public class mainController implements Initializable {


    @FXML
    private Label lbUserName;

    @FXML
    private BorderPane paneLoad;

    public void showInfomation(String name){
        Date date = new Date();
        lbUserName.setText("Xin chào: " + name + ", bây giờ là: " + date.getTime());
    }

    public void showCustomerPage(){
        pageLoad object = new pageLoad();
        Pane view = object.getPage("customerInf.fxml");
        paneLoad.setCenter(view);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
