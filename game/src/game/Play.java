package game;

public class Play implements Runnable {

	public ObjAction action;
	
	Play (ObjAction o) {
		action = o;
	}
	
	@Override
	public void run() {
		while(true) {
			action.update();
			try{
				Thread.sleep(18);
			} catch (Exception e){}
		}
	}
}
