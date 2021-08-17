package candy;

import org.jetbrains.annotations.NotNull;

import java.util.Arrays;

public class Candy {
    public int candy(@NotNull int[] ratings) {
        int len = ratings.length;
        int[] candiesArray = new int[len];
        Arrays.fill(candiesArray, 1);
        for (int index = 1; index < len; index++) {
            if (ratings[index] > ratings[index - 1]) {
                candiesArray[index] = candiesArray[index - 1] + 1;
            }
        }
        for (int index = len - 2; index >= 0; index--) {
            if (ratings[index] > ratings[index + 1]) {
                candiesArray[index] = Math.max(candiesArray[index], candiesArray[index + 1] + 1);
            }
        }
        int totalCandies = 0;
        for (int candies : candiesArray) {
            totalCandies += candies;
        }
        return totalCandies;
    }
}
