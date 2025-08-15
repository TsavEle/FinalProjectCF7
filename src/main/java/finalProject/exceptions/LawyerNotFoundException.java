package finalProject.exceptions;

import java.io.Serial;

public class LawyerNotFoundException extends Exception {
    @Serial
    private static final long serialVersionUID = 1L;

    public LawyerNotFoundException(String s) {
        super(s);
    }
}
