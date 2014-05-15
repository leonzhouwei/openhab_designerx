package org.openhab.designerx.ui.javafx.controller;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.Set;

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

import org.openhab.designerx.repo.queryrepo.ItemResourceQueryRepo;
import org.openhab.designerx.repo.queryrepo.SitemapQueryRepo;
import org.openhab.designerx.repo.queryrepo.impl.QueryRepo;
import org.openhab.designerx.ui.javafx.util.Util;
import org.openhab.designerx.ui.javafx.view.GuiPromptMessage;
import org.openhab.designerx.ui.javafx.viewmodel.ConfigItem;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MainController extends BaseController implements Initializable {
	private static final Logger logger = LoggerFactory.getLogger(MainController.class);

	@FXML
	private Parent root;
	@FXML
	private Label msgLabel;
	@FXML
	private TreeView<ConfigItem> treeView;
	private TreeItem<ConfigItem> itemResources = new TreeItem<ConfigItem>(new ConfigItem(ConfigItem.Type.NONE, "items"));
	private TreeItem<ConfigItem> sitemaps = new TreeItem<ConfigItem>(new ConfigItem(ConfigItem.Type.NONE, "sitemaps"));
	@FXML
	private TableView<String> itemResTableView;
	@FXML
	private AnchorPane itemResAnchorPane;
	
	private ItemResourceQueryRepo irqr = QueryRepo.itemResourceQueryRepo();
	private SitemapQueryRepo sqr = QueryRepo.sitemapQueryRepo();
	
	@Override
	public Parent getView() {
		return root;
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		initConfigTreeView();
		//
		itemResTableView.setEditable(false);
		itemResTableView.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
	}
	
	private class ChangeListenerImpl implements ChangeListener<TreeItem<ConfigItem>> {
		@Override
		public void changed(
			ObservableValue<? extends TreeItem<ConfigItem>> observable, 
			TreeItem<ConfigItem> oldValue, 
			TreeItem<ConfigItem> newValue
		) {
			TreeItem<ConfigItem> selectedItem = (TreeItem<ConfigItem>) newValue;
			if (selectedItem != null) {
				setNormalMessage(selectedItem.getValue().toString());
			}
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
	
	private void initConfigTreeView() {
		// create the tree structure
		itemResources.setExpanded(true);
		itemResources.getChildren().clear();
		sitemaps.setExpanded(true);
		sitemaps.getChildren().clear();
		ConfigItem rootData = new ConfigItem(ConfigItem.Type.NONE, "");
		TreeItem<ConfigItem> root = new TreeItem<ConfigItem>(rootData);
		treeView.setRoot(root);
		treeView.setShowRoot(false);
		treeView.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
		treeView.getSelectionModel().selectedItemProperty().addListener(new ChangeListenerImpl());
		root.setExpanded(true);
		root.getChildren().add(itemResources);
		root.getChildren().add(sitemaps);
		// fill children tree view items
		Set<String> irNames = irqr.names();
		logger.debug("loading item resources...");
		for (String name : irNames) {
			ConfigItem item = new ConfigItem(ConfigItem.Type.ITEM_RESOURCE, name);
			itemResources.getChildren().add(new TreeItem<ConfigItem>(item));
		}
		Set<String> sitemapNames = sqr.names();
		for (String name : sitemapNames) {
			ConfigItem item = new ConfigItem(ConfigItem.Type.SITEMAP, name);
			sitemaps.getChildren().add(new TreeItem<ConfigItem>(item));
		}
	}

}
