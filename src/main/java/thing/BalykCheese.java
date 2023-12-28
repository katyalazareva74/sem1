package thing;

public class BalykCheese implements Snack{
    @Override
    public boolean getProtein() {
        return true;
    }

    @Override
    public boolean getFat() {
        return false;
    }

    @Override
    public boolean getСarbohydrates() {
        return false;
    }

    @Override
    public String getName() {
        return "Сыр (Балык)";
    }
}
