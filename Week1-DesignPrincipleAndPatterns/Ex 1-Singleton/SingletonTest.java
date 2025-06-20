package singleton;

public class SingletonTest {

    public static void main(String[] args) {

        Logger logger1 = Logger.getInstance();
        logger1.log("First message from logger1.");

        Logger logger2 = Logger.getInstance();
        logger2.log("Second message from logger2.");


        if (logger1 == logger2) {
            System.out.println("Both logger1 and logger2 refer to the same instance(Singleton confirmed).");
        } else {
            System.out.println("Different instances detected!");
        }
    }
}

