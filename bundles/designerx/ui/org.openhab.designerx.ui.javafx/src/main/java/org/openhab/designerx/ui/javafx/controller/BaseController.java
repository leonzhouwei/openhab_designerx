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
		Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
		Scene scene = new Scene(getView(), dimension.getWidth(), dimension.getWidth());
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
    
    public void resizeTo(int w, int h) {
        if (stage != null) {
            stage.setWidth(w);
            stage.setHeight(h);
        }
    }
}
