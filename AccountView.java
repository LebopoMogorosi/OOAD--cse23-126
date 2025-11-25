package bank.gui;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

/**
 * AccountView
 * ------------
 * Displays account info, deposits, withdrawals, transactions.
 * Currently uses placeholder data; logic added in next phase.
 */
public class AccountView {

    private VBox layout;
    private Stage stage;

    public AccountView(Stage stage) {
        this.stage = stage;
        layout = new VBox(15);
        layout.setAlignment(Pos.CENTER);
        layout.setPadding(new Insets(20));

        Label title = new Label("Account Overview");
        title.getStyleClass().add("header");

        TableView<String> transactionTable = new TableView<>();
        transactionTable.setPlaceholder(new Label("No transactions yet"));

        Button backBtn = new Button("Back");
        backBtn.getStyleClass().add("secondary-btn");
        backBtn.setOnAction(e -> {
            DashboardView dash = new DashboardView(stage);
            Scene scene = new Scene(dash.getView(), 800, 600);
            scene.getStylesheets().add(getClass().getResource("Styles.css").toExternalForm());
            stage.setScene(scene);
        });

        layout.getChildren().addAll(title, transactionTable, backBtn);
    }

    public VBox getView() {
        return layout;
    }
}
