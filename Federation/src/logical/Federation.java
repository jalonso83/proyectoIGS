package logical;

public class Federation {
  private SportMan[] athletes;
  public static int cantAthletes;
  private static int autoGenerateCode;

  
  public Federation() {
	super();
	athletes = new SportMan[50];
	cantAthletes = 0;
	autoGenerateCode=0;
}


public SportMan[] getAthletes() {
	return athletes;
}


public void setAthletes(SportMan[] athletes) {
	this.athletes = athletes;
}


public static int getCantAthletes() {
	return cantAthletes;
}


public static void setCantAthletes(int cantAthletes) {
	Federation.cantAthletes = cantAthletes;
}
  
  public void insertSpotMan(SportMan spotMan){
	  autoGenerateCode++;
	  spotMan.setCode(autoGenerateCode);
	  athletes[cantAthletes] = spotMan;
	  cantAthletes++;
  }


public void deleteSportMan(int code) {
	SportMan aux[] = new SportMan[50];
	int pos = 0;
	
	for (int i = 0; i < cantAthletes; i++) {
		if(athletes[i].getCode()!=code){
			aux[pos]=athletes[i];
			pos++;
		}
	}
	athletes=aux;
	cantAthletes--;
	
}
  
  
}
