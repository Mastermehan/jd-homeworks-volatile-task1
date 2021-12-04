public class RunnableToy implements Runnable{
    private static final int TIME_TO_TURN_OFF = 1000;
    private Toy toy;
    private Thread threadUser;

    public RunnableToy(Toy toy, Thread threadUser) {
        this.toy = toy;
        this.threadUser = threadUser;
    }

    @Override
    public void run() {
        while (threadUser.isAlive()) { //Метод возвращает true,
            // если поток, для которого вызван метод, еще выполняется.
            if (toy.isFlag()) {
                try {
                    Thread.sleep(TIME_TO_TURN_OFF);
                    toy.setFlag(false);
                    System.out.println(Thread.currentThread().getName() + " тумблер выключен!");
                } catch (InterruptedException ex) {
                    return;
                }
            }
        }
        System.out.println(Thread.currentThread().getName() + " выключаюсь.");
    }
}
