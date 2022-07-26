package fr.afpa.tumulte.controllers;

import fr.afpa.tumulte.app.App;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;

/**
 * The type Controller emprunt livre.
 */
public class ControllerEmpruntLivre implements Initializable {

    /**
     * Bouton annuler.
     */
    @FXML
    private Button btnAnnuler;

    /**
     * Bouton emprunter.
     */
    @FXML
    private Button btnEmprunter;

    /**
     * Bouton Menu Principal.
     */
    @FXML
    private Button btnMenuPrincipal;

    /**
     * Bouton rechercher Livre.
     */
    @FXML
    private Button btnRechercherLivre;

    /**
     * Label de l'auteur.
     */
    @FXML
    private Label lblAuteur;

    /**
     * Label de disponibilité du livre.
     */
    @FXML
    private Label lblDisponible;

    /**
     * Label de l'emplacement du livre.
     */
    @FXML
    private Label lblEmplacement;

    /**
     * Label de l'état du livre.
     */
    @FXML
    private Label lblEtat;

    /**
     * Label de l'ISBN.
     */
    @FXML
    private Label lblISBN;

    /**
     * Label de l'ISSN.
     */
    @FXML
    private Label lblISSN;

    /**
     * Label indiquant le nom de l'adhérent.
     */
    @FXML
    private Label lblNomAdherent;

    /**
     * Label indiquant le numéro de l'adhérent.
     */
    @FXML
    private Label lblNumAdherent;

    /**
     * Label indiquant le prénom de l'adhérent.
     */
    @FXML
    private Label lblPrenomAdherent;

    /**
     * Label indiquant le thème du livre.
     */
    @FXML
    private Label lblTheme;

    /**
     * Label indiquant le titre du livre.
     */
    @FXML
    private Label lblTitreExemplaire;

    /**
     * Label indiquant le code de l'exemplaire.
     */
    @FXML
    private TextField txtCodeExemplaire;

    /**
     * Barre de menu.
     */
    @FXML
    private MenuBar menuBar;
    @FXML
    private Label lblDate;
    @FXML
    private MenuItem menuEmprunt;
    @FXML
    private Label lblRole;
    @FXML
    private MenuItem itmAbout;

    /**
     * Annuler.
     */
    @FXML
    void annuler() {
        effacer();
    }

    /**
     * Emprunter livre.
     */
    @FXML
    void emprunterLivre() {
        confEmpruntLivre();
        effacer();
    }

    /**
     * Rechercher livre.
     */
    @FXML
    void rechercherLivre() {
        afficherLabels();

    }

    /**
     * Retour menu principal.
     */
    @FXML
    void retourMenuPrincipal() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(
                App.class.getResource("/fxml/menuPrincipal.fxml"));
        Stage stage = (Stage) (menuBar.getScene().getWindow());
        Scene scene = new Scene(fxmlLoader.load());
        scene.getStylesheets().add(getClass().getResource("/css/style.css").toExternalForm());
        stage.setTitle("Menu principal");
        stage.setScene(scene);
        stage.show();
    }

    /**
     * Activer btn rechercher.
     */
    @FXML
    void activerBtnRechercher() {
        btnRechercherLivre.setDisable(codeExemplaireIsEmpty());
    }

    /**
     * Désactive le btn rechercher à l'initialisation.
     */
    @Override
    public void initialize(final URL url, final ResourceBundle resourceBundle) {
        init();
    }

    private void init() {
        btnRechercherLivre.setDisable(true);
        DateTimeFormatter frformat = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        lblDate.setText(LocalDate.now().format(frformat));

    }

    /**
     * Affiche les valeurs du livre lors du click sur
     * le bouton rechercher.
     */
    private void afficherLabels() {
        lblTitreExemplaire.setText("JavaFX pour les nuls");
        lblAuteur.setText("Doug Lowe");
        lblTheme.setText("Autre");
        lblEtat.setText("Neuf");
        lblDisponible.setText("Oui");
        lblISBN.setText("978-1-118-38534-0");
        lblISSN.setText("NC");
        lblEmplacement.setText("B1");

    }

    private void effacer() {
        txtCodeExemplaire.setText("");
        lblTitreExemplaire.setText("");
        lblAuteur.setText("");
        lblTheme.setText("");
        lblEtat.setText("");
        lblDisponible.setText("");
        lblISBN.setText("");
        lblISSN.setText("");
        lblEmplacement.setText("");
    }

    private void confEmpruntLivre() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Confirmation");
        alert.setHeaderText("Le livre est emprunté.");
        alert.setContentText("Le Livre JavaFX pour les nuls est emprunté\r"
                + "Vous pouvez passer au suivant ou quitter");
        alert.showAndWait();
    }

    private boolean codeExemplaireIsEmpty() {
        return txtCodeExemplaire.getLength() == 0;
    }

    @FXML
    void openAbout(ActionEvent event) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("A propos");
        alert.setHeaderText("A propos de l'application");
        alert.setContentText("L'appli Mégathèque a été réalisée par Jérôme Chaput, Damien Gruffeille, Julien Jégo et Oziris à l'Afpa de Beaumont.\rElle est vachement bien.\r© Afpa 2022 ");
        alert.showAndWait();
    }
}