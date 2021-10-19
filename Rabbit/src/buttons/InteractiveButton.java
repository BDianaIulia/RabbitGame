package buttons;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import javafx.animation.PauseTransition;
import javafx.application.Platform;
import javafx.concurrent.Task;
import javafx.concurrent.WorkerStateEvent;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Tooltip;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.ImagePattern;
import javafx.util.Duration;
import view.ModelRole;

public class InteractiveButton implements ButtonRole, Serializable {
	private List<ModelRole> modelList;
	private transient Button button;
	private int i;
	private int j;
	private String style;

	public InteractiveButton(int i, int j, int gridLength, double buttonSize, String style, String tooltip) {
		modelList = new LinkedList<>();

		button = new Button();
		this.i = i;
		this.j = j;

		button.setMinWidth(buttonSize);
		button.setMinHeight(buttonSize);

		button.setMaxWidth(buttonSize);
		button.setMaxHeight(buttonSize);
		button.setId(String.valueOf(i * (gridLength + 2) + j));
		button.setStyle(style);

		button.setTooltip(new Tooltip(tooltip));
	}

	@Override
	public void addTo(GridPane gridPane) {
		gridPane.add(button, i, j);
	}

	@Override
	public void disable(ModelRole model) {
		modelList.remove(model);
		if (modelList.isEmpty()) {
			Platform.runLater(() -> {
				button.setGraphic(null);

			});
		} else {
			setImageTo(modelList.get(0));
		}
	}

	@Override
	public void setOnAction(EventHandler<ActionEvent> buttonHandler) {
		button.setOnAction(buttonHandler);
	}

	@Override
	public void setImageTo(ModelRole model) {

		model.setImageTo(button);
	}

	@Override
	public void addToButton(ModelRole model) {
		if (modelList.size() == 0)
			setImageTo(model);

		modelList.add(model);
	}

	@Override
	public void setBackground(String path) {
		style = path + Double.toString(button.getWidth()) + "," + Double.toString(button.getHeight()) + ";";
		Platform.runLater(() -> {
			button.setGraphic(null);
			button.setStyle(style);
		});

	}

}
