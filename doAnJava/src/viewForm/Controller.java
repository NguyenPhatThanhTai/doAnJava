package viewForm;

import DAO.doDao;
import com.sun.jnlp.ApiDialog;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import javafx.scene.control.Alert;
import javafx.scene.control.TextField;

import javax.swing.*;
import java.net.URL;
import java.util.ResourceBundle;

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
            }
            else {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setHeaderText("Sai mật khẩu hoặc tài khoản!");
                alert.showAndWait();
            }
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
