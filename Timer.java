public class Timer implements Runnable{
	private Program program;
	private int sec;
	private boolean working;
	public Timer(Program main){
		program=main;
		sec=0;
		working=true;
	}
	@Override
	public void run() {
		while(working){
			program.setTextArea(sec++);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public void stopWorking(){
		working=false;
		sec=0;
	}
}
