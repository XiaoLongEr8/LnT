package mainPackages;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Database_Controller extends Input_Scanner{

//	public static void main(String[] args) throws IOException {
//		
//		Show_and_get_Database();
//		
//	}
	
	public static void Show_and_get_Database() throws IOException{
		
		FileReader fin = new FileReader("Database.txt");
		BufferedReader bin = new BufferedReader(fin);
		bin.mark(5000000);
		bin.reset();
		
		ArrayList<String> No = new ArrayList<String>();
		ArrayList<String> Kode = new ArrayList<String>();
		ArrayList<String> Nama = new ArrayList<String>();
		ArrayList<String> JenisKelamin = new ArrayList<String>();
		ArrayList<String> Jabatan = new ArrayList<String>();
		ArrayList<Integer> Gaji = new ArrayList<Integer>();
		ArrayList<Integer> Rank = new ArrayList<Integer>();
		
		scan = new Scanner(bin);
		scan.nextLine();
		scan.useDelimiter("#");
		int i=0;
		int j=1;
		int flag=0;
		while(scan.hasNext()) {
			if(i==0) {
				flag=1;
				if(j==1) {
					j++;
					No.add(scan.next());
					//System.out.println("No \t\t: "+No.get(i));
				}
				else if(j==2) {
					j++;
					Kode.add(scan.next());
					//System.out.println("Kode \t\t: "+Kode.get(i));
				}
				else if(j==3){
					j++;
					Nama.add(scan.next());
					//System.out.println("Nama \t\t: "+Nama.get(i));
				}
				else if(j==4) {
					j++;
					JenisKelamin.add(scan.next());
					//System.out.println("JenisKelamin \t: "+JenisKelamin.get(i));
				}
				else if(j==5) {
					j++;
					Jabatan.add(scan.next());
					//System.out.println("Jabatan \t: "+Jabatan.get(i));
				}
				else if(j==6) {
					j++;
					Gaji.add(Integer.parseInt(scan.next()));
					//System.out.println("Gaji \t\t: "+Gaji.get(i));
				}
				else if(j==7) {
					j=1;
					Rank.add(Integer.parseInt(scan.next()));
					//System.out.println("Gaji \t\t: "+Gaji.get(i));
					i++;
				}
			}
			else {
				if(j==1) {
					j++;
					String temp=scan.next();
					No.add(temp.substring(1));
					//System.out.println("No \t\t: "+No.get(i));
				}
				else if(j==2) {
					j++;
					Kode.add(scan.next());
					//System.out.println("Kode \t\t: "+Kode.get(i));
				}
				else if(j==3){
					j++;
					Nama.add(scan.next());
					//System.out.println("Nama \t\t: "+Nama.get(i));
				}
				else if(j==4) {
					j++;
					JenisKelamin.add(scan.next());
					//System.out.println("JenisKelamin \t: "+JenisKelamin.get(i));
				}
				else if(j==5) {
					j++;
					Jabatan.add(scan.next());
					//System.out.println("Jabatan \t: "+Jabatan.get(i));
				}
				else if(j==6) {
					j++;
					Gaji.add(Integer.parseInt(scan.next()));
					//System.out.println("Gaji \t\t: "+Gaji.get(i));
				}
				else if(j==7) {
					j=1;
					Rank.add(Integer.parseInt(scan.next()));
					//System.out.println("Gaji \t\t: "+Gaji.get(i));
					i++;
				}
			}
		}
		bin.close();
		fin.close();
		int n=Nama.size();
		//System.out.println("n ==>"+n);
		
		if(n>1) {
			for(i=0;i<n;i++) {
				for(j=0;j<n-i-1;j++) {
					if(Nama.get(j).compareToIgnoreCase(Nama.get(j+1))>0) {
						
						String temp = "";
						
						temp = Nama.get(j);
						Nama.set(j, Nama.get(j+1));
						Nama.set(j+1, temp);
						//System.out.println("Temp = "+ temp);
						
						temp = Kode.get(j);
						Kode.set(j, Kode.get(j+1));
						Kode.set(j+1, temp);
						
						temp = No.get(j);
						No.set(j, No.get(j+1));
						No.set(j+1, temp);
						
						temp = JenisKelamin.get(j);
						JenisKelamin.set(j, JenisKelamin.get(j+1));
						JenisKelamin.set(j+1, temp);
						
						temp = Jabatan.get(j);
						Jabatan.set(j, Jabatan.get(j+1));
						Jabatan.set(j+1, temp);
						
						int tempInt;
						tempInt = Gaji.get(j);
						Gaji.set(j, Gaji.get(j+1));
						Gaji.set(j+1, tempInt);
						
						tempInt = Rank.get(j);
						Rank.set(j, Rank.get(j+1));
						Rank.set(j+1, tempInt);
					}
				}
			}
		}
		
		
		if(flag==0) {
			System.out.println("\n\nData Karyawan");
			System.out.println("=======");
			System.out.println("No people registered yet");
		}
		else {
			System.out.println("\n\nDatabase");
			System.out.println("=======");
			System.out.println("No|Kode    |Nama Karyawan             |Jenis Kelamin |Jabatan        |Gaji       |");
			System.out.println("==================================================================================");
			for(i=0;i<n;i++) {
				System.out.printf("%-2s|%-8s|%-26s|%-14s|%-15s|%-11d|\n", Integer.toString(i+1), Kode.get(i), Nama.get(i), JenisKelamin.get(i), Jabatan.get(i), Gaji.get(i));
				System.out.println("==================================================================================");
			}
		}
		
		FileWriter fout = new FileWriter("Database.txt");
		fout.write("No#Kode#Nama#JenisKelamin#Jabatan#Gaji#Rank#\n");
		for(i=0;i<n;i++) {
			fout.write(Integer.toString(i+1)+"#"+Kode.get(i)+"#"+Nama.get(i)+"#"+JenisKelamin.get(i)+"#"+Jabatan.get(i)+"#"+Gaji.get(i)+"#"+Rank.get(i)+"#\n");
		}
		fout.close();
	}
	
	public static void Delete_Database(int index) throws IOException{
		
		FileReader fin = new FileReader("Database.txt");
		BufferedReader bin = new BufferedReader(fin);
		bin.mark(5000000);
		bin.reset();
		
		ArrayList<String> No = new ArrayList<String>();
		ArrayList<String> Kode = new ArrayList<String>();
		ArrayList<String> Nama = new ArrayList<String>();
		ArrayList<String> JenisKelamin = new ArrayList<String>();
		ArrayList<String> Jabatan = new ArrayList<String>();
		ArrayList<Integer> Gaji = new ArrayList<Integer>();
		ArrayList<Integer> Rank = new ArrayList<Integer>();
		
		scan = new Scanner(bin);
		scan.nextLine();
		scan.useDelimiter("#");
		int i=0;
		int j=1;
		int flag=0;
		while(scan.hasNext()) {
			if(i==0) {
				flag=1;
				if(j==1) {
					j++;
					No.add(scan.next());
					//System.out.println("No \t\t: "+No.get(i));
				}
				else if(j==2) {
					j++;
					Kode.add(scan.next());
					//System.out.println("Kode \t\t: "+Kode.get(i));
				}
				else if(j==3){
					j++;
					Nama.add(scan.next());
					//System.out.println("Nama \t\t: "+Nama.get(i));
				}
				else if(j==4) {
					j++;
					JenisKelamin.add(scan.next());
					//System.out.println("JenisKelamin \t: "+JenisKelamin.get(i));
				}
				else if(j==5) {
					j++;
					Jabatan.add(scan.next());
					//System.out.println("Jabatan \t: "+Jabatan.get(i));
				}
				else if(j==6) {
					j++;
					Gaji.add(Integer.parseInt(scan.next()));
					//System.out.println("Gaji \t\t: "+Gaji.get(i));
				}
				else if(j==7) {
					j=1;
					Rank.add(Integer.parseInt(scan.next()));
					//System.out.println("Gaji \t\t: "+Gaji.get(i));
					i++;
				}
			}
			else {
				if(j==1) {
					j++;
					String temp=scan.next();
					No.add(temp.substring(1));
					//System.out.println("No \t\t: "+No.get(i));
				}
				else if(j==2) {
					j++;
					Kode.add(scan.next());
					//System.out.println("Kode \t\t: "+Kode.get(i));
				}
				else if(j==3){
					j++;
					Nama.add(scan.next());
					//System.out.println("Nama \t\t: "+Nama.get(i));
				}
				else if(j==4) {
					j++;
					JenisKelamin.add(scan.next());
					//System.out.println("JenisKelamin \t: "+JenisKelamin.get(i));
				}
				else if(j==5) {
					j++;
					Jabatan.add(scan.next());
					//System.out.println("Jabatan \t: "+Jabatan.get(i));
				}
				else if(j==6) {
					j++;
					Gaji.add(Integer.parseInt(scan.next()));
					//System.out.println("Gaji \t\t: "+Gaji.get(i));
				}
				else if(j==7) {
					j=1;
					Rank.add(Integer.parseInt(scan.next()));
					//System.out.println("Gaji \t\t: "+Gaji.get(i));
					i++;
				}
			}
		}
		bin.close();
		fin.close();
		
		No.remove(index);
		Kode.remove(index);
		Nama.remove(index);
		JenisKelamin.remove(index);
		Jabatan.remove(index);
		Gaji.remove(index);
		
		int n=Nama.size();
		//System.out.println("n ==>"+n);
		
		if(n>1) {
			for(i=0;i<n;i++) {
				for(j=0;j<n-i-1;j++) {
					if(Nama.get(j).compareToIgnoreCase(Nama.get(j+1))>0) {
						
						String temp = "";
						
						temp = Nama.get(j);
						Nama.set(j, Nama.get(j+1));
						Nama.set(j+1, temp);
						//System.out.println("Temp = "+ temp);
						
						temp = Kode.get(j);
						Kode.set(j, Kode.get(j+1));
						Kode.set(j+1, temp);
						
						temp = No.get(j);
						No.set(j, No.get(j+1));
						No.set(j+1, temp);
						
						temp = JenisKelamin.get(j);
						JenisKelamin.set(j, JenisKelamin.get(j+1));
						JenisKelamin.set(j+1, temp);
						
						temp = Jabatan.get(j);
						Jabatan.set(j, Jabatan.get(j+1));
						Jabatan.set(j+1, temp);
						
						int tempInt;
						tempInt = Gaji.get(j);
						Gaji.set(j, Gaji.get(j+1));
						Gaji.set(j+1, tempInt);
						
						tempInt = Rank.get(j);
						Rank.set(j, Rank.get(j+1));
						Rank.set(j+1, tempInt);
					}
				}
			}
		}
		
		
		if(flag==0) {
			System.out.println("\n\nData Karyawan");
			System.out.println("=======");
			System.out.println("No people registered yet");
		}
		else {
			System.out.println("\n\nDatabase");
			System.out.println("=======");
			System.out.println("No|Kode    |Nama Karyawan             |Jenis Kelamin |Jabatan        |Gaji       |");
			System.out.println("==================================================================================");
			for(i=0;i<n;i++) {
				System.out.printf("%-2s|%-8s|%-26s|%-14s|%-15s|%-11d|\n", Integer.toString(i+1), Kode.get(i), Nama.get(i), JenisKelamin.get(i), Jabatan.get(i), Gaji.get(i));
				System.out.println("==================================================================================");
			}
		}
		
		FileWriter fout = new FileWriter("Database.txt");
		fout.write("No#Kode#Nama#JenisKelamin#Jabatan#Gaji#Rank#\n");
		for(i=0;i<n;i++) {
			fout.write(Integer.toString(i+1)+"#"+Kode.get(i)+"#"+Nama.get(i)+"#"+JenisKelamin.get(i)+"#"+Jabatan.get(i)+"#"+Gaji.get(i)+"#"+Rank.get(i)+"#\n");
		}
		fout.close();
		System.out.println("Delete Succes");
	}
	
	public static void Insert_Database(String Code, String Name, String Gender, String Position) throws IOException{
		
		FileReader fin = new FileReader("Database.txt");
		BufferedReader bin = new BufferedReader(fin);
		bin.mark(5000000);
		bin.reset();
		
		ArrayList<String> No = new ArrayList<String>();
		ArrayList<String> Kode = new ArrayList<String>();
		ArrayList<String> Nama = new ArrayList<String>();
		ArrayList<String> JenisKelamin = new ArrayList<String>();
		ArrayList<String> Jabatan = new ArrayList<String>();
		ArrayList<Integer> Gaji = new ArrayList<Integer>();
		ArrayList<Integer> Rank = new ArrayList<Integer>();
		
		scan = new Scanner(bin);
		scan.nextLine();
		scan.useDelimiter("#");
		int i=0;
		int j=1;
		int flag=0;
		int flagManajer=0;
		int flagSupervisor=0;
		int flagAdmin=0;
		while(scan.hasNext()) {
			if(i==0) {
				flag=1;
				if(j==1) {
					j++;
					No.add(scan.next());
					//System.out.println("No \t\t: "+No.get(i));
				}
				else if(j==2) {
					j++;
					Kode.add(scan.next());
					//System.out.println("Kode \t\t: "+Kode.get(i));
				}
				else if(j==3){
					j++;
					Nama.add(scan.next());
					//System.out.println("Nama \t\t: "+Nama.get(i));
				}
				else if(j==4) {
					j++;
					JenisKelamin.add(scan.next());
					//System.out.println("JenisKelamin \t: "+JenisKelamin.get(i));
				}
				else if(j==5) {
					j++;
					Jabatan.add(scan.next());
					//System.out.println("Jabatan \t: "+Jabatan.get(i));
					if(Jabatan.get(i).contentEquals("Manager")) {
						flagManajer++;
					}
					else if(Jabatan.get(i).contentEquals("Supervisor")) {
						flagSupervisor++;
					}
					else if(Jabatan.get(i).contentEquals("Admin")) {
						flagAdmin++;
					}
				}
				else if(j==6) {
					j++;
					Gaji.add(Integer.parseInt(scan.next()));
					//System.out.println("Gaji \t\t: "+Gaji.get(i));
				}
				else if(j==7) {
					j=1;
					Rank.add(Integer.parseInt(scan.next()));
					//System.out.println("Gaji \t\t: "+Gaji.get(i));
					i++;
				}
			}
			else {
				if(j==1) {
					j++;
					String temp=scan.next();
					No.add(temp.substring(1));
					//System.out.println("No \t\t: "+No.get(i));
				}
				else if(j==2) {
					j++;
					Kode.add(scan.next());
					//System.out.println("Kode \t\t: "+Kode.get(i));
				}
				else if(j==3){
					j++;
					Nama.add(scan.next());
					//System.out.println("Nama \t\t: "+Nama.get(i));
				}
				else if(j==4) {
					j++;
					JenisKelamin.add(scan.next());
					//System.out.println("JenisKelamin \t: "+JenisKelamin.get(i));
				}
				else if(j==5) {
					j++;
					Jabatan.add(scan.next());
					//System.out.println("Jabatan \t: "+Jabatan.get(i));
					if(Jabatan.get(i).contentEquals("Manager")) {
						flagManajer++;
					}
					else if(Jabatan.get(i).contentEquals("Supervisor")) {
						flagSupervisor++;
					}
					else if(Jabatan.get(i).contentEquals("Admin")) {
						flagAdmin++;
					}
				}
				else if(j==6) {
					j++;
					Gaji.add(Integer.parseInt(scan.next()));
					//System.out.println("Gaji \t\t: "+Gaji.get(i));
				}
				else if(j==7) {
					j=1;
					Rank.add(Integer.parseInt(scan.next()));
					//System.out.println("Gaji \t\t: "+Gaji.get(i));
					i++;
				}
			}
		}
		bin.close();
		fin.close();
		
		int n=Nama.size();
		//System.out.println("n ==>"+n);
		
		String TempNo = Integer.toString(n);
		No.add(TempNo);
		Kode.add(Code);
		Nama.add(Name);
		JenisKelamin.add(Gender);
		Jabatan.add(Position);
		
		if(Position.contentEquals("Manager")) {
			Gaji.add(8000000);
		}
		else if(Position.contentEquals("Supervisor")) {
			Gaji.add(6000000);
		}
		else if(Position.contentEquals("Admin")) {
			Gaji.add(4000000);
		}
		
		if(Position.contentEquals("Manager")) {
			flagManajer++;
			Rank.add(flagManajer);
			if((flagManajer-1)%3==0) {
				for(i=0;i<Nama.size()-1;i++) {
					if(Jabatan.get(i).contentEquals("Manager")) {
						int Bonus = Gaji.get(i);
						Bonus += (Bonus*10/100);
						Gaji.set(i, Bonus);
					}
				}
			}
		}
		else if(Position.contentEquals("Supervisor")) {
			flagSupervisor++;
			Rank.add(flagSupervisor);
			if((flagSupervisor-1)%3==0) {
				for(i=0;i<Nama.size()-1;i++) {
					if(Jabatan.get(i).contentEquals("Supervisor")) {
						int Bonus = Gaji.get(i);
						Bonus += (Bonus*75/1000);
						Gaji.set(i, Bonus);
					}
				}
			}
		}
		else if(Position.contentEquals("Admin")) {
			flagAdmin++;
			Rank.add(flagAdmin);
			if((flagAdmin-1)%3==0) {
				for(i=0;i<Nama.size()-1;i++) {
					if(Jabatan.get(i).contentEquals("Admin")) {
						int Bonus = Gaji.get(i);
						Bonus += (Bonus*5/100);
						Gaji.set(i, Bonus);
					}
				}
			}
		}
		
		n=Nama.size();
//		System.out.println("\nJumlah Manager ==> " + flagManajer);
//		System.out.println("Jumlah Supervisor ==> " + flagSupervisor);
//		System.out.println("Jumlah Admin ==> " + flagAdmin);
		
		if(n>1) {
			for(i=0;i<n;i++) {
				for(j=0;j<n-i-1;j++) {
					if(Nama.get(j).compareToIgnoreCase(Nama.get(j+1))>0) {
						
						String temp = "";
						
						temp = Nama.get(j);
						Nama.set(j, Nama.get(j+1));
						Nama.set(j+1, temp);
						//System.out.println("Temp = "+ temp);
						
						temp = Kode.get(j);
						Kode.set(j, Kode.get(j+1));
						Kode.set(j+1, temp);
						
						temp = No.get(j);
						No.set(j, No.get(j+1));
						No.set(j+1, temp);
						
						temp = JenisKelamin.get(j);
						JenisKelamin.set(j, JenisKelamin.get(j+1));
						JenisKelamin.set(j+1, temp);
						
						temp = Jabatan.get(j);
						Jabatan.set(j, Jabatan.get(j+1));
						Jabatan.set(j+1, temp);
						
						int tempInt;
						tempInt = Gaji.get(j);
						Gaji.set(j, Gaji.get(j+1));
						Gaji.set(j+1, tempInt);
						
						tempInt = Rank.get(j);
						Rank.set(j, Rank.get(j+1));
						Rank.set(j+1, tempInt);
					}
				}
			}
		}
		
		
		if(flag==0) {
			System.out.println("\n\nData Karyawan");
			System.out.println("=======");
			System.out.println("No people registered yet");
		}
		else {
			System.out.println("\n\nDatabase");
			System.out.println("=======");
			System.out.println("No|Kode    |Nama Karyawan             |Jenis Kelamin |Jabatan        |Gaji       |");
			System.out.println("==================================================================================");
			for(i=0;i<n;i++) {
				System.out.printf("%-2s|%-8s|%-26s|%-14s|%-15s|%-11d|\n", Integer.toString(i+1), Kode.get(i), Nama.get(i), JenisKelamin.get(i), Jabatan.get(i), Gaji.get(i));
				System.out.println("==================================================================================");
			}
		}
		
		FileWriter fout = new FileWriter("Database.txt");
		fout.write("No#Kode#Nama#JenisKelamin#Jabatan#Gaji#Rank#\n");
		for(i=0;i<n;i++) {
			fout.write(Integer.toString(i+1)+"#"+Kode.get(i)+"#"+Nama.get(i)+"#"+JenisKelamin.get(i)+"#"+Jabatan.get(i)+"#"+Gaji.get(i)+"#"+Rank.get(i)+"#\n");
		}
		fout.close();
		System.out.println("Insert Succes");
	}
	
	public static int Get_Database_by_Index(int target) throws IOException{
		
		FileReader fin = new FileReader("Database.txt");
		BufferedReader bin = new BufferedReader(fin);
		bin.mark(5000000);
		bin.reset();
		
		ArrayList<String> No = new ArrayList<String>();
		ArrayList<String> Kode = new ArrayList<String>();
		ArrayList<String> Nama = new ArrayList<String>();
		ArrayList<String> JenisKelamin = new ArrayList<String>();
		ArrayList<String> Jabatan = new ArrayList<String>();
		ArrayList<Integer> Gaji = new ArrayList<Integer>();
		ArrayList<Integer> Rank = new ArrayList<Integer>();
		
		scan = new Scanner(bin);
		scan.nextLine();
		scan.useDelimiter("#");
		int i=0;
		int j=1;
		int flag=0;
		while(scan.hasNext()) {
			if(i==0) {
				flag=1;
				if(j==1) {
					j++;
					No.add(scan.next());
					//System.out.println("No \t\t: "+No.get(i));
				}
				else if(j==2) {
					j++;
					Kode.add(scan.next());
					//System.out.println("Kode \t\t: "+Kode.get(i));
				}
				else if(j==3){
					j++;
					Nama.add(scan.next());
					//System.out.println("Nama \t\t: "+Nama.get(i));
				}
				else if(j==4) {
					j++;
					JenisKelamin.add(scan.next());
					//System.out.println("JenisKelamin \t: "+JenisKelamin.get(i));
				}
				else if(j==5) {
					j++;
					Jabatan.add(scan.next());
					//System.out.println("Jabatan \t: "+Jabatan.get(i));
				}
				else if(j==6) {
					j++;
					Gaji.add(Integer.parseInt(scan.next()));
					//System.out.println("Gaji \t\t: "+Gaji.get(i));
				}
				else if(j==7) {
					j=1;
					Rank.add(Integer.parseInt(scan.next()));
					//System.out.println("Gaji \t\t: "+Gaji.get(i));
					i++;
				}
			}
			else {
				if(j==1) {
					j++;
					String temp=scan.next();
					No.add(temp.substring(1));
					//System.out.println("No \t\t: "+No.get(i));
				}
				else if(j==2) {
					j++;
					Kode.add(scan.next());
					//System.out.println("Kode \t\t: "+Kode.get(i));
				}
				else if(j==3){
					j++;
					Nama.add(scan.next());
					//System.out.println("Nama \t\t: "+Nama.get(i));
				}
				else if(j==4) {
					j++;
					JenisKelamin.add(scan.next());
					//System.out.println("JenisKelamin \t: "+JenisKelamin.get(i));
				}
				else if(j==5) {
					j++;
					Jabatan.add(scan.next());
					//System.out.println("Jabatan \t: "+Jabatan.get(i));
				}
				else if(j==6) {
					j++;
					Gaji.add(Integer.parseInt(scan.next()));
					//System.out.println("Gaji \t\t: "+Gaji.get(i));
				}
				else if(j==7) {
					j=1;
					Rank.add(Integer.parseInt(scan.next()));
					//System.out.println("Gaji \t\t: "+Gaji.get(i));
					i++;
				}
			}
		}
		bin.close();
		fin.close();
		
		int n=Nama.size();
		
		//System.out.println("N ==> "+n);
		
		if(target<n) {
			System.out.println("\n\nLatest Database");
			System.out.println("=======");
			System.out.println("No|Kode    |Nama Karyawan             |Jenis Kelamin |Jabatan        |Gaji       |");
			System.out.println("==================================================================================");
			System.out.printf("%-2s|%-8s|%-26s|%-14s|%-15s|%-11d|\n", Integer.toString(target+1), Kode.get(target), Nama.get(target), JenisKelamin.get(target), Jabatan.get(target), Gaji.get(target));
			System.out.println("==================================================================================");
			return 1;
		}
		
		else {
			System.out.println("Maaf, Proses gagal");
			System.out.println("Silahkan check kembali nomor karyawan");
			return 0;
		}
		
	}
	
	public static void Update_Database(String Code, String Name, String Gender, String Position, int target) throws IOException{
		
		FileReader fin = new FileReader("Database.txt");
		BufferedReader bin = new BufferedReader(fin);
		bin.mark(5000000);
		bin.reset();
		
		ArrayList<String> No = new ArrayList<String>();
		ArrayList<String> Kode = new ArrayList<String>();
		ArrayList<String> Nama = new ArrayList<String>();
		ArrayList<String> JenisKelamin = new ArrayList<String>();
		ArrayList<String> Jabatan = new ArrayList<String>();
		ArrayList<Integer> Gaji = new ArrayList<Integer>();
		ArrayList<Integer> Rank = new ArrayList<Integer>();
		
		scan = new Scanner(bin);
		scan.nextLine();
		scan.useDelimiter("#");
		int i=0;
		int j=1;
		int flag=0;
		int flagManajer=0;
		int flagSupervisor=0;
		int flagAdmin=0;
		while(scan.hasNext()) {
			if(i==0) {
				flag=1;
				if(j==1) {
					j++;
					No.add(scan.next());
					//System.out.println("No \t\t: "+No.get(i));
				}
				else if(j==2) {
					j++;
					Kode.add(scan.next());
					//System.out.println("Kode \t\t: "+Kode.get(i));
				}
				else if(j==3){
					j++;
					Nama.add(scan.next());
					//System.out.println("Nama \t\t: "+Nama.get(i));
				}
				else if(j==4) {
					j++;
					JenisKelamin.add(scan.next());
					//System.out.println("JenisKelamin \t: "+JenisKelamin.get(i));
				}
				else if(j==5) {
					j++;
					Jabatan.add(scan.next());
					//System.out.println("Jabatan \t: "+Jabatan.get(i));
					if(Jabatan.get(i).contentEquals("Manager")) {
						flagManajer++;
					}
					else if(Jabatan.get(i).contentEquals("Supervisor")) {
						flagSupervisor++;
					}
					else if(Jabatan.get(i).contentEquals("Admin")) {
						flagAdmin++;
					}
				}
				else if(j==6) {
					j++;
					Gaji.add(Integer.parseInt(scan.next()));
					//System.out.println("Gaji \t\t: "+Gaji.get(i));
				}
				else if(j==7) {
					j=1;
					Rank.add(Integer.parseInt(scan.next()));
					//System.out.println("Gaji \t\t: "+Gaji.get(i));
					i++;
				}
			}
			else {
				if(j==1) {
					j++;
					String temp=scan.next();
					No.add(temp.substring(1));
					//System.out.println("No \t\t: "+No.get(i));
				}
				else if(j==2) {
					j++;
					Kode.add(scan.next());
					//System.out.println("Kode \t\t: "+Kode.get(i));
				}
				else if(j==3){
					j++;
					Nama.add(scan.next());
					//System.out.println("Nama \t\t: "+Nama.get(i));
				}
				else if(j==4) {
					j++;
					JenisKelamin.add(scan.next());
					//System.out.println("JenisKelamin \t: "+JenisKelamin.get(i));
				}
				else if(j==5) {
					j++;
					Jabatan.add(scan.next());
					//System.out.println("Jabatan \t: "+Jabatan.get(i));
					if(Jabatan.get(i).contentEquals("Manager")) {
						flagManajer++;
					}
					else if(Jabatan.get(i).contentEquals("Supervisor")) {
						flagSupervisor++;
					}
					else if(Jabatan.get(i).contentEquals("Admin")) {
						flagAdmin++;
					}
				}
				else if(j==6) {
					j++;
					Gaji.add(Integer.parseInt(scan.next()));
					//System.out.println("Gaji \t\t: "+Gaji.get(i));
				}
				else if(j==7) {
					j=1;
					Rank.add(Integer.parseInt(scan.next()));
					//System.out.println("Gaji \t\t: "+Gaji.get(i));
					i++;
				}
			}
		}
		bin.close();
		fin.close();
		
		int n=Nama.size();
		//System.out.println("n ==>"+n);
		
		String TempNo = Integer.toString(n);
		Kode.set(target, Code);
		Nama.set(target, Name);
		JenisKelamin.set(target, Gender);
		String flagJabatan = Jabatan.get(target);
		Jabatan.set(target, Position);
		if(!(Jabatan.get(target).equals(flagJabatan))){
			if(Position.contentEquals("Manager")) {
				flagManajer--;
			}
			else if(Position.contentEquals("Supervisor")) {
				flagSupervisor--;
			}
			else if(Position.contentEquals("Admin")) {
				flagAdmin--;
			}
		}
		
		if(Position.contentEquals("Manager")) {
			Gaji.set(target, 8000000);
		}
		else if(Position.contentEquals("Supervisor")) {
			Gaji.set(target, 6000000);
		}
		else if(Position.contentEquals("Admin")) {
			Gaji.set(target, 4000000);
		}
		
		if(Position.contentEquals("Manager")) {
			flagManajer++;
			Rank.add(flagManajer);
			if((flagManajer-1)%3==0) {
				for(i=0;i<Nama.size()-1;i++) {
					if(Jabatan.get(i).contentEquals("Manager")) {
						int Bonus = Gaji.get(i);
						Bonus += (Bonus*10/100);
						Gaji.set(i, Bonus);
					}
				}
			}
		}
		else if(Position.contentEquals("Supervisor")) {
			flagSupervisor++;
			Rank.add(flagSupervisor);
			if((flagSupervisor-1)%3==0) {
				for(i=0;i<Nama.size()-1;i++) {
					if(Jabatan.get(i).contentEquals("Supervisor")) {
						int Bonus = Gaji.get(i);
						Bonus += (Bonus*75/1000);
						Gaji.set(i, Bonus);
					}
				}
			}
		}
		else if(Position.contentEquals("Admin")) {
			flagAdmin++;
			Rank.add(flagAdmin);
			if((flagAdmin-1)%3==0) {
				for(i=0;i<Nama.size()-1;i++) {
					if(Jabatan.get(i).contentEquals("Admin")) {
						int Bonus = Gaji.get(i);
						Bonus += (Bonus*5/100);
						Gaji.set(i, Bonus);
					}
				}
			}
		}
		
		n=Nama.size();
//		System.out.println("\nJumlah Manager ==> " + flagManajer);
//		System.out.println("Jumlah Supervisor ==> " + flagSupervisor);
//		System.out.println("Jumlah Admin ==> " + flagAdmin);
		
		if(n>1) {
			for(i=0;i<n;i++) {
				for(j=0;j<n-i-1;j++) {
					if(Nama.get(j).compareToIgnoreCase(Nama.get(j+1))>0) {
						
						String temp = "";
						
						temp = Nama.get(j);
						Nama.set(j, Nama.get(j+1));
						Nama.set(j+1, temp);
						//System.out.println("Temp = "+ temp);
						
						temp = Kode.get(j);
						Kode.set(j, Kode.get(j+1));
						Kode.set(j+1, temp);
						
						temp = No.get(j);
						No.set(j, No.get(j+1));
						No.set(j+1, temp);
						
						temp = JenisKelamin.get(j);
						JenisKelamin.set(j, JenisKelamin.get(j+1));
						JenisKelamin.set(j+1, temp);
						
						temp = Jabatan.get(j);
						Jabatan.set(j, Jabatan.get(j+1));
						Jabatan.set(j+1, temp);
						
						int tempInt;
						tempInt = Gaji.get(j);
						Gaji.set(j, Gaji.get(j+1));
						Gaji.set(j+1, tempInt);
						
						tempInt = Rank.get(j);
						Rank.set(j, Rank.get(j+1));
						Rank.set(j+1, tempInt);
					}
				}
			}
		}
		
		
		if(flag==0) {
			System.out.println("\n\nData Karyawan");
			System.out.println("=======");
			System.out.println("No people registered yet");
		}
		else {
			System.out.println("\n\nDatabase");
			System.out.println("=======");
			System.out.println("No|Kode    |Nama Karyawan             |Jenis Kelamin |Jabatan        |Gaji       |");
			System.out.println("==================================================================================");
			for(i=0;i<n;i++) {
				System.out.printf("%-2s|%-8s|%-26s|%-14s|%-15s|%-11d|\n", Integer.toString(i+1), Kode.get(i), Nama.get(i), JenisKelamin.get(i), Jabatan.get(i), Gaji.get(i));
				System.out.println("==================================================================================");
			}
		}
		
		FileWriter fout = new FileWriter("Database.txt");
		fout.write("No#Kode#Nama#JenisKelamin#Jabatan#Gaji#Rank#\n");
		for(i=0;i<n;i++) {
			fout.write(Integer.toString(i+1)+"#"+Kode.get(i)+"#"+Nama.get(i)+"#"+JenisKelamin.get(i)+"#"+Jabatan.get(i)+"#"+Gaji.get(i)+"#"+Rank.get(i)+"#\n");
		}
		fout.close();
		System.out.println("Insert Succes");
	}
	
}