package bank.gui;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

/**
 * LoginView
 * ----------
 * Displays username/password fields.
 * On login button click, navigates to DASHBOARD
 */
public class LoginView {

    private VBox layout;
    private Stage stage;

    public LoginView(Stage stage) {
        this.stage = stage;
        layout = new VBox(15);
        layout.setAlignment(Pos.CENTER);
        layout.setPadding(new Insets(30));

        Label title = new Label("Welcome to Smart Banking");
        title.getStyleClass().add("title");

        TextField username = new TextField();
        username.setPromptText("Username");

        PasswordField password = new PasswordField();
        password.setPromptText("Password");

        Button loginBtn = new Button("Login");
        loginBtn.getStyleClass().add("primary-btn");

        // Temporary navigation only
        loginBtn.setOnAction(e -> {
            DashboardView dash = new DashboardView(stage);
            Scene scene = new Scene(dash.getView(), 800, 600);
            scene.getStylesheets().add(getClass().getResource("Styles.css").toExternalForm());
            stage.setScene(scene);
        });

        layout.getChildren().addAll(title, username, password, loginBtn);
    }

    public VBox getView() {
        return layout;
    }
}
