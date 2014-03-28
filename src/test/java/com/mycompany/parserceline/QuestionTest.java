package com.mycompany.parserceline;
import java.util.ArrayList;
import mycompany.parserceline.Question;
import static org.junit.Assert.*;

import mycompany.parserceline.Reponse;
import mycompany.parserceline.Type;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * 
 */

/**
 * @author 21003139
 *
 */
public class QuestionTest {
	
	private Question q;
	private ArrayList<Reponse> tab;

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
			tab = new ArrayList<Reponse>();
			 q = new Question(Type.SINGLE, tab,1, "une question"  );
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
	}

	
	//teste si le tab de questions est vide
	@Test
	public void testTabVide() {

		assertEquals(this.q.getListeReponses().size(), 0);
	}
	//teste si le tableau de question est plein
	@Test
	public void testTabPlein() {
		Reponse r1 = new Reponse ("r1", true);
		Reponse r2 = new Reponse ("r2", false);

		 tab.add(r1);
		 tab.add(r2);
		 
		assertEquals(q.getListeReponses().size(), 2);
	}

	@Test
	public void testType() {

		assertEquals(q.getType(), Type.SINGLE);
	}
	
	@Test
	public void testListeReponse() {
		Reponse r1 = new Reponse ("r1", true);
		 tab.add(r1);
		assertEquals(q.getListeReponses().get(0), r1);
	}
	
	@Test
	public void testReponseCorrecte() {
		assertEquals(this.q.getNbReponsesCorrects(), 1);
	}
        	@Test
	public void testgetQuestion() {
		assertEquals(this.q.getTexteQuestion(), "une question");
	}
        
} 
