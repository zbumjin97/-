

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class NameSave {
	
	
	public NameSave(String Name, int Time) throws IOException,Exception{

		File f= new File("Clear.txt");
		
		if(f.exists()){
			

			String [] Rankname=new String[8];
			int [] Ranktime	= new int[8];
			
			Scanner input = new Scanner(f);
			int a=0;
			
			while(input.hasNext()) {
				
				String setname = input.next();
				int setsecond = input.nextInt();
				
				Rankname[a]= setname;
				Ranktime[a]	= setsecond;
				a++;
				
			}
			input.close();

			
			f.delete();

			Rankname[7]=Name;
			Ranktime[7]=Time;
			
			for(int i = 0; i<8;i++) {
					for(int j=i+1;j<8;j++) {
						if (Ranktime[i]>Ranktime[j]) {
						String name1 = Rankname[i];
						int Second1 = Ranktime[i];
						Rankname[i]=Rankname[j];
						Ranktime[i] =Ranktime[j];
						Rankname[j] = name1;
						Ranktime[j] = Second1;		
						}
					}
				}
				
			
			
			Rankname[7]="XXX";
			Ranktime[7]=99999;
			
		
			
			PrintWriter output = new PrintWriter(f)	;

			for(int i=0; i<8;i++) {
				output.println(Rankname[i]+"    "+Ranktime[i]);
			}
			output.close();
		}
		
		else
		{
			PrintWriter output = new PrintWriter(f)	;
		
			String [] Rankname=new String[8];
			int [] Ranktime	= new int[8];
			
		Rankname[0]=Name; Ranktime[0]=Time;
		
		for(int i=1;i<8;i++) {
			Rankname[i]="XXX";
			Ranktime[i]=99999;
		}
		for(int i =0;i<8;i++) {
		output.println(Rankname[i]+"    "+Ranktime[i]);
		}
		
		output.close();
		}
	}
	
}

