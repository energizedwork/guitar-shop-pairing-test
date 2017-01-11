package guitarshop;

public class InvalidLineException extends RuntimeException {
    public String line;

    public InvalidLineException(String line) {
        this.line = line;
    }
}
