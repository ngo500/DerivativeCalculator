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
	
	public String calculate(String input) {
		queue.clear();
		derivedQueue.clear();
		String output = "";
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
	
	public void addToQueue(String input) throws Exception {
		if(input.length() == 0)
			throw new Exception("Bad input: Empty input");
		input = input.replaceAll(" ", "");
		boolean addedOperand = false;
		int start = 0;
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
			if(input.charAt(i) == '+' || input.charAt(i) == '-' || input.charAt(i) == '*' || input.charAt(i) == '/') {
				if(parenthesesStack.empty()) {
					queue.add(input.substring(start, i));
					start = i;
					queue.add(input.substring(start, i+1));
					start++;
					addedOperand = true;
				}
				else
					addedOperand = false;
			}
			else
				addedOperand = false;
		}
		queue.add(input.substring(start, input.length()));
		if(!parenthesesStack.empty() || addedOperand)
			throw new Exception("Bad input: Doesn't have an ending parentheses or has multiple operators");
	}
	
	public boolean isAcceptable(char character) {
		for(int i = 0; i < acceptableCharacters.length; i++) {
			if(character == acceptableCharacters[i])
				return true;
		}
		return false;
	}
	
	public void deriveTerms() {
		while(!queue.isEmpty()) {
			String term = queue.remove();
			String newTerm = rh.derive(term);
			derivedQueue.add(newTerm);
		}
	}
	
	public String createOutput() {
		String outputString = "";
		while(!derivedQueue.isEmpty()) {
			outputString += derivedQueue.poll();
			outputString += " ";
		}
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
