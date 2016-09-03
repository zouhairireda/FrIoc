package sgcib.eliot.datalake.HBernate.ioc.utils;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.Map;

import org.junit.Before;
import org.junit.Test;

public class XMLDeserializerTest {

	private static String file_config;
	private XMLDeserializer deserializer;

	@Before
	public void setUp() throws Exception {
		file_config = "test_file.xml";
		deserializer = new XMLDeserializer(file_config);
	}

	@Test
	public void deserializeTest() {
		Map<String, String> mappingInterfaceClass = deserializer.deserialize();
		assertNotNull(mappingInterfaceClass);
		assertEquals(1, mappingInterfaceClass.size());
		assertEquals(mappingInterfaceClass.entrySet().iterator().next().getKey(),
				"sgcib.eliot.datalake.HBernate.ioc.mapping.IService");
		assertEquals(mappingInterfaceClass.entrySet().iterator().next().getValue(),
				"sgcib.eliot.datalake.HBernate.ioc.mapping.Service");
	}
}
