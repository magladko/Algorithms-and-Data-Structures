package com;

import java.util.Stack;

public class ArithmeticStack {

    String wyr;
    int maxArgStackSize;
    int maxOpStackSize;
    int popArgs;
    int popOps;
    int pushArgs;
    int pushOps;
    Stack<Character> operators;
    Stack<Integer> arguments;

    public static void main(String[] args) {
//        ArithmeticStack a1 = new ArithmeticStack("((1+(5+4))*(3*((8+6)+2)))");
//        ArithmeticStack a2 = new ArithmeticStack("(5+(((2*((3*4)*4))+7)*2))"); // (5+(((2*((3*4)*4))+7)*2))
<<<<<<< HEAD
 //       ArithmeticStack a3 = new ArithmeticStack("(2*((7*8)+(2*((6+7)*8))))");
//        ArithmeticStack a1 = new ArithmeticStack("((5+(((1+2)*8)*(5+5)))*8)");
//            ArithmeticStack a1 = new ArithmeticStack("(((3+(7*3))+7)+(4+(2*2)))");
//            ArithmeticStack a2 = new ArithmeticStack("(((2*((4+(5*8))*4))*4)*9)");
//            ArithmeticStack a3 = new ArithmeticStack("(((6+9)+(3*(1*4)))*7)*6)");

       // a1.printDetails();
      // a2.printDetails();
       // a3.printDetails();
=======
//        ArithmeticStack a3 = new ArithmeticStack("(2*((7*8)+(2*((6+7)*8))))");
        ArithmeticStack a1 = new ArithmeticStack("((5+(((1+2)*8)*(5+5)))*8)");

        a1.printDetails();
//        a2.printDetails();
//        a3.printDetails();
>>>>>>> 41df3d944dd834b414f35f35790cf0626a1c8262
    }

    public ArithmeticStack(String input) {
        this.wyr = input;

        operators = new Stack<>();
        arguments = new Stack<>();

        maxArgStackSize = 0;
        maxOpStackSize = 0;
        popArgs = 0;
        popOps = 0;
        pushArgs = 0;
        pushOps = 0;
        count();
    }

    public void count() {
        String[] splitted = wyr.split("");
        for (String s : splitted) {
            switch (s) {
                case "*", "+" -> {
                    operators.push(s.charAt(0)); pushOps++;
                    if (operators.size() > maxOpStackSize) maxOpStackSize = operators.size();
                }
                case ")" -> {
                    Character operator = operators.pop();
                    popOps++;

                    Integer a = arguments.pop();
                    popArgs++;
                    Integer b = arguments.pop();
                    popArgs++;

                    pushArgs++;
                    if (operator.equals('+')) {
                        arguments.push(a + b);
                    } else {
                        arguments.push(a * b);
                    }
                }
                case "(" -> {}
                default -> {
                    arguments.push(Integer.parseInt(s)); pushArgs++;
                    if (arguments.size() > maxArgStackSize) maxArgStackSize = arguments.size();
                }
            }
        }
    }

    public void printDetails() {
        System.out.println();
        System.out.println("for: " + wyr);
        System.out.println("Max ARGS stack: " + maxArgStackSize);
        System.out.println("Max OPS stack:  " + maxOpStackSize);
        System.out.println("TOTAL pops:   " + popArgs + popOps);
        System.out.println(" - pop ARGS:  " + popArgs);
        System.out.println(" - pop OPS:   " + popOps);
        System.out.println("TOTAL push:   " + pushArgs + pushOps);
        System.out.println(" - push ARGS: " + pushArgs);
        System.out.println(" - push OPS:  " + pushOps);
        System.out.println();
    }

}
