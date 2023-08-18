package Utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
public class PropertiesFileReader {
    public static void main(String[] args) throws IOException {
        String filepath = System.getProperty("user.dir")+"/data.properties";
        Properties prop = new Properties();
        prop.load(new FileInputStream(filepath));
        System.out.println(prop.getProperty("url"));
        System.out.println(prop.getProperty("name"));
        System.out.println(prop.getProperty("age"));
    }

}
