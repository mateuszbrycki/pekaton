package com.springiscoming.apriori;

import com.springiscoming.model.product.Product;

import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class Dataset {

    private LinkedList<Elementset> transactions = new LinkedList<Elementset>();


    public Dataset(List<List<Product>> productList) throws IOException {

        for (List<Product> products : productList) {
            Elementset newElementset = new Elementset();

            for (Product product : products) {
//				System.out.println(product.getCode());
                newElementset.add(new Element(product.getCode()));
            }

            if (newElementset.size() != 0) {
                //dodanie odczytanej lini do zbioru transakcji
                this.transactions.add(newElementset);
            }
        }
    }

    /**
     * Zwraca iterator do manipulowania na zbiorze tansakcji
     */
    public Iterator getTransactionIterator() {
        return this.transactions.iterator();
    }

    /**
     * Zwraca ilość transakcji wczytanych z pliku
     */
    public int getNumTransactions() {
        return this.transactions.size();
    }

    /**
     * Zwraca listę transakcji
     */
    public LinkedList getTransactions() {
        return this.transactions;
    }
}