package sgcib.eliot.datalake.HBernate.ioc.factory;

import sgcib.eliot.datalake.HBernate.ioc.engine.BeanEngine;
import sgcib.eliot.datalake.HBernate.ioc.engine.ConfigEngine;
import sgcib.eliot.datalake.HBernate.ioc.engine.Engine;
import sgcib.eliot.datalake.HBernate.ioc.mapping.IConfigurationMapping;

public class EngineFactory extends AbstractFactory {

	@Override
	public Engine getEngine(String type, Object param) throws Exception {
		if (type == null) {
			return null;
		}

		if (type.equalsIgnoreCase("BEAN")) {
			return new BeanEngine((IConfigurationMapping) param);

		} else if (type.equalsIgnoreCase("CONFIG")) {
			return new ConfigEngine(param.toString());

		}

		return null;
	}

}
