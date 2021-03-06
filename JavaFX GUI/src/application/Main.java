package application;
	
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.VBox;


public class Main extends Application {
	
	// Calls the ButtonHandler.java class and initializes all the math function buttons
	ButtonHandler buttonHandler = new ButtonHandler();
	
	Button sinBtn = buttonHandler.createButton("sin", 60, 25);
	Button cosBtn = buttonHandler.createButton("cos", 60, 25);
	Button tanBtn = buttonHandler.createButton("tan", 60, 25);
	Button addBtn = buttonHandler.createButton("+", 60, 25);
	Button divideBtn = buttonHandler.createButton("/", 60, 25);
	Button exponentBtn = buttonHandler.createButton("^", 60, 25);
	Button eBtn = buttonHandler.createButton("e", 60, 25);
	Button lnBtn = buttonHandler.createButton("ln", 60, 25);
	Button subtractBtn = buttonHandler.createButton("-", 60, 25);
	Button sqrtBtn = buttonHandler.createButton("\u221A", 60, 25);		// \u221A is the Unicode escape for the square root symbol in UTF-16 encoding
	Button inverseSinBtn = buttonHandler.createButton("sin^-1", 60, 25);
	Button inverseCosBtn = buttonHandler.createButton("cos^-1", 60, 25);
	Button inverseTanBtn = buttonHandler.createButton("tan^-1", 60, 25);
	Button multiplyBtn = buttonHandler.createButton("*", 60, 25);
	Button piBtn = buttonHandler.createButton("\u03C0", 60, 25);		// \u03C0 is the Unicode escape for the pi symbol in UTF-16 encoding
	Button calculateBtn = buttonHandler.createButton("Calculate", 110, 50);
	
	// Creates the input function text field
	TextField inputFunction = functionTextField();
	
	
	@Override
	public void start(Stage primaryStage) {
		try {
			BorderPane root = new BorderPane();
			
			root.setTop(mathButtonsWithLabel());
			root.setCenter(functionsSection());
			root.setRight(calculateSection());
			
			Scene scene = new Scene(root,400,400);
			primaryStage.setScene(scene);
			primaryStage.show();
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	
	// Creates a function text field with a preferred height of 50px
	private TextField functionTextField()
	{
		TextField function = new TextField();
		function.setPrefHeight(50);
		
		return function;
	}
	
	
	// Sets the on-click action of the math buttons to add their value to the input function text field
	public void setMathButtonsToAddInputOnButtonClick()
	{
		sinBtn.setOnAction(t -> inputFunction.setText(inputFunction.getText() + "sin()"));
		cosBtn.setOnAction(t -> inputFunction.setText(inputFunction.getText() + "cos()"));
		tanBtn.setOnAction(t -> inputFunction.setText(inputFunction.getText() + "tan()"));
		addBtn.setOnAction(t -> inputFunction.setText(inputFunction.getText() + "+"));
		divideBtn.setOnAction(t -> inputFunction.setText(inputFunction.getText() + "/"));
		exponentBtn.setOnAction(t -> inputFunction.setText(inputFunction.getText() + "^"));
		eBtn.setOnAction(t -> inputFunction.setText(inputFunction.getText() + "e"));
		lnBtn.setOnAction(t -> inputFunction.setText(inputFunction.getText() + "ln()"));
		subtractBtn.setOnAction(t -> inputFunction.setText(inputFunction.getText() + "-"));
		sqrtBtn.setOnAction(t -> inputFunction.setText(inputFunction.getText() + "\u221A()"));
		inverseSinBtn.setOnAction(t -> inputFunction.setText(inputFunction.getText() + "sin^-1()"));
		inverseCosBtn.setOnAction(t -> inputFunction.setText(inputFunction.getText() + "cos^-1()"));
		inverseTanBtn.setOnAction(t -> inputFunction.setText(inputFunction.getText() + "tan^-1()"));
		multiplyBtn.setOnAction(t -> inputFunction.setText(inputFunction.getText() + "*"));
		piBtn.setOnAction(t -> inputFunction.setText(inputFunction.getText() + "\u03C0"));
	}
	
	
	/*
	 * Creates a vertical box to be used in the center section of the border pane .
	 * Includes an input function label, output function label, and text fields for the input and derived functions.
	 */
	private VBox functionsSection()
	{
		VBox vbox = new VBox();
		Label inputLabel = new Label("Input Function:");
		Label outputLabel = new Label("Output");
		TextField derivedFunction = functionTextField();
		
		inputFunction.setPromptText("Enter function to be derived here");
		setMathButtonsToAddInputOnButtonClick();
		
		vbox.getChildren().addAll(inputLabel, inputFunction, outputLabel, derivedFunction);
		vbox.setPadding(new Insets(10, 10, 10, 10));
		
		return vbox;
	}
	
	
	/*
	 * Creates a vertical box to be used in the right section of the border pane .
	 * Includes the calculate button and a calculation outcome label.
	 */
	private VBox calculateSection()
	{
		// Creates a vertical box with 15px of spacing between each added item
		VBox vbox = new VBox(15);
		
		Label calculationOutcome = new Label("Temp placeholder");
		calculationOutcome.setPrefWidth(120);
		calculationOutcome.setPrefHeight(50);
		
		calculateBtn.setOnAction(t -> calculationOutcome.setText("Derivative calculated"));
		
		vbox.getChildren().addAll(calculateBtn, calculationOutcome);
		
		// Sets top padding to line up with the calculate button with the input function text field.
		vbox.setPadding(new Insets(27, 0, 0, 0));
		
		return vbox;
	}
	
	
	/*
	 * Creates a vertical box to be used in the top section of the border pane .
	 * Includes the math function buttons flowpane and a label letting the usere know to only use x for the calculation.
	 * This allows the label to always be on top of the math function buttons, no matter the width of the application.
	 */
	private VBox mathButtonsWithLabel()
	{
		VBox vbox = new VBox();
		Label onlyUseX = new Label("*Only use variable x for the calculation \n" + " ");
		
		vbox.setPadding(new Insets(10, 10, 10, 10));
		vbox.getChildren().addAll(onlyUseX, mathButtonsFlowPane());
		
		return vbox;
	}

	
	// Organize all of the math function buttons into a flowpane
	private FlowPane mathButtonsFlowPane()
	{
		FlowPane flowpane = new FlowPane();
		
		flowpane.setVgap(20);
		flowpane.setHgap(20);
		flowpane.getChildren().addAll(sinBtn, cosBtn, tanBtn, addBtn, divideBtn, exponentBtn, eBtn, lnBtn, 
				subtractBtn, sqrtBtn, inverseSinBtn, inverseCosBtn, inverseTanBtn, multiplyBtn, piBtn);
		
		return flowpane;
	}
	
	
	
	
	
	public static void main(String[] args) {
		launch(args);
	}
}
