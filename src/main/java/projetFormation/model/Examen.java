package projetFormation.model;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Version;
@Entity
public class Examen {
        @Id
        @GeneratedValue
        private Long id;
        @Version
        private int version;
        @Column(name="note")
        private int note;
        @Column(name="valide")
        private boolean valide;
        @Column(name="seuilDeValidation")
        private int seuilDeValidation;
        @OneToOne
        @JoinColumn(name = "offreEmploi_id")
        private OffreEmploi offreEmploi;
        @OneToMany(mappedBy = "examen")
    	private List<ExamenRecruteur> examenRecruteurs;
        @OneToOne
        @JoinColumn(name = "questionnaire_id")
        private Questionnaire questionnaire;
        
        
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
        public boolean isValide() {
            return valide;
        }
        public void setValide(boolean valide) {
            this.valide = valide;
        }
        public int getSeuilDeValidation() {
            return seuilDeValidation;
        }
        public void setSeuilDeValidation(int seuilDeValidation) {
            this.seuilDeValidation = seuilDeValidation;
        }
		public OffreEmploi getOffreEmploi() {
			return offreEmploi;
		}
		public void setOffreEmploi(OffreEmploi offreEmploi) {
			this.offreEmploi = offreEmploi;
		}
		public List<ExamenRecruteur> getExamenRecruteurs() {
			return examenRecruteurs;
		}
		public void setExamenRecruteurs(List<ExamenRecruteur> examenRecruteurs) {
			this.examenRecruteurs = examenRecruteurs;
		}
		public Questionnaire getQuestionnaire() {
			return questionnaire;
		}
		public void setQuestionnaire(Questionnaire questionnaire) {
			this.questionnaire = questionnaire;
		}
		public void noteExam() {
			
		}
        
}