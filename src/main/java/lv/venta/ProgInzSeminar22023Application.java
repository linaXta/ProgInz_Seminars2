package lv.venta;

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
				profRepo.save(pr1);
				profRepo.save(pr2);
				
				Student st1 = new Student("Jānis", "Bērziņš");
				Student st2 = new Student("Ieva", "Kalniņa");
				stRepo.save(st1);
				stRepo.save(st2);
				
				Course c1 = new Course("Java", 4, pr1);
				Course c2 = new Course("Datubāzes", 4, pr2);
				crRepo.save(c1);
				crRepo.save(c2);
				
				grRepo.save(new Grade(10, st1, c1));
				grRepo.save(new Grade(7, st1, c2));
				grRepo.save(new Grade(6, st2, c1));
				grRepo.save(new Grade(5, st2, c2));
				
				//TODO pārveidot saiti starp professor un kursu uz ManyToMany
				//TODO pamainīt testMode funkciju 1.professoram 2 kursus un 1.kurasm, ka to pasniedz abi profesori
				
			}
		};
	}
}
