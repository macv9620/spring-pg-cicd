package macv.ghactions.cicd;

import macv.ghactions.cicd.entity.UserEntity;
import macv.ghactions.cicd.service.UserService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

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

		Assertions.assertEquals(2, usersQuantity);
	}

}
