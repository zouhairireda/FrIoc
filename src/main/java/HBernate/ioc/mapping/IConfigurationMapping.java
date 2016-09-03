package sgcib.eliot.datalake.HBernate.ioc.mapping;

public interface IConfigurationMapping {
	void configure();
	<T> Class<? extends T> getMapping(Class<T> type);
}
