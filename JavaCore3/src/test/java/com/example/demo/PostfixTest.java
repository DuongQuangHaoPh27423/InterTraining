package com.example.demo;

import org.testng.annotations.Test;
import org.junit.jupiter.api.Assertions;

public class PostfixTest {
    @Test
    public void testEvaluateExpression_Addition() {
        String expression = "2+3";
        double expected = 5.0;
        double actual = Demo.evaluateExpression(expression);
        Assertions.assertEquals(actual, expected, 0.001);
    }

    @Test
    public void testEvaluateExpression_Subtraction() {
        String expression = "10-5";
        double expected = 5.0;
        double actual = Demo.evaluateExpression(expression);
        Assertions.assertEquals(actual, expected, 0.001);
    }

    @Test
    public void testEvaluateExpression_Multiplication() {
        String expression = "2*3";
        double expected = 6.0;
        double actual = Demo.evaluateExpression(expression);
        Assertions.assertEquals(actual, expected, 0.001);
    }

    @Test
    public void testEvaluateExpression_Division() {
        String expression = "10/2";
        double expected = 5.0;
        double actual = Demo.evaluateExpression(expression);
        Assertions.assertEquals(actual, expected, 0.001);
    }

    @Test
    public void testEvaluateExpression_ComplexExpression() {
        String expression = "5+3*2-6/2";
        double expected = 8.0;
        double actual = Demo.evaluateExpression(expression);
        Assertions.assertEquals(actual, expected, 0.001);
    }

    @Test
    public void testEvaluateExpression_Negativeactual() {
        String expression = "5-10";
        double expected = -5.0;
        double actual = Demo.evaluateExpression(expression);
        Assertions.assertEquals(actual, expected, 0.001);
    }

    @Test
    public void testEvaluateExpression_Decimalactual() {
        String expression = "3.5+1.5";
        double expected = 5.0;
        double actual = Demo.evaluateExpression(expression);
        Assertions.assertEquals(actual, expected, 0.001);
    }

    @Test
    public void testEvaluateExpression_Parentheses() {
        String expression = "(2+3)*4";
        double expected = 20.0;
        double actual = Demo.evaluateExpression(expression);
        Assertions.assertEquals(actual, expected, 0.001);
    }

    @Test
    public void testEvaluateExpression_ComplexWithParentheses() {
        String expression = "((10-5)*2+4)/2";
        double expected = 7.0;
        double actual = Demo.evaluateExpression(expression);
        Assertions.assertEquals(actual, expected, 0.001);
    }



    @Test
    public void testEvaluateExpression_EmptyExpression() {
        String expression = "";
        try {
            Demo.evaluateExpression(expression);
            // If the evaluation does not throw an exception, the test fails
            Assertions.assertEquals(true, false);
        } catch (RuntimeException e) {
            // Empty expression, the test passes
            Assertions.assertEquals(true, true);
        }
    }
}
