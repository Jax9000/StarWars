package starWars;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
	 * @NOT_IMPLEMENTED
	 */
	public static void LoadDatabase(String filePath) {
		//Yaml yaml = new Yaml(GetConstructor());
		System.err.println("Not implemented.");
	}
	
	public static void PrintQuestionList(List<Question> questions) {
		Yaml yaml = new Yaml(GetRepresenter(), new DumperOptions());
		System.out.println(yaml.dump(questions));
	}
		
	private static Representer GetRepresenter() {
		Representer representer = new Representer();
		representer.addClassTag(Question.class, new Tag(questionTag));
		return representer;
	}
	
	private static Constructor GetConstructor() {
		Constructor constructor = new Constructor();
		constructor.addTypeDescription(new TypeDescription(Question.class, questionTag));
		return constructor;
	}
	
	private static final String questionTag = "!question";
}
