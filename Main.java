import java.util.Scanner;
import java.util.ArrayList;
public class Main {
	static ArrayList<Beer> beers = new ArrayList<Beer>();
	protected static void add(String[] cmd)
	{
		Beer uj = new Beer (cmd[1], cmd[2], Double.parseDouble(cmd[3]));
		beers.add(uj);
	}
	
	protected static void list()
	{
		for(Beer sorok : beers)
		{
			System.out.println(sorok);
		}
	}
	public static void main(String[] args) {
		

		Scanner scanner = new Scanner(System.in);
		Beer A = new Beer("Kozel", "vilagos", 4);
		Beer B = new Beer("Borsodi", "barna", 4.3);
		System.out.println(A.toString());
		System.out.println(B.toString());
		while(1==1)
		{
			String beolvas = scanner.nextLine();
			String cmd[] = beolvas.split(" ");
			System.out.println(cmd[0]+ " a tomb elso eleme es " +cmd.length + " elemu a tomb");
			if(cmd[0].equals("add"))
			{
				add(cmd);
			}
			else if (cmd[0].equals("list"))
			{
				list();
			}
			else if ( cmd[0].equals("exit"))
			{
				System.exit(1);
			}
		}
		
	}

}
