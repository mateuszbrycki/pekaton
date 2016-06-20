package com.springiscoming.apriori;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.Vector;

/**
 * Reprezentacja zbioru elementów transakcji
 */
public class Elementset {

    private Set elements = new HashSet();

    /**
     * Domyślny konstruktor
     */
    public Elementset() {
    }

    /**
     * Tworzy zbiór elementów na podstawie podanego elementset
     */
    private Elementset(Elementset elementset) {
        this.elements = new HashSet(elementset.getElements());
    }

    /**
     * Dodaje element do zbioru
     */
    public void add(Element element) {
        this.elements.add(element);
    }

    /**
     * Wyciąga częsć wspólną zbiorów
     */
    public Elementset intersect(Elementset otherSet) {
        Elementset newElementset = new Elementset(this);
        newElementset.getElements().retainAll(otherSet.getElements());
        return newElementset;
    }

    /**
     * Wyciąga część wspólną elementów
     */
    public Elementset union(Elementset otherSet) {
        Elementset newElementset = new Elementset(this);
        newElementset.getElements().addAll(otherSet.getElements());
        return newElementset;
    }

    /**
     * Usuwa te elementy zbioru, które znajdują się w przekazanym zbiorze
     */
    public Elementset removeAll(Elementset otherSet) {
        Elementset newElementset = new Elementset(this);
        newElementset.getElements().removeAll(otherSet.getElements());
        return newElementset;
    }

    /**
     * Generuje wszystkie niepuste podzbiory
     *
     * @param itemsVector       zbiór, z którego będą generowane podzbiory
     * @param setLevel          poziom podzbioru
     * @param notEmptySubsets   zbiór wynikowy
     * @param currentElementset obecnie analizowany zbiór
     */
    private void prepareNotEmptySubsets(Vector itemsVector, int setLevel,
                                        Set notEmptySubsets, Elementset currentElementset) {

       /* System.out.println("ItemsVector: " + itemsVector);
        System.out.println("SetLevel: " + setLevel);
        System.out.println("NotEmptySubsets: " + notEmptySubsets);
        System.out.println("CurrentElement: " + currentElementset);
        System.out.println("---------------");*/

        // kopia listy elementów
        currentElementset = new Elementset(currentElementset);

        boolean itemAdded = false;
        while (true) {

            if (setLevel == itemsVector.size() - 1) {
                //tutaj wpadają wszystkie obiegi dla itemsVector na jeden element dla poziomu 0

                //sprawdzenie czy aktualnie analizowany zbiór elementów jest już niepustym podzbiorem zbioru itemsVector
                if (currentElementset.size() != 0
                        && currentElementset.size() != itemsVector.size()) {
                    //dodanie zbioru currentElementset do listy zbiorów niepustych
                    notEmptySubsets.add(currentElementset);
                }
            } else {
                //wygenerowanie nowego podzbioru
//                System.out.println("Rekurencja");
                prepareNotEmptySubsets(itemsVector, setLevel + 1,
                        notEmptySubsets, currentElementset);
//                System.out.println("Rekurencja - koniec");
            }
            if (itemAdded) {
                //jeżeli element został dodany to pętla jest przerywana
                break;
            } else {
                //kopia zbioru w celu uniknięcia modyfikacji przez rekurencyjne wywołania metody
                currentElementset = new Elementset(currentElementset);
                currentElementset.add((Element) itemsVector.elementAt(setLevel));

                //oznaczenie elementu jako dodanego
                itemAdded = true;
            }

//            System.out.println("CurrentElement: " + currentElementset);
//            System.out.println("NotEmptySubsets: " + notEmptySubsets);
        }

//        System.out.println("Wyjście z metody - CurrentElement: " + currentElementset);
        //emptysubsets ma dodane currentElements - linia 86
//        System.out.println("Wyjście z metody - NotEmptySubsets: " + notEmptySubsets);
    }

    /**
     * Generuje wszystkie niepuste podzbiory
     */
    public Set prepareNotEmptySubsets() {
        HashSet notEmptySubsets = new HashSet();
        this.prepareNotEmptySubsets(new Vector(this.elements), 0, notEmptySubsets,
                new Elementset());
//        System.out.println();
        return notEmptySubsets;
    }

    /**
     * Zwraca rozmiar zbioru elementów
     */
    public int size() {
        return this.elements.size();
    }

    /**
     * Zwraca iterator do operowania na zbiorze
     */
    public Iterator getIterator() {
        return this.elements.iterator();
    }

    public Element getFirst() {
        Iterator itItem = this.elements.iterator();
        Integer i = 0;
        while (itItem.hasNext() && i < 2) {
            return (Element) itItem.next();
        }

        return null;
    }

    /**
     * Zwraca elementy zbioru
     */
    public Set getElements() {
        return this.elements;
    }

    @Override
    public String toString() {
        StringBuffer out = new StringBuffer();
        Iterator itItem = this.elements.iterator();
        while (itItem.hasNext()) {
            Element element = (Element) itItem.next();
            out.append(element.toString());
            if (itItem.hasNext()) {
                out.append(" ");
            }
        }
        return out.toString();
    }

    @Override
    public boolean equals(Object o) {
        return ((Elementset) o).getElements().equals(this.elements);
    }

    @Override
    public int hashCode() {
        return this.elements.hashCode();
    }
}
