package finalProject.exceptions;

import java.io.Serial;

public class LawyerAlreadyExistsException extends Exception {
    @Serial
    private static final long serialVersionUID = 1L;

    public LawyerAlreadyExistsException(String s) {
        super(s);
    }
}
