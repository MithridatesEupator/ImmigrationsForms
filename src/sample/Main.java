package sample;

import javafx.event.EventHandler;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.StageStyle;
import org.apache.pdfbox.pdmodel.*;
import org.apache.pdfbox.pdmodel.interactive.form.PDAcroForm;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.application.*;
import javafx.geometry.Insets;

import java.io.IOException;
import javafx.animation.*;
import javafx.application.*;
//import java.io.*;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDDocumentCatalog;
import org.apache.pdfbox.pdmodel.interactive.form.*;

import static javafx.scene.effect.BlurType.GAUSSIAN;
import static javafx.scene.effect.BlurType.ONE_PASS_BOX;
import static javafx.scene.effect.BlurType.THREE_PASS_BOX;


public class Main extends Application  {

    private double xOffset = 0;
    private double yOffset = 0;

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("mainWindow.fxml"));
        primaryStage.setTitle("PDF Filler Application");
        primaryStage.setResizable(false);
        Scene scene = null;
        try {
            primaryStage.getIcons().add(new Image(ClassLoader.getSystemResourceAsStream("sample/resources/images/icon.png")));
        }
        catch (Exception ex) {

        }

        primaryStage.setScene(new Scene(root, 800, 600));
        primaryStage.initStyle(StageStyle.TRANSPARENT);
        //primaryStage.setPadding(new Insets(20,20,20,20));
        scene = (getShadowScene(root));
        scene.setFill(Color.TRANSPARENT);
        //primaryStage.getScene().getRoot().setEffect(new DropShadow(10, 3, 2, Color.BLACK));
        primaryStage.setScene( scene );
        primaryStage.show();

        root.setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                xOffset = event.getSceneX();
                yOffset = event.getSceneY();
            }
        });
        root.setOnMouseDragged(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                primaryStage.setX(event.getScreenX() - xOffset);
                primaryStage.setY(event.getScreenY() - yOffset);
            }
        });
    }

    public Scene getShadowScene(Parent p) {
        Scene scene;
        VBox outer = new VBox();
        outer.getChildren().add( p );
        outer.setPadding(new Insets(20.0d));
        outer.setBackground( new Background(new BackgroundFill( Color.rgb(0,0,0,0), new CornerRadii(0), new
                Insets(0))));

        p.setEffect(new DropShadow(GAUSSIAN, Color.rgb(0,0,0,.25), 15, 0, 0, 0));
        ((VBox)p).setBackground( new Background(new BackgroundFill( Color.TRANSPARENT, new CornerRadii(0), new Insets(0)
        )));

        scene = new Scene( outer );
        scene.setFill( Color.rgb(0,255,0,0) );
        return scene;
    }

    public static void main(String[] args) throws IOException {
        launch(args);

    }
}
