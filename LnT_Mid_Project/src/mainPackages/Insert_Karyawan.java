package mainPackages;

import java.io.IOException;

public class Insert_Karyawan extends Input_Scanner{
	
	public static String kode;
	public static String nama;
	public static String jenisKelamin;
	public static String jabatan;
	public static int gaji;
	
	
	public static void Insert_Data_Karyawan() throws IOException {
		
		
		System.out.println("\nData bersifat Case Sensitif");
		
		System.out.print("Input Nama karyawan [>=3] : ");
		nama = scan.nextLine();
		while(nama.length()<3) {
			System.out.println("\nNama yang diinput minimal 3 karakter");
			System.out.print("Input Nama karyawan [>=3] : ");
			nama=scan.nextLine();
		}
		
		System.out.print("Input jenis kelamin [Laki-laki | Perempuan] : ");
		jenisKelamin = scan.nextLine();
		while((!jenisKelamin.contentEquals("Laki-laki"))&&(!jenisKelamin.contentEquals("Perempuan"))) {
			System.out.println("\nJenis kelamin harus Laki-laki | Perempuan (Case Sensitive)");
			System.out.print("Input jenis kelamin [Laki-laki | Perempuan] : ");
			jenisKelamin = scan.nextLine();
		}
		
		System.out.print("Input jabatan [Manager | Supervisor | Admin] : ");
		jabatan = scan.nextLine();
		while((!jabatan.contentEquals("Manager"))&&(!jabatan.contentEquals("Supervisor"))&&(!jabatan.contentEquals("Admin"))) {
			System.out.println("\nJabatan harus Manager | Supervisor | Admin (Case Sensitive)");
			System.out.print("Input jabatan [Manager | Supervisor | Admin] : ");
			jabatan = scan.nextLine();
		}
		
		double char1 = Math.random() * (90-65+1)+65;
		double char2 = Math.random() * (90-65+1)+65;
		double numberCode = Math.random() * (9999-1000+1)+1000;
//		System.out.println("char 1 ==> "+(char) char1);
//		System.out.println("char 2 ==> "+(char) char2);
//		System.out.println("numberCode ==> "+(int) numberCode);
		kode = ((char) char1) +"" + ((char) char2) + "-"+(int)numberCode;
//		System.out.println("Code ==> "+kode);
		
		Database_Controller.Insert_Database(kode, nama, jenisKelamin, jabatan);
	}



}
