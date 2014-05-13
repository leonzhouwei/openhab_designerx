package org.openhab.designerx.ui.javafx.controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.TableView;
import javafx.scene.layout.AnchorPane;

public class MainController extends BaseController implements Initializable {

	@FXML
	private Parent root;
	@FXML
	private AnchorPane itemResAnchorPane;
	@FXML
	private TableView<String> itemResTableView;
	
	@Override
	public Parent getView() {
		return root;
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		itemResTableView.setEditable(false);
		itemResTableView.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
	}

}
