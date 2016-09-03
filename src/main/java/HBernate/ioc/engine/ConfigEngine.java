package sgcib.eliot.datalake.HBernate.ioc.engine;

import java.lang.reflect.Constructor;
import java.util.Map;

import sgcib.eliot.datalake.HBernate.ioc.annotations.Service;
import sgcib.eliot.datalake.HBernate.ioc.exceptions.AnnotationNotFoundException;
import sgcib.eliot.datalake.HBernate.ioc.exceptions.MalformedConfigurationException;
import sgcib.eliot.datalake.HBernate.ioc.utils.XMLDeserializer;

public class ConfigEngine extends Engine {

	private static final String CONFIG_FILE_NAME = "application-context.xml";

	/**
	 * application-context.xml (declaration of beans)
	 */
	protected String config_file;
	private XMLDeserializer deserializer;

	public ConfigEngine(String config_file) throws Exception {
		this.config_file = config_file;
		deserializer = new XMLDeserializer(config_file);
	}

	@Override
	@SuppressWarnings({ "rawtypes", "unused", "unchecked" })
	public Object load(Class clazz) throws Throwable {
		Map<String, String> mappingInterfaceClass = deserializer.deserialize();
		if (clazz != null) {

			boolean flag = true;
			int index = 0;
			for (Constructor constructor : clazz.getConstructors()) {
				if (constructor.isAnnotationPresent(Service.class)) {
					if (flag && index == 0) {
						flag = false;
						index++;

						Class[] parameterTypes = constructor.getParameterTypes();
						Object[] objArr = new Object[parameterTypes.length];
						int i = 0;

						for (Class c : parameterTypes) {
							if (!(c.isPrimitive())) {
								if (mappingInterfaceClass.containsKey(c.getName())) {
									String name_interface = c.getName();
									String name_class = mappingInterfaceClass.get(c.getName());
									Class dependency = Class.forName(name_class);
									if (c.isAssignableFrom(dependency)) {
										objArr[i++] = dependency.getConstructor().newInstance();
									}
								} else {
									throw new MalformedConfigurationException("The configuration " + CONFIG_FILE_NAME
											+ " is not mapped correctly with the service");
								}
							}
						}
						Object resObj = clazz.getConstructor(parameterTypes).newInstance(objArr);
						return resObj;
					}
				}
			}
		}
		throw new AnnotationNotFoundException("Annotation @Service not found");
	}

}
