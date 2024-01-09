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

public class DrzavaController {
    public TextField naziv;
    public ChoiceBox<Grad> izborGrad;
    public Button btnOk;
    public Button btnCan;
    public Drzava drzava = null;
    GeografijaDAO dao = GeografijaDAO.getInstance();
    private ArrayList<Grad> gradoviDAO = dao.gradovi();
    private ObservableList<Grad> gradovi = FXCollections.observableList(gradoviDAO);
    public DrzavaController(Drzava drzava, ArrayList<Grad> gradovi) {
        this.drzava = drzava;
        this.gradoviDAO = gradovi;
    }

    @FXML
    public void initialize() {
        izborGrad.setItems(gradovi);
        izborGrad.getSelectionModel().selectFirst();
        naziv.getStyleClass().add("prazno");

        naziv.textProperty().addListener((obs, oldNaziv, newNaziv) -> {
            if (!newNaziv.trim().isEmpty()) {
                naziv.getStyleClass().removeAll("prazno");
                naziv.getStyleClass().add("popunjeno");
            } else {
                naziv.getStyleClass().removeAll("popunjeno");
                naziv.getStyleClass().add("prazno");
            }
        });
    }

    public void CancelAction(ActionEvent actionEvent) {
        Stage stage = (Stage) btnCan.getScene().getWindow();
        stage.close();
    }

    public void btnOkAction(ActionEvent actionEvent) {
        if (!naziv.getText().trim().isEmpty() && drzava == null) {
            Drzava nova = new Drzava();
            drzava = nova;
            drzava.setNaziv(naziv.getText());
            drzava.setGlavniGrad(izborGrad.getSelectionModel().getSelectedItem());
            int id = dao.IDDrzave();
            drzava.setId(id);
        }

        if (!naziv.getText().trim().isEmpty()) {
            Stage stage = (Stage) btnOk.getScene().getWindow();
            stage.close();
        }
    }

    public Drzava getDrzavu() {
        return drzava;
    }
}