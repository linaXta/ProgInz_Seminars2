package lv.venta;

import java.util.ArrayList;
import java.util.Arrays;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import lv.venta.models.Course;
import lv.venta.models.Degree;
import lv.venta.models.Grade;
import lv.venta.models.Professor;
import lv.venta.models.Student;
import lv.venta.repos.ICourseRepo;
import lv.venta.repos.IGradeRepo;
import lv.venta.repos.IProfessorRepo;
import lv.venta.repos.IStudentRepo;

@SpringBootApplication
public class ProgInzSeminar22023Application {

	public static void main(String[] args) {
		SpringApplication.run(ProgInzSeminar22023Application.class, args);
	}

	@Bean //izsauks automātiski funkciju, kad strartēsies sistēma
	public CommandLineRunner testModel(IProfessorRepo profRepo, IStudentRepo stRepo, IGradeRepo grRepo, ICourseRepo crRepo) {
		return new CommandLineRunner() {
			
			@Override
			public void run(String... args) throws Exception {
				
				Professor pr1 = new Professor("Katrīna", "Šķirmante", Degree.mg);
				Professor pr2 = new Professor("Mārtiņš", "Saulītis", Degree.mg);
				Professor pr3 = new Professor("Jānis", "Baigasi", Degree.phd);
				Professor pr4 = new Professor("Raita", "Rollande", Degree.mg);
				profRepo.save(pr1);
				profRepo.save(pr2);
				profRepo.save(pr3);
				profRepo.save(pr4);
				
				Student st1 = new Student("Jānis", "Bērziņš");
				Student st2 = new Student("Ieva", "Kalniņa");
				stRepo.save(st1);
				stRepo.save(st2);
				

				Course c1 = new Course("Java", 4, new ArrayList<>(Arrays.asList(pr1, pr4)));
				Course c2 = new Course("Datubāzes", 4, new ArrayList<>(Arrays.asList(pr2)));
				Course c3 = new Course("Programmatūras inženierija", 4, new ArrayList<>(Arrays.asList(pr3, pr4)));
				crRepo.save(c1);
				crRepo.save(c2);
				crRepo.save(c3);
				
				c1.addProfessor(pr1);
				c1.addProfessor(pr4);
				c2.addProfessor(pr2);
				c3.addProfessor(pr3);
				c3.addProfessor(pr4);
				crRepo.save(c1);
				crRepo.save(c2);
				crRepo.save(c3);
				
				grRepo.save(new Grade(10, st1, c1));
				grRepo.save(new Grade(7, st1, c2));
				grRepo.save(new Grade(6, st2, c1));
				grRepo.save(new Grade(5, st2, c2));
				
				
			}
		};
	}
}
