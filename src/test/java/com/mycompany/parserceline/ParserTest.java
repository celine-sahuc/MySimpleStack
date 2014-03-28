/**
 * 
 */
package com.mycompany.parserceline;

import java.util.ArrayList;
import mycompany.parserceline.Parser;
import mycompany.parserceline.Parser;
import static org.junit.Assert.*;

import mycompany.parserceline.Question;
import mycompany.parserceline.Question;
import mycompany.parserceline.Reponse;
import mycompany.parserceline.Reponse;
import mycompany.parserceline.Type;
import mycompany.parserceline.Type;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * @author 21003139
 *
 */
public class ParserTest {

	private Parser p;
	private Question q;
	private ArrayList<Reponse> r; 
	/**
	 * @throws java.lang.Exception
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {

		p = new Parser();
		String question = "{Comment �a va? |type=\"()\"} + The correct answer.- Distractor.- Distractor. - Distractor.";
		q = p.parserFonction(question);
		r = new ArrayList<Reponse>();
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testType() {
		assertEquals(q.getType(), Type.SINGLE ); 
	}

	
	@Test
	public void testQuestion() {
		
		assertEquals(q.getTexteQuestion(), "Comment �a va? "); 
	}
@Test
public void testNbReponse() {
	
	assertEquals(q.getNbReponsesCorrects(), 1); 
}
@Test
public void testReponse() {
	r = q.getListeReponses();
		assertEquals(r.get(0).getReponse(), " + The correct answer");
		assertEquals(r.get(1).getReponse(), "- Distractor");
		assertEquals(r.get(2).getReponse(), "- Distractor");

}


public void testReponseCorrecte() {
	r = q.getListeReponses();
		assertEquals(r.get(0).isCorrect(), true);
		assertEquals(r.get(1).isCorrect(), false);
		assertEquals(r.get(2).isCorrect(), false);
}


public void testReponseFeedback() {
	r = q.getListeReponses();
		assertEquals(r.get(0).getFeedback(), null);
		assertEquals(r.get(1).getFeedback(), null);
		assertEquals(r.get(2).getFeedback(), null);
}

}
