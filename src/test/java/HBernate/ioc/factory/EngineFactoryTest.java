package sgcib.eliot.datalake.HBernate.ioc.factory;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import sgcib.eliot.datalake.HBernate.ioc.engine.Engine;
import sgcib.eliot.datalake.HBernate.ioc.mapping.Configuration;

public class EngineFactoryTest {

	private static final String NAME_TYPE_BEAN = "BEAN";
	private static final String NAME_TYPE_CONFIG = "CONFIG";
	private static final String FAKE_TYPE_CONFIG = "FAKE_CONFIG";
	private static final String FILE_NAME_CONFIG = "test_file.xml";

	private Configuration config;
	private EngineFactory factoryEngine;

	@Before
	public void setUp() {
		factoryEngine = new EngineFactory();
		config = new Configuration();
		config.configure();
	}

	@Test
	public void getEngineBeanTest() throws Exception {
		assertNotNull(factoryEngine.getEngine(NAME_TYPE_BEAN, config));
		assertTrue(factoryEngine.getEngine(NAME_TYPE_BEAN, config) instanceof Engine);
	}

	@Test
	public void getEngineConfigTest() throws Exception {
		assertNotNull(factoryEngine.getEngine(NAME_TYPE_CONFIG, FILE_NAME_CONFIG));
		assertTrue(factoryEngine.getEngine(NAME_TYPE_CONFIG, FILE_NAME_CONFIG) instanceof Engine);
	}

	@Test
	public void getEngineFakeTest() throws Exception {
		assertNull(factoryEngine.getEngine(FAKE_TYPE_CONFIG, config));
	}

}
