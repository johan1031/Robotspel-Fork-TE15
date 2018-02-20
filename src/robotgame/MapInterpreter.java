package robotgame;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import blocks.Block;
import blocks.ExampleBlock;
import blocks.Goal;
import blocks.MovableBlock;
import blocks.Points;
import blocks.WallBlock;
import javafx.scene.Group;

/**
 * 
 * @author Joakim
 */
public class MapInterpreter extends Group {
	
	public static ArrayList<Robot> arr = new ArrayList<>();
	public final double SQUARE_SIZE = 30;

	public MapInterpreter() throws FileNotFoundException {

		Scanner fileReader = new Scanner(new File("Map"));

		int y = -1;
		ArrayList<Integer> robotCoords = new ArrayList<Integer>();

		while (fileReader.hasNextLine()) {
			y++;
			String line = fileReader.nextLine();
			char[] blocks = line.toCharArray();

			for (int x = 0; x < blocks.length; x++) {
				char block = blocks[x];
				Block b = null;
				switch (block) {

				case '#':
					b = new WallBlock(SQUARE_SIZE);
					break;

				case 'P':
					b = new Points(SQUARE_SIZE);
					break;

				case 'X':
					b = new Goal(SQUARE_SIZE);
					break;
					
				case 'M':
					b = new MovableBlock(SQUARE_SIZE);
					break;

				case 'R': // ROBOT
					robotCoords.add(x);
					robotCoords.add(y);
					break;

				case ' ':
					b = null;
					break;

				default:
					b = null;
					break;

				}

				if (b != null) {
					b.setTranslateX(x * SQUARE_SIZE - 1);
					b.setTranslateY(y * SQUARE_SIZE - 1);
					this.getChildren().add(b);
				}

			}

		}

		for (int i = 0; i < robotCoords.size(); i += 2) {
			Robot r = new Robot(SQUARE_SIZE);
			r.setTranslateX(robotCoords.get(i) * SQUARE_SIZE);
			r.setTranslateY(robotCoords.get(i + 1) * SQUARE_SIZE);
			this.getChildren().add(r);
			arr.add(r);
		}

	}

}
