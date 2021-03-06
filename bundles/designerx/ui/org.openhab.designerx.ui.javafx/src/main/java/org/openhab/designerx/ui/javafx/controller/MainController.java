package org.openhab.designerx.ui.javafx.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import java.util.Set;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

import org.openhab.designerx.config.impl.ConfigImpl;
import org.openhab.designerx.model.items.Item;
import org.openhab.designerx.model.items.ItemResource;
import org.openhab.designerx.repo.queryrepo.ItemResourceQueryRepo;
import org.openhab.designerx.repo.queryrepo.SitemapQueryRepo;
import org.openhab.designerx.repo.queryrepo.impl.QueryRepo;
import org.openhab.designerx.ui.javafx.common.Constants;
import org.openhab.designerx.ui.javafx.view.Safe;
import org.openhab.designerx.ui.javafx.view.Unsafe;
import org.openhab.designerx.ui.javafx.viewmodel.ConfigInfo;
import org.openhab.designerx.ui.javafx.viewmodel.ItemInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public final class MainController extends BaseController implements Initializable {
	private static final Logger logger = LoggerFactory.getLogger(MainController.class);

	@FXML
	private Parent root;
	// top
	@FXML
	private Label msgLabel;
	// left
	@FXML
	private Button newConfigButton;
	@FXML
	private Button deleteConfigButton;
	@FXML
	private TreeView<ConfigInfo> treeView;
	private TreeItem<ConfigInfo> itemResources = new TreeItem<ConfigInfo>(new ConfigInfo(ConfigInfo.Type.NONE, "Items"));
	private TreeItem<ConfigInfo> sitemaps = new TreeItem<ConfigInfo>(new ConfigInfo(ConfigInfo.Type.NONE, "Sitemaps"));
	// right
	@FXML
	private AnchorPane itemResAnchorPane;
	@FXML
	private Label itemResNameLabel;
	@FXML
	private Button newItemButton;
	@FXML
	private Button deleteItemButton;
	@FXML
	private TableView<ItemInfo> itemResTableView;
	@FXML
	private TableColumn<ItemInfo, String> itemTypeColumn;
	@FXML
	private TableColumn<ItemInfo, String> itemNameColumn;
	@FXML
	private TableColumn<ItemInfo, String> itemLabelColumn;
	@FXML
	private TableColumn<ItemInfo, String> itemIconColumn;
	@FXML
	private TableColumn<ItemInfo, String> itemGroupsColumn;
	@FXML
	private TableColumn<ItemInfo, String> itemCommandColumn;
	@FXML
	private Button updateItemButton;
	//
	@FXML
	private ChoiceBox<String> itemTypeChoiceBox;
	@FXML
	private TextField itemNameTextField;
	@FXML
	private TextField itemLabelTextField;
	@FXML
	private ImageView itemIconImageView;
	@FXML
	private ChoiceBox<String> itemIconChoiceBox;
	@FXML
	private TextField itemGroupsTextField;
	@FXML
	private ChoiceBox<String> itemGroupChoiceBox;
	@FXML
	private TextField itemCommandTextField;
	//
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
        itemTypeColumn.setCellValueFactory(new PropertyValueFactory<ItemInfo, String>("type"));
        itemNameColumn.setCellValueFactory(new PropertyValueFactory<ItemInfo, String>("name"));
        itemLabelColumn.setCellValueFactory(new PropertyValueFactory<ItemInfo, String>("label"));
        itemIconColumn.setCellValueFactory(new PropertyValueFactory<ItemInfo, String>("icon"));
        itemGroupsColumn.setCellValueFactory(new PropertyValueFactory<ItemInfo, String>("groups"));
        itemCommandColumn.setCellValueFactory(new PropertyValueFactory<ItemInfo, String>("command"));
    	ObservableList<ItemInfo> data = FXCollections.observableArrayList();
    	itemResTableView.setItems(data);
    	itemResTableView.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<ItemInfo>() {
			@Override
			public void changed(ObservableValue<? extends ItemInfo> arg0,
					ItemInfo oldValue, ItemInfo newValue) {
				if (newValue == null || itemIconImageView == null) {
					return;
				}
				refreshItemParameters(newValue);
			}
		});
	}
	
	private void initConfigTreeView() {
		// create the tree structure
		itemResources.setExpanded(true);
		itemResources.getChildren().clear();
		sitemaps.setExpanded(true);
		sitemaps.getChildren().clear();
		ConfigInfo rootData = new ConfigInfo(ConfigInfo.Type.NONE, "");
		TreeItem<ConfigInfo> root = new TreeItem<ConfigInfo>(rootData);
		treeView.setRoot(root);
		treeView.setShowRoot(false);
		treeView.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
		treeView.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<TreeItem<ConfigInfo>>() {
			@Override
			public void changed(
				ObservableValue<? extends TreeItem<ConfigInfo>> observable, 
				TreeItem<ConfigInfo> oldValue, 
				TreeItem<ConfigInfo> newValue
			) {
				TreeItem<ConfigInfo> selectedItem = (TreeItem<ConfigInfo>) newValue;
				if (selectedItem != null) {
					Safe.setNormalMessage(msgLabel, selectedItem.getValue().toString());
					if (selectedItem.getValue().mapItemResource()) {
						fillItemResourceTableView(selectedItem.getValue().getName());
					}
				}
			}
		});
		root.setExpanded(true);
		root.getChildren().add(itemResources);
		root.getChildren().add(sitemaps);
		// fill children tree view items
		Set<String> irNames = irqr.names();
		logger.debug("loading item resources...");
		for (String name : irNames) {
			ConfigInfo item = new ConfigInfo(ConfigInfo.Type.ITEM_RESOURCE, name);
			itemResources.getChildren().add(new TreeItem<ConfigInfo>(item));
		}
		Set<String> sitemapNames = sqr.names();
		for (String name : sitemapNames) {
			ConfigInfo item = new ConfigInfo(ConfigInfo.Type.SITEMAP, name);
			sitemaps.getChildren().add(new TreeItem<ConfigInfo>(item));
		}
	}
	
	private void fillItemResourceTableView(String name) {
		try {
			ItemResource ir = irqr.getReplicaByName(name);
			if (ir == null) {
				return;
			}
			List<Item> items = ir.getAll();
			ObservableList<ItemInfo> itemInfoList = FXCollections.observableArrayList();
			for (Item item : items) {
				logger.debug(item.getName());
				ItemInfo ii = new ItemInfo(item);
				itemInfoList.add(ii);
			}
			itemResTableView.setItems(itemInfoList);
		} catch (Exception e) {
			Safe.setErrorMessage(msgLabel, e.getMessage());
			logger.warn("", e);
		}
	}
	
	@FXML
	void updateItem(ActionEvent event) {
		logger.debug("oops");
	}
	
	Image itemIcon(ItemInfo itemInfo) {
		if (itemInfo.iconProperty() == null || itemInfo.iconProperty().get().trim().isEmpty()) {
			return null;
		}
		String path = ConfigImpl.getInstance().getOpenHABWebappsImagesFolderPath() + Constants.FILE_SEPARATOR + itemInfo.iconProperty().get().trim() + ".png";
		File file = new File(path);
		logger.debug(path);
		if (!file.exists()) {
			return null;
		}
		Image image = null;
		try {
			image = new Image(new FileInputStream(file));
		} catch (FileNotFoundException e) {
			logger.warn("", e);
		}
		return image;
	}
	
	void refreshItemParameters(ItemInfo itemInfo) {
		Unsafe.setNormalMessage(msgLabel, itemInfo.nameProperty().toString());
		itemNameTextField.setText(itemInfo.nameProperty().get());
		itemIconImageView.setImage(null);
		Image image = itemIcon(itemInfo);
		itemLabelTextField.setText(itemInfo.labelProperty().get());
		if (image != null) {
			itemIconImageView.setImage(image);
		}
		itemGroupsTextField.setText(itemInfo.groupsProperty().get());
		itemCommandTextField.setText(itemInfo.commandProperty().get());
	}
	
}
