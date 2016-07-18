package com.springiscoming.apriori;

import com.springiscoming.model.entity.Product;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;

@Component
public class Apriori {

    private Dataset dataset;
    private AprioriAbstract aprioriStrategy;

    public Apriori() {}

    /**
     * Start programu, konfiguracja algorytmu, wygenerowanie wyników
     *
     * Argumenty uruchomienia programu: <nazwa pliku z danymi> <współczynnik wsparcia> <współczynnik ufnosci>
     */
    public Collection run(List<List<Product>> productList) {
        try {

            String[] args = new String[]{"dataset.dat", "0.1", "0.1"};
            this.dataset = new Dataset(productList);

            Double minimalSupport = Double.valueOf(args[1]);
            Double minimalConfidence = Double.valueOf(args[2]);


            this.aprioriStrategy = new AprioriStrategy(dataset);
            Collection associationRules = aprioriStrategy
                    .runApriori(minimalSupport, minimalConfidence);

//            this.printAssociationRules(associationRules);

            return associationRules;
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return null;
    }

    private void printAssociationRules(Collection associationRules) {

        Iterator associationRuleIterator = associationRules.iterator();

        while (associationRuleIterator.hasNext()) {

            AssociationRule associationRule = (AssociationRule) associationRuleIterator
                    .next();

            System.out
                    .println("assoctiation rule: "
                            + associationRule
                            + "\t\tsupport: "
                            + this.aprioriStrategy
                            .computeSupport(associationRule
                                    .getLeftSide().union(
                                            associationRule
                                                    .getRightSide()))
                            + "\t\tconfidence: "
                            + this.aprioriStrategy
                            .computeConfidence(associationRule));


        }
    }
}
