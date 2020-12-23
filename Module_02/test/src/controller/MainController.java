package controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.util.converter.DoubleStringConverter;
import javafx.util.converter.IntegerStringConverter;
import javafx.util.converter.LongStringConverter;
import model.Sneaker;

import java.io.*;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

import static javafx.scene.control.cell.TextFieldTableCell.forTableColumn;

public class MainController implements Initializable {
    @FXML
    private TableView<Sneaker> tableView;

    @FXML
    private TableColumn<Sneaker, Long> barcodeColumn;

    @FXML
    private TableColumn<Sneaker, String> brandColumn;

    @FXML
    private TableColumn<Sneaker, String> nameColumn;

    @FXML
    private TableColumn<Sneaker, Double> sizeColumn;

    @FXML
    private TableColumn<Sneaker, Integer> priceColumn;

    @FXML
    private TableColumn<Sneaker, Integer> stockColumn;

    private ObservableList<Sneaker> sneakersList = FXCollections.observableArrayList();

    @FXML
    private TextField barcodeText;

    @FXML
    private TextField brandText;

    @FXML
    private TextField nameText;

    @FXML
    private TextField sizeText;

    @FXML
    private TextField priceText;

    @FXML
    private TextField stockText;

    @FXML
    private TextField searchField;

    @FXML
    private Label noticeLabel;

    @FXML
    private Button addButton;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        barcodeColumn.setCellValueFactory(new PropertyValueFactory<Sneaker, Long>("barcode"));
        brandColumn.setCellValueFactory(new PropertyValueFactory<Sneaker, String>("brand"));
        nameColumn.setCellValueFactory(new PropertyValueFactory<Sneaker, String>("name"));
        sizeColumn.setCellValueFactory(new PropertyValueFactory<Sneaker, Double>("size"));
        priceColumn.setCellValueFactory(new PropertyValueFactory<Sneaker, Integer>("price"));
        stockColumn.setCellValueFactory(new PropertyValueFactory<Sneaker, Integer>("stock"));
        tableView.setItems(sneakersList);

        this.search();

        tableView.setEditable(true);
        barcodeColumn.setCellFactory(TextFieldTableCell.forTableColumn(new LongStringConverter()));
        brandColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        nameColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        sizeColumn.setCellFactory(TextFieldTableCell.forTableColumn(new DoubleStringConverter()));
        priceColumn.setCellFactory(TextFieldTableCell.forTableColumn(new IntegerStringConverter()));
        stockColumn.setCellFactory(TextFieldTableCell.forTableColumn(new IntegerStringConverter()));

