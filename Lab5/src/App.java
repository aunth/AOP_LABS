
import javafx.application.Application;
import javafx.scene.Cursor;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class App extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Hello, JavaFX!");
    
        // Load the imaged
        Image image = new Image(getClass().getResourceAsStream("/images/telephone.png"));
        ImageView imageView = new ImageView(image);
        imageView.setFitWidth(200); 
        imageView.setFitHeight(200); 
        imageView.setPreserveRatio(true);
        imageView.setTranslateX(-300);
        imageView.setTranslateY(-250);

        
        Text text = new Text("Замовити зворотній дзвінок");
        text.setFont(Font.font("Arial", FontWeight.BOLD, 30));
        text.setFill(Color.ORANGE.deriveColor(0, 1, 0.8, 1));
        text.setTranslateX(120);
        text.setTranslateY(-270);

        DropShadow dropShadow = new DropShadow();
        dropShadow.setRadius(5.0);
        dropShadow.setOffsetX(3.0);
        dropShadow.setOffsetY(3.0);

        Label label1 = new Label("Ваше ім'я: ");
        label1.setFont(Font.font("Arial", 21));
        TextField textField = new TextField();
        textField.setPrefHeight(50);
        textField.setPrefWidth(200);
        textField.setEffect(dropShadow);
        HBox hb1 = new HBox();
        hb1.getChildren().addAll(label1, textField);
        hb1.setSpacing(10);
        hb1.setTranslateX(450);
        hb1.setTranslateY(150);
        

        Label label2 = new Label("Телефон: ");
        label2.setFont(Font.font("Arial", 21));
        TextField textField1 = new TextField();
        textField1.setPrefHeight(50);
        textField1.setPrefWidth(200);
        textField1.setEffect(dropShadow);
        HBox hb2 = new HBox();
        hb2.getChildren().addAll(label2, textField1);
        hb2.setSpacing(10);
        hb2.setTranslateX(450);
        hb2.setTranslateY(240);

        ToggleGroup toggleGroup = new ToggleGroup();

        // Create radio buttons with circular indicators
        RadioButton radioButton1 = new RadioButton("Київ");
        radioButton1.setToggleGroup(toggleGroup);
        radioButton1.setStyle("-fx-font-size: 21; -fx-font-family: 'Arial'; -fx-text-fill: black;");


        RadioButton radioButton2 = new RadioButton("Харків");
        radioButton2.setToggleGroup(toggleGroup);
        radioButton2.setStyle("-fx-font-size: 21; -fx-font-family: 'Arial'; -fx-text-fill: black;");


        RadioButton radioButton3 = new RadioButton("Одеса");
        radioButton3.setToggleGroup(toggleGroup);
        radioButton3.setStyle("-fx-font-size: 21; -fx-font-family: 'Arial'; -fx-text-fill: black;");


        VBox vbox = new VBox(20); 
        vbox.getChildren().addAll(radioButton1, radioButton2, radioButton3);
        vbox.setTranslateX(220);
        vbox.setTranslateY(170);


        Text cityLabel = new Text("Місто: ");
        cityLabel.setFont(Font.font("Arial", FontWeight.BOLD, 26));
        cityLabel.setFill(Color.BLACK);
        cityLabel.setTranslateX(-290);
        cityLabel.setTranslateY(-120);

        Rectangle line = new Rectangle(750, 3, Color.GREEN);
        line.setTranslateY(0);
        line.setEffect(dropShadow);

        Text additionalInfo = new Text("Додаткова інформація: ");
        additionalInfo.setFont(Font.font("Arial", FontPosture.ITALIC, 21));
        additionalInfo.setFill(Color.BLACK);
        additionalInfo.setTranslateX(-220);
        additionalInfo.setTranslateY(50);

        TextField additionalInfoField = new TextField();
        additionalInfoField.setAlignment(javafx.geometry.Pos.TOP_LEFT);
        additionalInfoField.setPrefWidth(680);
        additionalInfoField.setMaxWidth(680);
        additionalInfoField.setPrefHeight(150);
        additionalInfoField.setTranslateX(0);
        additionalInfoField.setTranslateY(148);
        additionalInfoField.positionCaret(0);


        Button sendButton = new Button("Надіслати");
        sendButton.setFont(Font.font("Arial", FontWeight.BOLD,24));
        sendButton.setTextFill(Color.WHITE);
        sendButton.setStyle("-fx-background-color: black;");
        sendButton.setEffect(dropShadow);
        sendButton.setTranslateX(0);
        sendButton.setTranslateY(300);
        sendButton.setPrefSize(230, 40);

        sendButton.setOnAction(e -> {
            System.out.println("Button clicked!");
        });

        StackPane root = new StackPane();
        root.getChildren().add(imageView);
        root.getChildren().add(text);
        root.getChildren().add(cityLabel);
        root.getChildren().add(vbox);
        root.getChildren().add(hb1);
        root.getChildren().add(hb2);
        root.getChildren().add(line);
        root.getChildren().add(additionalInfoField);
        root.getChildren().add(additionalInfo);
        root.getChildren().add(sendButton);

        Scene scene = new Scene(root, 800, 700);
        scene.setFill(javafx.scene.paint.Color.rgb(245, 245, 245));

        primaryStage.setScene(scene);

        primaryStage.setResizable(false);


        primaryStage.show();
    }
}
