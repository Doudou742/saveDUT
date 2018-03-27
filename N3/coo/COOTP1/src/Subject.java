import java.util.ArrayList;

public abstract class Subject {
	ArrayList<Observer> observers = new ArrayList<Observer>();
	
	public void addObserver(Observer ob){
		observers.add(ob);
	}
	
	public void removeObserver(Observer ob){
		observers.remove(ob);
	}
	
	public void notifyObservers(){
		for(Observer ob: observers){
			ob.update();
		}
	}

}
