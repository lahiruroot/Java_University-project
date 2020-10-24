
 package university.project; 

import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.layout.Region;
import university.util.Database;

public class FXMLDocumentController {

    @FXML
    private Label label;

    @FXML
    private JFXTextField txtusername;

    @FXML
    private JFXPasswordField txtpasswd;

    @FXML
    private JFXTextField txtaid;

    @FXML
    private JFXTextField txtaname;

    @FXML
    private JFXPasswordField txtpass;

    @FXML
    private JFXPasswordField txtrepass;
    
    @FXML
    private void registerAdmin(ActionEvent event) {
        
        Connection con = Database.openConnection();
        
        String adminID = txtaid.getText();
        String name = txtaname.getText();
        String password  = txtpass.getText();
        String repassword  = txtrepass.getText();
        
        if(adminID.isEmpty() || name.isEmpty() || password.isEmpty() || repassword.isEmpty()) {
            error("All feilds required to register a new admin!");
        } else if(!password.equals(repassword)) {
            error("Passwords doesn't match!");
        } else {
            try {
                PreparedStatement s = con.prepareStatement("SELECT * FROM admin WHERE admin_id=?");
                s.setString(1, adminID);
                ResultSet rs = s.executeQuery();
                if(rs.first()) {
                    error("Admin already exists!");
                } else {
                    PreparedStatement s1 = con.prepareStatement("INSERT INTO admin VALUES(?,?,?)");
                    s1.setString(1, adminID);
                    s1.setString(2, name);
                    s1.setString(3, password);
                    if(s1.executeUpdate() == 1) {
                        info("Registration Success!");
                        clear();
                    } else {
                        error("Failed to register a new admin. Try again!");
                    }
                }
            } catch (SQLException ex) {
                Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
                error(ex.getMessage());
            }
        }
    }
    
    private void error(String message) {
        Alert alert = new Alert(AlertType.ERROR,message, ButtonType.OK);
        alert.getDialogPane().setMinHeight(Region.USE_PREF_SIZE);
        alert.show();
    }
    
    private void info(String message) {
        Alert alert = new Alert(AlertType.INFORMATION,message, ButtonType.OK);
        alert.getDialogPane().setMinHeight(Region.USE_PREF_SIZE);
        alert.show();
    }
    
    private void clear() {
        txtaid.setText("");
        txtaname.setText("");
        txtpass.setText("");
        txtrepass.setText("");
    }
    
//    Stage stage = (Stage) closeButton.getScene().getWindow();
//    // do what you have to do
//    stage.close();

}
