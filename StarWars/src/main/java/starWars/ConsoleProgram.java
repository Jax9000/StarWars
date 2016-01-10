package starWars;


import java.util.Random;

import org.drools.KnowledgeBase;
import org.drools.KnowledgeBaseFactory;
import org.drools.builder.KnowledgeBuilder;
import org.drools.builder.KnowledgeBuilderError;
import org.drools.builder.KnowledgeBuilderErrors;
import org.drools.builder.KnowledgeBuilderFactory;
import org.drools.builder.ResourceType;
import org.drools.io.ResourceFactory;
import org.drools.logger.KnowledgeRuntimeLogger;
import org.drools.logger.KnowledgeRuntimeLoggerFactory;
import org.drools.runtime.StatefulKnowledgeSession;

import javax.swing.*;

public class ConsoleProgram {
	
	public static final void main(String[] args) {
        try {
            // load up the knowledge base
            KnowledgeBase kbase = readKnowledgeBase();
            StatefulKnowledgeSession ksession = kbase.newStatefulKnowledgeSession();
            KnowledgeRuntimeLogger logger = KnowledgeRuntimeLoggerFactory.newFileLogger(ksession, "test");
            // go !
            JOptionPane.showMessageDialog(null, "Pomyœl o dowolnej postaci z StarWars, program przy\npomocy dialogu postara siê odgadnaæ o jakiej postaci pomyœla³eœ.", "StarWars", JOptionPane.INFORMATION_MESSAGE);
            
            
            Database database = YAMLManager.LoadDatabase(Database.defaultSaveFilePath);
            database.PrintToConsole();
            Question.setDatabase(database);
            InsertRankingMultiple(100, ksession);
            ksession.fireAllRules();
            logger.close();
        } catch (Throwable t) {
            t.printStackTrace();
        }
    }

    private static KnowledgeBase readKnowledgeBase() throws Exception {
        KnowledgeBuilder kbuilder = KnowledgeBuilderFactory.newKnowledgeBuilder();
        kbuilder.add(ResourceFactory.newClassPathResource("knowlage.drl"), ResourceType.DRL);
        kbuilder.add(ResourceFactory.newClassPathResource("questions.drl"), ResourceType.DRL);
        KnowledgeBuilderErrors errors = kbuilder.getErrors();
        if (errors.size() > 0) {
            for (KnowledgeBuilderError error: errors) {
                System.err.println(error);
            }
            throw new IllegalArgumentException("Could not parse knowledge.");
        }
        KnowledgeBase kbase = KnowledgeBaseFactory.newKnowledgeBase();
        kbase.addKnowledgePackages(kbuilder.getKnowledgePackages());
        return kbase;
    }
    
    private static void InsertRankingMultiple(int times, StatefulKnowledgeSession ksession)
    {
        Random random = new Random();
        int MAX_QUESTION_ORDER = 1000;
        for(int i = 0; i<times; i++)
        {
        	Ranking ranking = new Ranking(i, random.nextInt(MAX_QUESTION_ORDER));
        	ksession.insert(ranking);
        }
    }
    
}
