package decisionmaking;

import java.util.Objects;

public class Trees implements Comparable<Trees> {
	
	private String name;
	private int age;
	private double avHeight;
	
	public Trees(String name, int age, double avHeight) {
		
		this.name = name;
		this.age = age;
		this.avHeight = avHeight;
	}

	
/*---------Setter methods-------------------------------------*/	
	public String getName() {
		return name;
	}

	public int getAge() {
		return age;
	}
	
	public double getAvHeight() {
		return avHeight;
	}
	
/*---------Setter methods-------------------------------------*/
	public void setName(String name) {
		this.name = name;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public void setAvHeight(double avHeight) {
		this.avHeight = avHeight;
	}

/*-------Hash Code-------------------------------------------*/
	@Override
	public int hashCode() {
		return Objects.hash(age, avHeight, name);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Trees other = (Trees) obj;
		return age == other.age && Double.doubleToLongBits(avHeight) == Double.doubleToLongBits(other.avHeight)
				&& Objects.equals(name, other.name);
	}


	@Override
	public String toString() {
		return "[Name: " + name 
				+ ", Age: " + age 
				+ "years, Average Height: " + avHeight + "m]";
	}


	@Override
	public int compareTo(Trees other) {
		
		return Integer.compare(this.age, other.age);
	}
	
	
	
	

}
