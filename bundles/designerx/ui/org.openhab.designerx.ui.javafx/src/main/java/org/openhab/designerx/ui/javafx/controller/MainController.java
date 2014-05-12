package org.openhab.designerx.ui.javafx.controller;

import javafx.fxml.FXML;
import javafx.scene.Parent;

public class MainController extends BaseController {

	@FXML
	private Parent root;
	
	@Override
	public Parent getView() {
		return root;
	}

}
