package sgcib.eliot.datalake.HBernate.ioc.exceptions;

public class AnnotationNotFoundException extends Throwable {

	/**
	 *
	 */
	private static final long serialVersionUID = -7887792848787904537L;

	private String message;

	public AnnotationNotFoundException() {
		super();
	}

	public AnnotationNotFoundException(String message) {
		super(message);
		this.message = message;
	}

	public String getMessage() {
		return message;
	}
}
