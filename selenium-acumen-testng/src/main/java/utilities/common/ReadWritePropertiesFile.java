package utilities.common;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import org.apache.log4j.Logger;

/**
 * @author amit.kapilas
 */
public class ReadWritePropertiesFile {
	final static Logger logger = Logger.getLogger(ReadWritePropertiesFile.class);

	public static void setTestOutPutProperty(String key, String value) {
		Properties prop = new Properties();
		OutputStream output = null;
		try {
			output = new FileOutputStream(".\\properties\\config\\testOutput.properties", false);
			prop.setProperty(key, value);
			prop.store(output, null);
		} catch (IOException io) {
			logger.info("error in  setTestOutPutProperty", io);
		} finally {
			if (output != null) {
				try {
					output.close();
				} catch (IOException e) {
					logger.info("error in  setTestOutPutProperty", e);
				}
			}
		}
	}

	public static void setPropertyMail(String key, String value) {

		Properties prop = new Properties();
		OutputStream output = null;

		try {
			output = new FileOutputStream(".\\properties\\config\\mailRunTimeValues.properties", true);
			prop.setProperty(key, value);
			prop.store(output, null);
		} catch (IOException e) {
			logger.info("error in  setPropertyMail", e);
		} finally {
			if (output != null) {
				try {
					output.close();
				} catch (IOException e) {
					logger.info("error in  setPropertyMail", e);
				}
			}
		}
	}

	public static void setPropertyTestLink(String key, String value) {

		Properties prop = new Properties();
		OutputStream output = null;

		try {
			output = new FileOutputStream(".\\properties\\config\\testLinkBuild.properties", false);
			prop.setProperty(key, value);
			prop.store(output, null);
		} catch (IOException e) {
			logger.info("error in  setPropertyTestLink", e);
		} finally {
			if (output != null) {
				try {
					output.close();
				} catch (IOException e) {
					logger.info("error in  setPropertyTestLink", e);
				}
			}
		}
	}

	public static String getTestOutputProperty(String key) {
		String value = "";
		Properties prop = new Properties();
		InputStream input = null;
		try {
			input = new FileInputStream(".\\properties\\config\\testOutput.properties");
			prop.load(input);
			value = prop.getProperty(key);
		} catch (IOException e) {
			logger.info("error in  getTestOutputProperty", e);
		} finally {
			if (input != null) {
				try {
					input.close();
				} catch (IOException e) {
					logger.info("error in  getTestOutputProperty", e);
				}
			}
		}
		return value;

	}

	public static String getTestLinkProperty(String key) {
		String value = "";
		Properties prop = new Properties();
		InputStream input = null;
		try {
			input = new FileInputStream(".\\properties\\config\\testLinkBuild.properties");
			prop.load(input);
			value = prop.getProperty(key);
		} catch (IOException e) {
			logger.info("error in  getTestLinkProperty", e);
		} finally {
			if (input != null) {
				try {
					input.close();
				} catch (IOException e) {
					logger.info("error in  getTestLinkProperty", e);
				}
			}
		}
		return value;

	}

	public static ArrayList<String> getMailProperties() {
		ArrayList<String> arr = new ArrayList<String>();

		Properties prop = new Properties();
		InputStream input = null;
		try {
			input = new FileInputStream(".\\properties\\config\\mailSettings.properties");
			prop.load(input);
			arr.add(prop.getProperty("toUser"));
			arr.add(prop.getProperty("toManagement"));
			arr.add(prop.getProperty("user"));
			arr.add(prop.getProperty("userName"));
			arr.add(prop.getProperty("password"));
			arr.add(prop.getProperty("subject"));
			arr.add(prop.getProperty("msgManagement"));
			arr.add(prop.getProperty("msgUser"));
			arr.add(prop.getProperty("filename"));
			arr.add(prop.getProperty("filePath"));
			arr.add(prop.getProperty("host"));
			arr.add(prop.getProperty("ccManagement"));
			arr.add(prop.getProperty("bccManagement"));
		} catch (IOException e) {
			logger.info("error in  getMailProperties", e);
		} finally {
			if (input != null) {
				try {
					input.close();
				} catch (IOException e) {
					logger.info("error in  getMailProperties", e);
				}
			}
		}
		return arr;

	}

