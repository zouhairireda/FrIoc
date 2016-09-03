package sgcib.eliot.datalake.HBernate.ioc.utils;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.jdom.Attribute;
import org.jdom.Element;
import org.junit.Before;
import org.junit.Test;

public class XMLDeserializerFacadeTest {

	private static final String FILE_CONFIG = "test_file.xml";
	private static final String ID_CONFIG_NAME = "id";
	private static final String ID_CONFIG_VALUE = "serviceimpl";
	private static final String ELEMENT_NAME = "bean";
	private static final String ELEMENT_ROOT_NAME = "beans";
	private static String file_name = "";
	private XMLDomFacade facade_dom;
	private Element root;

	@Before
	public void setUp() throws Exception {
		file_name = XMLDeserializerFacadeTest.class.getClassLoader().getResource(FILE_CONFIG).getFile();
		facade_dom = new XMLDomFacade(file_name);
		root = facade_dom.getRoot();
	}

	@Test
	public void getRootTest() {
		assertNotNull(root);
		assertEquals(ELEMENT_ROOT_NAME, root.getName());
	}

	@Test
	public void getChildrenTest() {
		assertNotNull(root.getChildren());

		assertEquals(2, root.getChildren().size());
		assertEquals(ELEMENT_NAME, ((Element) root.getChildren().get(0)).getName());
		assertEquals(ELEMENT_NAME, ((Element) root.getChildren().get(1)).getName());
	}

	@Test
	public void getLengthChildrenTest() {
		assertEquals(2, root.getChildren().size());
	}

	@Test
	public void getAttributeTest() {
		Attribute attr = facade_dom.getAttribute(facade_dom.getChildren(facade_dom.getRoot()).get(0), ID_CONFIG_NAME);

		assertNotNull(attr);
		assertEquals(ID_CONFIG_NAME, attr.getName());
		assertEquals(ID_CONFIG_VALUE, attr.getValue());
	}

	@Test
	public void getAttributeNameTest() {
		String name = facade_dom.getAttributeName(facade_dom.getChildren(facade_dom.getRoot()).get(0), ID_CONFIG_NAME);
		assertNotNull(name);
		assertEquals(ID_CONFIG_NAME, name);
	}

	@Test
	public void getAttributeValueTest() {
		String value = facade_dom.getAttributeValue(facade_dom.getChildren(facade_dom.getRoot()).get(0),
				ID_CONFIG_NAME);
		assertNotNull(value);
		assertEquals(ID_CONFIG_VALUE, value);
	}

}
