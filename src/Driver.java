import java.util.*;


public class Driver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scnr = new Scanner(System.in);
		
		System.out.println("Enter your Infix Expression..");
		String infix = scnr.nextLine();
		
//		char infArr[] = infix.toCharArray();
		//String infix = "a+b*(c^d-e)^(f+g*h)-i";
		//( 2 + ( ( 3 + 4 ) * ( 5 * 6 ) ) )
		
		String postfix = infToPostfix(infix);
		String prefix = infToPrefix(infix);
		Double result = evaluate(postfix);
		
		System.out.println("Infix Expression: " + infix);
		System.out.println("Postfix Expression: " + postfix);
		System.out.println("Prefix Expression: " + prefix);
		System.out.println("Evaluation: " + result);
		scnr.close();
	}
	
	/*
	 * this function evaluates the expression
	 * @return result the answer of the expression
	 */
	public static double evaluate(String postfix) {
		Stack<Double> operands = new Stack<Double>();
		
		double a,b;
		//read in the string
		for(int i = 0; i <postfix.length(); i++) {
			char c = postfix.charAt(i);
			if (Character.isWhitespace(c))
				continue;
			if(Character.isDigit(c))
				operands.push((double) c - '0');
			else {
				b = operands.pop();
				a = operands.pop();
				switch(c)
                {
                    case '+':
                    operands.push(a + b);
                    break;
                     
                    case '-':
                    operands.push(a - b);
                    break;
                     
                    case '/':
                    operands.push(a / b);
                    break;
                     
                    case '*':
                    operands.push(a * b);
                    break;
              }
            }
        }
        return operands.pop(); 
				//System.out.println(ans);
		
	}
	
	/*
	 * This reverses a string and returns an array
	 */
	public static String reverse(String exp) {
		char arr[] = exp.toCharArray();
		int n = exp.length();
		char[] revArr = new char[n]; 
        int j = n; 
        for (int i = 0; i < n; i++) { 
        	if(arr[i] == '(')
        		arr[i] = ')';
        	else if (arr[i] == ')')
        		arr[i] = '(';
            revArr[j - 1] = arr[i]; 
            j = j - 1;
        }
        StringBuilder reverse = new StringBuilder();
        reverse.append(revArr);
        
        return reverse.toString();
	}
	
	/*
	 * Turns infix expression to prefix
	 * @return prefix
	 */
	public static String infToPrefix(String infix) {
		//Reverse infix expression
		String revExp = reverse(infix);
		
		String postfix = infToPostfix(revExp);
		revExp = reverse(postfix);

		return revExp;
	}


	
	/*
	 * Checks precedence of operators
	 */
	static int Prec(char c)
    {
        switch (c) {
        case '+':
        case '-':
            return 1;
 
        case '*':
        case '/':
            return 2;
 
        case '^':
            return 3;
        }
        return -1;
    }
	
	/*
	 * Changes infix to postfix
	 * @return String of postfix expression
	 */
	public static String infToPostfix(String infix) {
		StringBuilder builder = new StringBuilder();
		Stack<Character> stack = new Stack<Character>();
		for (int i = 0; i< infix.length(); ++i) {
			char c = infix.charAt(i);
			if (Character.isWhitespace(c))
				continue;
			if (Character.isLetterOrDigit(c)) 
				if((i+1<infix.length()) && (Character.isDigit(infix.charAt(i+1)))) {
                    builder.append( c + infix.charAt(i+1) + ' ');
                    i++;
                }
                else {
                    builder.append(c + ' ');
                }
			else if (c == '(')
				stack.push(c);
			else if ( c == ')') {
				while (!stack.isEmpty() && stack.peek() != '(') {
					builder.append(stack.peek() + " ");
					stack.pop();
				}
				stack.pop();
 			}else {
 				while (!stack.isEmpty() && Prec(c) <= Prec(stack.peek())) {
 					builder.append(stack.peek() + " ");
 					stack.pop();
 				}
 				stack.push(c);
				
			}
		}
		
		while (!stack.isEmpty()) {
			if (stack.peek() == '(') 
				return "Invalid expresion";
			builder.append(stack.peek() + " ");
			stack.pop();
		}
		return (builder.toString()).trim();
	}
	
	

}
