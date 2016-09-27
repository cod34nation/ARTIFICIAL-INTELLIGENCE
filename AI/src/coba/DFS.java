/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package coba;

/**
 *
 * @author AFRIZAL
 */

/******************************************************
 * Program Searching dengan Menggunakan Algoritma DFS *
 ******************************************************/
import java.util.*;
import java.io.*;

/*********************************
 * Kelas DFS                     *
 *********************************/
public class DFS {
 private String Node; //Node untuk menyimpan init state dan state saat ini.
 private String Goal;
 private String skrNode;
 private int JlhNode;
 private int Batas;
 private int NTkt;
 private int n;
 private boolean ketemu;
 private String Init;
 
 LinkedList<String>DaftarBuka;
 Map<String, Integer>Tingkat;
 Map<String, String>Telusur;
 
 /*********************************************
 * Konstruktor DFS       *
 *********************************************/
 public DFS(String InitState, String GoalState, int Bts) {
  this.JlhNode = 0;
  this.Node = InitState;
  this.Goal = GoalState;
  this.ketemu = false;
  this.Batas = Bts;
  this.Init = InitState;
  
  DaftarBuka = new LinkedList<String>();
  Tingkat = new HashMap<String, Integer>();
  Telusur = new HashMap<String, String>();
  this.TambahDaftarBuka(this.Node, null);
 }
 
 public DFS() {
  this.JlhNode = 0;
  this.Node = null;
  this.Goal = null;
  this.Init = null;
  this.ketemu = false;
  this.Batas = 0;
  
  DaftarBuka = new LinkedList<String>();
  Tingkat = new HashMap<String, Integer>();
  Telusur = new HashMap<String, String>();
 }
 
 public void IsiData(String InitState, String GoalState, int Bts) {
  this.JlhNode = 0;
  this.Node = InitState;
  this.Goal = GoalState;
  this.Init = InitState;
  this.ketemu = false;
  this.Batas = Bts;
  this.DaftarBuka.clear();
  this.TambahDaftarBuka(this.Node, null);
 }
 /**********************************************
 * Fungsi untuk memasukkan data ke Open List  *
 * sekaligus membuat jejak pencarian          *
 **********************************************/
 private void TambahDaftarBuka(String SB, String SL) {
  if (! Tingkat.containsKey(SB)) {
   this.NTkt = SL == null ? 0 : Tingkat.get(SL) + 1;
   Tingkat.put(SB, this.NTkt);
   DaftarBuka.addFirst(SB);
   Telusur.put(SB, SL);
  }
 }
 
