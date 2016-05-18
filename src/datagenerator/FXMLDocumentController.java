/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datagenerator;

import java.io.*;
import java.net.URL;
import java.util.*;
import java.util.prefs.Preferences;

import javafx.collections.FXCollections;
import javafx.collections.ObservableArray;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import static java.lang.System.out;

/**
 *
 * @author matyasmarkos
 */
public class FXMLDocumentController implements Initializable {

    @FXML
    private TextField dataRoot, targetDir, timeStamp, referenz;
    @FXML
    private TextArea logArea;
    @FXML
    private ObservableList<String> affiliateSelection;
    @FXML
    private void handleButtonAction(ActionEvent event) {
        out.println("You clicked me!");
        System.out.println(Data.get("dataRoot"));
        String affiliate = affiliateSelection.get(1);
        System.out.println(affiliate);
 
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO

        try {
            //load parameters from file
            Properties prop = null;
            prop = loadProps();
            setData(prop);
            logArea.setEditable(false);
            logArea.setMouseTransparent(true);
            logArea.setFocusTraversable(false);
            setLogLine("Settings loaded.");

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
        //set data to Data class
        for (String key : prop.stringPropertyNames()){
            Data.set(key,prop.getProperty(key));
        }

        //set data to GUI objects
        dataRoot.setText(Data.get("dataRoot"));
        targetDir.setText(Data.get("targetDir"));
    }


    public static void saveData(String pFileName) throws IOException {
        Properties prop = new Properties();

        prop.setProperty("dataRoot", Data.get("dataRoot"));
        prop.setProperty("targetDir", Data.get("targetDir"));
        OutputStream out = new FileOutputStream(new File(pFileName));
        prop.store(out, "");
    }

    public void updateData(Event event) {
        TextField currentField = (TextField) event.getSource();
        String id = currentField.getId();
        Data.set(id,currentField.getText());
    }
    private void setLogLine(String logline) {
        String fullline = new Date().toString() + ": " + logline + "\n";
        Data.set("logArea", fullline);
        System.out.println(fullline);
        logArea.setText(Data.get("logArea"));

    }
}

