package sgcib.eliot.datalake.HBernate.ioc.utils;

public class Utils {

	public static String getRealPath(String file_name) {
		try {
			return Utils.class.getClassLoader().getResource(file_name).getFile();
		} catch(Exception e) {
			return null;
		}
	}
}
