package com.jasypt.jasypt;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import org.jasypt.exceptions.EncryptionOperationNotPossibleException;

public class HelloController {
    @FXML
    private Label labelEncryptKey;
    @FXML
    private TextField encryptKey;
    @FXML
    private TextField input;
    @FXML
    private TextField result;
    @FXML
    private Button encryptButton;
    @FXML
    private Button decryptButton;

    @FXML
    private TextField input2;
    @FXML
    private TextField result2;
    @FXML
    private Button clearButton;
    @FXML
    private Button changeEncrypt;
    @FXML
    private TextArea resultArea;
    @FXML
    private TextArea resultArea2;

    @FXML
    protected void onEncryptButtonClick(){
        try {
            resultArea.setText(JasyptUtil.getInstance().encrypt(input.getText()));
        } catch (Exception e) {
            System.out.println("Exception caught in task!");
            Platform.runLater(() -> {
                Alert dialog = new Alert(Alert.AlertType.WARNING, "Wrong Encrypt Key", ButtonType.OK);
                dialog.show();
            });
        }
    }

    @FXML
    private void initialize() {
        encryptKey.setText(JasyptUtil.getInstance().getEncryptKey());
        changeLabelEncrypt();
        clearButton.setStyle("-fx-background-color: #bb2124; -fx-text-fill: #ffffff;");
        encryptButton.setStyle("-fx-background-color: #457ecd; -fx-text-fill: #ffffff;");
        decryptButton.setStyle("-fx-background-color: #457ecd; -fx-text-fill: #ffffff;");
    }


    public void onDecryptButtonClick(ActionEvent actionEvent) throws EncryptionOperationNotPossibleException {
        try{
            resultArea2.setText(JasyptUtil.getInstance().decrypt(input2.getText()));
        } catch (Exception e) {
            System.out.println("Exception caught in task!");
            Platform.runLater(() -> {
                Alert dialog = new Alert(Alert.AlertType.WARNING, "Wrong Encrypt Key", ButtonType.OK);
                dialog.show();
            });
        }
    }

    public void onClear(ActionEvent actionEvent) {
        input.clear();
        resultArea.clear();
        input2.clear();
        resultArea2.clear();
    }

    public void onChangeEncrypt(ActionEvent actionEvent){
        JasyptUtil.getInstance().changeEncryptKey(encryptKey.getText());
        changeLabelEncrypt();
    }

    private void changeLabelEncrypt(){
        labelEncryptKey.setText("Encrypt Key: "+JasyptUtil.getInstance().getEncryptKey());
    }
}