package com.example.pixelmessage;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;

import javafx.geometry.NodeOrientation;

import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

import javafx.stage.Stage;

import java.io.*;

import java.net.Socket;
import java.net.URL;
import java.util.ResourceBundle;

public class ClientChatController extends Thread  implements Initializable {

    @FXML
    private ImageView BgImage;

    @FXML
    private Button LogoutBtn;

    @FXML
    private Button SandBtn;

    @FXML
    private ImageView UserImage;

    @FXML
    private Label UserNameLabel;

    @FXML
    private TextField sendtextTextfield;


    @FXML
    private VBox TextVbox;

    @FXML
    private Pane ChatBox;

    @FXML
    private TextArea MsgRoom;

    @FXML
    private ScrollPane ChatScrollPane;

    private Socket User;

    BufferedReader reader;
    PrintWriter writer;

    @Override
    public void run() {

        try {

            while (true) {
                String msg = reader.readLine();
                String[] tokens = msg.split(" ");
                String cmd = tokens[0];
                System.out.println(cmd);
                StringBuilder fulmsg = new StringBuilder();
                for(int i = 1; i < tokens.length; i++) {
                    fulmsg.append(tokens[i]);
                }
                System.out.println(fulmsg);

                MsgRoom.appendText(msg + "\n");
            }
        } catch (IOException e) {

                e.printStackTrace();
                System.out.println("ERROR READING MESSAGE");
                ShutDown();
            }

        }

        void ShutDown(){

        try{
            reader.close();
            writer.close();
            User.close();


        } catch (IOException e){
            e.printStackTrace();
        }

        }


    @FXML
    void LogoutBtnAction(ActionEvent event) throws IOException {
        Stage LoginStage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("SignUpScene.fxml"));
        Scene loginScene = new Scene(root);
        LoginStage.setScene(loginScene);
        Image AppIcon = new Image(DataController.IconImage);
        LoginStage.getIcons().add(AppIcon);
        LoginStage.show();
        LoginStage.setTitle("PixaText");
        Stage stage = (Stage) LogoutBtn.getScene().getWindow();
        stage.close();
        DataController.imageSource = "";
        String Discon = UserNameLabel.getText()+" has Disconnected";
        writer.println(Discon);
        MsgRoom.setNodeOrientation(NodeOrientation.LEFT_TO_RIGHT);

    }


    @FXML
    void SandBtnAction(ActionEvent event) throws IOException  {


        String msg = UserNameLabel.getText()+": "+sendtextTextfield.getText();
        writer.println(msg);
        MsgRoom.setNodeOrientation(NodeOrientation.LEFT_TO_RIGHT);
       MsgRoom.appendText("(me)");
        sendtextTextfield.setText("");

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        UserImage.setImage(new Image(DataController.imageSource));
        UserNameLabel.setText(DataController.NewName);
        SocketConnect();
    }

    public  void SocketConnect(){
        try{
            User = new Socket("localhost", 1018);
            System.out.println("Client Connected to Socket");
            reader = new BufferedReader(new InputStreamReader(User.getInputStream()));
            writer = new PrintWriter(User.getOutputStream(), true);
            String Con = UserNameLabel.getText()+" has connected to the Server";
            writer.println(Con);

            this.start();



        }catch (IOException e){

            e.printStackTrace();
        }

    }
}
