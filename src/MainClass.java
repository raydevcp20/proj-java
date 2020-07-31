import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;

public class MainClass {

	public static void main(String[] args) throws ParseException {
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		System.out.println("Digite o numero do quarto: ");
		int num = sc.nextInt();
		System.out.println("entre com a data de CheckIn(DD/MM/YYYY): ");
		Date ci = sdf.parse(sc.next());
		System.out.println("entre com a data de CheckOut(DD/MM/YYYY): ");
		Date co = sdf.parse(sc.next());
		
		if (!co.after(ci)) {
			System.out.println("Error na data de checkin e checkout");
		}else {
			Reserva rs = new Reserva(num, ci, co);
			System.out.println("Reserva: "+ rs);
			
			System.out.println("Entre com os novos dados:");
			System.out.println("entre com a data de CheckIn(DD/MM/YYYY): ");
			ci = sdf.parse(sc.next());
			System.out.println("entre com a data de CheckOut(DD/MM/YYYY): ");
			co = sdf.parse(sc.next());
			
			Date agora = new Date();
					
			if(co.before(agora) || ci.before(agora)) {
				System.out.println("ERROR: a data de check in ou a de check out � antiga");
			}if (!co.after(ci)) {
				System.out.println("Error na data de checkout");
			}else {
			rs.atualizarDias(ci, co);
			System.out.println("Reserva: "+ rs);}
		}
		
		
	}

}
