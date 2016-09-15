package logical;

public class SportMan {
   private String name;
   private int code;
   private int age;
   private String Sport;
   private float[] times;
   

   public SportMan(String name, int age, String sport) {
	super();
	this.name = name;
	this.age = age;
	Sport = sport;
	this.times = new float[5];
}

public String getName() {
	return name;
}

public void setName(String name) {
	this.name = name;
}

public int getAge() {
	return age;
}

public void setAge(int age) {
	this.age = age;
}

public String getSport() {
	return Sport;
}

public void setSport(String sport) {
	Sport = sport;
}

public float[] getTimes() {
	return times;
}

public void setTimes(float[] times) {
	this.times = times;
}

public int getCode() {
	return code;
}

public void setCode(int code) {
	this.code = code;
}
   
   
}
