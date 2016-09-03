package sgcib.eliot.datalake.HBernate.ioc.mapping;

public class Configuration extends AbstractConfigurationMapping {

	@Override
	public void configure() {
		createMapping(IService.class, Service.class);
	}

}
