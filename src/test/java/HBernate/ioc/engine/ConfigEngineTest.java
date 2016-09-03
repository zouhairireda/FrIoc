package sgcib.eliot.datalake.HBernate.ioc.engine;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Before;
import org.junit.Test;

import sgcib.eliot.datalake.HBernate.ioc.endpoint.EndPoint;
import sgcib.eliot.datalake.HBernate.ioc.endpoint.EndPointConfig;

public class ConfigEngineTest {

	private static String fileConfig;
	private ConfigEngine configEngine;

	@Before
	public void setUp() throws Exception {
		fileConfig = "test_file.xml";
		configEngine = new ConfigEngine(fileConfig);
	}

	@Test
	public void loadTest() throws Throwable {
		EndPointConfig obj = (EndPointConfig) configEngine.load(EndPointConfig.class);
		assertNotNull(configEngine.load(EndPointConfig.class));

		assertNotNull(obj);
		assertEquals(EndPointConfig.class, obj.getClass());
	}
}