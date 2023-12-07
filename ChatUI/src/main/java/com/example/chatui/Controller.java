package com.example.chatui;

import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;

public class Controller {
    @FXML
    private TextField SendTxtField;

    @FXML
    private ImageView sendButton;

    @FXML
    private ScrollPane sp_main;
    @FXML
    private VBox vboxMessages;

    @FXML
    void sendAction(MouseEvent mouseEvent) {
        if (!SendTxtField.getText().isBlank()) {
            String txt = SendTxtField.getText();
            Text text = new Text(SendTxtField.getText());
            text.setStyle("-fx-text-fill: white");
            TextFlow textFlow = new TextFlow(text);
            textFlow.setStyle(
                    "-fx-background-color: purple;" +
                            "-fx-background-radius: 20px;" + "-fx-font-family: 'Comic Sans MS'");
            textFlow.setPadding(new Insets(5, 10, 5, 10));
            HBox hBox = new HBox();
            hBox.setAlignment(Pos.CENTER_LEFT);
            hBox.setPadding(new Insets(5, 5, 5, 10));
            hBox.getChildren().add(textFlow);

            // Thêm HBox vào VBox
            vboxMessages.getChildren().add(hBox);

            // Đặt nội dung của VBox vào ScrollPane
            sp_main.setContent(vboxMessages);

            // Xóa nội dung của TextField sau khi gửi
            SendTxtField.clear();
        }
    }



}
