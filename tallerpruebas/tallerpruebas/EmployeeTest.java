package tallerpruebas;
import junit.framework.TestCase;
import static org.junit.Assert.assertEquals;
import org.junit.Test;
import org.junit.Before;

public class EmployeeTest extends TestCase {
	private Employee workerUSD;
	private Employee  supervisorUSD;
	private Employee  managerOtherCurrency;
	
	@Before
    public void antesdeTest() {
		workerUSD = new Employee(1200, "USD", 0, EmployeeType.Worker);
        supervisorUSD = new Employee(1500, "USD", 10, EmployeeType.Supervisor);
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
	
}
