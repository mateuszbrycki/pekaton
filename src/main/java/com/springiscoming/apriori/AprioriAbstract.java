package com.springiscoming.apriori;import java.util.Collection;

public abstract class AprioriAbstract {

    protected Dataset dataset;

    public AprioriAbstract(Dataset dataset) {
        this.dataset = dataset;
    }

    public Dataset getDataset() {
        return this.dataset;
    }

    public abstract Collection runApriori(double minimalSupport, double minimalConfidence);
    public abstract Double computeSupport(Elementset elementset);
    public abstract Double computeConfidence(AssociationRule associationRule);
}
