package viewForm.Controller;

import DAO.doDao;
import Model.customerModel;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXToggleButton;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;

import java.net.URL;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.ResourceBundle;

public class customerInfController implements Initializable {
    ObservableList<customerModel> listCustomer;
    int index = -1;
    Connection conn = null;
    ResultSet rs = null;
    PreparedStatement pst = null;

//    @FXML
//    private JFXComboBox txtGioiTinh;

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
    private TableColumn<customerModel, Date> colCustomerTimeAdd;

    @FXML
    private JFXButton btnTest;

    @FXML
    private TextField txtMaKhachHang;

    @FXML
    private JFXButton btnTest1;

    @FXML
    private JFXButton btnTest2;

    @FXML
    private JFXButton btnTest3;

    @FXML
    private TextField txtTenKhachHang;

    @FXML
    private JFXToggleButton txtGioiTinh;

    @FXML
    private TextField txtEmail;

    @FXML
    private TextField txtSoDienThoai;

    @FXML
    private TextField txtNgayThem;

    @FXML
    private DatePicker txtNgaySinh;


    @FXML
    private TableView<customerModel> tableListCustomer;

    public void loadData(){
        doDao dao = new doDao();
        // khi load form sẽ hiển thị luôn
        colCustomerId.setCellValueFactory(new PropertyValueFactory<customerModel, String>("Customer_Id"));
        colCustomerName.setCellValueFactory(new PropertyValueFactory<customerModel, String>("Customer_Name"));
        colCustomerSex.setCellValueFactory(new PropertyValueFactory<customerModel, String>("Customer_Sex"));
        colCustomerBirth.setCellValueFactory(new PropertyValueFactory<customerModel, String>("Customer_Birth"));
        colCustomerEmail.setCellValueFactory(new PropertyValueFactory<customerModel, String>("Customer_Email"));
        colCustomerPhone.setCellValueFactory(new PropertyValueFactory<customerModel, String>("Customer_Phone"));
        colCustomerTimeAdd.setCellValueFactory(new PropertyValueFactory<customerModel, Date>("Customer_TimeAdd"));

        listCustomer = dao.getAllCustomer();
        tableListCustomer.setItems(listCustomer);
    }

    public void getItemFromTableView(){
        tableListCustomer.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                customerModel cus = tableListCustomer.getItems().get(tableListCustomer.getSelectionModel().getSelectedIndex());
                txtMaKhachHang.setText(cus.getCustomer_Id());
                txtTenKhachHang.setText(cus.getCustomer_Name());
                if (cus.getCustomer_Sex().equals("Nam")){
                    txtGioiTinh.setSelected(true);
                }
                else {
                    txtGioiTinh.setSelected(false);
                }
                txtNgaySinh.setValue(LocalDate.parse(cus.getCustomer_Birth()));
                txtEmail.setText(cus.getCustomer_Email());
                txtSoDienThoai.setText(cus.getCustomer_Phone());
                txtNgayThem.setText(String.valueOf(cus.getCustomer_TimeAdd()));
            }
        });
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        loadData();
    }
}
