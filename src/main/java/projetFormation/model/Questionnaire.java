package projetFormation.model;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Version;
@Entity
public class Questionnaire {
    @Id
    @GeneratedValue
    private Long id;
    @Version
    private int version;
    @Column(name="note")
    private int note;
    @Column(name="secteurActivite", length=250)
    private String secteurActivite;
    @OneToMany(mappedBy = "questionnaire")
    private List<Question> questions;
    
    
    public Questionnaire() {
		super();
	}
	public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public int getVersion() {
        return version;
    }
    public void setVersion(int version) {
        this.version = version;
    }
    public int getNote() {
        return note;
    }
    public void setNote(int note) {
        this.note = note;
    }
    public String getSecteurActivite() {
        return secteurActivite;
    }
    public void setSecteurActivite(String secteurActivite) {
        this.secteurActivite = secteurActivite;
    }
	public List<Question> getQuestions() {
		return questions;
	}
	public void setQuestions(List<Question> questions) {
		this.questions = questions;
	}
    
    
}