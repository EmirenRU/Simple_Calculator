public class Main
{
    static private final Calculator calculator;

    static {
        try {
            calculator = new Calculator();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args)
    {

    }
}