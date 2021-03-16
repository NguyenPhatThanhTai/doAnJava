package viewForm.Controller;

import DAO.doDao;
import Model.customerModel;
import com.jfoenix.controls.JFXButton;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Date;
import java.util.ResourceBundle;

public class customerInfController implements Initializable {
    ObservableList<customerModel> listCustomer;
    int index = -1;
    Connection conn = null;
    ResultSet rs = null;
    PreparedStatement pst = null;

    @FXML
    private JFXButton btnTest;

    @FXML
    private TableColumn<customerModel, String> colCustomerId;

    @FXML
    private TableColumn<customerModel, String> colCustomerName;

    @FXML
    private TableColumn<customerModel, String> colCustomerSex;

    @FXML
    private TableColumn<customerModel, String> colCustomerBirth;

    @FXML
    private TableColumn<customerModel, String> colCustomerEmail;

    @FXML
    private TableColumn<customerModel, String> colCustomerPhone;

    @FXML
    private TableColumn<customerModel, String> colCustomerTimeAdd;

    @FXML
    private TableView<customerModel> tableListCustomer;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        doDao dao = new doDao();
        // khi load form sẽ hiển thị luôn
        colCustomerId.setCellValueFactory(new PropertyValueFactory<customerModel, String>("Customer_Id"));
        colCustomerName.setCellValueFactory(new PropertyValueFactory<customerModel, String>("Customer_Name"));
        colCustomerSex.setCellValueFactory(new PropertyValueFactory<customerModel, String>("Customer_Sex"));
        colCustomerBirth.setCellValueFactory(new PropertyValueFactory<customerModel, String>("Customer_Birth"));
        colCustomerEmail.setCellValueFactory(new PropertyValueFactory<customerModel, String>("Customer_Email"));
        colCustomerPhone.setCellValueFactory(new PropertyValueFactory<customerModel, String>("Customer_Phone"));
        colCustomerTimeAdd.setCellValueFactory(new PropertyValueFactory<customerModel, String>("Customer_TimeAdd"));

        listCustomer = dao.getAllCustomer();
        tableListCustomer.setItems(listCustomer);
    }

    public void test(){
        System.out.println("Ok");
    }
}
