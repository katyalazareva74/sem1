package thing;

import java.util.ArrayList;
import java.util.Collection;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public class UMarket {
    private final Collection<Thing> things;

    public UMarket() {
        this.things = new ArrayList<>();
        initializeThings();
    }
    public void initializeThings(){
        things.add(new BalykCheese());
        things.add(new Cheburek());
        things.add(new Chicken());
        things.add(new ChocolateBa());
        things.add(new Crisps());
        things.add(new Fruit());
        things.add(new Notebook());
        things.add(new OliveOil());
        things.add(new Pen());
        things.add(new DumplingsBerries());
        things.add(new DumplingsMeat());
    }

    /**
     * Распечатать список товаров по типу
     * @param clazz - описатель типа товаров
     * @param <T> - тип товара
     */
    public <T extends Thing> void printThings(Class<T> clazz){
        int[] index = {1};
        things.stream()
                .filter(clazz::isInstance)
                .forEach(thing -> {
                    if(Food.class.isAssignableFrom(thing.getClass())){
                    Food foodthing = (Food) thing;
                    System.out.printf("[%d] %s (Белки: %s Жиры: %s Углеводы: %s) \n",
                            index[0]++, thing.getName(),
                            foodthing.getProtein() ? "Да" : "Нет",
                            foodthing.getFat() ? "Да" : "Нет",
                            foodthing.getСarbohydrates() ? "Да" : "Нет");
                    }
                    else {
                        System.out.printf("[%d] %s \n", index[0]++, thing.getName());
                    }
                });
    }
    /**
     * Метод для получения списка товаров определенного типа
     * @param clazz - описатель товара
     * @return - возвращает список товаров
     * @param <T> тип товара
     */
    public <T extends Thing> Collection<T> getThings(Class<T> clazz){
        return things.stream()
                .filter(clazz::isInstance)
                .map(clazz::cast)
                .collect(Collectors.toList());
    }

    /**
     * Метод для получения товара по его номеру
     * @param clazz - описатель типа
     * @param index - номер товара
     * @return возвращает товар
     * @param <T> тип товара
     */
    public <T extends Thing> T getThingByIndex(Class<T> clazz, int index){
        AtomicInteger counter = new AtomicInteger(1);
        return  things.stream()
                .filter(clazz::isInstance)
                .filter(thing -> index==counter.getAndIncrement())
                .map(clazz::cast)
                .findFirst()
                .orElse(null);
    }
}
