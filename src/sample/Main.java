package sample;

import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.layout.VBox;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.paint.Color;
import javafx.stage.StageStyle;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.geometry.Insets;
import static javafx.scene.effect.BlurType.GAUSSIAN;


public class Main extends Application  {

    private double horizontalCoord = 0;
    private double verticalCoord = 0;

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("mainApp.fxml"));
        primaryStage.setTitle("PDF Filler Application");
        primaryStage.setResizable(false);
        Scene scene = null;
        try {
            primaryStage.getIcons().add(new Image(ClassLoader.getSystemResourceAsStream("sample/resources/images/icon.png")));
        }
        catch (Exception ex) { }
        primaryStage.setScene(new Scene(root, 800, 650));
        primaryStage.initStyle(StageStyle.TRANSPARENT);
        scene = (getShadowScene(root));
        scene.setFill(Color.TRANSPARENT);
        primaryStage.setScene( scene );
        primaryStage.show();
        root.setOnMousePressed(eventApp -> {
            try {
                horizontalCoord = eventApp.getSceneX();
                verticalCoord = eventApp.getSceneY();
            } catch (Exception ex) { }
        });
        root.setOnMouseDragged(eventApp -> {
            try {
                primaryStage.setX(eventApp.getScreenX() - horizontalCoord);
                primaryStage.setY(eventApp.getScreenY() - verticalCoord);
            } catch (Exception ex) { }
            });
    }

    public Scene getShadowScene(Parent p) {
        Scene scene;
        VBox outer = new VBox();
        outer.getChildren().add( p );
        outer.setPadding(new Insets(20.0d));
        outer.setBackground( new Background(new BackgroundFill( Color.rgb(0,0,0,0), new CornerRadii(0), new Insets(0))));
        p.setEffect(new DropShadow(GAUSSIAN, Color.rgb(0,0,0,.65), 15, 0, 0, 0));
        ((VBox) p).setBackground(new Background(new BackgroundFill(Color.TRANSPARENT, new CornerRadii(0), new Insets(0))));
        scene = new Scene( outer );
        scene.setFill( Color.rgb(0,255,0,0) );
        return scene;
    }

    public static void main(String[] args) {
        launch(args);
    }
}
