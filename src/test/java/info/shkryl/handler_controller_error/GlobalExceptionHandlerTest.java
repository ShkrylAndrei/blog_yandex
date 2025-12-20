package info.shkryl.handler_controller_error;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class GlobalExceptionHandlerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void shouldReturnUnifiedErrorResponseWhenValidationFails() throws Exception {
        String json = "{\"email\": \"\", \"password\": \"123\"}";

        MvcResult result = mockMvc.perform(post("/api/users")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(json))
                .andExpect(status().isBadRequest())
                .andReturn();

        // Проверяем структуру JSON
        String responseBody = result.getResponse().getContentAsString();
        Assertions.assertThat(responseBody).contains("Validation Failed");
        Assertions.assertThat(responseBody).contains("timestamp");
        Assertions.assertThat(responseBody).contains("\"status\":400");
    }
}