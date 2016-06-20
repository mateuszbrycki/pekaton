package com.springiscoming.apriori;

/**
 * Represents an association rule: leftSide => rightSide
 */
public class AssociationRule {

    private Elementset leftSide;

    private Elementset rightSide;

    public AssociationRule(Elementset leftSide, Elementset rightSide) {
        this.leftSide = leftSide;
        this.rightSide = rightSide;
    }

    public Elementset getLeftSide() {
        return this.leftSide;
    }

    public Elementset getRightSide() {
        return this.rightSide;
    }

    public String toString() {
        return "{" + this.leftSide + "} => {" + this.rightSide + "}";
    }

}
