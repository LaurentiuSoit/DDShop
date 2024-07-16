package dd.projects.ddshop.Controllers;

import dd.projects.ddshop.DTOs.ProductDTO;
import dd.projects.ddshop.Services.ProductService;
import java.util.ArrayList;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/product")
public class ProductRest {

    ProductService productService;

    public ProductRest(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping(path = "/getAll")
    public ResponseEntity<List<ProductDTO>> getAllProductsSortedBy(String sortBy) {
        try {
            return productService.getAllProductsSortedBy(sortBy);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return new ResponseEntity<>(new ArrayList<ProductDTO>(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @DeleteMapping(path = "/delete/{id}")
    public ResponseEntity<String> deleteProduct(@PathVariable Integer id) {
        try {
            return productService.deleteProduct(id);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return new ResponseEntity<String>(
            "Something went wrong.",
            HttpStatus.INTERNAL_SERVER_ERROR
        );
    }
}
