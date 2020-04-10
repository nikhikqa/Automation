package utilities.testNG;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public class TestCase extends TestBase{

	@Retention(RetentionPolicy.RUNTIME)
	public @interface UseAsTestName {
		int idx() default 0;
	}

}
