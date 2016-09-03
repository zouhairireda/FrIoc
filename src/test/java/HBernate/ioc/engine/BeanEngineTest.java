package sgcib.eliot.datalake.HBernate.ioc.engine;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Before;
import org.junit.Test;

import sgcib.eliot.datalake.HBernate.ioc.endpoint.EndPoint;
import sgcib.eliot.datalake.HBernate.ioc.mapping.Configuration;

public class BeanEngineTest {

	private BeanEngine engine;

	@Before
	public void setUp() {
		Configuration config = new Configuration();
		config.configure();
		engine = new BeanEngine(config);
	}

	@Test
	public void engineNotNullTest() {
		assertNotNull(engine);
	}

	@Test
	public void loadTest() throws Throwable {
		EndPoint obj = (EndPoint) engine.load(EndPoint.class);
		assertNotNull(obj);
		assertEquals(EndPoint.class, obj.getClass());
	}
}
