package tallerpruebas;
import junit.framework.TestCase;
import static org.junit.Assert.assertEquals;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

import org.junit.Test;
import org.junit.Before;
import org.junit.AssumeTrue;
import org.junit.AssumeFalse;

public class EmployeeTest extends TestCase {
	Date date = new Date();
	public LocalDate localDate = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
	public int month = localDate.getMonthValue();
	
	private Employee workerUSD;
	private Employee workerOtherCurrency;
	private Employee  supervisorUSD;
	private Employee  managerUSD;
	private Employee  managerOtherCurrency;
	
	@Before
    public void antesdeTest() {
		workerUSD = new Employee(1200, "USD", 0, EmployeeType.Worker);
		workerOtherCurrency = new Employee(1200, "Libras", 0, EmployeeType.Worker);
        supervisorUSD = new Employee(1500, "USD", 10, EmployeeType.Supervisor);
        managerUSD = new Employee(2000, "USD", 0.20F, EmployeeType.Manager);
        managerOtherCurrency = new Employee(2000, "EUR", 0.20F, EmployeeType.Manager);
    }
	@Test
	public void testCsWorkerUSDPar() {
		Assume.assumeTrue(month%2==0);
		float expected = 1200;
		assertEquals(expected, workerUSD.cs(), 0.01);
	}
	@Test
	public void testCsWorkerUSDImpar() {
		Assume.assumeFalse(month%2==0);
		float expected = 1200 + 386/12*2;
		assertEquals(expected, workerUSD.cs(), 0.01);
	}
	//------------
	@Test
    public void testCsManagerUSDPar() {
		Assume.assumeTrue(month%2==0);
        float expected = 2000 + (0.20F * 0.7F);
        assertEquals(expected, managerUSD.cs(), 0.01);
    }
	public void testCsManagerUSDImpar() {
		Assume.assumeFalse(month%2==0);
        float expected = (2000 + (0.20F * 0.7F)) + 386/12*2;
        assertEquals(expected, managerUSD.cs(), 0.01);
    }
	@Test
    public void testCsManagerOtherCurrencyPar() {
		Assume.assumeTrue(month%2==0);
        float expected = (2000 * 0.95F) + (0.20F * 0.7F);
        assertEquals(expected, managerOtherCurrency.cs(), 0.01);
    }
	@Test
    public void testCsManagerOtherCurrencyImpar() {
		Assume.assumeFalse(month%2==0);
        float expected = ((2000 * 0.95F) + (0.20F * 0.7F)) + 386/12*2;
        assertEquals(expected, managerOtherCurrency.cs(), 0.01);
    }
	//----------------
	@Test
    public void testCsWorkerOtherCurrencyPar() {
		Assume.assumeTrue(month%2==0);
        float expected = (float) (1200 * 0.95);
        assertEquals(expected, managerOtherCurrency.cs(), 0.01);
    }
	@Test
    public void testCsWorkerOtherCurrencyImpar() {
		Assume.assumeFalse(month%2==0);
        float expected = (float) ((1200 * 0.95) + 386/12*2);
        assertEquals(expected, managerOtherCurrency.cs(), 0.01);
    }
	
}
