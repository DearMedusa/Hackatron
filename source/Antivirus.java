package source;
public class Antivirus extends ClasseAbstraite{

  /**
  * Certains serveurs ont un antivirus, cette classe gere leur fonctionnement
  */

  /**
  *@param name String, le nom de l'objet
  *@param niveau int, le niveau de l'objet
  *@param Active boolean, si l'objet est actif ou non
  */

  private String name;
  private int niveau;
  private boolean Active;

  /**
  *Constructeur d'un antivirus
  *@param S String, le nom de l'instance
  *@param lvl int le niveau de l'instance
  */

  public Antivirus(String S, int lvl){
    this.name = S;
    this.niveau = lvl;
    this.Active = true;
  }
  /**
  *Setter qui désactive l'attribut Active
  */

  public void disable()
  {
    this.Active = false;
  }

  /**
  *Getters & Setters
  */

  public String getName()
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
}
