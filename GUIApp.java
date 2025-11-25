package bank.gui;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * Launches the JavaFX GUI.
 * - Acts as entry point (Boundary layer)
 * - No business logic here
 */
public class GUIApp extends Application {

    @Override
    public void start(Stage primaryStage) {
        LoginView loginView = new LoginView(primaryStage);
        Scene scene = new Scene(loginView.getView(), 420, 520);
        scene.getStylesheets().add(getClass().getResource("Styles.css").toExternalForm());
        primaryStage.setTitle("Smart Banking System");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
