package org.openhab.designerx.ui.javafx.view;

import javafx.application.Platform;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public final class Safe {

	public static void runLater(Runnable r) {
		Platform.runLater(r);
	}

	private Safe() {
	}

	public static void setErrorMessage(final Label msgLabel,
			final String message) {
		Runnable r = new Runnable() {
			@Override
			public void run() {
				Unsafe.setErrorMessage(msgLabel, message);
			}
		};
		runLater(r);
	}

	public static void setNormalMessage(final Label label, final String message) {
		Runnable r = new Runnable() {
			@Override
			public void run() {
				Unsafe.setNormalMessage(label, message);
			}
		};
		runLater(r);
	}

	@SuppressWarnings("rawtypes")
	public static void refreshTableView(final TableView tv) {
		runLater(new Runnable() {
			@Override
			public void run() {
				int size = tv.getColumns().size();
				if (size < 1) {
					return;
				}
				TableColumn column = (TableColumn) tv.getColumns().get(size - 1);
				column.setVisible(false);
				column.setVisible(true);
			}
		});
	}

}
