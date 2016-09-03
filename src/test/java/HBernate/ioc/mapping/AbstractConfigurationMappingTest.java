package sgcib.eliot.datalake.HBernate.ioc.mapping;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Before;
import org.junit.Test;

public class AbstractConfigurationMappingTest {

	private Configuration config;

	@Before
	public void setUp() {
		config = new Configuration();
		config.configure();
	}

	@Test
	public void getMappingTest() {
		assertNotNull(config.getMapping(IService.class));
	}

	@Test
	public void createMappingTest() {
		assertEquals(Service.class, config.getMapping(IService.class));
	}
}
