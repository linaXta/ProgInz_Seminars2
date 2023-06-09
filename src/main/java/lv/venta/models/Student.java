package lv.venta.models;

import java.util.Collection;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Table(name = "Student_table")
@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString
public class Student {
	
	@Setter(value = AccessLevel.NONE)
	@Column(name = "Ids") 
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long ids;
	
	@Column(name = "Name")
	@NotNull
	@Pattern(regexp = "[A-ZĀĢČĒĪĶĻŅŠŪŽ]{1}[a-zāģčēīķļņšūž\\ ]+")
	@Size(min = 3, max = 15)
	private String name;
	
	@Column(name = "Surname")
	@NotNull
	@Pattern(regexp = "[A-ZĀĢČĒĪĶĻŅŠŪŽ]{1}[a-zāģčēīķļņšūž\\ ]+")
	@Size(min = 3, max = 15)
	private String surname;
	
	@OneToMany(mappedBy = "student")
	@ToString.Exclude// TO STRIN FUNKCIJA ŠO NEIZSAUKS, LAI NEAIZIET bezgalīgā ciklā
	private Collection<Grade> grades; //Vairākas atzīmes vienam studentam

	public Student(String name, String surname) {
		this.name = name;
		this.surname = surname;
	}
	
	

}
