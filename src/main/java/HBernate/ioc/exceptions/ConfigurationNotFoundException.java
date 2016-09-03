package sgcib.eliot.datalake.HBernate.ioc.exceptions;

public class ConfigurationNotFoundException extends RuntimeException {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	protected String message;

	public ConfigurationNotFoundException() {
		super();
	}

	public ConfigurationNotFoundException(String message) {
		super(message);
		this.message = message;
	}

	public String getMessage() {
		return this.message;
	}
}
