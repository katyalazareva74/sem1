package thing;

public class OliveOil implements HealthyFood {
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
        return "Оливковое масло";
    }
}
