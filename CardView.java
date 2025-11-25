package bank.gui;

import bank.model.BankCard;
import bank.model.Customer;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

/**
 * CardView - shows cards and allows PIN verification & blocking.
 */
public class CardView {

    private VBox layout;
    private Stage stage;
    private Customer customer;
    private ListView<BankCard> cardList;

    public CardView(Stage stage, Customer customer) {
        this.stage = stage;
        this.customer = customer;

        layout = new VBox(12);
        layout.setPadding(new Insets(16));
        layout.setAlignment(Pos.TOP_CENTER);

        Label title = new Label(
                "Bank Cards for " + customer.getFirstName());
        title.getStyleClass().add("header");

        cardList = new ListView<>();
        ObservableList<BankCard> cards =
                FXCollections.observableArrayList(customer.getBankCards());
        cardList.setItems(cards);

        cardList.setCellFactory(list -> new ListCell<>() {
            @Override
            protected void updateItem(BankCard item, boolean empty) {
                super.updateItem(item, empty);
                if (empty || item == null)
                    setText(null);
                else
                    setText(item.toString());
            }
        });

        TextField pinField = new TextField();
        pinField.setPromptText("Enter PIN");

        Button verifyBtn = new Button("Verify PIN");
        Button blockBtn = new Button("Block");
        Button unblockBtn = new Button("Unblock");
        Button backBtn = new Button("Back");

        HBox actions = new HBox(10, pinField, verifyBtn, blockBtn, unblockBtn);
        actions.setAlignment(Pos.CENTER);

        verifyBtn.setOnAction(e -> {
            BankCard selected = cardList.getSelectionModel().getSelectedItem();
            if (selected == null) {
                show("Select a card first.");
                return;
            }
            boolean ok = selected.validatePin(pinField.getText());
            if (ok)
                show("PIN correct for " + selected.getMaskedNumber());
            else if (selected.isBlocked())
                show("Card is blocked.");
            else
                show("Incorrect PIN.");
        });

        blockBtn.setOnAction(e -> {
            BankCard selected = cardList.getSelectionModel().getSelectedItem();
            if (selected == null) { show("Select card first."); return; }
            selected.block();
            cardList.refresh();
        });

        unblockBtn.setOnAction(e -> {
            BankCard selected = cardList.getSelectionModel().getSelectedItem();
            if (selected == null) { show("Select card first."); return; }
            selected.unblock();
            cardList.refresh();
        });

        backBtn.setOnAction(e -> {
            DashboardView dv = new DashboardView(stage, customer);
            stage.setScene(new javafx.scene.Scene(dv.getView(), 900, 600));
            stage.getScene().getStylesheets().add(
                    getClass().getResource("Styles.css").toExternalForm());
        });

        layout.getChildren().addAll(title, cardList, actions, backBtn);
    }

    private void show(String msg) {
        new Alert(Alert.AlertType.INFORMATION, msg).showAndWait();
    }

    public VBox getView() {
        return layout;
    }
}
