class Hi extends Thread{

    public void run(){
        for(int i=0;i<5;i++) {
            System.out.println("Hi");
            try {

                Hi.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println(e);
            }
        }
    }
}

class Helo extends Thread{

    @Override
    public void run(){
        for(int i=0;i<5;i++) {
            System.out.println("Hello");
            try {

                Helo.sleep(1000);

            } catch (InterruptedException e) {
                System.out.println(e);
            }
        }
    }
}

public class Threading {


    public static void main(String[] args) {
        Thread thread=new Thread(()-> {
            for(int i=0;i<5;i++) {
                System.out.println("hi");
                try {

                    Thread.sleep(1000);

                } catch (InterruptedException e) {
                    System.out.println(e);
                }
            }
            }
        );

        Thread thread1=new Thread(()-> {
            for(int i=0;i<5;i++) {
                System.out.println("Hello");
                try {

                    Thread.sleep(1000);

                } catch (InterruptedException e) {
                    System.out.println(e);
                }
            }
        }

        );
        thread.start();
        thread1.start();

    }

}

