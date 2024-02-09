package entities;

public class TaxPayer {

	private Double salaryIncome;
	private Double servicesIncome;
	private Double capitalIncome;
	private Double healthSpending;
	private Double educationSpending;

	public TaxPayer(Double salaryIncome, Double servicesIncome, Double capitalIncome, Double healthSpending,
			Double educationSpending) {
		this.salaryIncome = salaryIncome;
		this.servicesIncome = servicesIncome;
		this.capitalIncome = capitalIncome;
		this.healthSpending = healthSpending;
		this.educationSpending = educationSpending;
	}

	public Double getSalaryIncome() {
		return salaryIncome;
	}

	public Double getServicesIncome() {
		return servicesIncome;
	}

	public Double getCapitalIncome() {
		return capitalIncome;
	}

	public Double getHealthSpending() {
		return healthSpending;
	}

	public Double getEducationSpending() {
		return educationSpending;
	}

	public Double salaryTax() {
		Double salary = salaryIncome / 12;
		if (salary < 3000) {
			return 0.0;
		} else if (salary < 5000) {
			return salaryIncome * 0.1;
		} else {
			return salaryIncome * 0.2;
		}
	}

	public Double servicesTax() {
		return servicesIncome * 0.15;
	}

	public Double capitalTax() {
		return capitalIncome * 0.2;
	}

	public Double grossTax() {
		return salaryTax() + servicesTax() + capitalTax();
	}

	public Double taxRebate() {
		double maxDed = grossTax() * 30 / 100;
		double minDed = healthSpending + educationSpending;

		if (minDed < maxDed) {
			return minDed;
		} else {
			return maxDed;
		}
	}

	public Double netTax() {
		return grossTax() - taxRebate();
	}

	@Override
	public String toString() {
		return "Imposto bruto total: " 
				+ String.format("%.2f%n", grossTax())
				+ "Abatimento: " + String.format("%.2f%n", taxRebate())
				+ "Imposto devido: " + String.format("%.2f%n", netTax());
	}
}