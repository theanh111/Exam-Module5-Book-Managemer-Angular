package controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;
import model.Deck;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;

public class MainController implements Initializable, Serializable {
    @FXML
    private ImageView imageView;

    @FXML
    private TableView<Deck> table;

    @FXML
    private TableColumn<Deck, Integer> idColumn;

    @FXML
    private TableColumn<Deck, Integer> imageColumn;

    @FXML
    private TableColumn<Deck, Integer> codeColumn;

    @FXML
    private TableColumn<Deck, Double> sizeColumn;

    @FXML
    private TableColumn<Deck, String> nameColumn;

    @FXML
    private TableColumn<Deck, String> brandColumn;

    @FXML
    private TableColumn<Deck, String> colorColumn;

    @FXML
    private TableColumn<Deck, Double> priceColumn;


    private ObservableList<Deck> deckList;

    @FXML
    private TextField idText;

    @FXML
    private TextField imageText;

    @FXML
    private TextField codeText;

    @FXML
    private TextField sizeText;

    @FXML
    private TextField nameText;

    @FXML
    private TextField brandText;

    @FXML
    private TextField colorText;

    @FXML
    private TextField priceText;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        deckList = FXCollections.observableArrayList(readFile());
        idColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
        imageColumn.setCellValueFactory(new PropertyValueFactory<>("image"));
        codeColumn.setCellValueFactory(new PropertyValueFactory<>("code"));
        sizeColumn.setCellValueFactory(new PropertyValueFactory<>("size"));
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        brandColumn.setCellValueFactory(new PropertyValueFactory<>("brand"));
        colorColumn.setCellValueFactory(new PropertyValueFactory<>("color"));
        priceColumn.setCellValueFactory(new PropertyValueFactory<>("price"));
        table.setItems(deckList);
    }

    public void imageButton() throws MalformedURLException {
        FileChooser fileChooser = new FileChooser();
        File fileSelected = fileChooser.showOpenDialog(null);
        if (fileSelected != null) {
            String imageFile = fileSelected.toURI().toURL().toString();
            Image image = new Image(imageFile);
            imageView.setImage(image);
            imageText.setText(fileSelected.toURI().toURL().toString());
        } else {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Wrong File!");
            alert.setHeaderText(null);
            alert.setContentText("Please choose a file!");
            alert.showAndWait();
        }
    }

    public void add() {
        try {
            Deck newDeck = new Deck();
            Image image = new Image(imageText.getText());
            newDeck.setId(Integer.parseInt(idText.getText()));
            newDeck.setImage(new ImageView(image));
            newDeck.setCode(codeText.getText());
            newDeck.setSize(Double.parseDouble(sizeText.getText()));
            newDeck.setName(nameText.getText());
            newDeck.setBrand(brandText.getText());
            newDeck.setColor(colorText.getText());
            newDeck.setPrice(Double.parseDouble(priceText.getText()));

            boolean checkId = true;
            for (Deck deck : deckList) {
                if (Integer.parseInt(idText.getText()) == deck.getId()) {
                    checkId = false;
                }
            }

            if (checkId) {
                deckList.add(newDeck);
                reset();
            } else {
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("Wrong Input!");
                alert.setHeaderText(null);
                alert.setContentText("Invalid input!");
                alert.showAndWait();
            }

        } catch (Exception exception) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Wrong Input!");
            alert.setHeaderText(null);
            alert.setContentText("Please Input Full Information!");
            alert.showAndWait();
        }
    }

    public void delete() {
        Deck deckSelected = table.getSelectionModel().getSelectedItem();
        if (deckSelected != null) {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("WARNING!");
            alert.setHeaderText(null);
            alert.setContentText("Are you sure to delete?");
            Optional<ButtonType> action = alert.showAndWait();
            if (action.get() == ButtonType.OK) {
                deckList.remove(deckSelected);
            }
            reset();
        } else {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Can't Delete!");
            alert.setHeaderText(null);
            alert.setContentText("Please Choose One To Delete!");
            alert.showAndWait();
        }
    }

    public void select() {
        Deck deckSelected = table.getSelectionModel().getSelectedItem();
        idText.setText(String.valueOf(deckSelected.getId()));
        imageText.setText(String.valueOf(deckSelected.getImage()));
        codeText.setText(deckSelected.getCode());
        nameText.setText(deckSelected.getName());
        brandText.setText(deckSelected.getBrand());
        sizeText.setText(String.valueOf(deckSelected.getSize()));
        colorText.setText(deckSelected.getColor());
        priceText.setText(String.valueOf(deckSelected.getPrice()));
    }

    public void update() {
        Image image = new Image(imageText.getText());
        for (int i = 0; i < deckList.size(); i++) {
            if (Integer.parseInt(idText.getText()) == deckList.get(i).getId()) {
                deckList.get(i).setId(Integer.parseInt(idText.getText()));
                deckList.get(i).setImage(new ImageView(image));
                deckList.get(i).setCode(codeText.getText());
                deckList.get(i).setName(nameText.getText());
                deckList.get(i).setBrand(brandText.getText());
                deckList.get(i).setSize(Double.parseDouble(sizeText.getText()));
                deckList.get(i).setColor(colorText.getText());
                deckList.get(i).setPrice(Double.parseDouble(priceText.getText()));
                deckList.set(i, deckList.get(i));
            }
        }
    }

    public void reset() {
        idText.clear();
        imageText.clear();
        codeText.clear();
        sizeText.clear();
        nameText.clear();
        brandText.clear();
        colorText.clear();
        priceText.clear();
        imageView.setImage(null);
    }


    public void writeFile() {
        try {
            ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream("D:\\CodeGym\\Module_02\\CaseStudy_Module2\\src\\file\\SkateshopManagement.dat"));
            for (Deck deck : deckList) {
                outputStream.writeObject(deck);
            }
            outputStream.close();
        } catch (NotSerializableException e) {
            e.getMessage();
        } catch (IOException e) {
            e.getMessage();
        }
    }

    public List<Deck> readFile() {
        List<Deck> newDeckList = new ArrayList<>();
        try {
            ObjectInputStream readFile = new ObjectInputStream(new FileInputStream("D:\\CodeGym\\Module_02\\CaseStudy_Module2\\src\\file\\SkateshopManagement.dat"));
            while (true) {
                newDeckList.add((Deck) readFile.readObject());
            }
        } catch (EOFException e) {
            e.getMessage();
        } catch (IOException e) {
            e.getMessage();
        } catch (ClassNotFoundException e) {
            e.getMessage();
        }
        return newDeckList;
    }
}

