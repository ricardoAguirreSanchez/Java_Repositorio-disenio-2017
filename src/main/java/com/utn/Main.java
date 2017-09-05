package com.utn;


public class Main {

	public static void main(String[] args) {
		
		/*//TEST DE LONGEVIDAD
		MetodologiaDAO metodologiaDAO = new MetodologiaDAO();
		MetodologiaServiceImplementation msi = new MetodologiaServiceImplementation(metodologiaDAO);
		
		ArrayList<String> listaCondiciones = new ArrayList<>();
		listaCondiciones.add("Longevidad");
		
		Metodologia metodologia = new Metodologia();
		metodologia.setCondiciones(listaCondiciones);
		
		HashMap<String,Empresa> hash = msi.realizaComparacion(metodologia);
		System.out.println("La empresa ganadora de Longevidad es: "+ hash.get("Longevidad").getNombre() );
		//----------------------------------
		
		//TEST DE Maximizar ROE
		MetodologiaDAO metodologiaDAO1 = new MetodologiaDAO();
		MetodologiaServiceImplementation msi1 = new MetodologiaServiceImplementation(metodologiaDAO1);
		
		ArrayList<String> listaCondiciones1 = new ArrayList<>();
		listaCondiciones1.add("Maximizar ROE");
		
		Metodologia metodologia1 = new Metodologia();
		metodologia1.setCondiciones(listaCondiciones1);
		
		HashMap<String,Empresa> hash1 = msi1.realizaComparacion(metodologia1);
		System.out.println("La empresa ganadora de Maximizar ROE es: "+ hash1.get("Maximizar ROE").getNombre() );
		//----------------------------------
		
		//TEST DE Margenes de ganancia
		MetodologiaDAO metodologiaDAO2 = new MetodologiaDAO();
		MetodologiaServiceImplementation msi2 = new MetodologiaServiceImplementation(metodologiaDAO2);
		
		ArrayList<String> listaCondiciones2 = new ArrayList<>();
		listaCondiciones2.add("Margenes de ganancia");
		
		Metodologia metodologia2 = new Metodologia();
		metodologia2.setCondiciones(listaCondiciones2);
		
		HashMap<String,Empresa> hash2 = msi2.realizaComparacion(metodologia2);
		System.out.println("La empresa ganadora de Margenes de ganancia es: "+ hash2.get("Margenes de ganancia").getNombre() );
		//----------------------------------
		
		
		//TEST DE "Minimizar deuda"
		MetodologiaDAO metodologiaDAO3 = new MetodologiaDAO();
		MetodologiaServiceImplementation msi3 = new MetodologiaServiceImplementation(metodologiaDAO3);
		
		ArrayList<String> listaCondiciones3 = new ArrayList<>();
		listaCondiciones3.add("Minimizar deuda");
		
		Metodologia metodologia3 = new Metodologia();
		metodologia3.setCondiciones(listaCondiciones3);
		
		HashMap<String,Empresa> hash3 = msi3.realizaComparacion(metodologia3);
		System.out.println("La empresa ganadora de Minimizar deuda es: "+ hash3.get("Minimizar deuda").getNombre() );
		//----------------------------------
		
		
		//PARA CARGAR/CREAR LAS METODOLOGIAS USANDO REGLAS EXISTENTES EN LA BASE
		
		//pido todas las reglas
		CatalogoReglasDAO catalogoDAO = new CatalogoReglasDAO();
		CatalogoReglasImplementation catalogoReglas = new CatalogoReglasImplementation(catalogoDAO);
		catalogoReglas.getReglas();
		
		//muesto al usuario esta lista de reglas y dejo elegir las q quiera y un nombre para la metodologia
		//cargo las reglas y el nombre de la metodologia en un objeto METODOLOGIA
		//guardo la metodologia
		Metodologia metodologiaNueva = new Metodologia();
		metodologiaNueva.setNombre("nombre que quiero");
		
		ArrayList<String > listaCondicionesNuevas = new ArrayList<>();
		listaCondicionesNuevas.add("Maximizar ROE");
		listaCondicionesNuevas.add("Maxima cantidad cuentas");
		metodologiaNueva.setCondiciones(listaCondiciones3);
		//guardo la metodologia
		msi3.setMetodologia(metodologiaNueva);
		
		//muestro todas la metodologias del sistema
		msi3.getMetodologias();
		System.out.println(msi3.getMetodologias()); */
	}

}
