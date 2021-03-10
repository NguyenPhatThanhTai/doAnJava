package viewForm.Controller;

import DAO.doDao;
import com.sun.jnlp.ApiDialog;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;

import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import javax.swing.*;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Controller implements Initializable {
    @FXML
    public TextField txtTaiKhoan;
    @FXML
    public TextField txtMatKhau;
    public void DangNhap(ActionEvent e){
        if (txtTaiKhoan.getText().equals("") && txtMatKhau.getText().equals("")){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText("Không được để trống!");
            alert.showAndWait();
        }else {
            doDao dao = new doDao();
            if(dao.checkLogin(txtTaiKhoan.getText(), txtMatKhau.getText())){
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setHeaderText("Đăng nhập thành công!");
                alert.showAndWait();

                try {
                    FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../View/Main.fxml"));
                    Parent root1 = (Parent) fxmlLoader.load();
                    Stage stage = new Stage();
                    stage.setTitle("Main form");
                    stage.setScene(new Scene(root1));
                    stage.show();
                    ((Node)(e.getSource())).getScene().getWindow().hide();
                } catch (Exception ioException) {
                    ioException.printStackTrace();
                }
            }
            else {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setHeaderText("Sai mật khẩu hoặc tài khoản!");
                alert.showAndWait();
            }
        }
    }

    public void openNewWindows(ActionEvent e){
        txtTaiKhoan.setText("");
        txtMatKhau.setText("");
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
