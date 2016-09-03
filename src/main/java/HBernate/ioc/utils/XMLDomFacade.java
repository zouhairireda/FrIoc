package sgcib.eliot.datalake.HBernate.ioc.utils;

import java.io.File;
import java.util.List;

import org.jdom.Attribute;
import org.jdom.Document;
import org.jdom.Element;
import org.jdom.input.SAXBuilder;

import sgcib.eliot.datalake.HBernate.ioc.exceptions.ConfigurationNotFoundException;
import sgcib.eliot.datalake.HBernate.ioc.exceptions.MalformedConfigurationException;

public class XMLDomFacade {

	private static final String NAME_CONFIG_FILE = "application-context.xml";

	private SAXBuilder sxb;
	private Document document;

	public XMLDomFacade(String file_config) throws Exception {
		sxb = new SAXBuilder();
		File fileF_config = null;
		if (file_config == null || !((fileF_config = new File(file_config)) != null && fileF_config.exists())) {
			throw new ConfigurationNotFoundException("The configuration " + NAME_CONFIG_FILE + " is not found");
		}
		try {
			document = sxb.build(fileF_config);
		} catch (Exception e) {
			throw new MalformedConfigurationException("the configuration " + NAME_CONFIG_FILE + " is malformed");
		}
	}

	public Element getRoot() {
		return document.getRootElement();
	}

	@SuppressWarnings("unchecked")
	public List<Element> getChildren(Element e) {
		return (List<Element>) e.getChildren();
	}

	public long getLengthChildren(Element e) {
		return e.getChildren().size();
	}

	public Attribute getAttribute(Element e, String attribute) {
		return e.getAttribute(attribute);
	}

	public String getAttributeName(Element e, String attribute) {
		return this.getAttribute(e, attribute).getName();
	}

	public String getAttributeValue(Element e, String attribute) {
		return this.getAttribute(e, attribute).getValue();
	}

}
