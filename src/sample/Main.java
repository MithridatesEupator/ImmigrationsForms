package sample;

import javafx.event.EventHandler;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
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

import java.awt.*;
import java.io.IOException;
//import java.io.*;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDDocumentCatalog;
import org.apache.pdfbox.pdmodel.interactive.form.*;


public class Main extends Application {

    private double xOffset = 0;
    private double yOffset = 0;

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("mainWindow.fxml"));
        primaryStage.setTitle("PDF Filler Application");
        primaryStage.setResizable(false);
        //Image image1 = new Image(this.getClass().getResourceAsStream("resources//icon.png"));
        //primaryStage.getIcons(image1);
        //primaryStage.getIcons().add(new Image(ClassLoader.getSystemResourceAsStream("/icon.png")));
        //Image AppIcon = new Image(this.getClass().getResource("/images/quit.png"));
        //primaryStage.getIcons().add(AppIcon);
        //primaryStage.getIcons().add(new Image(getClass().getResourceAsStream("resources//icon.png")));
        try {
            primaryStage.getIcons().add(new Image(ClassLoader.getSystemResourceAsStream("sample/resources/images/icon.png")));
        }
        catch (Exception ex) {

        }
        primaryStage.setScene(new Scene(root, 800, 600));
        primaryStage.getScene().setFill(Color.TRANSPARENT);
        primaryStage.getScene().getRoot().setEffect(new DropShadow(10, 3, 2, Color.BLACK));
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

    public static void main(String[] args) throws IOException {
        launch(args);

    }
}
