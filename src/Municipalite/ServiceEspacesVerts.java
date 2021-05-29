package Municipalite;
import java.awt.Point;
import java.util.ArrayList;
import java.util.Date;

import Asso.Notifiable;
import Asso.Notification;
import Asso.NotificationArbre;
import Municipalite.Mairie;

public class ServiceEspacesVerts {
	
	private ArrayList<Notifiable> notifiables; 
	private Mairie Mairie;
	
	public ServiceEspacesVerts(Mairie Mairie) {
		this.Mairie = Mairie;
		notifiables = new ArrayList<Notifiable>();
	}
	
	
	/**
	 * M�thode permettant la classification d'un arbre
	 * @param arbre un arbre
	 * @param remarquable vaut true si l'arbre est remarquable, false sinon
	 */
	public void classifier(Arbre arbre) {
		
		arbre.classifier(new Date());
		
		Notification notification = new NotificationArbre("classification",arbre);
		
		for(Notifiable i :notifiables) {
			i.notifier(notification);
		}
	}
	
	/**
	 * M�thode permettant de planter un arbre � un endroit donn�
	 * @param arbre l'arbre � plant�
	 * @param GPS les futures coordonn�es GPS l'arbre
	 * @param Adresse la future adresse de l'arbre
	 */
	public void Planter(Arbre arbre,Float[] GPS, String adresse) {
		arbre.setAdresse(adresse);
		arbre.setGPS(GPS);
		
		Notification notification = new NotificationArbre("plantation",arbre);
		
		for(Notifiable i :notifiables) {
			i.notifier(notification);
		}
	}
	
	/**
	 * M�thode permettant l'abattage d'un arbre
	 * @param arbre l'arbre � abattre
	 */
	public void Abattre(Arbre arbre) {
	
		Notification notification = new NotificationArbre("Abattage",arbre);
		
		for(Notifiable i :notifiables) {
			i.notifier(notification);
		}
		Mairie.getListArbre().remove(arbre);
		arbre=null;
	}
	
	public void ajoutNotifiable(Notifiable n) {
		notifiables.add(n);
	}
	public static void main(String[] args) {
	

	}

}
