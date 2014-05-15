package org.openhab.designerx.ui.javafx.util;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javafx.application.Platform;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import javafx.stage.DirectoryChooser;
import javafx.stage.DirectoryChooserBuilder;
import javafx.stage.Stage;

import org.openhab.designerx.ui.javafx.common.Constants;

public class Util {

	public static File getSelectedFolderInPopupWindow(String title,
			Stage primaryStage) {
		DirectoryChooserBuilder builder = DirectoryChooserBuilder.create();
		builder.title(title);
		File file = new File(Constants.USER_HOME_DIR);
		builder.initialDirectory(file);
		DirectoryChooser chooser = builder.build();
		return chooser.showDialog(primaryStage);
	}

	public static void setErrorMessage(final Label msgLabel,
			final String message) {
		Runnable r = new Runnable() {
			@Override
			public void run() {
				msgLabel.setTextFill(Color.RED);
				msgLabel.setText(message);
			}
		};
		runLaterInJavaFXAppThread(r);
	}

	public static void setNormalMessage(final Label label, final String message) {
		Runnable r = new Runnable() {
			@Override
			public void run() {
				label.setTextFill(Color.BLACK);
				label.setText(message);
			}
		};
		runLaterInJavaFXAppThread(r);
	}

	public static void runLaterInJavaFXAppThread(Runnable r) {
		Platform.runLater(r);
	}
	
	public static List<File> listRegularFileNames(File directory, String fileExtension) {
		File[] array = directory.listFiles();
		List<File> files = new ArrayList<File>();
		for (File file : array) {
			if (file.getName().endsWith(fileExtension)) {
				files.add(file);
			}
		}
		return files;
	}
	
	public static List<String> baseNames(List<File> files, String fileExtension) {
		List<String> baseNames = new ArrayList<String>();
		for (File file : files) {
			String name = file.getName();
			int index = name.indexOf(fileExtension);
			String baseName = name.substring(0, index);
			baseNames.add(baseName);
		}
		return baseNames;
	}

}
