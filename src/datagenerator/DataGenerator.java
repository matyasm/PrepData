package datagenerator;

import java.io.File;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author matyasmarkos
 */
public class DataGenerator extends Application {
    
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
        

        Scene scene = new Scene(root);
        
        stage.setScene(scene);
        stage.show();
        
        //load parameters from file
        File inFile = new File("settings.properties");
        
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {  //first class called
        launch(args);  //set up program as a javafx application, then calls start
    }
    
}
