package sgcib.eliot.datalake.HBernate.ioc.test;

import sgcib.eliot.datalake.HBernate.ioc.endpoint.EndPoint;
import sgcib.eliot.datalake.HBernate.ioc.engine.Context;
import sgcib.eliot.datalake.HBernate.ioc.engine.Engine;
import sgcib.eliot.datalake.HBernate.ioc.factory.AbstractFactory;
import sgcib.eliot.datalake.HBernate.ioc.factory.FactoryProducerTest;
import sgcib.eliot.datalake.HBernate.ioc.mapping.Configuration;

public class FinalTest {
	public static void main(String[] args) throws Throwable {


		Configuration conf = new Configuration();
		conf.configure();

		Context c = new Context(conf);
		EndPoint ep = (EndPoint) c.lookup(EndPoint.class);
		ep.getService().test();
//		Engine engine1 = af.getEngine("CONFIG", "test_file.xml");
//		EndPoint ep1 = (EndPoint) engine1.load(EndPoint.class);
//		ep1.getService().test();

		/*
		 * Engine engine = new ConfigEngine("test_file.xml"); EndPoint ep = (EndPoint) engine.load(EndPoint.class);
		 * ep.getService().test();
		 */
	}
}
