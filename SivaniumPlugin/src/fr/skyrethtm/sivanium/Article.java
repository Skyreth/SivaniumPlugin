package fr.skyrethtm.sivanium;

public class Article 
{
	private int id;
	private short meta;
	private double achat, vente;
	private String article;
	
	public Article(double prixachat, double prixvente, String Nom, int ID, short meta)
	{
		achat = prixachat;
		vente = prixvente;
		id = ID;
		article = Nom;
	}
	
	public double getBuyPrice()
	{
		return achat;
	}
	
	public double getSellPrice()
	{
		return vente;
	}
	
	public int getId()
	{
		return id;
	}
	
	public int getMeta()
	{
		return meta; 
	}
	
	public String getArticleName()
	{
		return article;
	}
}
