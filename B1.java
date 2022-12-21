package BAI1_3;
import java.util.Scanner;

class BAI1_3{
    private int tuSo;
    private int mauSo;
    BAI1_3(){

    }
    BAI1_3(int tuSo, int mauSo){
        this.tuSo = tuSo;
        this.mauSo = mauSo;
    }
    public void setTuSo(int tuSo){
        this.tuSo = tuSo;
    }
    public int getTuSo(){
        return tuSo;
    }
    public void setMauSo(int mauSo){
        this.mauSo = mauSo;
    }
    public int getMauSo(){
        return mauSo;
    }
    public void enterFraction(Scanner sc){
        tuSo = sc.nextInt();
        mauSo = sc.nextInt();
    }
    public void display(){
        if(tuSo*mauSo<0){
            System.out.println("-"+Math.abs(tuSo)+"/"+Math.abs(mauSo));
        }else{
            System.out.println(Math.abs(tuSo) + "/" + Math.abs(mauSo));
        }
    }
    public BAI1_3 addFraction(BAI1_3 f2){
        int t = tuSo * f2.mauSo + f2.tuSo * mauSo;
        int m = mauSo * f2.mauSo;
        BAI1_3 ftong = new BAI1_3(t,m);
        ftong.rutGon();
        return ftong;
    }
    public BAI1_3 subFraction(BAI1_3 f2){
        int t = tuSo * f2.mauSo - f2.tuSo * mauSo;
        int m = mauSo * f2.mauSo;
        BAI1_3 fhieu = new BAI1_3(t,m);
        fhieu.rutGon();
        return fhieu;
    }
    public BAI1_3 tichFraction(BAI1_3 f2){
        int t = tuSo*f2.tuSo;
        int m = mauSo*f2.mauSo;
        BAI1_3 ftich = new BAI1_3(t,m);
        ftich.rutGon();
        return ftich;
    }
    public BAI1_3 divFraction(BAI1_3 f2) {
        int temp = f2.tuSo;
        f2.tuSo = f2.mauSo;
        f2.mauSo = temp;
        int t = tuSo * f2.tuSo;
        int m = mauSo * f2.mauSo;
        BAI1_3 fdiv = new BAI1_3(t,m);
        fdiv.rutGon();
        return fdiv;
    }
    public void rutGon() {
        int a = tuSo;
        int b = mauSo;
        int r = a % b;
        while (r != 0) {
            a = b;
            b = r;
            r = a % b;
        }
        tuSo /= b;
        mauSo /= b;
    }
}
class ArrayOfFractions{
    BAI1_3[] arrF = new BAI1_3[10];
    Scanner scan = new Scanner(System.in);
    ArrayOfFractions(){

    }
    public void enterArrF(){
        for(int i=0;i<10;i++){
            System.out.println("Nhap ps thu"+(i+1));
            arrF[i] = new BAI1_3();
            arrF[i].enterFraction(scan);
        }
    }
    public void maxFraction(){
        double[] arr = new double[10];
        for(int i=0;i<10;i++){
            arr[i] = (arrF[i].getTuSo()*1.0)/(arrF[i].getMauSo()*1.0);
        }
        for(int i=0;i<arr.length;i++){
            for(int j=i+1;j<arr.length;j++){
                if(arr[i]>arr[j]){
                    double temp = arr[i];
                    BAI1_3 tempF = arrF[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                    arrF[i] = arrF[j];
                    arrF[j] = tempF;
                }
            }
        }
        System.out.println("Two Fraction have greatest sum: ");
        arrF[arrF.length-2].display();
        arrF[arrF.length-1].display();
    }
}
public class B1 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
         BAI1_3 f1 = new BAI1_3();
         BAI1_3 f2 = new BAI1_3();
         BAI1_3 fAdd;
         BAI1_3 fSub;
         BAI1_3 ftich;
         BAI1_3 fdiv;
         System.out.print("Nhap f1: ");
         f1.enterFraction(sc);
         System.out.print("Nhap f2: ");
         f2.enterFraction(sc);
         fAdd = f1.addFraction(f2);
         fAdd.display();
         fSub = f1.subFraction(f2);
         fSub.display();
         ftich = f1.tichFraction(f2);
         ftich.display();
         fdiv = f1.divFraction(f2);
         fdiv.display();
        ArrayOfFractions aF = new ArrayOfFractions();
        aF.enterArrF();
        aF.maxFraction();
    }
}