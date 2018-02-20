package robotgame;


import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class main extends Application{

	public static Scene scene;

	static int WorldWith = 1300;
	static int WorldHeigth = 600;

	private static Group root;
	private static Group menuGroup = new Group();

	static Stage pStage;
	private static Scene menuScene;

	private static Rectangle playButton;

	@Override
	public void start(Stage primaryStage) throws Exception {

		pStage = primaryStage;

		root = new MapInterpreter();

		menu();

		scene = new Scene(root,WorldWith,WorldHeigth);
		menuScene = new Scene(menuGroup,WorldWith,WorldHeigth);



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
		playButton = new Rectangle(WorldWith*(1.0/5), WorldHeigth*(1.0/5));

		menuGroup.getChildren().addAll(playButton);
		
		playButton.setOnMouseClicked(event ->{
			pStage.setScene(scene);
		});
	}

	

}
