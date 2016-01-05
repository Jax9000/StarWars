package starWars;


import java.io.*;

import org.yaml.snakeyaml.DumperOptions;
import org.yaml.snakeyaml.TypeDescription;
import org.yaml.snakeyaml.Yaml;
import org.yaml.snakeyaml.constructor.Constructor;
import org.yaml.snakeyaml.nodes.Tag;
import org.yaml.snakeyaml.representer.Representer;

/**
 * Class manage YAML export/import.
 * @author Konrad
 *
 */
public class YAMLManager {
	
	/**
	 * Load questions database from file. 
	 * @param filePath
	 * Path to YAML file.
	 * @return
	 * New database instance.
	 * @throws FileNotFoundException
	 */
	public static Database LoadDatabase(String filePath) throws FileNotFoundException {
		InputStream input = new FileInputStream(new File(filePath));
		Yaml yaml = new Yaml(GetConstructor());
        return (Database) yaml.load(input);
	}
	
	public static String PrintDumped(Database db){
		Yaml yaml = new Yaml(GetRepresenter(), new DumperOptions());
		return yaml.dump(db);
	}
	
	public static void SaveDumpedData(Database db, String filePath) {
		FileWriter fw;
		try {
			fw = new FileWriter(new File(filePath));
			fw.write(PrintDumped(db));
			fw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
		
	private static Representer GetRepresenter() {
		Representer representer = new Representer();
		representer.addClassTag(Database.class, new Tag(databseTag));
		return representer;
	}
	
	private static Constructor GetConstructor() {
		Constructor constructor = new Constructor(Database.class);
		constructor.addTypeDescription(new TypeDescription(Database.class, databseTag));
		return constructor;
	}
	
	private static final String databseTag = "!database";
}
