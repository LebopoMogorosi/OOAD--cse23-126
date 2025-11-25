package bank.gui;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.stage.Stage;

/**
 * DashboardView
 * --------------
 * Acts as a main menu after login.
 * Provides buttons to navigate to AccountView and other features.
 */
public class DashboardView {

    private BorderPane layout;
    private Stage stage;

    public DashboardView(Stage stage) {
        this.stage = stage;
        layout = new BorderPane();

        Label header = new Label("Smart Banking Dashboard");
        header.getStyleClass().add("header");
        BorderPane.setAlignment(header, Pos.CENTER);
        layout.setTop(header);
        BorderPane.setMargin(header, new Insets(10));

        VBox menu = new VBox(15);
        menu.setAlignment(Pos.CENTER);
        menu.setPadding(new Insets(20));

        Button accountsBtn = new Button("View Accounts");
        Button logoutBtn = new Button("Logout");

        accountsBtn.getStyleClass().add("primary-btn");
        logoutBtn.getStyleClass().add("secondary-btn");

        accountsBtn.setOnAction(e -> {
            AccountView av = new AccountView(stage);
            Scene scene = new Scene(av.getView(), 800, 600);
            scene.getStylesheets().add(getClass().getResource("Styles.css").toExternalForm());
            stage.setScene(scene);
        });

        logoutBtn.setOnAction(e -> {
            LoginView lv = new LoginView(stage);
            Scene scene = new Scene(lv.getView(), 420, 520);
            scene.getStylesheets().add(getClass().getResource("Styles.css").toExternalForm());
            stage.setScene(scene);
        });

        menu.getChildren().addAll(accountsBtn, logoutBtn);
        layout.setCenter(menu);
    }

    public BorderPane getView() {
        return layout;
    }
}
