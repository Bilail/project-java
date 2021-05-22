package Asso;
import java.util.ArrayList;

public class Budget {
	
	private float somme;
	private ArrayList<ExerciceBudgetaire> listExercicesBudgetaires;
	
	/**
	 * Constructeur de Budget avec un montant initial
	 * @param le montant initial du budget
	 */
	public Budget() {
		listExercicesBudgetaires= new ArrayList<ExerciceBudgetaire>();
		somme=0;
		//EBactuel=new ExerciceBudgetaire(this);
	}
	
	
	/**
	 * Methode d'acc�s au montant actuel du Budget
	 * @return le montant actuel du Budget
	 */
	public float getSomme() {
		return somme;
	}
	
	/**
	 * M�thode d'acc�s aux exercices budg�taires pr�c�dents
	 * @return la liste des exercices budg�taires pr�c�dents
	 */
	public ArrayList<ExerciceBudgetaire> getExercicesBudgetaires(){
		return listExercicesBudgetaires;
	}
	
	/**
	 * Methode d'acc�s � l'exercice budg�taire actuel
	 * @return l'exercice budg�taire en cours
	 */
	public ExerciceBudgetaire getEBActuel() {
		return listExercicesBudgetaires.get(listExercicesBudgetaires.size());
	}
	
	/**
	 * Methode de mise � jour du Budget et qui fait appel � la sauvegarde de 
	 * la transaction dans l'exercice budg�taire actuel
	 * @param transaction la transaction effectue�
	 */
	void CalculBudget(Transaction transaction) {
		
		somme=somme+transaction.getMontant();
		//getEBActuel().SauvegarderTransaction(transaction, this);
	}
	
	void changementAnnee() {
		listExercicesBudgetaires.add(new ExerciceBudgetaire(this));
	}
}
