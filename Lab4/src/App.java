
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class App extends Application {

    @Override
    public void start(Stage primaryStage) {
        // Creating shapes
        Rectangle square = new Rectangle(200, 200);
        square.setFill(Color.RED);

        Polygon triangle = new Polygon(0, 0, 100, 200, 200, 0);
        triangle.setFill(Color.GREEN);

        Circle circle = new Circle(50);
        circle.setFill(Color.BLUE);

        Text nameLabel = new Text("Vlad Maslianko");
        nameLabel.setFont(Font.font("Arial", FontWeight.SEMI_BOLD, FontPosture.ITALIC, 20));
        nameLabel.setFill(Color.BLUE);
        nameLabel.setTranslateY(-200);

        StackPane root = new StackPane();
        root.getChildren().addAll(square, triangle, circle, nameLabel);

        StackPane.setMargin(nameLabel, new javafx.geometry.Insets(20, 0, 0, 0));

        Scene scene = new Scene(root, 600, 600);

        primaryStage.setTitle("Shapes App");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
