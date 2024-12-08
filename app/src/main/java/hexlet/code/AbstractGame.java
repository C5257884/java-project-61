package hexlet.code;

abstract class AbstractGame implements Game {
    protected int index;
    protected String title;

    AbstractGame(int index, String title) {
        this.index = index;
        this.title = title;
    }

    @Override
    public void outDescription() {
        System.out.println(index + " - " + title);
    }

    @Override
    public void play() {
        return;
    }
}
