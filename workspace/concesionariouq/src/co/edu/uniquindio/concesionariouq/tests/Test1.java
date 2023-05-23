package co.edu.uniquindio.concesionariouq.tests;

import org.junit.Before;
import org.junit.Test;

import co.edu.uniquindio.concesionariouq.exceptions.NullException;
import co.edu.uniquindio.concesionariouq.exceptions.VehiculoYaExisteException;
import co.edu.uniquindio.concesionariouq.model.Concesionario;
import co.edu.uniquindio.concesionariouq.model.Deportivo;
import co.edu.uniquindio.concesionariouq.model.Diesel;
import co.edu.uniquindio.concesionariouq.model.EstadoVehiculo;
import co.edu.uniquindio.concesionariouq.model.Gasolina;
import co.edu.uniquindio.concesionariouq.model.Moto;
import co.edu.uniquindio.concesionariouq.model.TipoCambio;
import co.edu.uniquindio.concesionariouq.util.Utility;

public class Test1 {
	Concesionario concesionario = new Concesionario("Nombre", "id");

	@Before
	public void test() throws NullException, VehiculoYaExisteException {
		concesionario.agregarVehiculo("AAAA", new Moto("AAAA", "mazda", "2020", 200d, 200d, new Gasolina(),
				EstadoVehiculo.NUEVO, TipoCambio.AUTOMATICO));
		concesionario.agregarVehiculo("XG", new Deportivo("XG", "mazda", "2020", 200d, 200d, new Gasolina(),
				EstadoVehiculo.NUEVO, TipoCambio.MANUAL, 5, 2, 3, 40, 4d));
		concesionario.agregarVehiculo("ASAAS", new Moto("ASAAS", "mazda", "2020", 200d, 200d, new Gasolina(),
				EstadoVehiculo.NUEVO, TipoCambio.AUTOMATICO));
		concesionario.agregarVehiculo("AAAZ", new Moto("AAAZ", "mazda", "2020", 200d, 200d, new Diesel(),
				EstadoVehiculo.NUEVO, TipoCambio.AUTOMATICO));
		concesionario.agregarVehiculo("AAAV", new Moto("AAAV", "mazda", "2020", 200d, 200d, new Diesel(),
				EstadoVehiculo.NUEVO, TipoCambio.AUTOMATICO));
		System.out.println(concesionario.listarVehiculos());
	}

	@Test
	public void testCodigoRandom() {
		for (int i = 0; i < 100; i++)
			System.out.println(Utility.crearCodigoRandomAlfaNumerico(6));
	}

}
