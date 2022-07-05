package africa.semicolon.Exceptions;

public class UserAlreadyExistException extends  EmailNotFoundException{
    public UserAlreadyExistException(String message) {
        super(message);
    }
}
