package projetFormation.model;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Version;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
@Entity
public class Question {
    @Id
    @GeneratedValue
    private Long id;
    @Version
    private int version;
    @Column(name="index")
    private int index;
    @Column(name="texte", length=1000)
    private String texte;
    
    @ManyToOne
    @JoinColumn(name = "questionnaire_id")
    @JsonIgnoreProperties("questions")
    private Questionnaire questionnaire;
    @OneToMany(mappedBy = "question")
    private List<Reponse> reponses;
    
    
    
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public int getVersion() {
        return version;
    }
    public int getIndex() {
        return index;
    }
    public void setIndex(int index) {
        this.index = index;
    }
    public String getTexte() {
        return texte;
    }
    public void setTexte(String texte) {
        this.texte = texte;
    }
 
    public void setVersion(int version) {
        this.version = version;
    }
	public Questionnaire getQuestionnaire() {
		return questionnaire;
	}
	public void setQuestionnaire(Questionnaire questionnaire) {
		this.questionnaire = questionnaire;
	}
    
    
}