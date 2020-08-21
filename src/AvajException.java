package src;

public class AvajException extends Exception {

    /**
     *
     */
    private static final long serialVersionUID = 231686548957612676L;
    
    public AvajException(String error) {
        super(error);
    }

    public static void printHelp() {
        System.out.println(
            "TO BE TYPED"
        );
    }
}