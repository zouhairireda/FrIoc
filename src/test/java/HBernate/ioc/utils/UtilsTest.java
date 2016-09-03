package sgcib.eliot.datalake.HBernate.ioc.utils;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.io.File;

import org.junit.Before;
import org.junit.Test;

public class UtilsTest {

	private static String realPath;
	private static String fakePath;

	@Before
	public void setUp() {
		realPath = "test_file.xml";
		fakePath = "fake_path.xml";
	}

	@Test
	public void getRealPathTest() {
		assertNotNull(Utils.getRealPath(realPath));
	}

	@Test
	public void getFakePathTest() throws Exception {
		assertNull(Utils.getRealPath(fakePath));
	}
}
