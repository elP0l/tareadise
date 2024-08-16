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
        supervisorUSD = new Employee(1500, "USD", 0.10F, EmployeeType.Supervisor);
        supervisoOtherCurrency = new Employee(1500, "Bolivar", 0.10F, EmployeeType.Supervisor);
        managerUSD=new Employee(2000, "USD", 0.20F, EmployeeType.Manager);
        managerOtherCurrency = new Employee(2000, "EUR",0.20F, EmployeeType.Manager);
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
	    float salarioAjustado = 1500; 
	    float bono = 10 * 0.35F; 
	    float expected = salarioAjustado + bono; 
	    assertEquals(expected, supervisorUSD.cs(), 0.01);
	}
	@Test
	public void testCsSupervisorUSDImpar() {
	    float salarioAjustado = 1500; 
	    float bono = 10 * 0.35F; 
	    float rmuPorMes = 386.0F / 12 * 2; 
	    float expected = salarioAjustado + bono + rmuPorMes;
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
    @Test
    public void testCalculateYearBonusWorkerUSD() {
        float expected = 386.0F;
        assertEquals(expected, workerUSD.CalculateYearBonus(), 0.01);
    }
    @Test
    public void testCalculateYearBonusSupervisorUSD() {
        float expected = 1500 + 386.0F * 0.5F;
        assertEquals(expected, supervisorUSD.CalculateYearBonus(), 0.01);
    }

    @Test
    public void testCalculateYearBonusManagerUSD() {
        float expected = 2000 + 386.0F * 1.0F; 
        assertEquals(expected, managerUSD.CalculateYearBonus(), 0.01);
    }
    @Test
    public void testCalculateYearBonusWorkerOtherCurrency() {
        float expected = 386.0F * 0.95F;
        assertEquals(expected, supervisoOtherCurrency.CalculateYearBonus(), 0.01);
    }
    @Test
    public void testCalculateYearBonusSupervisorOtherCurrency() {
        float salarioAjustado = 1500 * 0.95F;
        float expected = salarioAjustado + 386.0F * 0.5F; 
        assertEquals(expected, supervisoOtherCurrency.CalculateYearBonus(), 0.01);
    }
    @Test
    public void testCalculateYearBonusManagerOtherCurrency() {
        float salarioAjustado = 2000 * 0.95F;
        float expected = salarioAjustado + 386.0F * 1.0F; 
        assertEquals(expected, managerOtherCurrency.CalculateYearBonus(), 0.01);
    }
}

	
	
	

