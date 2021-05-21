package exceptions;

/**
 * An Exception which deals with a customer who asks to be removed from a provider list, while not being in it.
 */
public class  CustomerNotListedException extends Exception {
    public  CustomerNotListedException(){
        super();
    }
}
