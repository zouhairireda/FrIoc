package sgcib.eliot.datalake.HBernate.ioc.mapping;

import java.util.HashMap;
import java.util.Map;

public abstract class AbstractConfigurationMapping implements IConfigurationMapping {
	private Map<Class<?>, Class<?>> classMap = new HashMap<>();

	public abstract void configure();

	protected <T> void createMapping(Class<T> baseClass, Class<? extends T> subClass) {
		classMap.put(baseClass, subClass.asSubclass(baseClass));
	}

	public <T> Class<? extends T> getMapping(Class<T> type) {
		Class<?> implementation = classMap.get(type);
		if(implementation == null) {
			throw new IllegalArgumentException("Couldn't find the mapping for : " + type);
		}
		return implementation.asSubclass(type);
	}

}
