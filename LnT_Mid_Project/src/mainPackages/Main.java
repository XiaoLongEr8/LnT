package mainPackages;

import java.io.IOException;

public class Main extends Input_Scanner{

	public static void main(String[] args) throws IOException {
		display();
	}

	public static void display() throws IOException {
		System.out.println("        PT. Mentol");
		System.out.println("=========================");
		System.out.println("1. View Data Karyawan");
		System.out.println("2. Insert Data Karyawan");
		System.out.println("3. Update Data Karyawan");
		System.out.println("4. Delete Data Karyawan");
		System.out.println("5. Exit");
		System.out.println("=========================");
		int choice;
		System.out.println("Input : ");
		choice=scan.nextInt();
		if(choice==1) {
			View_Karyawan.Display_Costumer();
		}
		else if(choice==2){
			Insert_Karyawan.Insert_Data_Karyawan();
		}
		else if(choice==3) {
			Update_Karyawan.Show_All_Data_for_Insert();
			Update_Karyawan.Update_Proses();
		}
		else  if(choice==4) {
			Delete_Karyawan.Show_Costumer_Database();
			Delete_Karyawan.Delete_Proses();
		}
		else  if(choice==5) {
			System.out.println("Thank you for using this program");
			System.exit(0);
		}
	}
	
}
