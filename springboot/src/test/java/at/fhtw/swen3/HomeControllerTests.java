package at.fhtw.swen3;

import at.fhtw.swen3.controller.rest.HomeController;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class HomeControllerTests {

    private HomeController homeController = new HomeController();
    @Test
    void testIndex() {
        Assertions.assertEquals("redirect:swagger-ui.html", homeController.index());
    }

    @Test
    void testIndexNotNull() {
        Assertions.assertNotNull(homeController.index());
    }
}
