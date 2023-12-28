package thing;

public class Crisps implements Snack{
    @Override
    public boolean getProtein() {
        return false;
    }

    @Override
    public boolean getFat() {
        return true;
    }

    @Override
    public boolean getСarbohydrates() {
        return false;
    }

    @Override
    public String getName() {
        return "Чипсы";
    }
}
