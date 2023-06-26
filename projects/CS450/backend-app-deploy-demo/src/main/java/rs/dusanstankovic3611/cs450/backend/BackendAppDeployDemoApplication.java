package rs.dusanstankovic3611.cs450.backend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class BackendAppDeployDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(BackendAppDeployDemoApplication.class, args);
	}
	@RestController
	public class HelloController {
		@RequestMapping("/")
		public String index() {
			return "CS450 - Cloud Computing - Dušan Stanković 3611";
		}
	}
}
