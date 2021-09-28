import java.util.Scanner;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Collections;
public class Main {
	static ArrayList<Beer> beers = new ArrayList<Beer>();
	protected static void add(String[] cmd)
	{
		Beer uj = new Beer (cmd[1], cmd[2], Double.parseDouble(cmd[3]));
		beers.add(uj);
	}
	
	protected static void list(String[] cmd)
	{
		
		Comparator<Beer> cmp = null;
		switch(cmd[1])
		{
		case "name":
			cmp = new NameComparator();
			break;
		case "style":
			cmp = new StyleComparator();
			break;
		case "strength":
			cmp = new StrengthComparator();
			break;
		}
		Collections.sort(beers, cmp);
		
		for(Beer sorok : beers)
		{
			System.out.println(sorok);
			
		}
	}
	
	protected static void save() throws IOException, ClassNotFoundException
	{
		FileOutputStream fileout = new FileOutputStream("BeersInfo.ser");
		ObjectOutputStream out = new ObjectOutputStream(fileout);
		out.writeObject(beers);
		out.close();
		fileout.close();

	}
	
	protected static void load() throws IOException, ClassNotFoundException
	{
		ArrayList<Beer> beers = null;
		FileInputStream fileIn = 	new FileInputStream("C:\\Users\\rusva\\workspace\\4.labor\\BeersInfo.ser");
		ObjectInputStream in = new ObjectInputStream(fileIn);
		beers = (ArrayList<Beer>) in.readObject();
		in.close();
		fileIn.close();
	}
	protected static void  search(String name)
	{
		for(Beer sorok : beers)
		{
			if(sorok.getName().matches(name))
			{
				System.out.println(sorok);
			}
			
			
		} 
	}
	protected static void find(String smth)
	{
		for(Beer sorok : beers)
		{
			if(sorok.getName().contains(smth));
			{
				System.out.println(sorok);
			}
		}
	}
	/*protected static void delete(String name)
	{
		for(Beer sorok : beers)
		{
			if(sorok.getName().matches(name))
			{
				
				System.out.println("Az elem torolve");
			}
		}
	}*/
	public static void main(String[] args) throws ClassNotFoundException, IOException {
		

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
				list(cmd);
			}
			else if(cmd[0].equals("save"))
			{
				save();
			}
			else if(cmd[0].equals("load"))
			{
				load();
			}
			else if(cmd[0].equals("search"))
			{
				search(cmd[1]);
			}
			else if(cmd[0].equals("find"))
			{
				find(cmd[1]);
			}
			else if ( cmd[0].equals("exit"))
			{
				System.exit(1);
			}
		}
		
	}

}
