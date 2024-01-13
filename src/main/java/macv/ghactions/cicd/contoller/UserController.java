package macv.ghactions.cicd.contoller;

import macv.ghactions.cicd.entity.UserEntity;
import macv.ghactions.cicd.service.UserService;
import macv.ghactions.cicd.utils.ResponseWrapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/")
    public ResponseEntity<ResponseWrapper<?>> getUsers(){
        String message;
        List<UserEntity> data;
        HttpStatus httpStatus;

        try {
            data = userService.getAllUsers();
            System.out.println(data);
            message = data.size() + " users found";
            httpStatus = HttpStatus.OK;
        } catch (Exception e){
            data = null;
            message = e.getMessage();
            httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
        }

        ResponseWrapper<List<UserEntity>> responseWrapper = new ResponseWrapper<>(
                message,
                data
        );

        return new ResponseEntity<>(responseWrapper, httpStatus);
    }
}
