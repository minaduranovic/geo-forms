package ba.unsa.etf.rpr;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class GlavnaController {
    @FXML
    public TableView tableViewGradovi;
    @FXML
    public TableColumn colGradId;
    @FXML
    public TableColumn colGradNaziv;
    @FXML
    public TableColumn colGradStanovnika;
    @FXML
    public TableColumn colGradDrzava;
    @FXML
    public Button btnDodajGrad;
    @FXML
    public Button btnObrisiGrad;
    @FXML
    public Button btnIzmijeniGrad;
    @FXML
    public Button btnDodajDrzavu;
}
