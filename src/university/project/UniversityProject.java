/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package university.project;

import java.sql.Connection;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import university.util.Database;

/**
 *
 * @author Lahiru
 */
public class UniversityProject extends Application {
    
    private Connection con;
    
    @Override
    public void start(Stage stage) throws Exception {
        
        
        
        Parent root = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
        
//        EventHandler<ActionEvent> registrationHandler = new EventHandler<ActionEvent>() {
//                @Override
//                public void handle(ActionEvent event) {
//                    System.out.println("=============================");
//                    event.consume();
//                }
//        };
//        
        
        
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
