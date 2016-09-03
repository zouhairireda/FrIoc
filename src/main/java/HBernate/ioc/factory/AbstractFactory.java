package sgcib.eliot.datalake.HBernate.ioc.factory;

import sgcib.eliot.datalake.HBernate.ioc.engine.Engine;

public abstract class AbstractFactory {
	public abstract Engine getEngine(String type, Object param) throws Exception;
}