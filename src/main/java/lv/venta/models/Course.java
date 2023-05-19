package lv.venta.models;

import java.util.ArrayList;
import java.util.Collection;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Table(name = "course_table")
@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString
public class Course {

	@Setter(value = AccessLevel.NONE)
	@Column(name = "Idc") 
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long idc;
	
	@Column(name = "Title")
	@NotNull
	@Pattern(regexp = "[A-ZĀĢČĒĪĶĻŅŠŪŽ]{1}[a-zāģčēīķļņšūž\\ ]+")
	@Size(min = 4, max = 30)
	private String title;
	
	@Column(name = "CreditPoint")
	@Min(value = 1)
	@Max(value = 20)
	private int creditPoint;
	
	
	@ManyToMany
	@JoinTable(name = "course_prof_table", joinColumns = @JoinColumn(name ="Idc"), inverseJoinColumns = @JoinColumn(name = "Idp") )
	private Collection<Professor> professors = new ArrayList<>();

	@OneToMany(mappedBy = "course")
	@ToString.Exclude
	private Collection<Grade> grades;
	
	public Course(String title, int creditPoint, ArrayList<Professor> professors) {
		this.title = title;
		this.creditPoint = creditPoint;
		this.professors = professors;
	}
	
	public void addProfessor (Professor inputProfessor) {
		if(!professors.contains(inputProfessor)) {
			professors.add(inputProfessor);
		}
	}
}
