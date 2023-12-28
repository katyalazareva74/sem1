package thing;

public class DumplingsBerries implements SemiFinishedFood{
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
        return "Замороженные ягоды";
    }
}
