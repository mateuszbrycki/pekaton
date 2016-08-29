package com.springiscoming.service.apriori;

import com.springiscoming.apriori.Apriori;
import com.springiscoming.apriori.AssociationRule;
import com.springiscoming.apriori.Element;
import com.springiscoming.apriori.Elementset;
import com.springiscoming.model.entity.Product;
import com.springiscoming.model.entity.Purchase;
import com.springiscoming.model.other.recomennded.RecommendedProduct;
import com.springiscoming.service.ProductService;
import com.springiscoming.service.PurchaseService;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.*;

@Service
public class AprioriService {

    @Inject
    private Apriori apriori;

    @Inject
    private ProductService productService;

    @Inject
    private PurchaseService purchaseService;


    public List<RecommendedProduct> getAssociationRules() {

        List<List<Product>> aprioriPurchaseproducts = new ArrayList<>();

        for(Purchase purchase : purchaseService.findAll()) {
            List<Product> purchaseProducts = productService.getProductListsByPurchaseId(purchase.getPurchaseId());
            aprioriPurchaseproducts.add(purchaseProducts);
        }

        Collection associationRules = apriori.run(aprioriPurchaseproducts);

        Iterator associationRuleIterator = associationRules.iterator();

        HashMap<Product, List<Product>> resultMap = new HashMap<>();
        while (associationRuleIterator.hasNext()) {

            AssociationRule associationRule = (AssociationRule) associationRuleIterator
                    .next();

            Elementset leftSide = associationRule.getLeftSide();
            if (leftSide.size() == 1) {
                Product leftSideProduct = productService.findOneByCode(leftSide.getFirst().getValue());

                List<Product> leftSideFromMap = resultMap.get(leftSideProduct);


               /*Generate right side*/
                Elementset rightSide = associationRule.getRightSide();
                List<Product> rightSideProductList = new ArrayList<>();

                Iterator rightSideIterator = rightSide.getIterator();
                while(rightSideIterator.hasNext()) {

                    Element rightSideTempElement = (Element)rightSideIterator.next();
                    rightSideProductList.add(productService.findOneByCode(rightSideTempElement.getValue()));
                }

                if(leftSideFromMap != null && (leftSideFromMap.size() < rightSide.size())) {
                    //replace element
                    resultMap.put(leftSideProduct, rightSideProductList);
                } else if(leftSideFromMap == null) {
                    //add new element
                    resultMap.put(leftSideProduct, rightSideProductList);
                }
            }

        }

        List<RecommendedProduct> resultList = this.convertFromMapToList(resultMap);

        return resultList;
    }

    private List<RecommendedProduct> convertFromMapToList( HashMap<Product, List<Product>> resultMap) {
        List<RecommendedProduct> result = new ArrayList<>();

        for(Map.Entry<Product, List<Product>> mapEntry : resultMap.entrySet()) {
            RecommendedProduct product = new RecommendedProduct(mapEntry.getKey(), mapEntry.getValue());
            result.add(product);
        }

        return result;
    }
}
