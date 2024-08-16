package tallerpruebas;
import static org.junit.Assert.assertEquals;
import org.junit.Test;
import org.junit.BeforeClass;


public class EmployeeTest {
	private Employee workerUSD;
	private Employee  supervisorUSD;
	private Employee  managerOtherCurrency;
	
	@BeforeClass
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
	
}
