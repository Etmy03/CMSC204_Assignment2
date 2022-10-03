/**
 * 
 * @author etmybarbosa
 *
 */
public class Notation{
	
	private static MyStack<String> stack;
	private static MyQueue<String> queue;
	
	/**
	 * Convert an infix expression into a postfix expression
	 * @param postfix
	 * @return
	 * @throws InvalidNotationFormatException
	 */
	public static String convertPostfixToInfix​(String postfix) throws InvalidNotationFormatException{
		stack = new MyStack<String>(postfix.length());
		char myChar;
		
		try {
			for(int i=0; i<postfix.length(); i++) {
				myChar = postfix.charAt(i);
				if(myChar == ' ') {
					continue;
				}
				if(Character.isDigit(myChar)) {
					stack.push(Character.toString(myChar));
					continue;
				}
				if(myChar == '+' ||myChar == '-' ||myChar == '*' ||myChar == '/') {
					if(stack.size() < 2) {
						throw new InvalidNotationFormatException();
					}
					else {
						String x = stack.pop();
						String y = stack.pop();
						String str = "(" + y + Character.toString(myChar) + x + ")";
						stack.push(str);
					}
				}
			}
			if(stack.size() != 1) {
				throw new InvalidNotationFormatException();
			}
			return stack.toString();
		}catch(Exception e) {
			throw new InvalidNotationFormatException();
		}
		
	}
	
	/**
	 * Convert the Postfix expression to the Infix expression
	 * @param infix
	 * @return
	 * @throws InvalidNotationFormatException
	 */
	public static String convertInfixToPostfix​(String infix) throws InvalidNotationFormatException{
		stack = new MyStack<String>(infix.length());
		queue = new MyQueue<String>(infix.length());
		char myChar;
		try {
			for(int i=0; i<infix.length(); i++) {
				myChar = infix.charAt(i);
				if(myChar == ' ') {
					continue;
				}
				if(Character.isDigit(myChar)) {
					queue.enqueue(Character.toString(myChar));
					continue;
				}
				if(myChar == '(') {
					stack.push(Character.toString(myChar));
					continue;
				}
				if(myChar == '+' ||myChar == '-' ||myChar == '*' ||myChar == '/') {
					if(!stack.isEmpty()) {
						String op = stack.top();
						if(op.equals("(")) {
							stack.push(Character.toString(myChar));
							continue;
						}
						if(!(op.equals("+")||op.equals("-")||op.equals("*")||op.equals("/"))) {
							stack.push(Character.toString(myChar));
							continue;
						}
						else {
							String str = "";
							
							if((myChar == '+' ||myChar == '-') && (op.equals("*")||op.equals("/"))) {
								str = op + myChar;
							}
							else if((myChar == '*' ||myChar == '/') && (op.equals("+")||op.equals("-"))){
								str = myChar + op;
							}
							else {
								str = myChar + op;
							}
							stack.push(str);
						}
					}
					else {
						stack.push(Character.toString(myChar));
					}
					continue;
				}
				if(myChar == ')') {
					String c;
					try {
						do {
							c = stack.pop();
							if(!c.equals("(")) {
								queue.enqueue(c);
							}
							if(c.equals("(")) {
								continue;
							}
							if(stack.isEmpty()||!stack.top().equals("(")) {
								throw new InvalidNotationFormatException();
							}
							
						}while((!(c.equals("("))) && !(stack.isEmpty()));
					}catch(Exception e) {
						throw new InvalidNotationFormatException();
					}
					continue;
				}
			}
			for(int i=0; i< stack.size(); i++) {
				queue.enqueue(stack.pop());
			}
			return queue.toString();
		}catch(Exception e) {
			throw new InvalidNotationFormatException();
		}
		//return "";
	}
	
	/**
	 * Evaluates a postfix expression from a string to a doubled
	 * @param postfixExpr
	 * @return
	 * @throws InvalidNotationFormatException
	 */
	public static double evaluatePostfixExpression​(String postfixExpr) throws InvalidNotationFormatException{
		stack = new MyStack<String>(postfixExpr.length());
		char myChar;
		try {
			for(int i=0; i<postfixExpr.length(); i++) {
				myChar = postfixExpr.charAt(i);
				if(myChar == ' ') {
					continue;
				}
				if(Character.isDigit(myChar) || myChar == '(') {
					stack.push(Character.toString(myChar));
				}
				if(myChar == '+' ||myChar == '-' ||myChar == '*' ||myChar == '/') {
					if(stack.size() < 2) {
						throw new InvalidNotationFormatException();
					}
					else {
						String x = stack.pop();
						double num2 = Double.valueOf(x);
						String y = stack.pop();
						double num1 = Double.valueOf(y);
						double total = 0;
						if(myChar == '+') {
							total = num1+num2;
						}
						else if(myChar == '-') {
							total = num1-num2;
						}
						else if(myChar == '*') {
							total = num1*num2;
						}
						else if(myChar == '/') {
							total = num1/num2;
						}
						stack.push(String.valueOf(total));
					}
				}
				
			}
			if(stack.size() == 1) {
				return Double.valueOf(stack.toString());
			}
			else {
				throw new InvalidNotationFormatException();
			}
		}catch(Exception e) {
			throw new InvalidNotationFormatException();
		}
		//return 0.0;
	}
}
