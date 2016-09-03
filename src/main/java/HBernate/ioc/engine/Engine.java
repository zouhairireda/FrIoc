package sgcib.eliot.datalake.HBernate.ioc.engine;

public abstract class Engine {

	@SuppressWarnings("rawtypes")
	public abstract Object load(Class clazz) throws Throwable;
}
