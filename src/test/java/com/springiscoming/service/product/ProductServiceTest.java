package com.springiscoming.service.product;

import com.springiscoming.model.product.Product;
import com.springiscoming.repository.ProductRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static com.springiscoming.builder.ProductBuilder.get;
import static org.mockito.Mockito.verify;

/**
 * Created by winio_000 on 2016-06-20.
 */

@RunWith(MockitoJUnitRunner.class)
public class ProductServiceTest {

    @Mock
    private MostPopularProductService mostPopularProductService;

    @Mock
    private ProductRepository productRepository;

    @InjectMocks
    private ProductService productService;

    @Test
    public void shouldSaveProductInProductRepository() throws Exception {
        Product product = get().withId(1L).withName("name").withCode("code").withPrice(1f).build();

        productService.save(product);

        verify(productRepository).save(product);
    }

    @Test
    public void shouldFindProductByCodeInProductRepository() throws Exception {
        String productCode = "productCode";

        productService.findOneByCode(productCode);

        verify(productRepository).findFirstByCodeOrderByProductId(productCode);
    }

    @Test
    public void shouldFindAllProductsInProductRepository() throws Exception {
        productService.getAll();

        verify(productRepository).findAll();
    }

    @Test
    public void shouldFindMostPopularProduct() throws Exception {
        productService.getMostPopular();

        verify(mostPopularProductService).findMostPopular();
    }

    @Test
    public void shouldFindProductsByPurchaseId() throws Exception {
        long purchaseId = 1L;

        productService.getProductListsByPurchaseId(purchaseId);

        verify(productRepository).getProductListsByPurchaseId(purchaseId);
    }
}