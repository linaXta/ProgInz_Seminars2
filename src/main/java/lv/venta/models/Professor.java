package lv.venta.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Table(name = "professor_table")
@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString
public class Professor {
	
	
	// uzlikt Data JPA anotācijas (@Colum utt)
	// uzlikt atbilstošās validācijasi
	@Setter(value = AccessLevel.NONE)
	@Column(name = "Idp") 
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long idp;
	
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
	
	@Column(name = "Degree")
	@NotNull
	private Degree degree;
	
	@OneToOne(mappedBy = "professor") //sasaistam ar otras klase mainīgo
	@ToString.Exclude// TO STRIN FUNKCIJA ŠO NEIZSAUKS, LAI NEAIZIET bezgalīgā ciklā
	private Course course;

	public Professor(String name, String surname, Degree degree) {
		super();
		this.name = name;
		this.surname = surname;
		this.degree = degree;
	}

	
}
