package mainPackages;

import java.io.IOException;
import java.util.Scanner;

public class Delete_Karyawan {
	
	public static int deleteIndex;
	
	static Scanner Scan = new Scanner (System.in);

	public static void Show_Costumer_Database() throws IOException{
		Database_Controller.Show_and_get_Database();
	}
	
	public static void Delete_Proses() throws IOException {
		System.out.print("Masukkan nomor karyawan yang ingin dihapus : ");
		deleteIndex = Scan.nextInt();
		Database_Controller.Delete_Database(deleteIndex-1);
	}

}
