package blocks;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import robotgame.MapInterpreter;

public class Goal extends Block implements Win{

	public Goal(double square_size) {
		super(square_size);
		Rectangle rec = new Rectangle(square_size, square_size);
		rec.setFill(Color.rgb(0, 255, 0));
		this.getChildren().add(rec);
		
		
	}
	
	
}
