package ex06;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class Airplane {

	@Autowired
	@Qualifier("bat")
	private IBattery battery;

	public IBattery getBattery() {
		return battery;
	}
	public void setBattery(IBattery battery) {
		this.battery = battery;
	}
	
	
}
