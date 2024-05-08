
interface Run {
	void PrintName();
	int GetSpeed();
	float GetWeight();
	int GetPassangers();
	int GetWheelNumber();
}

abstract class Machine implements Run {
	public static final int MAX_SPEED = 500;
	public static final int MIN_SPEED = 0;
	public static final int MIN_PASSANGERS = 0;
	public static final int MAX_PASSANGERS = 200;
	
	protected String Name;
	protected int Speed;

	Machine(String name, int speed) {
		this.Name = name;
		this.Speed = speed;
	}

	@Override
	public void PrintName() {
		System.out.printf("Name of the machine is %s", this.Name);
	}
}

class Plane extends Machine {
	protected int Passangers;
	protected int Weight;
	protected int WheelNumber;

    public Plane(String name, int speed) {
        super(name, speed);
    }

	public void SetSpeed(int speed) {
		if (speed > MAX_SPEED || speed < MIN_SPEED) {
			System.out.println("Your speed is invalid, try some other number");
		} else {
			this.Speed = speed;
		}
	}

    @Override
    public void PrintName() {
        System.out.printf("Name of the plane is %s%n", this.Name);
    }

	@Override
	public float GetWeight() {
		return this.Weight;
	}

	@Override
	public int GetPassangers() {
		return this.Passangers;
	}

	@Override
	public int GetSpeed() {
		return this.Speed;
	}

	@Override
	public int GetWheelNumber() {
		return 2;
	}
}


class StealthJet extends Plane {

	StealthJet(String name, int speed, int capacity, int weigth) {
		super(name, speed);
		this.Passangers = capacity;
	}
}

class Corncob extends Plane {
	Corncob(String name, int speed, int capacity, int weight) {
		super(name, speed);
		this.Passangers = capacity;
		this.Weight = weight;
	}
}


public class ex1 {
	public static void main(String[] argv) {
		Corncob plane1 = new Corncob("Corncob1", 100, 4, 100);
		StealthJet plane2 = new StealthJet("StealthJat1", 400, 2, 500);

		plane1.PrintName();
		System.out.println(plane1.GetPassangers());
		plane2.PrintName();
		System.out.println(plane2.GetPassangers());
	}
}
