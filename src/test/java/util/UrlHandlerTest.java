package util;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class UrlHandlerTest {

    //TDD -> Test Driven Development

    @Test
    @DisplayName("1번 테스트")
    void test() throws Exception {
        String uri  ="/controller/target?userId=3";
        UrlHandler urlHandler = new UrlHandler(uri);
        String action = urlHandler.getAction();
        String division = urlHandler.getDivision();
        Map<String, String> parameterMap = urlHandler.getParameterMap();
        assertEquals("controller", division);
        assertEquals("target", action);
        assertEquals("3", parameterMap.get("userId"));
    }

    @Test
    @DisplayName("잘못된 url")
    void wrongURL() throws Exception {
        String uri  ="/controller/target?userId=";

        Assertions.assertThrows(IllegalArgumentException.class, () -> {UrlHandler urlHandler = new UrlHandler(uri);});

    }


}