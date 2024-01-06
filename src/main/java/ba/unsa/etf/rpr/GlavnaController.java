package ba.unsa.etf.rpr;

<<<<<<< HEAD
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.List;

public class GlavnaController {
    @FXML
    public TableView<Grad> tableViewGradovi;
=======
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class GlavnaController {
    @FXML
    public TableView tableViewGradovi;
>>>>>>> origin/master
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
<<<<<<< HEAD

    private ObservableList<Grad> gradovi= FXCollections.observableArrayList();
    private GeografijaDAO geo= GeografijaDAO.getInstance();

public void initialize(){
    List<Grad> temp = geo.gradovi();
    for(Grad g : temp){
        gradovi.add(new Grad(g.getId(), g.getIme(),g.getBrojStanovnika(), g.getDrzava()));
    }
    tableViewGradovi.setItems(gradovi);
}
public void refreshingTVgradovi(){
    List<Grad> temp= geo.gradovi();
    ObservableList<Grad> novi=FXCollections.observableArrayList();
    for(Grad g : temp){
        novi.add(new Grad(g.getId(), g.getIme(),g.getBrojStanovnika(), g.getDrzava()));
    }
    tableViewGradovi.setItems(novi);
    gradovi = novi;
}

    public void onBtnDodajGrad() {
        try{
            FXMLLoader fxmlLoader = new FXMLLoader(GeoApp.class.getResource("grad.fxml"));
            GradController gradCont = new GradController(geo, this);
            gradCont.setDodaj(true);
            fxmlLoader.setController(gradCont);
            Scene scene = new Scene(fxmlLoader.load(), 400, 200);
            Stage stage = new Stage();
            stage.setTitle("Grad");
            stage.setScene(scene);
            stage.show();
        }
        catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void onBtnObrisiGrad() {
        try{
            FXMLLoader fxmlLoader = new FXMLLoader(GeoApp.class.getResource("grad.fxml"));
            GradController gradCont = new GradController(geo, this);
            gradCont.setObrisi(true);
            fxmlLoader.setController(gradCont);
            Scene scene = new Scene(fxmlLoader.load(), 400, 200);
            Stage stage = new Stage();
            stage.setTitle("Grad");
            stage.setScene(scene);
            stage.show();
        }
        catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    public void onBtnDodajDrzavu() {
        try{
            FXMLLoader fxmlLoader = new FXMLLoader(GeoApp.class.getResource("drzava.fxml"));
            DrzavaController drzavaCont = new DrzavaController(geo, this);
            drzavaCont.setDodaj(true);
            fxmlLoader.setController(drzavaCont);
            Scene scene = new Scene(fxmlLoader.load(), 300, 200);
            Stage stage = new Stage();
            stage.setTitle("Drzava");
            stage.setScene(scene);
            stage.show();
        }
        catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void onBtnIzmijeniGrad() {
        try{
            FXMLLoader fxmlLoader = new FXMLLoader(GeoApp.class.getResource("grad.fxml"));
            GradController gradCont = new GradController(geo, this);
            gradCont.setIzmijeni(true);
            fxmlLoader.setController(gradCont);
            Scene scene = new Scene(fxmlLoader.load(), 400, 200);
            Stage stage = new Stage();
            stage.setTitle("Grad");
            stage.setScene(scene);
            stage.show();
        }
        catch (IOException e) {
            throw new RuntimeException(e);
        }
=======
>>>>>>> origin/master
}
