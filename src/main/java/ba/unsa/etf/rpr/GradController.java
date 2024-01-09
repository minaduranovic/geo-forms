package ba.unsa.etf.rpr;


import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.util.ArrayList;

public class GradController {
    public TextField fieldNaziv;
    public Button btnOk;
    public Button btnCan;
    public TextField fieldBrStanovnika;
    public ChoiceBox<Drzava> choiceDrzava;
    public Grad grad = null;
    GeografijaDAO dao = GeografijaDAO.getInstance();
    private ArrayList<Grad> gradoviDAO = dao.gradovi();
    private ObservableList<Grad> gradoviList;
    private ArrayList<Drzava> drzaveDAO = dao.drzave();
    private ObservableList<Drzava> drzaveList = FXCollections.observableList(drzaveDAO);

    public GradController(Grad grad, ArrayList<Drzava> drzave) {
        this.grad = grad;
        drzaveDAO = drzave;
    }

    public GradController() {
        drzaveList = FXCollections.observableList(drzaveDAO);
    }

    @FXML
    public void initialize() {
        choiceDrzava.setItems(drzaveList);
        choiceDrzava.getSelectionModel().selectFirst();
        fieldNaziv.getStyleClass().add("prazno");
        fieldBrStanovnika.getStyleClass().add("prazno");
        fieldNaziv.textProperty().addListener((obs, oldNaziv, newNaziv) -> {
            if (!newNaziv.trim().isEmpty()) {
                fieldNaziv.getStyleClass().removeAll("prazno");
                fieldNaziv.getStyleClass().add("popunjeno");
            } else {
                fieldNaziv.getStyleClass().removeAll("popunjeno");
                fieldNaziv.getStyleClass().add("prazno");
            }
        });

        fieldBrStanovnika.textProperty().addListener((obs, oldBroj, newBroj) -> {
            int broj = 0;

            try {
                broj = Integer.parseInt(newBroj);
            } catch (NumberFormatException e) {
                e.printStackTrace();
            }
            if (!newBroj.trim().isEmpty() && broj > 0) {
                fieldBrStanovnika.getStyleClass().removeAll("prazno");
                fieldBrStanovnika.getStyleClass().add("popunjeno");
            } else {
                fieldBrStanovnika.getStyleClass().removeAll("popunjeno");
                fieldBrStanovnika.getStyleClass().add("prazno");
            }
        });

    }

    public void zatvaranjeProzor(ActionEvent actionEvent) {
        Stage stage = (Stage) btnCan.getScene().getWindow();
        stage.close();
    }

    public Grad getGrad() {
        return grad;
    }

    public void btnOkAction(ActionEvent actionEvent) {
        String naziv = "";
        int brojStanovnika = 0;
        String nazivDrzave = "";

        if (!fieldNaziv.getText().isEmpty())
            naziv = fieldNaziv.getText();

        int broj = 0;
        try {
            broj = Integer.parseInt(fieldBrStanovnika.getText());
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }

        if (!fieldBrStanovnika.getText().trim().isEmpty() && broj > 0)
            brojStanovnika = broj;
        if (!fieldNaziv.getText().isEmpty() && !fieldBrStanovnika.getText().isEmpty() && broj > 0 && grad == null) {
            Grad novi = new Grad();
            grad = novi;
            grad.setNaziv(naziv);
            grad.setBrojStanovnika(brojStanovnika);
            grad.setDrzava(choiceDrzava.getSelectionModel().getSelectedItem());
            int id = dao.IDGrada();
            grad.setId(id);
        }
        if (!fieldNaziv.getText().isEmpty() && !fieldBrStanovnika.getText().isEmpty() && broj > 0) {
            Stage stage = (Stage) btnOk.getScene().getWindow();
            stage.close();
        }
    }
}
