package com.crud;
	
import java.io.IOException;
import java.time.LocalDate;

import com.crud.gui.PessoaController;
import com.crud.gui.model.Pessoa;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;


public class Main extends Application {
	
	private Stage primaryStage;	
	private AnchorPane principal;
	
	private ObservableList<Pessoa> dados = FXCollections.observableArrayList();
	
	public Main() {
		dados.add(new Pessoa("Andrey","Masiero", LocalDate.of(1983, 10, 29)));
		dados.add(new Pessoa("Nelson","Mandela", LocalDate.of(1918, 07, 18)));
		dados.add(new Pessoa("Frida","Kahlo", LocalDate.of(1907, 7, 06)));
		dados.add(new Pessoa("Ada","Lovelace", LocalDate.of(1815, 12, 29)));
		dados.add(new Pessoa("Karen","Horney", LocalDate.of(1885, 9, 16)));
	}

	@Override
	public void start(Stage primaryStage) {
		this.primaryStage = primaryStage;
		this.primaryStage.setTitle("CRUD JavaFX");
		
		initMainStage();

	}
	
	private void initMainStage() {
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(Main.class.getResource("gui/principal.fxml"));
			
			this.principal = (AnchorPane) loader.load();
			
			Scene cena = new Scene(this.principal);
			PessoaController pessoaController = loader.getController();
			pessoaController.setMain(this);
			this.primaryStage.setScene(cena);
			this.primaryStage.show();
			
		} catch (IOException ex) {
			ex.printStackTrace();
		}
		
	}

	public static void main(String[] args) {
		launch(args);
	}

	public ObservableList<Pessoa> getDados() {
		return this.dados;
	}
}
