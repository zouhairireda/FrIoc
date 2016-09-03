package sgcib.eliot.datalake.HBernate.ioc.utils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.jdom.Element;

import sgcib.eliot.datalake.HBernate.ioc.exceptions.MalformedConfigurationException;

public class XMLDeserializer {

	private static final String NAME_CONFIG_FILE = "application-context.xml";
	private static final String NAME_ATTRIBUTE_CLASS = "class";
	private static final String NAME_ATTRIBUTE_REF = "name";
	private static final String NAME_ATTRIBUTE_ID = "id";

	protected String file_config;
	private XMLDomFacade facade_dom;

	public XMLDeserializer(String file_config) throws Exception {
		this.file_config = Utils.getRealPath(file_config);
		facade_dom = new XMLDomFacade(this.file_config);
	}

	public Map<String, String> deserialize() {
		Map<String, String> mappingIdClass = new HashMap<>();
		Map<String, String> mappingInterfaceClass = new HashMap<>();

		List<Element> list = facade_dom.getChildren(facade_dom.getRoot());
		for (Element e : list) {
			List<Element> subList = facade_dom.getChildren(e);
			mappingIdClass.put(facade_dom.getAttributeValue(e, NAME_ATTRIBUTE_ID),
					facade_dom.getAttributeValue(e, NAME_ATTRIBUTE_CLASS));
			if (subList.size() != 0) {
				Element subElement = subList.get(0);

				if (mappingIdClass.containsKey(facade_dom.getAttributeValue(subElement, NAME_ATTRIBUTE_REF))) {
					mappingInterfaceClass.put(facade_dom.getAttributeValue(e, NAME_ATTRIBUTE_CLASS),
							mappingIdClass.get(facade_dom.getAttributeValue(subElement, NAME_ATTRIBUTE_REF)));
				} else {
					throw new MalformedConfigurationException(
							"the configuration " + NAME_CONFIG_FILE + " is malformed");
				}
			}
		}
		return mappingInterfaceClass;
	}
}
