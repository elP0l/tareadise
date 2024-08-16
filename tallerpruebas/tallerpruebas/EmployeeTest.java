package tallerpruebas;
import static org.junit.Assert.assertEquals;
import org.junit.Test;
import org.junit.Before;

public class EmployeeTest  {
	private Employee workerUSD;
	private Employee  supervisorUSD;
	private Employee  managerOtherCurrency;
	private Employee supervisoOtherCurrency;
	private Employee managerUSD;
	
	@Before
    public void antesdeTest() {
		workerUSD = new Employee(1200, "USD", 0, EmployeeType.Worker);
        supervisorUSD = new Employee(1500, "USD", 10, EmployeeType.Supervisor);
        supervisoOtherCurrency = new Employee(1500, "Bolivar", 10, EmployeeType.Supervisor);
        managerUSD=new Employee(2000, "USD", 20, EmployeeType.Manager);
        managerOtherCurrency = new Employee(2000, "EUR", 20, EmployeeType.Manager);
    }
	@Test
	public void testCsWorkerUSDImpar() {
		float expected = 1200 + 386/12*2;
		assertEquals(expected, workerUSD.cs(), 0.01);
	}
	@Test
	public void testCsWorkerUSDPar() {
		float expected = 1200;
		assertEquals(expected, workerUSD.cs(), 0.01);
	}
	@Test
    public void testCsWorkerOtherCurrencyPar() {
        float expected = (float) (1200 * 0.95);
        assertEquals(expected, managerOtherCurrency.cs(), 0.01);
    }
	@Test
    public void testCsWorkerOtherCurrencyImpar() {
        float expected = (float) ((1200 * 0.95) + 386/12*2);
        assertEquals(expected, managerOtherCurrency.cs(), 0.01);
    }
	@Test
	public void testCsSupervisorUSDPar() {
		float expected = 1500 + 10 * 0.35F;
		assertEquals(expected, supervisorUSD.cs(), 0.01);
	    }
	@Test
    public void testCsSupervisorUSDImpar() {
        float expected = 1500 + 10 * 0.35F + 386 / 12 * 2;
        assertEquals(expected, supervisorUSD.cs(), 0.01);
    }
	@Test
    public void testCsSupervisorOtherCurrencyImpar() {
        float salarioAjustado = 1500 * 0.95F; 
        float expected = salarioAjustado + 10 * 0.35F + 386 / 12 * 2;
        assertEquals(expected, supervisoOtherCurrency.cs(), 0.01);
    }

    @Test
    public void testCsSupervisorOtherCurrencyPar() {
        float salarioAjustado = 1500 * 0.95F; // 
        float expected = salarioAjustado + 10 * 0.35F;
        assertEquals(expected, supervisoOtherCurrency.cs(), 0.01);
    }
}
	
	
	

