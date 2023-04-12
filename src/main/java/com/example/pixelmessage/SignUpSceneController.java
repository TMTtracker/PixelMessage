package com.example.pixelmessage;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyCodeCombination;
import javafx.scene.input.KeyCombination;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

import java.io.*;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.Scanner;
import java.util.jar.Attributes;

public class SignUpSceneController implements Initializable {

    @FXML
    private ImageView BgImage;



    @FXML
    private Label LogoLabel;

    @FXML
    private Label NewNameLabel;

    @FXML
    private TextField NewNameTextField;

    @FXML
    private Label NewPassLabel;

    @FXML
    private PasswordField NewPassPassField;

    @FXML
    private AnchorPane Scene02;

    @FXML
    private Button SignUpbtn;
    @FXML
    private Label SignUpSuccesfulLabel;


    @FXML
    private Label VerifyLabel;
    @FXML
    private Button LoginBtn;





    String Filepath = "F:\\Jfile\\PixelMessage\\src\\UserInfo.txt";



    @FXML
    void SignUpBtnAction(ActionEvent event) throws IOException {


        DataController.NewName = NewNameTextField.getText();
        DataController.NewPass = NewPassPassField.getText();


        String Username = NewNameTextField.getText();
        String pass = NewPassPassField.getText();

        String Fullinfo = Username+","+pass;

        if((VerifySignup(Username,pass,Filepath))==true){

            VerifyLabel.setText("User Already Exists");
            NewNameTextField.clear();
            NewPassPassField.clear();

        }
        else {
            AppendText(Fullinfo);
            VerifyLabel.setText("NEW USER ADDED NOW PLEASE LOGIN");
            NewNameTextField.clear();
            NewPassPassField.clear();

        }

    }








    public void AppendText(String fullInfo){


        try {



            FileWriter WRT = new FileWriter(Filepath,true);

            WRT.write(fullInfo+"\n");



            WRT.close();



        }catch(IOException e){

            e.printStackTrace();
            System.out.println("Error Writing File");
        }



    }


    private static Scanner x;
    public boolean VerifySignup(String Username, String pass, String FilePath){


        String tempUsername="";
        String tempPassWord="";
        boolean found = false;

        try{


            x = new Scanner(new File(FilePath));
            x.useDelimiter("[,\n]");

            while(x.hasNext()&& !found){

                tempUsername = x.next();
                tempPassWord = x.next();

                if(tempUsername.trim().equals(Username.trim())&& tempPassWord.trim().equals(pass.trim())){

                    found =true;
                }
            }







        }catch(Exception e){
            e.printStackTrace();
            System.out.println("error reading File");


        }




    return found; }


    @FXML
    void LoginBtnAction(ActionEvent event) throws IOException {

        DataController.NewName = NewNameTextField.getText();
        DataController.NewPass = NewPassPassField.getText();

        String Username = NewNameTextField.getText();
        String pass = NewPassPassField.getText();


        if((VerifySignup(Username,pass,Filepath)==true)){

            Stage NextStage = new Stage();
            Parent root = FXMLLoader.load(getClass().getResource("AvatarEdit.fxml"));
            Scene Scene03 = new Scene(root);
            NextStage.setScene(Scene03);
            Image AppIcon = new Image(DataController.IconImage);
            NextStage.getIcons().add(AppIcon);
            NextStage.show();
            NextStage.setTitle("PixaText");
            Stage stage = (Stage) LoginBtn.getScene().getWindow();
            stage.close();



        } else {
            VerifyLabel.setText("User Does Not Exist!");
            NewNameTextField.clear();
            NewPassPassField.clear();
        }



    }





    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        VerifyLabel.setText("");

    }
}


/*DataController.NewName = NewNameTextField.getText();
        DataController.NewPass = NewPassPassField.getText();

        String Username = NewNameLabel.getText();
        String pass = NewPassPassField.getText();

        String Fullinfo = Username+","+pass;
        AppendText(Fullinfo);*/


        /*if((VerifySignup(name,pass,Filepath)==true)){

                Stage NextStage = new Stage();
                Parent root = FXMLLoader.load(getClass().getResource("AvatarEdit.fxml"));
                Scene Scene03 = new Scene(root);
                NextStage.setScene(Scene03);
                Image AppIcon = new Image(DataController.IconImage);
                NextStage.getIcons().add(AppIcon);
                NextStage.show();
                NextStage.setTitle("PixaText");
                Stage stage = (Stage) SignUpbtn.getScene().getWindow();
                stage.close();



                }
















                else {
                VerifyLabel.setText("SIGNUP FAILED!!");
                }*/






















