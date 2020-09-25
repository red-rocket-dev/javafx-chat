package pl.sda.view;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import pl.sda.Main;

public class LoginController {
    @FXML
    public TextField loginTextField;

    public void initialize() {
        System.out.println("initialized");
    }

    public void loginBtnAction(ActionEvent actionEvent) {
        Main application = Main.getApplication();
        application.showChatStage();
        application.getChatController().setName("TEST TEST TEST");
    }
}
