package sgcib.eliot.datalake.HBernate.ioc.engine;

import java.lang.reflect.Constructor;

import sgcib.eliot.datalake.HBernate.ioc.annotations.Bean;
import sgcib.eliot.datalake.HBernate.ioc.exceptions.AnnotationNotFoundException;
import sgcib.eliot.datalake.HBernate.ioc.mapping.IConfigurationMapping;

public class BeanEngine extends Engine {
	private IConfigurationMapping configMapping;

	public BeanEngine(IConfigurationMapping module) {
		this.configMapping = module;
	}

	@Override
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public Object load(Class clazz) throws Throwable {
		if (clazz != null) {
			boolean flag = true;
			int index = 0;

			for (Constructor constructor : clazz.getConstructors()) {
				if (constructor.isAnnotationPresent(Bean.class)) {
					if (flag && index == 0) {
						flag = false;
						index++;

						Class[] parameterTypes = constructor.getParameterTypes();
						Object[] objArr = new Object[parameterTypes.length];
						int i = 0;

						for (Class c : parameterTypes) {
							if (!(c.isPrimitive())) {
								Class dependency = configMapping.getMapping(c);

								if (c.isAssignableFrom(dependency)) {
									objArr[i++] = dependency.getConstructor().newInstance();
								}
							}
						}
						Object resObj = clazz.getConstructor(parameterTypes).newInstance(objArr);
						return resObj;
					}
				}
			}
		}
		throw new AnnotationNotFoundException("Annotation @Bean not found");
	}
}
