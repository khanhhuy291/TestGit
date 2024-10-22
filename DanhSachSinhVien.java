import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner; 

class SortById implements Comparator<SinhVien>{
    @Override
     public int compare(SinhVien a,SinhVien b){
        return a.getId().compareTo(b.getId());
     }
}

class SinhVien{
    private String idSv,nameSv;
    private String classSv,emailSv;

    SinhVien(){}
    SinhVien(String idSv,String nameSv,String classSv,String emailSv){
        this.idSv = idSv;
        this.nameSv = ChuanHoa(nameSv);
        this.classSv = classSv;
        this.emailSv = emailSv;
    }
    public String getId(){
        return this.idSv;
    }
    @Override
    public String toString(){
        return this.idSv + " " + this.nameSv + " " + this.classSv + " " + this.emailSv; 
    }
    public String ChuanHoa(String s){
        s = s.toLowerCase().trim();
        String[] words = s.split("\\s+");
        String name = "";
        for(String word : words){
            if(word.length()>0){
                name += Character.toUpperCase(word.charAt(0));
            }
            if(word.length()>1){
                name += word.substring(1, word.length());
            }
            name += " ";            
        }
        return name;
    }
}

public class DanhSachSinhVien {
    public static void main(String[] args) throws FileNotFoundException {
        File f = new File("SINHVIEN.in");
        Scanner sc = new Scanner(f);
        int t = Integer.parseInt(sc.nextLine());
        ArrayList<SinhVien> sv = new ArrayList<>();
        while(t--!=0){
            sv.add(new SinhVien(sc.nextLine(),sc.nextLine(),sc.nextLine(),sc.nextLine()));
        }
        Collections.sort(sv,new SortById());
        for(SinhVien x : sv){
            System.out.println(x);
        }
    }
}