package macv.ghactions.cicd;

import macv.ghactions.cicd.contoller.PageMainController;
import macv.ghactions.cicd.entity.UserEntity;
import macv.ghactions.cicd.service.UserService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;

import java.util.List;

@SpringBootTest
class CicdApplicationTests {
	@Autowired
	private UserService userService;

	@Test
	void usersQuantity() {
		List<UserEntity> users;

		users = userService.getAllUsers();
		int usersQuantity = users.size();

		Assertions.assertEquals(1, usersQuantity);
	}

	@Test
	void healthCheck() {
		PageMainController pageMainController = new PageMainController();

		HttpStatusCode healthCheckResponse = pageMainController.getVersion().getStatusCode();

		Assertions.assertEquals(200, healthCheckResponse.value());

	}
}
