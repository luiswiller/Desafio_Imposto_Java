import java.util.Locale;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);

		System.out.print("Renda anual: ");
		double salarioAnual = sc.nextDouble();
		System.out.print("Prestacao de Servico: ");
		double rendaServico = sc.nextDouble();
		System.out.print("Renda Capital: ");
		double rendaCapital = sc.nextDouble();
		System.out.print("Gastos Medicos: ");
		double gastosMed = sc.nextDouble();
		System.out.print("Gastos Educacionais: ");
		double gastosEdu = sc.nextDouble();

		double salarioMensal = salarioAnual / 12;
		double impostoSalario = 0;
		double impostoServico = 0;
		double impostoCapital = 0;

		
		if(salarioMensal < 3000.00) {
			impostoSalario = 0;
		}
		else if (salarioMensal >= 3000.00 && salarioMensal < 5000.00) {
			impostoSalario = salarioAnual * 0.10;
		} else {
			impostoSalario = salarioAnual * 0.20;

		}

		if (rendaServico > 0) {
			impostoServico = rendaServico * 0.15;
		}

		if (rendaCapital > 0) {
			impostoCapital = rendaCapital * 0.20;
		}

		
		double impostoTotal = impostoSalario + impostoServico + impostoCapital;		
		double maxDedutivel = impostoTotal * 0.3;
		double gastoDedutivel = gastosMed + gastosEdu;
		double abatimento = 0;
		double impostoDevido = 0;
		
		if(gastoDedutivel <= maxDedutivel) {
			abatimento = gastoDedutivel;
			impostoDevido = impostoTotal - abatimento;
		} else {
			abatimento = maxDedutivel;
			impostoDevido = impostoTotal - abatimento;
		}

		System.out.printf("\nRELATÓRIO DE IMPOSTO DE RENDA");
		System.out.printf("\nCONSOLIDADO DE RENDA:\n");
		if (salarioMensal < 3000.00) {
			System.out.println("Imposto sobre salário Isento");
		} else {
			System.out.printf("Imposto sobre Salário: R$ %.2f\n", impostoSalario);
		}
		System.out.printf("Imposto sobre Serviços: R$ %.2f\n", impostoServico);
		System.out.printf("Imposto sobre Capital: R$ %.2f\n", impostoCapital);
		System.out.printf("\nDEDUÇÕES:\n");
		System.out.printf("Máximo dedutível: %.2f\n", maxDedutivel);
		System.out.printf("Gastos Dedutíveis: %.2f\n", gastoDedutivel);
		System.out.printf("\nRESUMO:\n");
		System.out.printf("Imposto bruto Total: %.2f\n", impostoTotal);
		System.out.printf("Abatimento: %.2f\n", abatimento);
		System.out.printf("Imposto devido: %.2f", impostoDevido);

		sc.close();

	}

}
