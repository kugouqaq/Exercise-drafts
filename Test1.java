package test1;

class A{
    public synchronized void xxx(){
        System.out.printf("xxx");
        while (true);
    }
}
class T extends Thread {
    private A a;
    public T(A a) {
        this.a=a;
    }

    @Override
    public void run() {
        synchronized (a){
            System.out.printf("run");
            while (true);
        }

    }
}

public class Test1 {
    public static void main(String[] args) {
        A a=new A();
        A a1=new A();
        T t=new T(a);
        t.start();
        a.xxx();
    }
}
