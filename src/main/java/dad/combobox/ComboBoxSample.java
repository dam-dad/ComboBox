package dad.combobox;

import javafx.application.Application;
import javafx.beans.binding.Bindings;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ComboBoxSample extends Application {

	private ComboBox<Alumno> miComboBox;
	private ComboBox<Videojuego> videojuegoComboBox;
	private Label seleccionadoLabel;
	private Button deseleccionarButton;
	
	private ObjectProperty<Alumno> seleccionado = new SimpleObjectProperty<>();

	@Override
	public void start(Stage primaryStage) throws Exception {
		
		miComboBox = new ComboBox<>();
		miComboBox.getItems().addAll(
				new Alumno("Chuck", "Norris", "12345678XYZ"), 
				new Alumno("Perico", "Palotes", "56454654XYZ"), 
				new Alumno("Michael", "Knight", "GBG5556665YZ"), 
				new Alumno("Hulk", "Hogan", "FGF555XYZ"), 
				new Alumno("Charles", "Bronson", "98765432ABC")
			);
		miComboBox.getSelectionModel().selectFirst();
		
		videojuegoComboBox = new ComboBox<>();
		videojuegoComboBox.getItems().setAll(Videojuego.values());

		seleccionadoLabel = new Label("etiqueta");
		
		deseleccionarButton = new Button("X");
		deseleccionarButton.setOnAction(e -> onDeseleccionarButtonAction(e));

		VBox root = new VBox(5, 
				new HBox(5, miComboBox, deseleccionarButton), 
				seleccionadoLabel,
				videojuegoComboBox
			);
		root.setFillWidth(false);
		root.setAlignment(Pos.CENTER);

		Scene scene = new Scene(root, 320, 200);

		primaryStage.setTitle("ComboBox Sample");
		primaryStage.setScene(scene);
		primaryStage.show();
		
		// bindeos
		
		seleccionado.bind(miComboBox.getSelectionModel().selectedItemProperty());
		
		seleccionadoLabel.textProperty().bind(
				Bindings
					.concat("El alumno seleccionado es: ")
					.concat(seleccionado.asString())
			);
		
	}

	private void onDeseleccionarButtonAction(ActionEvent e) {
		miComboBox.getSelectionModel().clearSelection();
	}

	public static void main(String[] args) {
		launch(args);
	}

}
