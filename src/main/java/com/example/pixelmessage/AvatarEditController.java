package com.example.pixelmessage;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.Socket;
import java.net.URL;
import java.util.ResourceBundle;

public class AvatarEditController implements Initializable {


    @FXML
    private Button GoBackBtn;

    @FXML
    private ImageView Avatar1;

    @FXML
    private Label Avatar1Label;

    @FXML
    private ImageView Avatar2;

    @FXML
    private Label Avatar2Label;

    @FXML
    private ImageView Avatar3;

    @FXML
    private Label Avatar3Label;

    @FXML
    private ImageView Bgimage;

    @FXML
    private Button Confirmbtn;

    @FXML
    private Label SelectAvaterLabel;

    @FXML
    private Label WelcomeLabel;

    @FXML
    private AnchorPane Scene03;

    @FXML
    void Avatar1ClickAction(MouseEvent event) {

        Avatar1Label.setUnderline(true);
        Avatar3Label.setUnderline(false);
        Avatar2Label.setUnderline(false);
        DataController.imageSource="F:\\Jfile\\PixelMessage\\src\\a81de1888b96c5063359346724cb17f2.jpg";


    }

    @FXML
    void Avatar2ClickAction(MouseEvent event) {
        Avatar1Label.setUnderline(false);
        Avatar3Label.setUnderline(false);
        Avatar2Label.setUnderline(true);
        DataController.imageSource = "F:\\Jfile\\PixelMessage\\src\\cool_cats_pixel_art_by_islimed_df8ghv8-fullview.jpg";

    }

    @FXML
    void Avatar3ClickAction(MouseEvent event) {
        Avatar1Label.setUnderline(false);
        Avatar2Label.setUnderline(false);
        Avatar3Label.setUnderline(true);
        DataController.imageSource = "F:\\Jfile\\PixelMessage\\src\\de7fld8-e0ffeb16-cca0-4cc5-9aa5-b4f152f3101e.png";

    }

    @FXML
    void ConfirmBtnAction(ActionEvent event) throws IOException {
        try{Stage ChatStage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("ClientChat.fxml"));
        Scene ChatScene = new Scene(root);
        ChatStage.setScene(ChatScene);
        Image AppIcon = new Image(DataController.IconImage);

        ChatStage.getIcons().add(AppIcon);
        ChatStage.show();
        ChatStage.setTitle("PixaText");
        Stage stage =(Stage) Confirmbtn.getScene().getWindow();
        stage.close();}
        catch (Exception e){
            SelectAvaterLabel.setTextFill(Color.RED);
            SelectAvaterLabel.setText("YOU MUST SELECT AVATAR!!");
        }










    }
    @FXML
    void GoBackBtnAction(ActionEvent event) throws IOException {
        Stage LoginStage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("SignUpScene.fxml"));
        Scene loginScene = new Scene(root);
        LoginStage.setScene(loginScene);
        Image AppIcon = new Image(DataController.IconImage);
        LoginStage.getIcons().add(AppIcon);
        LoginStage.show();
        LoginStage.setTitle("PixaText");
        Stage stage =(Stage) GoBackBtn.getScene().getWindow();
        stage.close();


    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        WelcomeLabel.setText("WELCOME "+DataController.NewName);


    }
}

