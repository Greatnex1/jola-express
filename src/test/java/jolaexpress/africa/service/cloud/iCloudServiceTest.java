package jolaexpress.africa.service.cloud;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
@Slf4j
class iCloudServiceTest {

@Autowired
    private CloudService cloudService;

private MultipartFile file;


    @BeforeEach
    void setUp() throws IOException {
        Path path = Paths.get("src/main/resources/image/peak.jpeg");
        file = new MockMultipartFile("Peak Milk", Files.readAllBytes(path));
    }

    @Test
    @DisplayName(" upload test")

    void uploadProductImage() {
        try {
            String response = cloudService.uploadProductImage(file.getBytes(), ObjectUtils.emptyMap());

            assertThat(response).isNotNull();
        } catch (IOException err) {
            err.printStackTrace();
        }
        catch (Exception exe) {
            throw new RuntimeException(exe);
        }
        log.info("product uploaded to cloudinary");

    }
}