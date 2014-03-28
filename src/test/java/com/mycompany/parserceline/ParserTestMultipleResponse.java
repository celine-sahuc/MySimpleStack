package com.mycompany.parserceline;

import java.util.ArrayList;
import mycompany.parserceline.Parser;
import static org.junit.Assert.*;

import mycompany.parserceline.Question;
import mycompany.parserceline.Reponse;
import mycompany.parserceline.Type;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class ParserTestMultipleResponse {
	private Parser p;
	private Question q;
	private ArrayList<Reponse> r; 


	@Before
	public void setUp() throws Exception {
		p = new Parser();
		String question = "{Comment ça va? |type=\"[]\"} + Correct answer.- Incorrect answer.+ Correct answer.- Incorrect answer.";
		q = p.parserFonction(question);
		r = new ArrayList<Reponse>();
	}

	@Test
	public void testType() {
		assertEquals(q.getType(), Type.MULTIPLE); 
	}


	@Test
	public void testQuestion() {
		assertEquals(q.getTexteQuestion(), "Comment ça va? "); 
	}
	
@Test
public void testNbReponse() {

	assertEquals(q.getNbReponsesCorrects(), 2); 
}
@Test
public void testReponse() {
	r = q.getListeReponses();
		assertEquals(r.get(0).getReponse(), " + Correct answer");
		assertEquals(r.get(1).getReponse(), "- Incorrect answer");
		assertEquals(r.get(2).getReponse(), "+ Correct answer");
		assertEquals(r.get(3).getReponse(), "- Incorrect answer");


}


public void testReponseCorrecte() {
	r = q.getListeReponses();
		assertEquals(r.get(0).isCorrect(), true);
		assertEquals(r.get(1).isCorrect(), false);
		assertEquals(r.get(2).isCorrect(), true);
		assertEquals(r.get(2).isCorrect(), false);
}


public void testReponseFeedback() {
	r = q.getListeReponses();
		assertEquals(r.get(0).getFeedback(), null);
		assertEquals(r.get(1).getFeedback(), null);
		assertEquals(r.get(2).getFeedback(), null);
}

}
