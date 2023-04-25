package NW11;
public class SingletonApp{
    public static void main(String[] args) throws InterruptedException{
        final int STEP = 10;
        Thread t[] = new Thread[STEP];
        for(int i=0; i<STEP; i++){
            t[i]= new Thread(new R());
            t[i].start();
        }
        for (int i=0; i<STEP; i++) t[i].join();
        System.out.println(Singleton.counter);
}
}
class R implements Runnable{

    @Override
    public void run() {
        Singleton.getInstance();
    }
}
class Singleton{
public static int counter = 0;
private static Singleton instance;
private Singleton(){
    counter++;
}

public static Singleton getInstance(){
    if(instance == null) {
        instance = new Singleton();
    }
        return instance;
    }
}