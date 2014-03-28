package mycompany.parserceline;

import java.util.ArrayList;

public class Parser {

	public Parser () {
		
	}
	/**
	 * multiple choice single response
	 * {Comment �a va? |type="()"}
	+ The correct answer.
	- Distractor.
	- Distractor.
	- Distractor
	{Question
|type="[]"}
+ Correct answer.
- Incorrect answer.
+ Correct answer.
- Incorrect answer.


	 */
	
	/**
	 * 
	 * @param question
	 * @return objet question 
	 */
	public Question parserFonction(String question) {
		
		String texteQuestion = null;
		String type = null;
		ArrayList<Reponse> reponse = new ArrayList<Reponse>();
		String ensembleReponse = null;

		String delims = "[{}|]+";
		String[] tokens = question.split(delims);

			texteQuestion = tokens[1];
			type = tokens[2];
			ensembleReponse = tokens[3];

		//d�limiter le type () ou []
		delims = "[\"\"]";
		tokens = type.split(delims);
		Question q = null;
		//type multiple choice single response
		if (tokens[1].equals("()")) {
			delims = "[.]";
		   tokens = ensembleReponse.split(delims);

		   for (int i = 0; i < tokens.length; i++) {
			   if (tokens[i].contains("+")) {
			reponse.add(new Reponse(tokens[i], true));
		   }
			   else {
				   reponse.add(new Reponse(tokens[i], false));
			   }
			}		   
		q = new Question(Type.SINGLE, reponse, 1, texteQuestion);
		
		}
		else if (tokens[1].equals("[]")) {
			delims = "[.]";
			   tokens = ensembleReponse.split(delims);
				int nbbonnereponse = 0;
			   for (int i = 0; i < tokens.length; i++) {
				   if (tokens[i].contains("+")) {
				reponse.add(new Reponse(tokens[i], true));
				nbbonnereponse++;
				   }
				   else {
						reponse.add(new Reponse(tokens[i], false));
				   }
				}
				q = new Question(Type.MULTIPLE, reponse, nbbonnereponse++, texteQuestion);

		}


		return q;

	}
}
 