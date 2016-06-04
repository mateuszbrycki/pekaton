package com.springiscoming.apriori;import java.util.*;


public class AprioriStrategy extends AprioriAbstract {

    private static final int MAX_ELEMENTS_AMOUNT = 500;

    public AprioriStrategy(Dataset dataset) {
        super(dataset);
    }

    /**
     * Oblicza współczynnik wsparcia
     */
    @Override
    public Double computeSupport(Elementset elementset) {

        int occurrenceCount = 0;

        //iterator do transakcji
        Iterator transactionsIterator = this.dataset.getTransactionIterator();

        while (transactionsIterator.hasNext()) {
            //sprawdzenie ile razy zbiór elementów wystąpił w transakcjach
            Elementset elementSet = (Elementset) transactionsIterator.next();

            //jeżeli część wspólna transakcji i zbioru jest takiej samej wielkości jak zbiór
            //to oznacza, że zbiór wystąpił w transakcji
            if (elementSet.intersect(elementset).size() == elementset.size()) {
                occurrenceCount++;
            }
        }

        //współczynnik wsparcia = wystąpienia zbioru / ilość transakcji
        return ((double) occurrenceCount) / this.dataset.getNumTransactions();
    }

    /**
     * Oblicza współczynnik ufności
     */
    @Override
    public Double computeConfidence(AssociationRule associationRule) {

        //część wspólna prawej i lewej strony reguły
        Elementset union = associationRule.getLeftSide().union(
                associationRule.getRightSide());

        //współczynnik ufności = współczynnik wsparcia(część wspólna) / współczynnik wsparcia część lewa
        return computeSupport(union)
                / computeSupport(associationRule.getLeftSide());
    }

    /**
     * Zwraca zbiór częsty jednoelementowy
     */
    public Set getAllElementsetsOfSizeOne() {
        Iterator itItemset = this.dataset.getTransactionIterator();
        Elementset allItems = new Elementset();

        while (itItemset.hasNext()) {
            //dla każdej transakcji utwórz nowy element
            Elementset elementset = (Elementset) itItemset.next();

            //i dodaj go do wszystkich elementów
            allItems = allItems.union(elementset);
        }

        // ze wszystkich elementów utwórz jednoelementowe zbiory
        HashSet<Elementset> allItemsets = new HashSet<Elementset>();
        Iterator itItem = allItems.getIterator();
        while (itItem.hasNext()) {
            Element element = (Element) itItem.next();
            Elementset elementset = new Elementset();
            elementset.add(element);
            allItemsets.add(elementset);
        }

        return allItemsets;
    }

    /**
     * Uruchamia algorytm apriori
     *
     * @return lista reguł asocjacyjnych
     */
    @Override
    public Collection runApriori(double minimalSupport, double minimalConfidence) {


        // generowanie zbioru kandydatów
        Set[] candidates = this.generateCandidatesSet(minimalSupport);

        // generowanie listy reguł asocjacji
        Collection associationRules = this.generateAssociationRules(candidates, minimalConfidence);

        return associationRules;
    }

    /**
     * Generuje zbiór kandydatów
     */
    private Set[] generateCandidatesSet(double minimalSupport) {

        Set[] candidates = new Set[AprioriStrategy.MAX_ELEMENTS_AMOUNT];

        //generowanie zbiorów jednoelementowych
        candidates[1] = getAllElementsetsOfSizeOne();
        for (int itemNumber = 1; itemNumber < AprioriStrategy.MAX_ELEMENTS_AMOUNT && !candidates[itemNumber].isEmpty(); itemNumber++) {

            //przy pierwszej iteracji candidates[itemNumber] ma wszystkie liczby z pliku
            candidates[itemNumber + 1] = new HashSet<Elementset>();

            //iteruj po każdym elemencie ze zbioru trzymanego w candidates[itemsNumber]
            //pierwsza iteracja ma tutaj wszystkie liczby z pliku => po każdej licznie z pliku
            for (Iterator prevoiusElementsetIterator = candidates[itemNumber].iterator(); prevoiusElementsetIterator
                    .hasNext(); ) {

                //zwróć element ze zbioru
                Elementset previousElementset = (Elementset) prevoiusElementsetIterator.next();

                //nextElementsetIterator to iterator po zbiorze elementset
                for (Iterator nextElementsetIterator = candidates[itemNumber].iterator(); nextElementsetIterator
                        .hasNext(); ) {

                    //zwróć następny element z podzbioru
                    Elementset nextElementSet = (Elementset) nextElementsetIterator.next();

                    //cześć wspólna zbioru poprzedniego i następnego
                    //elementy będą iterowane tak długo, aż znajdzie się zbiór, gdzie część wspólna
                    // previousElementset i nextElementSet bedzie równa itemLevel - 1 tzn. zbiór elementów wspólnych
                    //będzie o jeden poziom mniejszy
                    if (previousElementset.intersect(nextElementSet).size() == itemNumber - 1) {

                        //część wspólna obu zbiorów
                        Elementset candidateElementset = previousElementset.union(nextElementSet);

                        assert (candidateElementset.size() == itemNumber + 1);

                        //jeżeli zbiór spełnia warunek minimalnego wsparcia to dodajemy go do listy kandydatów
                        if (computeSupport(candidateElementset) > minimalSupport) {
                            candidates[itemNumber + 1].add(candidateElementset);
                        }

                    }
                }
            }
        }
        return candidates;
    }

    /**
     * Generuje reguły asocjacji
     */
    private Collection generateAssociationRules(Set[] candidates, double minimalConfidence) {
        Collection discoveredAssociationRules = new LinkedList<AssociationRule>();

        //dla każdego poziomu ze zbioru kandydatów
        for (int itemNumber = 1; itemNumber < AprioriStrategy.MAX_ELEMENTS_AMOUNT && !candidates[itemNumber].isEmpty(); itemNumber++) {

            //iteruj po elementach z danego poziomu
            for (Iterator elementsetCandidateIterator = candidates[itemNumber].iterator(); elementsetCandidateIterator.hasNext(); ) {

                //zwróć wskazywany zbiór elementów
                Elementset elementsetCandidate = (Elementset) elementsetCandidateIterator.next();

                //candidateElementsetIterator iterator po podzbiorach wygenerowanych przez prepareNotEmptySubsets
                //dla zbioru elementsetCandidate
                for (Iterator candidateElementsetIterator = elementsetCandidate
                        .prepareNotEmptySubsets().iterator(); candidateElementsetIterator
                             .hasNext(); ) {

                    //przejdź do następnego podzbioru
                    Elementset elementsetSubset = (Elementset) candidateElementsetIterator.next();

                    //prawa strona reguły asocjacji
                    Elementset elementsetA = elementsetSubset;

                    //pomniejszenie zbioru kandydującego o elementy podzbioru => przeniesienie ich na lewą strone
                    Elementset elementsetB = elementsetCandidate.removeAll(elementsetSubset);

                    AssociationRule candidateAssociationRule = new AssociationRule(
                            elementsetA, elementsetB);

                    //obliczenie współczynnika wsparcia dla nowowygenerowanej reguły
                    if (computeConfidence(candidateAssociationRule) > minimalConfidence) {

                        //dodanie reguły do reguł spełniających zadane kryteria
                        discoveredAssociationRules.add(candidateAssociationRule);
                    }
                }
            }
        }

        return discoveredAssociationRules;
    }
}
