package de.telran;

public class Main {

    public static void main(String[] args) {
        // write your code here
        System.out.println(divide(10, 3));
        try {
            int res = divideManualException(10, 0);
            System.out.println(res);
            System.out.println("Code after division");
        } catch (CastomArithmeticException ex){
            System.out.println("Caught CustomArithmeticException");
        } catch (ArithmeticException e){
            System.out.println("Caught ArithmeticException");
        }
    }

    public static int divide(int a, int b) {
        int res = a / b;
        return res;
    }

    public static int divideManualException(int a, int b) throws CastomArithmeticException {
        if (b == 0)
            throw new CastomArithmeticException();

        return a / b;
    }

}
