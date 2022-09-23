package sport.jok95bba.basic.requestmapping;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MappingController {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @GetMapping("/mapping/{userId}")
    public String mappingPath(@PathVariable String userId) {
        logger.info("mappingPath userId={}", userId);
        return "ok";
    }

//    @GetMapping("/log-test")
//    public String logTest() {
//        String name = "Spring";
//        logger.trace("trace log={}", name);
//        logger.debug("debug log={}", name);
//        logger.info(" info log={}", name);
//        logger.warn(" warn log={}", name);
//        logger.error("error log={}", name);
////로그를 사용하지 않아도 a+b 계산 로직이 먼저 실행됨, 이런 방식으로 사용하면 X log.debug("String concat log=" + name);
//        return "ok";
//    }

    @GetMapping("/mapping/users/{userId}/orders/{orderId}")
    public String mappingPath(@PathVariable String userId, @PathVariable Long orderId) {
        logger.info("mappingPath userId={}, orderId={}", userId, orderId);
        return "ok";
    }

    /**
     * 파라미터로 추가 매핑
     * params="mode",
     * params="!mode"
     * params="mode=debug"
     * params="mode!=debug" (! = )
     * params = {"mode=debug","data=good"}
     */

    @GetMapping(value = "/mapping-param", params = "mode=debug")
    public String mappingParam() {
        logger.info("mappingParam");
        return "ok";
    }

    /**
     *특정 헤더로 추가 매핑
     * headers="mode",
     * headers="!mode"
     * headers="mode=debug"
     * headers="mode!=debug" (! = )
     */
    @GetMapping(value = "/mapping-header", headers = "mode=debug")
    public String mappingHeader() {
        logger.info("mappingHeader");
        return "ok";
    }

    /**
     * Content-Type 헤더 기반 추가 매핑 Media Type * consumes="application/json"

     * consumes="!application/json"
     * consumes="application/*"
     * consumes="*\/*"
     * MediaType.APPLICATION_JSON_VALUE
     */
    @PostMapping(value = "/mapping-consume", consumes = "application/json")
    public String mappingConsumes() {
        logger.info("mappingConsumes");
        return "ok";
    }

    /**
     * Accept 헤더 기반 Media Type * produces = "text/html"
     * produces = "!text/html" * produces = "text/*"
     * produces = "*\/*"
     */
    @PostMapping(value = "/mapping-produce", produces = "text/html")
    public String mappingProduces() {
        logger.info("mappingProduces");
        return "ok";
    }
}
