package lv.venta.models;

import java.util.Collection;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@MappedSuperclass
@Getter
@Setter
@NoArgsConstructor
@ToString
public class Person {
	

		
		@Setter(value = AccessLevel.NONE)
		@Column(name = "Idpe") 
		@Id
		@GeneratedValue(strategy = GenerationType.AUTO)
		private long idpe;
		
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

		public Person(String name, String surname) {
			this.name = name;
			this.surname = surname;
		}
		
	
}
