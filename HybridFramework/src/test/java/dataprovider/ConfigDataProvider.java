package dataprovider;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigDataProvider {
	
	Properties pro;
	
	public ConfigDataProvider()
	{
		pro=new Properties();
		try {
			pro.load(new FileInputStream(new File(System.getProperty("user.dir")+"/Config/myconfig.properties")));
		} catch (FileNotFoundException e) {
			
			System.out.println("File not present "+e.getMessage());
		} catch (IOException e) {
			
			System.out.println("Unable to read file "+e.getMessage());
		}
	}
	
	public String getValue(String key)
	{
		return pro.getProperty(key);
	}
	
	public String getBrowser()
	{
		return pro.getProperty("browser");
	}
	
	public String stagingURL()
	{
		return pro.getProperty("stagingURL");
	}
	
	public String prodURL()
	{
		return pro.getProperty("prodURL");
	}
	
}
