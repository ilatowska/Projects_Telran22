package de.telran;

public class PairwiseProblem {

    //TODO implements this, finding two max numbers (the numbers must be on the different indexes)
    public long solve(int[] array) {
        int firstIndex = 0;
        int secondIndex = 0;

        for (int i = 1; i < array.length; i++) {
            if (array[i] > array[firstIndex])
                firstIndex = i;
        }

        for (int j = 1; j < array.length; j++) {
            if (array[j] > array[secondIndex] && j != firstIndex)
                secondIndex = j;

        }
        return (long) array[firstIndex] * array[secondIndex];
    }
}
