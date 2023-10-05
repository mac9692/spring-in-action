package tacos.service;

import org.springframework.stereotype.Service;
import org.springframework.web.servlet.function.ServerRequest;
import org.springframework.web.servlet.function.ServerResponse;

/**
 * @author parkjinseong
 * @version 1.0
 * @since 2023/10/05
 */
@Service
public class TestService {

    public ServerResponse getTest(ServerRequest request) {
        return ServerResponse.ok().body("test");
    }
}
