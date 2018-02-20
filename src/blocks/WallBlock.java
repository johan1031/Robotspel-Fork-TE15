package blocks;

import javafx.scene.shape.Rectangle;

public class WallBlock extends Block {

	public WallBlock(double square_size) {
		super(square_size);
		Rectangle r = new Rectangle(square_size,square_size);
		this.getChildren().add(r);
	}
	
	

}
