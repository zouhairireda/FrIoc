package sgcib.eliot.datalake.HBernate.ioc.factory;

public class FactoryProducer {
	public static AbstractFactory getFactory(String choice) {

		if (choice.equalsIgnoreCase("ENGINE")) {
			return new EngineFactory();
		}

		return null;
	}
}