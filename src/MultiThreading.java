public class MultiThreading {

    public static void main(String[] args) throws InterruptedException{
        ReadWrite readWrite=new ReadWrite();

       Producer producer=new Producer(readWrite);
        Consumer consumer=new Consumer(readWrite);
        producer.start();
        consumer.start();
        producer.join();
        consumer.join();
        System.out.println("Done Producing and Consuming");
    }


    static class ReadWrite{

        private int value=0;
        private int flag=0;
        synchronized void setValue(int value){
            while (flag>0){
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            this.value=value;
            flag++;
            notifyAll();
        }

        synchronized int getValue(){
            int ans=0;
            while (flag<1){
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            ans=this.value;
            flag=0;
            notifyAll();
            return ans;
        }

    }

    static class Producer extends Thread{
        final ReadWrite readWrite;
        private int count=0;
        Producer(ReadWrite readWrite){
            this.readWrite=readWrite;
        }


        @Override
        public void run(){
            while (count<10){
               readWrite.setValue(count);
               System.out.println("Producer: set "+count);
               count++;
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }


   static class Consumer extends Thread{
        final ReadWrite readWrite;

        Consumer(ReadWrite readWrite){
            this.readWrite=readWrite;
        }

        @Override
        public void run(){
            int ans1=0;
            while (ans1<10){
                int ans=readWrite.getValue();
                System.out.println("Consumer: get "+ans);
                ans1++;
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }


}
