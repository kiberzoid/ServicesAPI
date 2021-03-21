package com.kiberzoid.emailservice;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.kiberzoid.emailservice.web.EmailController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.web.servlet.MockMvc;

import java.nio.charset.StandardCharsets;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.multipart;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class EmailServiceApplicationTests {
    private static final String URL = EmailController.URL + "/message";

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper mapper;

    @Test
    void contextLoads() {
    }

    @Test
    public void sendMessageWithoutAttachment() throws Exception {
        MockMultipartFile mockFile = new MockMultipartFile("msg", "msg.json",
                MediaType.APPLICATION_JSON_VALUE, mapper.writeValueAsString(TestData.MSG).getBytes(StandardCharsets.UTF_8));
        mockMvc.perform(multipart(URL)
                .file(mockFile))
                .andDo(print())
                .andExpect(status().isNoContent());
    }

    @Test
    public void sendMessageWithAttachment() throws Exception {
        MockMultipartFile mockFileAttachment = new MockMultipartFile("attachment", "manual.txt",
                MediaType.TEXT_PLAIN_VALUE, "text inside manual".getBytes(StandardCharsets.UTF_8));
        MockMultipartFile mockFile = new MockMultipartFile("msg", "msg.json",
                MediaType.APPLICATION_JSON_VALUE, mapper.writeValueAsString(TestData.MSG).getBytes(StandardCharsets.UTF_8));
        mockMvc.perform(multipart(URL)
                .file(mockFileAttachment)
                .file(mockFile))
                .andDo(print())
                .andExpect(status().isNoContent());
    }

    @Test
    public void sendMessageWithoutMsg() throws Exception {
        MockMultipartFile mockFileAttachment = new MockMultipartFile("attachment", "manual.txt",
                MediaType.MULTIPART_FORM_DATA_VALUE, "text inside manual".getBytes(StandardCharsets.UTF_8));
        mockMvc.perform(multipart(URL)
                .file(mockFileAttachment))
                .andDo(print())
                .andExpect(status().isBadRequest());
    }


    @Test
    public void sendBadMessageWithoutAttachment() throws Exception {
        MockMultipartFile mockFile = new MockMultipartFile("msg", "msg.json",
                MediaType.APPLICATION_JSON_VALUE, mapper.writeValueAsString(TestData.BAD_MSG).getBytes(StandardCharsets.UTF_8));
        mockMvc.perform(multipart(URL)
                .file(mockFile))
                .andDo(print())
                .andExpect(status().isUnprocessableEntity());
    }
}
