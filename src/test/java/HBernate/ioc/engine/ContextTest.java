package sgcib.eliot.datalake.HBernate.ioc.engine;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import sgcib.eliot.datalake.HBernate.ioc.endpoint.EndPoint;
import sgcib.eliot.datalake.HBernate.ioc.endpoint.EndPointConfig;
import sgcib.eliot.datalake.HBernate.ioc.mapping.Configuration;

public class ContextTest {

	private Context context;
	private Configuration config;
	private static String fileConfig;

	@Before
	public void setUp(){
		fileConfig = "test_file.xml";
		config = new Configuration();
		config.configure();
	}

	@Test
	public void lookupBeanTest() throws Throwable{
		context = new Context(config);
		assertNotNull(context.lookup(EndPoint.class));
		assertTrue(context.lookup(EndPoint.class) instanceof EndPoint);
	}

	@Test
	public void lookupConfigTest() throws Throwable{
		context = new Context(fileConfig);
		assertNotNull(context.lookup(EndPointConfig.class));
		assertTrue(context.lookup(EndPointConfig.class) instanceof EndPointConfig);
	}
}
