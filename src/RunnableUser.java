public class RunnableUser implements Runnable {

    private static final int TIMER = 2000;
    private static final int AMOUNT_OF_GAMES = 3;

    private final Toy toy;

    public RunnableUser(Toy toy) {
        this.toy = toy;
    }

    @Override
    public void run() {
        try {
            for (int i = 0; i < AMOUNT_OF_GAMES; i++) {
                Thread.sleep(TIMER);
                toy.setFlag(true);//вызываем метод включения тумблера
                System.out.println(Thread.currentThread().getName() + " включаю тумблер!");
            }
            Thread.sleep(TIMER);
            System.out.println(Thread.currentThread().getName() + " хватит играть");
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
    }
}