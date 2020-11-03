package application;

import javafx.scene.control.Button;

public class ButtonHandler
{
	public ButtonHandler()
	{
		
	}
	
	
	public Button create60pxButton(String buttonText)
	{
		Button Btn = new Button(buttonText);
		Btn.setPrefWidth(60);
		
		return Btn;
	}
	
	
	public Button createCalculateButton()
	{
		Button calculate = new Button("Calculate");
		calculate.setPrefHeight(50);
		calculate.setPrefWidth(110);
		
		return calculate;
	}
	
}
