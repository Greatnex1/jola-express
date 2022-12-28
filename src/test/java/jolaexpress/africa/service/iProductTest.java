package jolaexpress.africa.service;

import jolaexpress.africa.data.dto.request.AllItemRequest;
import jolaexpress.africa.data.dto.request.UploadProductRequest;
import jolaexpress.africa.data.dto.response.UploadProductResponse;
import jolaexpress.africa.data.model.Category;
import jolaexpress.africa.data.model.Product;
import jolaexpress.africa.exception.ProductNotFoundException;
import jolaexpress.africa.repository.ProductRepository;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
@Slf4j
class iProductTest {

    @Autowired
    private ProductService productService;

    private UploadProductRequest productRequest;

    private UploadProductResponse productResponse;

   // private ProductRepository productRepo;



    @BeforeEach
    void up() throws IOException {
        Path path = Paths.get("src/main/resources/image/peak.jpeg");
        MultipartFile file = new MockMultipartFile("Peak Milk", Files.readAllBytes(path));

        productRequest = UploadProductRequest
                .builder()
                .productName("Peak")
                .productCategory("BEVERAGES")
                .price(BigDecimal.valueOf(100.00))
                .quantity(5)
                .image(file)
                .build();

        productResponse = productService.uploadProductImage(productRequest);
    }


    @Test
    void uploadProductImage() {
        assertThat(productResponse).isNotNull();
     //   assertThat(productRequest.getProductName()).isEqualTo("Peak");
    }

    @Test
    void updateProductDetails() {
    }

    @Test
    void getProductById() throws ProductNotFoundException {
        Product productFound = productService.getProductById(productResponse.getProductId()) ;
        assertThat(productFound).isNotNull();
        log.info("produt :: {}",productFound);
    }

    @Test
    void getAllProducts() throws IOException {
        productService.uploadProductImage(productRequest);

        var getItems = AllItemRequest.builder()
                .numberOfProductPerPage(8)
                .pageNumber(1)
                .build();
        Page<Product> productPage =  productService.getAllProducts(getItems);
        log.info("page  contents  ::{}", productPage.getTotalElements());
        assertThat(productPage).isNotNull();
    }

    @Test
    void deleteProduct() {

        assertThat(productService.deleteProduct(productResponse.getProductId()));
    }
}