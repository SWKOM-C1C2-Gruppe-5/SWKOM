package at.fhtw.swen3;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
@SpringBootTest(classes = OpenApiGeneratorApplication.class)
@AutoConfigureMockMvc

public class IntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void FailSubmitParcel() throws Exception {
        mockMvc.perform(post("/parcel")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content((byte[]) null))
                .andExpect(status().isBadRequest());

    }




    @Test
    void SuccessSubmitParcel() throws Exception {

        String parcel ="{\"weight\": 992,\n" +
                "\"recipient\": {\n" +
                "\"name\": \"Taqi Taqi\",\n" +
                "\"street\": \"Satoschigasse 83\",\n" +
                "\"postalCode\": \"A-1210\",\n" +
                "\"city\": \"Vienna\",\n" +
                "\"country\": \"Austria\"\n" +
                "},\n" +
                "\"sender\": {\n" +
                "\"name\": \"Hi Name\",\n" +
                "\"street\": \"Donaufelderstraße 1\",\n" +
                "\"postalCode\": \"A-1210\",\n" +
                "\"city\": \"Vienna\",\n" +
                "\"country\": \"Austria\"\n" +
                "}}" ;

        mockMvc.perform(post("/parcel")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(parcel))
                .andExpect(status().isCreated());
    }

}
