package application;

import javafx.scene.control.Button;

public class ButtonHandler
{
	// Creates a button with the provided text, width, and height
	public Button createButton(String buttonText, int width, int height)
	{
		Button Btn = new Button(buttonText);
		Btn.setPrefWidth(width);
		Btn.setPrefHeight(height);
		
		return Btn;
	}
}
