package blocks;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class MovableBlock extends Block implements Movable{

	public MovableBlock(double square_size) {
		super(square_size);
		Rectangle rec = new Rectangle(square_size, square_size);
		rec.setFill(Color.rgb(0, 255, 238));
		this.getChildren().add(rec);
	}

}
