package io.casino.chancegames.chancegameutilities;

import java.util.Random;

public class RandomNumGen {
private Random random;

    public RandomNumGen() {
        random = new Random();
    }


    public int randomRoulette() {
        return random.nextInt(37);
    }
}
