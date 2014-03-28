package mycompany.parserceline;

public class Reponse {
	private String reponse;
	private boolean correct;
	private String feedback;


	public Reponse(String r, boolean c, String f) {
		this.reponse = r;
		this.correct = c;
		this.feedback = f;
		
	}
	
	public Reponse(String r, boolean c) {
		this.reponse = r;
		this.correct = c;
		this.feedback = null;
		
	}
	
	public final String getReponse() {
		return this.reponse;
	}

	public final void setReponse(String reponse) {
		this.reponse = reponse;
	}
	public final String getFeedback() {
		return feedback;
	}
	public final void setFeedback(String feedback) {
		this.feedback = feedback;
	}
	public final boolean isCorrect() {
		return correct;
	}
	public final void setCorrect(boolean co) {
		this.correct = co;
	} 
	
	public final void afficher() {
      	 System.out.println(this.reponse);
       	 System.out.println(this.correct);
       	 System.out.println(this.feedback);

	
}

}