	public static String getIISProperty() {
		String iis = "";
		Properties prop = new Properties();
		InputStream input = null;
		try {
			input = new FileInputStream(".\\properties\\config\\mailSettings.properties");
			prop.load(input);
			iis = prop.getProperty("iisPath");
		} catch (IOException e) {
			logger.info("error in  getIISProperty", e);
		} finally {
			if (input != null) {
				try {
					input.close();
				} catch (IOException e) {
					logger.info("error in  getIISProperty", e);
				}
			}
		}
		return iis;

	}

	public static ArrayList<String> getMailRunTimeProperties() {
		ArrayList<String> arr = new ArrayList<String>();

		Properties prop = new Properties();
		InputStream input = null;
		try {
			input = new FileInputStream(".\\properties\\config\\mailRunTimeValues.properties");
			prop.load(input);
			arr.add(prop.getProperty("StartTime"));
			arr.add(prop.getProperty("url"));
			arr.add(prop.getProperty("Environment"));

		} catch (IOException e) {
			logger.info("error in  getMailRunTimeProperties", e);
		} finally {
			if (input != null) {
				try {
					input.close();
				} catch (IOException e) {
					logger.info("error in  getMailRunTimeProperties", e);
				}
			}
		}
		return arr;

	}

	public static ArrayList<String> getTestLinkBaseLineProperties() {
		ArrayList<String> arr = new ArrayList<String>();
		Properties prop = new Properties();
		InputStream input = null;
		try {
			input = new FileInputStream(".\\properties\\config\\testLinkBaseLine.properties");
			prop.load(input);
			arr.add(prop.getProperty("testLinkURL"));
			arr.add(prop.getProperty("devKeyAdmin"));
			arr.add(prop.getProperty("devKeyUser"));
			arr.add(prop.getProperty("project"));
			arr.add(prop.getProperty("testPlan"));
			arr.add(prop.getProperty("buildDescription"));
			arr.add(prop.getProperty("build"));

		} catch (IOException e) {
			logger.info("error in  getTestLinkBaseLineProperties", e);
		} finally {
			if (input != null) {
				try {
					input.close();
				} catch (IOException e) {
					logger.info("error in  getTestLinkBaseLineProperties", e);
				}
			}
		}
		return arr;

	}

	public static String getTestLinkBaseLinePropertiesAgainstKey(String key) {

		Properties prop = new Properties();
		InputStream input = null;
		String value = "";
		try {
			input = new FileInputStream(".\\properties\\config\\testLinkBaseLine.properties");
			prop.load(input);
			value = prop.getProperty(key);
		} catch (IOException e) {
			logger.info("error in  getTestLinkBaseLinePropertiesAgainstKey", e);
		} finally {
			if (input != null) {
				try {
					input.close();
				} catch (IOException e) {
					logger.info("error in  getTestLinkBaseLinePropertiesAgainstKey", e);
				}
			}
		}
		return value;

	}

	public static void setPropertySQL(String key, String value) {
		String file = ".\\properties\\sys\\sql.properties";
		Properties prop = new Properties();
		OutputStream output = null;

		try {
			output = new FileOutputStream(file, true);
			prop.setProperty(key, value);
			prop.store(output, null);
		} catch (IOException io) {
			io.printStackTrace();
		} finally {
			if (output != null) {
				try {
					output.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

	public static String getPropertySQL(String key) {
		String file = ".\\properties\\sys\\sql.properties";
		String value = "";
		Properties prop = new Properties();
		InputStream input = null;
		try {
			input = new FileInputStream(file);
			prop.load(input);
			value = prop.getProperty(key);
		} catch (IOException ex) {
			ex.printStackTrace();
		} finally {
			if (input != null) {
				try {
					input.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return value;

	}

}
