package selenium.browser;


public enum Browsers {
	
	FIREFOX  ("firefox"), 
	IEXPLORER ("internetexplorer"),
	CHROME ("chrome");
	
	private String value;

	Browsers(String value) {
		this.setValue(value);
	
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

}
