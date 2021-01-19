package mainPackages;

import java.io.IOException;
import java.util.Scanner;

public class Update_Karyawan extends Input_Scanner{
	
	public static int updateIndex;
	
	public static String kodeREV;
	public static String namaREV;
	public static String jenisKelaminREV;
	public static String jabatanREV;
	public static int gajiREV;
	
	public static Scanner cin = new Scanner (System.in);
	
	public static void Show_All_Data_for_Insert() throws IOException {
		Database_Controller.Show_and_get_Database();
	}
	
	public static void Update_Proses() throws IOException {
		System.out.println("Input nomor karyawan yang ingin diupdate : ");
		updateIndex = cin.nextInt();
		int flag = Database_Controller.Get_Database_by_Index(updateIndex-1);
		
		if(flag==1) {
			System.out.println("\nData bersifat Case Sensitif");
			
			System.out.print("Input Nama karyawan [>=3] : ");
			namaREV = cin.nextLine();
			while(namaREV.length()<3) {
				System.out.println("\nNama yang diinput minimal 3 karakter");
				System.out.print("Input Nama karyawan [>=3] : ");
				namaREV=cin.nextLine();
			}
			
			System.out.print("Input jenis kelamin [Laki-laki | Perempuan] : ");
			jenisKelaminREV = cin.nextLine();
			while((!jenisKelaminREV.contentEquals("Laki-laki"))&&(!jenisKelaminREV.contentEquals("Perempuan"))) {
				System.out.println("\nJenis kelamin harus Laki-laki | Perempuan (Case Sensitive)");
				System.out.print("Input jenis kelamin [Laki-laki | Perempuan] : ");
				jenisKelaminREV = cin.nextLine();
			}
			
			System.out.print("Input jabatan [Manager | Supervisor | Admin] : ");
			jabatanREV = cin.nextLine();
			while((!jabatanREV.contentEquals("Manager"))&&(!jabatanREV.contentEquals("Supervisor"))&&(!jabatanREV.contentEquals("Admin"))) {
				System.out.println("\nJabatan harus Manager | Supervisor | Admin (Case Sensitive)");
				System.out.print("Input jabatan [Manager | Supervisor | Admin] : ");
				jabatanREV = cin.nextLine();
			}
			
			String kodeREV;
			System.out.println("Keterangan Format Kode ==> HH-AAAA");
			System.out.println("H ==> Huruf Kapital / UpperCase");
			System.out.println("A ==> Angka");
			System.out.print("Input Kode Karyawan [7 Charakter, format ==> (HH-AAAA) ]: ");
			kodeREV = cin.nextLine();
			while(kodeREV.length()!=7) {
				System.out.println("Kode harus berisi 7 karakter");
				System.out.print("Input Kode Karyawan [7 Charakter, format ==> (HH-AAAA) ]: ");
				kodeREV = cin.nextLine();
			}
			
			while(kodeREV.charAt(0)<'A'||kodeREV.charAt(0)>'Z') {
				System.out.println("Kode pertama harus Huruf Kapital");
				System.out.print("Input Kode Karyawan [7 Charakter, format ==> (HH-AAAA) ]: ");
				kodeREV = cin.nextLine();
			}
			
			while(kodeREV.charAt(1)<'A'||kodeREV.charAt(1)>'Z') {
				System.out.println("Kode kedua harus Huruf Kapital");
				System.out.print("Input Kode Karyawan [7 Charakter, format ==> (HH-AAAA) ]: ");
				kodeREV = cin.nextLine();
			}
			
			while(kodeREV.charAt(2)!='-') {
				System.out.println("Kode ketiga harus memakai simbol '-'");
				System.out.print("Input Kode Karyawan [7 Charakter, format ==> (HH-AAAA) ]: ");
				kodeREV = cin.nextLine();
			}
			
			while(kodeREV.charAt(3)<'0'||kodeREV.charAt(3)>'9') {
				System.out.println("Kode keempat harus memakai angka");
				System.out.print("Input Kode Karyawan [7 Charakter, format ==> (HH-AAAA) ]: ");
				kodeREV = cin.nextLine();
			}
			
			while(kodeREV.charAt(4)<'0'||kodeREV.charAt(4)>'9') {
				System.out.println("Kode kelima harus memakai angka");
				System.out.print("Input Kode Karyawan [7 Charakter, format ==> (HH-AAAA) ]: ");
				kodeREV = cin.nextLine();
			}
			
			while(kodeREV.charAt(5)<'0'||kodeREV.charAt(5)>'9') {
				System.out.println("Kode keenam harus memakai angka");
				System.out.print("Input Kode Karyawan [7 Charakter, format ==> (HH-AAAA) ]: ");
				kodeREV = cin.nextLine();
			}
			
			while(kodeREV.charAt(6)<'0'||kodeREV.charAt(6)>'9') {
				System.out.println("Kode ketujuh harus memakai angka");
				System.out.print("Input Kode Karyawan [7 Charakter, format ==> (HH-AAAA) ]: ");
				kodeREV = cin.nextLine();
			}
			
			Database_Controller.Update_Database(kodeREV, namaREV, jenisKelaminREV, jabatanREV, updateIndex-1);
		}
		else {
			Database_Controller.Show_and_get_Database();
			Update_Proses();
		}
	}
}
