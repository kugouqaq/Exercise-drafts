package oeg;


//class MyThread extends Thread{
//    @Override
//    public void run(){
//        for (int i=0;i<10;i++){
//            System.out.println(i);
//            try {
//                Thread.sleep(100);
//            }catch (InterruptedException e){
//                e.printStackTrace();
//            }
//        }
//    }
//}
//
//public class Test {
//    public static void main(String[] args) {
//        MyThread myThread=new MyThread();
//        myThread.start();
//        for (int i=0;i<10;i++){
//            System.out.println("OK");
//            try {
//                Thread.sleep(100);
//            }catch (InterruptedException e){
//                e.printStackTrace();
//            }
//        }
//    }
//}
class Mytask implements Runnable{
    @Override
    public void run(){
        System.out.println("ok");
    }
}
public class Test{
    public static void main(String[] args) {
        Mytask mytask=new Mytask();
        Thread t=new Thread(mytask);
        t.setDaemon(true);
        t.start();
        System.out.println("ok");

    }
}