        validateAddTextField();

    }


    public void search() {
        FilteredList<Sneaker> searchList = new FilteredList<>(sneakersList, b-> true);
        searchField.textProperty().addListener(((observable, oldValue, newValue) -> {
            searchList.setPredicate(sneaker -> {
                if (newValue == null || newValue.isEmpty()) {
                    return true;
                }
                String lowercaseValue = newValue.toLowerCase();
                if (String.valueOf(sneaker.getBarcode()).indexOf(lowercaseValue) != -1) return true;
                else if (sneaker.getBrand().toLowerCase().indexOf(lowercaseValue) != -1) return true;
                else if (sneaker.getName().toLowerCase().indexOf(lowercaseValue) != -1) return true;
                else if (String.valueOf(sneaker.getSize()).indexOf(lowercaseValue) != -1) return true;
                else if (String.valueOf(sneaker.getPrice()).indexOf(lowercaseValue) != -1) return true;
                else if (String.valueOf(sneaker.getStock()).indexOf(lowercaseValue) != -1) return true;
                else return false;
            });
        }));
        tableView.setItems(searchList);
    }

    public void add(ActionEvent event) {
        Sneaker sneaker = new Sneaker();
        try {
            sneaker.setBarcode(Long.parseLong(barcodeText.getText()));
            sneaker.setBrand(brandText.getText());
            sneaker.setName(nameText.getText());
            sneaker.setSize(Double.parseDouble(sizeText.getText()));
            sneaker.setPrice(Integer.parseInt(priceText.getText()));
            sneaker.setStock(Integer.parseInt(stockText.getText()));
            sneakersList.add(sneaker);
        } catch (Exception exception) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Invalid Input!");
            alert.setHeaderText(null);
            alert.setContentText("Please try again");
            alert.showAndWait();
        }

        barcodeText.clear();
        brandText.clear();
        nameText.clear();
        sizeText.clear();
        priceText.clear();
        stockText.clear();
    }


    public void validateAddTextField() {
        barcodeText.textProperty().addListener((observable, oldValue, newValue) -> {
            if (!newValue.matches("^\\d+$") && !newValue.isEmpty()) {
                noticeLabel.setText("Invalid barcode!");
                addButton.setDisable(true);
            } else {
                noticeLabel.setText("");
                addButton.setDisable(false);
            }
        });
        sizeText.textProperty().addListener(((observable, oldValue, newValue) -> {
            if (!newValue.isEmpty() && !newValue.matches("^\\d+(\\.\\d)?$")) {
                noticeLabel.setText("Invalid size!");
                addButton.setDisable(true);
            } else {
                noticeLabel.setText("");
                addButton.setDisable(false);
            }
        }));
        priceText.textProperty().addListener((observable, oldValue, newValue) -> {
            if (!newValue.isEmpty() && !newValue.matches("^\\d+$")) {
                noticeLabel.setText("Invalid price!");
                addButton.setDisable(true);
            } else {
                noticeLabel.setText("");
                addButton.setDisable(false);
            }
        });
        stockText.textProperty().addListener((observable, oldValue, newValue) -> {
            if (!newValue.isEmpty() && !newValue.matches("^\\d+$")) {
                noticeLabel.setText("Invalid stock!");
                addButton.setDisable(true);
            } else {
                noticeLabel.setText("");
                addButton.setDisable(false);
            }
        });
    }

    public void delete(ActionEvent event) {
        Sneaker selectedSneaker = tableView.getSelectionModel().getSelectedItem();
        if (selectedSneaker != null) {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Confirmation");
            alert.setHeaderText(null);
            alert.setContentText("Are you sure?");
            ButtonType buttonTypeYes = new ButtonType("Yes", ButtonBar.ButtonData.YES);
            ButtonType buttonTypeNo = new ButtonType("No", ButtonBar.ButtonData.NO);
            alert.getButtonTypes().setAll(buttonTypeYes, buttonTypeNo);
            Optional<ButtonType> choice = alert.showAndWait();
            if (choice.get().getButtonData() == ButtonBar.ButtonData.YES) {
                sneakersList.remove(selectedSneaker);
            }
        } else {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Notification");
            alert.setHeaderText(null);
            alert.setContentText("Please choose one!");
            alert.showAndWait();
        }
    }

    public void editBarcode(TableColumn.CellEditEvent cellEditEvent) {
        Sneaker sneakerSelected = tableView.getSelectionModel().getSelectedItem();
        sneakerSelected.setBarcode(Long.parseLong(cellEditEvent.getNewValue().toString()));
    }

    public void editBrand(TableColumn.CellEditEvent cellEditEvent) {
        Sneaker sneakerSelected = tableView.getSelectionModel().getSelectedItem();
        sneakerSelected.setBrand(cellEditEvent.getNewValue().toString());
    }

    public void editName(TableColumn.CellEditEvent cellEditEvent) {
        Sneaker sneakerSelected = tableView.getSelectionModel().getSelectedItem();
        sneakerSelected.setName(cellEditEvent.getNewValue().toString());
    }

    public void editSize(TableColumn.CellEditEvent cellEditEvent) {
        Sneaker sneakerSelected = tableView.getSelectionModel().getSelectedItem();
        sneakerSelected.setSize(Double.parseDouble(cellEditEvent.getNewValue().toString()));
    }

    public void editPrice(TableColumn.CellEditEvent cellEditEvent) {
        Sneaker sneakerSelected = tableView.getSelectionModel().getSelectedItem();
        sneakerSelected.setPrice(Integer.parseInt(cellEditEvent.getNewValue().toString()));
    }

    public void editStock(TableColumn.CellEditEvent cellEditEvent) {
        Sneaker sneakerSelected = tableView.getSelectionModel().getSelectedItem();
        sneakerSelected.setStock(Integer.parseInt(cellEditEvent.getNewValue().toString()));
    }

    public void writeToFile() throws IOException {
        FileOutputStream fileOutputStream = null;
        ObjectOutputStream objectOutputStream = null;
        try {
            fileOutputStream = new FileOutputStream("sneaker.txt");
            objectOutputStream = new ObjectOutputStream(fileOutputStream);
            for (Sneaker sneaker : sneakersList) {
                objectOutputStream.writeObject(sneaker);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            assert objectOutputStream != null;
            objectOutputStream.close();
            fileOutputStream.close();
        }
    }

    public void readFile() throws IOException {
        FileInputStream fileInputStream = null;
        ObjectInputStream objectInputStream = null;
        try {
            fileInputStream = new FileInputStream("sneaker.txt");
            objectInputStream = new ObjectInputStream(fileInputStream);
            Sneaker sneaker = null;
            while ((sneaker = (Sneaker) objectInputStream.readObject()) != null) {
                sneakersList.add(sneaker);
            }
        } catch (ClassNotFoundException  e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            assert objectInputStream != null;
            objectInputStream.close();
            fileInputStream.close();
        }
    }





}
