package robotgame;


import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class main extends Application{

	public static Scene scene;

	static int WorldWidth = 1300;
	static int WorldHeight = 600;

	private static Group root;
	private static Group menuGroup = new Group();

	static Stage pStage;
	private static Scene menuScene;

	private static Rectangle playButton;
	private static Text play;
	

	@Override
	public void start(Stage primaryStage) throws Exception {

		pStage = primaryStage;

		root = new MapInterpreter();

		menu();

		scene = new Scene(root,WorldWidth,WorldHeight);
		menuScene = new Scene(menuGroup,WorldWidth,WorldHeight);



		primaryStage.setScene(menuScene);
		primaryStage.show();

		primaryStage.setResizable(false);


		scene.setOnKeyPressed(event ->{
			if(event.getCode() == KeyCode.UP){
				MapInterpreter.arr.get(0).moveForward();
			}
			if(event.getCode() == KeyCode.LEFT){
				MapInterpreter.arr.get(0).rotateRight();
			}
			if(event.getCode() == KeyCode.RIGHT){
				MapInterpreter.arr.get(0).rotateLeft();
			}

		});


	}

	public static void main(String[] args) {
		launch(args);
	}

	public static void menu(){
		playButton = new Rectangle(WorldWidth*(1.0/5), WorldHeight*(1.0/5));
		playButton.setTranslateX(WorldWidth/2-playButton.getWidth()/2);
		playButton.setTranslateY(WorldHeight/2-playButton.getHeight()/2);
		playButton.setFill(Color.rgb(0, 255, 238));
		
		play = new Text("Play");
		play.setFont(new Font("Arial", 50));
		play.setTranslateX(WorldWidth/2-play.getLayoutBounds().getWidth()/2);
		play.setTranslateY(WorldHeight/2);
		
		menuGroup.getChildren().addAll(playButton, play);
		
		playButton.setOnMouseClicked(event ->{
			pStage.setScene(scene);
		});
		play.setOnMouseClicked(event ->{
			pStage.setScene(scene);
		});
	}

	

}
