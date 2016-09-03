package sgcib.eliot.datalake.HBernate.ioc.engine;

import sgcib.eliot.datalake.HBernate.ioc.factory.AbstractFactory;
import sgcib.eliot.datalake.HBernate.ioc.factory.FactoryProducer;
import sgcib.eliot.datalake.HBernate.ioc.mapping.Configuration;
import sgcib.eliot.datalake.HBernate.ioc.mapping.IConfigurationMapping;

public class Context {

	private static final String NAME_TYPE_BEAN = "BEAN";
	private static final String NAME_TYPE_CONFIG = "CONFIG";
	private static final String NAME_TYPE_ENGINE = "ENGINE";

	private Object config;

	public Context() {
		super();
	}

	public Context(Object config) {
		this.config = config;
	}

	public void setConfig(Object config) {
		this.config = config;
	}

	public Object lookup(Class<?> clientService) throws Throwable {
		AbstractFactory factory = FactoryProducer.getFactory(NAME_TYPE_ENGINE);
		Engine engine = null;
		if (this.config instanceof IConfigurationMapping) {
			Configuration conf = new Configuration();
			conf.configure();
			engine = factory.getEngine(NAME_TYPE_BEAN, conf);
		} else {
			engine = factory.getEngine(NAME_TYPE_CONFIG, this.config);
		}
		return engine.load(clientService);

	}
}
