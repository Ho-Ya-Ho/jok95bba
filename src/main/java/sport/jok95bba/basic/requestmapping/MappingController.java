package sport.jok95bba.basic.requestmapping;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MappingController {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @GetMapping("/hello-basic")
    public String logTest() {
        logger.info("helloBasic");
        return "ok";
    }

    @GetMapping("/mapping/{userId}")
    public String mappingPath(@PathVariable String userId) {
        logger.info("mappingPath userId={}", userId);
        return "ok";
    }
}
