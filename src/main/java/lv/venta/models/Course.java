package lv.venta.models;

import java.util.Collection;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
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
	
	@OneToOne
	@JoinColumn(name = "Idp") //sasaistam ar otras klases PK
	private Professor professor;
	
	@OneToMany(mappedBy = "course")
	@ToString.Exclude// TO STRIN FUNKCIJA ŠO NEIZSAUKS, LAI NEAIZIET bezgalīgā ciklā
	private Collection<Grade> grades;

	public Course(String title, int creditPoint, Professor professor) {
		this.title = title;
		this.creditPoint = creditPoint;
		this.professor = professor;
	}
	
	
}
