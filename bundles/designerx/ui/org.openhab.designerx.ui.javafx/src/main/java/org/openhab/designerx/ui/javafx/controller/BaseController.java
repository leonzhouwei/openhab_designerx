package org.openhab.designerx.ui.javafx.controller;

import java.awt.Dimension;
import java.awt.Toolkit;

import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public abstract class BaseController {

	protected Stage stage;

	public abstract Parent getView();
	
	public BaseController create(Stage stage, Stage parent) {
		if (this.stage != null) {
			return this;
		}
		this.stage = stage;
		Scene scene = new Scene(getView());
		stage.setScene(scene);
		if (parent != null) {
			stage.initOwner(parent);
		}
		return this;
	}
	
    public BaseController setTitle(String title) {
        stage.setTitle(title);
        return this;               
    }
    
    public BaseController show() {
        stage.show();
        return this;
    }

    public BaseController hide() {
        stage.hide();
        return this;
    }

    public void close() {
        stage.close();
    }
    
    public void resizeMax() {
    	Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
    	resizeTo(dim.getWidth(), dim.getHeight());
    }
    
    public void resizeTo(double w, double h) {
        if (stage != null) {
            stage.setWidth(w);
            stage.setHeight(h);
        }
    }
    
}
