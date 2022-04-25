package projetFormation.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Reponse {
	@Id
	@GeneratedValue
	private Long id;
	
	private String nom;
	private boolean juste;
	private boolean choisie;
	@ManyToOne
	@JoinColumn(name="question_id")
	private Question question;
	
	
	public Reponse() {
		super();
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getNom() {
		return nom;
	}


	public void setNom(String nom) {
		this.nom = nom;
	}


	public boolean isJuste() {
		return juste;
	}


	public void setJuste(boolean juste) {
		this.juste = juste;
	}


	public boolean isChoisie() {
		return choisie;
	}


	public void setChoisie(boolean choisie) {
		this.choisie = choisie;
	}


	public Question getQuestion() {
		return question;
	}


	public void setQuestion(Question question) {
		this.question = question;
	}

	
	
}
