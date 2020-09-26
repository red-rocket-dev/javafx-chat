package pl.sda;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import pl.sda.service.CurrentTimeService;
import pl.sda.util.EntityManagerUtil;
import pl.sda.view.ChatController;
import pl.sda.view.LoginController;

public class Main extends Application {

    private static Main application;
    private Stage chatStage;
    private Stage loginStage;
    private Stage currentStage;
    private LoginController loginController;
    private ChatController chatController;

    @Override
    public void start(Stage stage) throws Exception {
        // to EntityManagerUtil.get() można wywalić, jest tylko na potrzeby sprawdzenia czy dziala Ci baza danych
        EntityManagerUtil.get();
        application = this;
        stage.close();
        // zamiast wczytywac stage dopiero wtedy kiedy ich potrzebujemy robimy to na samym poczatku
        // zeby uniknac dlugich czasow ladowania przy przelaczaniu ekranow
        loadStages();

        //tutaj tworz serwisy i ustaw/przekaz je tam gdzie potrzebujesz
        CurrentTimeService currentTimeService = new CurrentTimeService();
        this.chatController.setCurrentTimeService(currentTimeService);


        //tutaj pokazywanie pierwszego stage
        loginStage.show();
        currentStage = loginStage;
    }

    private void loadStages() throws java.io.IOException {
        FXMLLoader loginStageLoader = new FXMLLoader(getClass().getClassLoader().getResource("login.fxml"));
        this.loginStage = loginStageLoader.load();
        this.loginController = loginStageLoader.getController();
        FXMLLoader chatStageLoader = new FXMLLoader(getClass().getClassLoader().getResource("chat.fxml"));
        this.chatStage = chatStageLoader.load();
        this.chatController = chatStageLoader.getController();


    }

    public void showChatStage() {
        currentStage.close();
        chatStage.show();
    }

    public static Main getApplication() {
        return application;
    }

    public static void main(String[] args) {
        launch(args);
    }

    public LoginController getLoginController() {
        return loginController;
    }

    public ChatController getChatController() {
        return chatController;
    }
}
