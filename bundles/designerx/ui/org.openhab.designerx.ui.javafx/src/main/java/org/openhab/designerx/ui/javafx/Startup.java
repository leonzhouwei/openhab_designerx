package org.openhab.designerx.ui.javafx;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;

import org.openhab.designerx.ui.javafx.controller.MainController;

public class Startup extends Application {
	
	public static void main(String[] args) {
        launch(args);
    }

	@Override
	public void start(Stage stage) throws Exception {
		// 初始化主界面
		FXMLLoader loader = new FXMLLoader();
		loader.load(Startup.class.getResourceAsStream("/fxml/Main.fxml"));
		MainController mc = loader.getController();
		mc.create(new Stage(), stage);
		mc.setTitle("FXML Welcome");
		mc.resizeMax();
		
		// 显示主界面
		mc.show();
	}

}
