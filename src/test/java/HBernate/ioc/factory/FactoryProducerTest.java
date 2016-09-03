package sgcib.eliot.datalake.HBernate.ioc.factory;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class FactoryProducerTest {

	private static final String NAME_TYPE_FACTORY = "ENGINE";
	private static final String FAKE_TYPE_FACTORY = "FAKE_ENGINE";

	@Before
	public void setUp(){

	}

	@Test
	public void getFactoryGoodTest(){
		Object af = FactoryProducer.getFactory(NAME_TYPE_FACTORY);
		assertNotNull(af);
		assertTrue(af instanceof AbstractFactory);
	}

	@Test
	public void getFactoryFakeTest(){
		Object af = FactoryProducer.getFactory(FAKE_TYPE_FACTORY);
		assertNull(af);
	}

}