 /****************************************
 * Fungsi untuk melalukan pencarian     *
 * pada setiap Node                     *
 ****************************************/
 public void Cari() {
  //this.ketemu = false;
  //this.JlhNode = 0;
  while (! DaftarBuka.isEmpty()) {
   this.skrNode = DaftarBuka.removeFirst();
   if (this.skrNode.equals(this.Goal)) {
    this.ketemu = true;
    try {
     this.printSolution(this.skrNode);
    }
    catch (IOException io) {}
    break;
   }
   else {
    if (Tingkat.get(this.skrNode) < this.Batas) {
     
     this.n = this.skrNode.indexOf("0");
     
     //Gerak ke kiri
     if (this.n != 0 && this.n != 3 && this.n != 6) {
      String STB = this.skrNode.substring(0, this.n-1) + "0" +
                    this.skrNode.charAt(this.n-1) +
           this.skrNode.substring(this.n+1);
      TambahDaftarBuka(STB, this.skrNode);
      this.JlhNode++;
     }
     
     //Gerak ke Atas
     if (this.n != 0 && this.n != 1 && this.n != 2) {
      //String nextState = currState.substring(0,a-3)+”0?+currState.substring(a-2,a)+currState.charAt(a-3)+currState.substring(a+1);//swap blank with destination
      String STB = this.skrNode.substring(0, this.n-3) + "0" +
           this.skrNode.substring(this.n-2, this.n) +
           this.skrNode.charAt(this.n-3) +
           this.skrNode.substring(this.n+1);
      TambahDaftarBuka(STB, this.skrNode);
      this.JlhNode++;
     }
     
     //Gerak ke kanan
     if (this.n != 2 && this.n != 5 && this.n != 8) {
      //String nextState = currState.substring(0,a)+currState.charAt(a+1)+”0?+currState.substring(a+2);//swap blank with destination
      String STB = this.skrNode.substring(0, this.n) + 
                    this.skrNode.charAt(this.n+1) + "0" +
           this.skrNode.substring(this.n+2);
      TambahDaftarBuka(STB, this.skrNode);
      this.JlhNode++;
     }
     
     //Gerak ke bawah
     if (this.n != 6 && this.n != 7 && this.n != 8) {
      //String nextState = currState.substring(0,a)+currState.substring(a+3,a+4)+currState.substring(a+1,a+3)+”0?+currState.substring(a+4);//swap blank with destination
      String STB = this.skrNode.substring(0, this.n) + 
                    this.skrNode.substring(this.n+3, this.n+4) +
           this.skrNode.substring(this.n+1, this.n+3) + "0" +
           this.skrNode.substring(this.n+4);
      TambahDaftarBuka(STB, this.skrNode);
      this.JlhNode++;
     }
     
    }
   }
  }
  if (this.ketemu) {
   System.out.println("Goal ditemukan pada " + (int) Tingkat.get(this.skrNode) + " langkah");
   System.out.println("Banyaknya Node yang dihasilkan : " + JlhNode);
  }
  else {
   System.out.println("Goal Tidak Ditemukan !!!");
   System.out.println("Batasan tingkat pencarian : " + this.Batas);
  }
  
 }
 
 void printSolution(String currState) throws IOException {
        if (this.ketemu) {
            System.out.println("Solusi ditermukan dalam " + Tingkat.get(currState) + " langkah");
            System.out.println("Node yang Dihasilkan : " + JlhNode);
            //System.out.println("Unique Node generated: " + unique);
        } else {

            System.out.println("Solusi Tidak Ditermukan !");
            System.out.println("Tingkat Kedalaman Pencarian Telah Tercapai!");
            System.out.println("Jumlah Node yang Dihasilkan : " + JlhNode);
            //System.out.println("Unique Node generated: " + unique);
        }
  
  InputStreamReader isr = new InputStreamReader(System.in);
  BufferedReader br =  new BufferedReader(isr);
  System.out.print("\nApakah Rincian Node Ingin Ditampilkan <Y>a/<T>idak : ");
  String r = br.readLine();
  r = r.toUpperCase();
  
  while ((! r.equals("Y")) && (! r.equals("T"))) {
   System.out.println("\nPilihan Salah !!! Ketik Y Untuk Ya; T untuk Tidak");
   System.out.print("Apakah Rincian Node Ingin Ditampilkan <Y>a/<T>idak : ");
   r = br.readLine();
   r = r.toUpperCase();
  }
  
  if (r.equals("Y")) {
   String traceState = currState;
   while (traceState != null) {
    System.out.println(traceState + " at " + Tingkat.get(traceState));
    try {
     for (int z = 0; z < 9; z++) {
      System.out.print(" " + String.valueOf(traceState.charAt(z)) + " ");
      if ((z + 1) % 3 == 0) {
       System.out.println();
      }
     }
    } catch (NullPointerException e) {
    }
    traceState = Telusur.get(traceState);
   }
  }
        //System.exit(0); //break
    }
 
 
 public String getInitState() {
  return this.Init;
 }
 
 public String getGoalState() {
  return this.Goal;
 }
 
 public void setNode(String ST) {
  this.Node = ST;
 }
 
 public void setInit(String ST) {
  this.Init = ST;
 }
 
 public void setGoal(String ST) {
  this.Goal = ST;
 }
 
 
}