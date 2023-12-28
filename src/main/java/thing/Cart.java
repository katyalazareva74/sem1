package thing;

import java.util.ArrayList;
import java.util.Collection;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

public class Cart<T extends Food> {
    private final ArrayList<T> foodstuffs;
    private final UMarket market;
    private final Class<T> clazz;

    public Cart(UMarket market, Class<T> clazz) {
        this.foodstuffs = new ArrayList<>();
        this.market = market;
        this.clazz = clazz;
    }

    public Collection<T> getFoodstuffs() {
        return foodstuffs;
    }

    /**
     * Печать товаров
     */
    public void printFoodstuffs() {
        AtomicInteger index = new AtomicInteger(1);
        foodstuffs.forEach(food -> System.out.printf("[%d] %s (Белки: %s Жиры: %s Углеводы: %s) \n", index.getAndIncrement(),
                food.getName(),
                food.getProtein() ? "Да" : "Нет",
                food.getFat() ? "Да" : "Нет",
                food.getСarbohydrates() ? "Да" : "Нет"));
    }

    /**
     * Метод балансировки корзины по БЖУ.
     */
    public void cartBalancing() {
        AtomicBoolean proteins = new AtomicBoolean(false);
        AtomicBoolean fats = new AtomicBoolean(false);
        AtomicBoolean carbohydrates = new AtomicBoolean(false);

        foodstuffs
                .forEach((food) -> {
                    if (!proteins.get() && food.getProtein()) {
                        proteins.set(true);
                    } else if (!fats.get() && food.getFat())
                        fats.set(true);
                    else if (!carbohydrates.get() && food.getСarbohydrates())
                        carbohydrates.set(true);
                });
        if (proteins.get() && fats.get() && carbohydrates.get()) {
            System.out.println("Корзина уже сбалансирована по БЖУ.");
            return;
        }
        market.getThings(clazz)
                .forEach(thing -> {
                    if (!proteins.get() && thing.getProtein()) {
                        proteins.set(true);
                        foodstuffs.add(thing);
                    } else if (!fats.get() && thing.getFat()) {
                        fats.set(true);
                        foodstuffs.add(thing);
                    } else if (!carbohydrates.get() && thing.getСarbohydrates()) {
                        carbohydrates.set(true);
                        foodstuffs.add(thing);
                    }
                });
        if (proteins.get() && fats.get() && carbohydrates.get())
            System.out.println("Корзина сбалансирована по БЖУ.");
        else
            System.out.println("Невозможно сбалансировать корзину по БЖУ.");
    }
}
