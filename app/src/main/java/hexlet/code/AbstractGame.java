package hexlet.code;

abstract class AbstractGame implements Game {
    protected final int gameHotPoint;
    protected String title;
    protected String userName;

    AbstractGame(int gameHotPoint, String title) {
        this.gameHotPoint = gameHotPoint;
        this.title = title;
    }

    @Override
    public void outDescription() {
        System.out.println(gameHotPoint + " - " + title);
    }

    @Override
    public void play() {
        System.out.println("My index: " + gameHotPoint + " my title: " + title); // ##TODO debug mode
    }

    @Override
    public int getHotPoint() {
        return gameHotPoint;
    }
}
