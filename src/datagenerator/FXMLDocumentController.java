/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datagenerator;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.util.Properties;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import static java.lang.System.out;

/**
 *
 * @author matyasmarkos
 */
public class FXMLDocumentController implements Initializable {
    
    @FXML
    private Label label;
    @FXML
    private TextField dataRoot, targetDir;
    //private Label timestampLabel;
    
    @FXML
    private void handleButtonAction(ActionEvent event) {
        out.println("You clicked me!");
        label.setText("Hello World!");
        //timestampLabel.setText("logContent");
 
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO

        try {
            //load parameters from file
            Properties prop = null;
            prop = loadProps();
            setData(prop);
        } catch (Exception e) {
            out.println(e.toString());
        }

    }
    public static Properties loadProps() throws IOException {
        Properties prop = new Properties();
        String pFileName = "settings.properties";
        File propFile = new File(pFileName);
        FileInputStream propFileIn = new FileInputStream(propFile);
        prop.load(propFileIn);
        return prop;
    }

    public void setData(Properties prop){
        System.out.println(prop.toString());
        dataRoot.setText(prop.getProperty("dataRoot"));
        targetDir.setText(prop.getProperty("targetDir"));

    }


    
}
