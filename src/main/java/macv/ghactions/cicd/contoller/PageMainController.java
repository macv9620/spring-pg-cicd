package macv.ghactions.cicd.contoller;

import macv.ghactions.cicd.utils.ResponseWrapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class PageMainController {
    @GetMapping
    public ResponseEntity<ResponseWrapper<?>> getVersion(){
        String message;
        String data;
        HttpStatus httpStatus;

            data = "Health Check OK";
            message = "This is the V.1";
            httpStatus = HttpStatus.OK;

        ResponseWrapper<String> responseWrapper = new ResponseWrapper<>(
                message,
                data
        );

        return new ResponseEntity<>(responseWrapper, httpStatus);
    }
}
