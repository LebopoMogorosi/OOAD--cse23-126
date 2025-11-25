package bank.controller;

import javafx.scene.Scene;
import javafx.stage.Stage;
import bank.gui.LoginView;
import bank.gui.AccountView;
import bank.gui.CardView;

/**
 * DashboardController
 * -------------------
 * Handles navigation between major screens.
 */
public class DashboardController {
    private Stage stage;

    public DashboardController(Stage stage) {
        this.stage = stage;
    }

    public void goToAccounts() {
        // Implemented via button events in GUI
    }

    public void goToCards() {
        // Implemented via button events in GUI
    }

    public void logout() {
        LoginView lv = new LoginView(stage);
        Scene scene = new Scene(lv.getView(), 420, 520);
        scene.getStylesheets().add(getClass()
                .getResource("/bank/gui/Styles.css")
                .toExternalForm());

        stage.setScene(scene);
    }
}
