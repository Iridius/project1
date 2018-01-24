package controller;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Main extends Application {

    //public static void main(String[] args) {
    //    launch(args);
    //}

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Drawing Operations Test");
        Group root = new Group();
        Canvas canvas = new Canvas(1000, 1000);
        drawField(canvas.getGraphicsContext2D());
        root.getChildren().add(canvas);
        primaryStage.setScene(new Scene(root, 300, 300));
        primaryStage.show();
    }

    private void drawField(GraphicsContext gc) {
        gc.setFill(Color.GREEN);
        gc.setStroke(Color.BLUE);
        gc.setLineWidth(1.0);

        int rect_width = 0;
        int rect_height = 0;
        int y = 0;

        for(int i = 0; i <= Config.RECT_COUNT; i++){
            int x = 0;

            for(int j = 0; j <= Config.RECT_COUNT; j++){
                rect_height = Config.RECT_HEIGHT;
                if(i == 0 || i == Config.RECT_COUNT){
                    rect_height = 2 * Config.RECT_HEIGHT;
                }

                rect_width = Config.RECT_WIDTH;
                if(j == 0 || j == Config.RECT_COUNT){
                    rect_width = 2 * Config.RECT_WIDTH;
                }

                if(i == 0 || i == Config.RECT_COUNT || j == 0 || j == Config.RECT_COUNT){
                    gc.strokeRoundRect(
                        x,
                        y,
                        rect_width,
                        rect_height,
                        Config.RECT_ROUND_RADIUS,
                        Config.RECT_ROUND_RADIUS
                    );
                }

                x = x + rect_width + Config.RECT_INTERVAL;
            }

            y = y + rect_height + Config.RECT_INTERVAL;
        }
    }
}