public class Antivirus {
  /*
  * Description de la classe
  */

  private String name;
  private int niveau;
  private static boolean Active;


  public Antivirus(String S, int lvl){
    this.name = S;
    this.niveau = lvl;
    Active = true;
  }

  public String getname()
  {
    return this.name;
  }

  public int getlvl()
  {
    return this.niveau;
  }

  public boolean getStatut()
  {
    return this.Active;
  }

  public void killAvast()
  {
    this.Active = false;
  }

}
