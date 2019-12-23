import java.io.IOException;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        final Object lock = new Object();


        SomeClass sc1 = new SomeClass();
        Server s1 = new Server(1, sc1);
        Thread t1  = new Thread(){
            public void run(){
                s1.doStuff(lock);
                try {
                    s1.run();
                } catch (InterruptedException e) {
                   s1.close();
                }

            }
        };
        t1.setName("server1");
        t1.start();

        SomeClass sc2 = new SomeClass();
        Server s2 = new Server(2, sc2);
        Thread t2  = new Thread(){
            public void run(){
                s2.doStuff(lock);
                try {
                    s2.run();
                } catch (InterruptedException e) {
                    s2.close();
                }

            }
        };
        t2.setName("server2");
        t2.start();

        SomeClass sc3 = new SomeClass();
        Server s3 = new Server(3, sc3);
        Thread t3  = new Thread(){
            public void run(){
                s3.doStuff(lock);
                try {
                    s3.run();
                } catch (InterruptedException e) {
                    s3.close();
                }

            }
        };
        t3.setName("server3");
        t3.start();

        SomeClass sc4 = new SomeClass();
        Server s = new Server(4, sc4);
        Thread t4  = new Thread(){
            public void run(){
                s.doStuff(lock);
                try {
                    s.run();
                } catch (InterruptedException e) {
                    s.close();
                }

            }
        };
        t4.setName("server4");
        t4.start();



//        Thread t1 = new Thread(new Runnable(){
//            public void run(){
//                SomeClass sc = new SomeClass();
//                Server s = new Server(1,lock, sc);
//                s.doStuff();
//                s.run();
//            }
//        });

//        Thread t2 = new Thread(new Runnable(){
//            public void run(){
//                SomeClass sc = new SomeClass();
//                Server s = new Server(2,lock, sc);
//                s.doStuff();
//                s.run();
//            }
//        });
//        t2.setName("server2");
//        t2.start();
//
//        Thread t3 = new Thread(new Runnable(){
//            public void run(){
//                SomeClass sc = new SomeClass();
//                Server s = new Server(3,lock,sc);
//                s.doStuff();
//                s.run();
//            }
//        });
//        t3.setName("server3");
//        t3.start();
//
//        Thread t4 = new Thread(new Runnable(){
//            public void run(){
//                SomeClass sc = new SomeClass();
//                Server s = new Server(4,lock, sc);
//                s.doStuff();
//                s.run();
//            }
//        });
//        t4.setName("server4");
//        t4.start();


        Thread.sleep(10000);

        t1.interrupt();
        t2.interrupt();
        t3.interrupt();
        t4.interrupt();

//        try {
////            t1.join();
////            t2.join();
////            t3.join();
////            t4.join();
//        } catch (InterruptedException e) {
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//        }
    }

}