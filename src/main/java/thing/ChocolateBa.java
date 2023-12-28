package thing;

public class ChocolateBa implements Snack{
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
        return "Шоколадный батончик";
    }
}
