package selenium.wrapper;

public enum Locators {
	
	ID  ("Id"), 
	CSS_SELECTOR ("CssSelector"),	
	lINK_TEXT ("LinkText"),
	PARTICAL_LINK_TEXT ("PartialLinkText"),
	NAME ("Name"),
	CLASS_NAME ("ClassName"),
	TAG_NAME ("TagName"),
	XPATH ("XPath");
	
	private String value;

	Locators(String value) {
		this.setValue(value);
	
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

}
