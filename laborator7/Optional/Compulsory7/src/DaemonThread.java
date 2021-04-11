public class DaemonThread extends Thread{
    long startTime=System.nanoTime();
    public void run(){
        while(this.isAlive()){

            try{
                Thread.sleep(1000);
            }
            catch (InterruptedException ig){

            }
        }
        System.out.println(System.nanoTime()+ "BUNA ZIUA LA TOATA LUMEA");

    }
}
