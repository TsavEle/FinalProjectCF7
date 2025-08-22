package finalProject.exceptions;



import java.io.Serial;


public class LawyerDAOException extends Exception {
    @Serial
    private static final long serialVersionUID = 1L;

    public LawyerDAOException(String s) {
        super(s);
    }
}
