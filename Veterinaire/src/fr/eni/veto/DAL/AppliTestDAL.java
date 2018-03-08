package fr.eni.veto.DAL;

import fr.eni.veto.BO.Animaux;

public class AppliTestDAL {
	
	public static void main(String[] args) {
		
		AnimauxDAOImpl co = new AnimauxDAOImpl();
		Animaux a = new Animaux("Petit Tonnerre", "M", "Brin", "Pur Sang Arabe", "Cheval", 7, "65-THE-8", "Il est con", false);
		try {
			co.insertAnimal(a);
			System.out.println(co.selectByCodeClient(7).toString());
			a.setNomAnimal("Kebab");
			co.updateAnimal(a);
			System.out.println(co.selectByCodeClient(7).toString());
			co.deleteAnimal(a.getCodeAnimal());
			System.out.println(co.selectByCodeClient(7));
		} catch (DALException e) {
			e.printStackTrace();
		}
		System.out.println("DONE");
	}
}
