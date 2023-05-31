package co.edu.uniquindio.concesionariouq.controllers;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.net.URL;
import java.util.ResourceBundle;

import co.edu.uniquindio.concesionariouq.exceptions.AtributosFaltantesException;
import co.edu.uniquindio.concesionariouq.exceptions.NullException;
import co.edu.uniquindio.concesionariouq.exceptions.VehiculoYaExisteException;
import co.edu.uniquindio.concesionariouq.model.Combustible;
import co.edu.uniquindio.concesionariouq.model.EstadoVehiculo;
import co.edu.uniquindio.concesionariouq.model.Moto;
import co.edu.uniquindio.concesionariouq.model.TipoCambio;
import co.edu.uniquindio.concesionariouq.util.FxUtility;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class AgregarMotoController {

	@FXML
	private ResourceBundle resources;

	@FXML
	private URL location;

	@FXML
	private TextField txtPlaca;

	@FXML
	private Label lblTipoVehiculo;

	@FXML
	private TextField txtModelo;

	@FXML
	private TextField txtVelMaxima;

	@FXML
	private Button btnCombustible;

	@FXML
	private ComboBox<TipoCambio> comboCambio;

	@FXML
	private ComboBox<EstadoVehiculo> comboEstado;

	@FXML
	private TextField txtCilindraje;

	@FXML
	private TextField txtMarca;

	@FXML
	private BorderPane root;

	@FXML
	private Button btnCerrar;

	@FXML
	private Button btnAgregar;

	private Combustible combustible;

	private Runnable actualizarTabla;

	public AgregarMotoController(Combustible combustible, Runnable actualizarTabla) {
		this.combustible = combustible;
		this.actualizarTabla = actualizarTabla;
	}

	@FXML
	void agregarAction(ActionEvent event) {
		try {
			Image image = new Image(new FileInputStream("/resources/images/vehiculos/moto.png"));
			ModelFactoryController.getInstance()
					.agregarVehiculo(new Moto(txtPlaca.getText().trim(), txtMarca.getText().trim(),
							txtModelo.getText().trim(), Double.parseDouble(txtCilindraje.getText().trim()),
							Double.parseDouble(txtVelMaxima.getText().trim()), combustible, comboEstado.getValue(),
							comboCambio.getValue(), image));
			actualizarTabla.run();
			FxUtility.mostrarMensaje("Informacion", "El vehiculo ha sido agregado con exito",
					"El vehiculo ha sido agregado con exito", AlertType.CONFIRMATION);
		} catch (NumberFormatException | NullException | AtributosFaltantesException | VehiculoYaExisteException
				| FileNotFoundException e) {
			FxUtility.mostrarMensaje("Advertencia", "No se pudo agregar el vehiculo", e.getMessage(), AlertType.ERROR);
		}
	}

	@FXML
	void cerrarAction(ActionEvent event) {
		((Stage) root.getScene().getWindow()).close();
	}

	@FXML
	void combustibleEvent(ActionEvent event) {

	}

	@FXML
	void initialize() {
		FxUtility.setAsNumberTextfield(txtPlaca);
		FxUtility.setMaximumTextSize(txtPlaca, 12);

		FxUtility.setAsAlphanumericTextfield(txtMarca);
		FxUtility.setMaximumTextSize(txtMarca, 12);

		FxUtility.setAsNumberTextfield(txtModelo);
		FxUtility.setMaximumTextSize(txtModelo, 4);

		FxUtility.setAsNumberTextfield(txtCilindraje);
		FxUtility.setMaximumTextSize(txtCilindraje, 10);

		FxUtility.setAsNumberTextfield(txtVelMaxima);
		FxUtility.setMaximumTextSize(txtVelMaxima, 10);

		comboEstado.setItems(FXCollections.observableList(EstadoVehiculo.getValues()));
		comboCambio.setItems(FXCollections.observableList(TipoCambio.getValues()));
	}
}
