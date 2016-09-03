package sgcib.eliot.datalake.HBernate.ioc.exceptions;

public class MalformedConfigurationException extends RuntimeException {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	protected String message;

	public MalformedConfigurationException() {
		super();
	}

	public MalformedConfigurationException(String message) {
		super(message);
		this.message = message;
	}

	public String getMessage() {
		return message;
	}
}
