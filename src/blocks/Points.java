package blocks;

import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class Points extends Block implements Collectible {

	public Points(double square_size) {
		super(square_size);
		Circle cir = new Circle(square_size/2, square_size/2, square_size/2);
		this.getChildren().add(cir);
		cir.setFill(Color.rgb(255, 255, 0));
	}

}
