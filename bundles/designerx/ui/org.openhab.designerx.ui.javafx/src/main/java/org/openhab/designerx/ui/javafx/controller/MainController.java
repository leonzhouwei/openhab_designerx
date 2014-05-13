package org.openhab.designerx.ui.javafx.controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableView;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.layout.AnchorPane;

import org.openhab.designerx.ui.javafx.util.Util;
import org.openhab.designerx.ui.javafx.view.GuiElemDefine;
import org.openhab.designerx.ui.javafx.view.GuiPromptMessage;

public class MainController extends BaseController implements Initializable {

	@FXML
	private Parent root;
	@FXML
	private Label msgLabel;
	@FXML
	private TreeView<String> treeView;
	private TreeItem<String> treeItemOfItems = new TreeItem<String>(GuiElemDefine.ITEMS);
	private TreeItem<String> treeItemOfSitemaps = new TreeItem<String>(GuiElemDefine.SITEMAPS);
	@FXML
	private TableView<String> itemResTableView;
	@FXML
	private AnchorPane itemResAnchorPane;
	
	@Override
	public Parent getView() {
		return root;
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		treeItemOfItems.setExpanded(true);
		treeItemOfItems.getChildren().clear();
		treeItemOfSitemaps.setExpanded(true);
		treeItemOfSitemaps.getChildren().clear();
		TreeItem<String> root = new TreeItem<String>(GuiElemDefine.CONFIGRATIONS);
		treeView.setRoot(root);
		treeView.setShowRoot(false);
		treeView.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
		treeView.getSelectionModel().selectedItemProperty().addListener(new ChangeListenerImpl());
		root.setExpanded(true);
		root.getChildren().add(treeItemOfItems);
		root.getChildren().add(treeItemOfSitemaps);
		//
		itemResTableView.setEditable(false);
		itemResTableView.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
	}
	
	private class ChangeListenerImpl implements ChangeListener<TreeItem<String>> {
		@Override
		public void changed(ObservableValue<? extends TreeItem<String>> observable, TreeItem<String> oldValue, TreeItem<String> newValue) {
			TreeItem<String> selectedItem = (TreeItem<String>) newValue;
			setNormalMessage(selectedItem.getValue());
		}
	}
	
	public void setErrorMessage(String message) {
		Util.setErrorMessage(msgLabel, message);
	}
	
	public void resetMessageLabel() {
		Util.setNormalMessage(msgLabel, GuiPromptMessage.WELCOME);
	}
	
	public void setNormalMessage(String message) {
		Util.setNormalMessage(msgLabel, message);
	}

}
