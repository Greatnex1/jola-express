package jolaexpress.africa.service;

import com.github.fge.jsonpatch.JsonPatch;
import jolaexpress.africa.data.dto.request.AllItemRequest;
import jolaexpress.africa.data.dto.request.UploadProductRequest;
import jolaexpress.africa.data.dto.response.DeleteProductResponse;
import jolaexpress.africa.data.dto.response.UpdateProductResponse;
import jolaexpress.africa.data.dto.response.UploadProductResponse;
import jolaexpress.africa.data.model.Product;
import jolaexpress.africa.exception.ProductNotFoundException;
import org.springframework.data.domain.Page;

import java.io.IOException;

public interface ProductService {
    UploadProductResponse uploadProductImage (UploadProductRequest productRequest) throws IOException;

    UpdateProductResponse updateProductDetails(Long productId, JsonPatch jsonPatch) throws ProductNotFoundException;

    Product getProductById(Long id) throws ProductNotFoundException;

    Page<Product> getAllProducts(AllItemRequest allItemRequest);

    DeleteProductResponse deleteProduct(Long  id);

}
