package pl.sda.view;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import pl.sda.service.CurrentTimeService;

public class ChatController {
    @FXML
    private TextField messageTextField;
    @FXML
    private TextArea chatTextArea;
    private String name;

    private CurrentTimeService currentTimeService;

    public void initialize() {
        System.out.println("initialized");
    }

    public void sendBtnAction(ActionEvent actionEvent) {
        //TODO: Brzydko się to wyświetla, sformatuj datę w linijce poniżej tak, żeby wyświetlała się w formacie dzień.miesiąc.rok godzina:minuty:sekundy
        //TODO: spraw, żeby zamiast "TEST TEST TEST" wyświetlał się tutaj nick zalogowanego użytkownika
        chatTextArea.setText(chatTextArea.getText() + "\n" + currentTimeService.getCurrentTime() + this.name + ":" + messageTextField.getText());
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCurrentTimeService(CurrentTimeService currentTimeService) {
        this.currentTimeService = currentTimeService;
    }
}
