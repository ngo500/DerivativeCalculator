package application;

import java.util.Queue;
import java.util.Stack;
import java.util.LinkedList;

public class Calculate {
	
	private static Queue<String> queue;
	private static Queue<String> derivedQueue;
	
	private static final char[] acceptableCharacters = 
			new char[]{'a', 'c', 'e', 'i', 'l', 'n', 'o', 'p', 'q', 'r', 's', 't', 'x', '+', '-', '*', '/', '^', '(', ')', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};
	private static Stack<Character> parenthesesStack;
	
	private static RuleHandler rh;
	
	public Calculate() {
		queue = new LinkedList<String>();
		derivedQueue = new LinkedList<String>();
		parenthesesStack = new Stack<Character>();
		rh = new RuleHandler();
	}
	
	//method to call from outside
	public String calculate(String input) {
		queue.clear();
		derivedQueue.clear();
		String output = "";
		// try and catch block for returning errors
		try {
			addToQueue(input);
			deriveTerms();
			output = createOutput();
		}
		catch(Exception e) {
			System.out.println(e);
		}
		return output;
	}
	
	// adds all terms in the input to a queue
	// examples include "tan(x)", "3x^2", "+", "-", 24
	private void addToQueue(String input) throws Exception {
		if(input.length() == 0)
			throw new Exception("Bad input: Empty input");
		if(input.length() > 20)
			throw new Exception("Bad input: Exceeds 20 characters in length");
		// remove spaces from function to ease adding terms
		input = input.replaceAll(" ", "");
		boolean addedOperator = false;
		int start = 0;
		// iterate through function to create terms
		for(int i = 0; i < input.length(); i++) {
			if(!isAcceptable(input.charAt(i)))
				throw new Exception("Bad input: contains an unacceptable character");
			if(input.charAt(i) == '(')
				parenthesesStack.push('(');
			else if(input.charAt(i) == ')') {
                if(parenthesesStack.empty())
                	throw new Exception("Bad input: Doesn't have a beginning parentheses");
                if(parenthesesStack.peek() == '(')
                	parenthesesStack.pop();
                else
                	throw new Exception("Bad input: Doesn't have an ending parentheses");
            }
			// use operands to split terms if the operand is outside parentheses
			if(input.charAt(i) == '+' || input.charAt(i) == '-') {
				if(parenthesesStack.empty()) {
					queue.add(input.substring(start, i));
					start = i;
					queue.add(input.substring(start, i+1));
					start++;
					addedOperator = true;
				}
				else
					addedOperator = false;
			}
			else
				addedOperator = false;
		}
		queue.add(input.substring(start, input.length()));
		// check to see if equation has extra parentheses or operator
		if(!parenthesesStack.empty() || addedOperator)
			throw new Exception("Bad input: Doesn't have an ending parentheses or has multiple operators");
	}
	
	// determines if the character in the input is acceptable
	private boolean isAcceptable(char character) {
		for(int i = 0; i < acceptableCharacters.length; i++) {
			if(character == acceptableCharacters[i])
				return true;
		}
		return false;
	}
	
	// use RuleHandler to derive terms in the queue
	private void deriveTerms() {
		while(!queue.isEmpty()) {
			String term = queue.remove();
			String newTerm = rh.derive(term);
			derivedQueue.add(newTerm);
		}
	}
	
	// make the derived function by putting all the terms back together
	private String createOutput() {
		String outputString = "";
		while(!derivedQueue.isEmpty()) {
			outputString += derivedQueue.poll();
			outputString += " ";
		}
		// fix any possible String errors
		outputString = outputString.replace("+ -", "-");
		outputString = outputString.replace("- +", "-");
		outputString = outputString.replace("+ +", "+");
		outputString = outputString.replace("- -", "+");
		outputString = outputString.replace("* +", "*");
		outputString = outputString.replace("/ +", "/");
		outputString = outputString.trim();
		return outputString;
	}
}
