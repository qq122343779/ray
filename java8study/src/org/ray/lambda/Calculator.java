package org.ray.lambda;

public class Calculator {

	interface IntegerMath {
		int operation(int a, int b);
	}

	public int operateBinary(int a, int b, IntegerMath op) {
		return op.operation(a, b);
	}

	public static void main(String[] args) {
		Calculator myapp = new Calculator();
		IntegerMath addition = (a, b) -> a + b;
		IntegerMath subtraction = (a, b) -> a - b;
		
		System.out.println(myapp.operateBinary(5, 5, addition));
		System.out.println(myapp.operateBinary(5, 6, subtraction));

	}
}
