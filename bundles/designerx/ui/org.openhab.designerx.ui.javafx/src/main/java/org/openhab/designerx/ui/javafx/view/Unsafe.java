package org.openhab.designerx.ui.javafx.view;

import java.io.File;

import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import javafx.stage.DirectoryChooser;
import javafx.stage.DirectoryChooserBuilder;
import javafx.stage.Stage;

import org.openhab.designerx.ui.javafx.common.Constants;

public final class Unsafe {

	public static File getSelectedFolderInPopupWindow(String title,
			Stage primaryStage) {
		DirectoryChooserBuilder builder = DirectoryChooserBuilder.create();
		builder.title(title);
		File file = new File(Constants.USER_HOME_DIR);
		builder.initialDirectory(file);
		DirectoryChooser chooser = builder.build();
		return chooser.showDialog(primaryStage);
	}

	private Unsafe() {
	}

	public static void setErrorMessage(final Label msgLabel,
			final String message) {
		msgLabel.setTextFill(Color.RED);
		msgLabel.setText(message);
	}

	public static void setNormalMessage(final Label label, final String message) {
		label.setTextFill(Color.BLACK);
		label.setText(message);
	}
}
