package ie.murph.sports.clinic;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SportsClinicApplication implements CommandLineRunner{

//	@Autowired
//    private PostRepository repository;
	
	public static void main(String[] args) {
		SpringApplication.run(SportsClinicApplication.class, args);
	}

	@Override
	public void run(String... arg0) throws Exception {
		
//		for (int i = 0; i < 5; i++) {
//            repository.save(new Post("My post number #" + (i+1)));
//        }
		
	}
}
