package thing;

public class Fruit implements HealthyFood{
    @Override
    public boolean getProtein() {
        return false;
    }

    @Override
    public boolean getFat() {
        return false;
    }

    @Override
    public boolean getСarbohydrates() {
        return true;
    }

    @Override
    public String getName() {
        return "Фрукт";
    }
}
