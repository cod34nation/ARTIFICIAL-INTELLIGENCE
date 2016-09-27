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


import javax.swing.JOptionPane;

/*

  * @author Danang-SWN

 */

public class hill_climb {

    public static void main(String[] args) {

        int matrixawal[][] = new int[0][0];

        String input;

        String menu;

        boolean ipt = true;

        int nilaiterkecil = 0;

        boolean lagi = true;

        boolean lagi1 = true;

        int kombinasi = 0;

        int temptukar;

        int iterator = 0;

        int di = 0;

        int level = 1;

        int itr = 0;

        int diagonal = 0;

        int matrixtukar[][];

        int matrixsementara[][];

        int opnext[];

        int nextlevel[];

        int levelkecil;

        //untuk hill climbing

        do {

            menu = JOptionPane.showInputDialog("Masukkan Pilihan tipe Pencarian :" + "\n 1. Simple Hill Climbing" + "\n 2. Steepest Ascent Hill Climbing");

            //pengecekan

            if (menu.equalsIgnoreCase("1")) {

                JOptionPane.showMessageDialog(null, "Anda memilih Simple Climbing");

                ipt = false;

            } else if (menu.equalsIgnoreCase("2")) {

                JOptionPane.showMessageDialog(null, "Anda memilih Steepest Climbing");

                ipt = false;

            } else {

                JOptionPane.showMessageDialog(null, "Inputan Salah");

            }

        } while (ipt);

        String mesin = JOptionPane.showInputDialog("Masukkan jumlah mesin :");

        String pekerja = JOptionPane.showInputDialog("Masukkan jumlah pekerja :");

        int jumlahpekerja = Integer.parseInt(pekerja);

        int jumlahmesin = Integer.parseInt(mesin);

        //pengecekan, jika mesin dan pekerja sama jumlahnya masukkan array seperti biasa

        if (jumlahmesin == jumlahpekerja) {

            matrixawal = new int[jumlahpekerja][jumlahmesin];

            for (int a = 0; a < jumlahpekerja; a++) {

                for (int b = 0; b < jumlahmesin; b++) {

                    input = JOptionPane.showInputDialog("masukkan elemen ke : " + a + "," + b);

                    matrixawal[a][b] = Integer.parseInt(input);

                }

            }

            //jika lebih banyak mesin,

        } else if (jumlahmesin > jumlahpekerja) {

            matrixawal = new int[jumlahmesin][jumlahmesin];

            //isi matrix dengan nilai 0

            for (int a = 0; a < matrixawal.length; a++) {

                for (int b = 0; b < matrixawal.length; b++) {

                    matrixawal[a][b] = 0;

                }

            }

            //tumpuk matrik sesuai dengan inputan penugasan

            for (int a = 0; a < jumlahpekerja; a++) {

                for (int b = 0; b < jumlahmesin; b++) {

                    input = JOptionPane.showInputDialog("masukkan elemen ke : " + a + "," + b);

                    matrixawal[a][b] = Integer.parseInt(input);

                }

            }

            //jika lebih banyak pekerja,

        } else if (jumlahmesin < jumlahpekerja) {

            matrixawal = new int[jumlahpekerja][jumlahpekerja];

            //isi matrik dengan nilai 0

            for (int a = 0; a < matrixawal.length; a++) {

                for (int b = 0; b < matrixawal.length; b++) {

                    matrixawal[a][b] = 0;

                }

            }

            //tumpuk matrik sesuai dengan nilai penugasan

            for (int a = 0; a < jumlahpekerja; a++) {

                for (int b = 0; b < jumlahmesin; b++) {

                    input = JOptionPane.showInputDialog("masukkan elemen ke : " + a + "," + b);

                    matrixawal[a][b] = Integer.parseInt(input);

                }

            }

        }

        //tampilkan matrik penugasan awal

        System.out.println("Bentuk matrix penugasan awal : ");

        for (int a = 0; a < matrixawal.length; a++) {

            for (int b = 0; b < matrixawal.length; b++) {

                System.out.print("  " + matrixawal[a][b]);

            }

            System.out.println("");

        }

        //pilihan pengerjaan

        if (menu.equalsIgnoreCase("1")) {

            //menghitung biaya awal

            for (int i = 0; i < matrixawal.length; i++) {

                nilaiterkecil += matrixawal[i][i];

            }

            levelkecil = nilaiterkecil;

            System.out.println("biaya awal adalah : " + nilaiterkecil);

            //menghitung kombinasi operator

            for (int a = 0; a < matrixawal.length; a++) {

                for (int b = a + 1; b < matrixawal.length; b++) {

                    kombinasi += 1;

                }

            }

            //membentuk operator yang digunakan

            int operator[] = new int[kombinasi * matrixawal.length];

            int index[] = new int[matrixawal.length];

            for (int i = 0; i < matrixawal.length; i++) {

                for (int j = i + 1; j < matrixawal.length; j++) {

                    for (int in = 0; in < index.length; in++) {

                        index[in] = in;

                    }

                    temptukar = index[i];

                    index[i] = index[j];

                    index[j] = temptukar;

                    for (int q = 0; q < matrixawal.length; q++) {

                        operator[iterator] = index[q];

                        iterator = iterator + 1;

                    }

                }

            }

            matrixtukar = new int[matrixawal.length][matrixawal.length];

            matrixsementara = new int[matrixawal.length][matrixawal.length];

            nextlevel = new int[matrixawal.length];

            opnext = new int[matrixawal.length];

            do {

                System.out.println("level ke : " + level);

                iterator = 0;

                di = 0;

                do {

                    //pembentukan matrix

                    for (int a = 0; a < matrixawal.length; a++) {

                        for (int b = iterator; b < iterator + matrixawal.length; b++) {

                            matrixtukar[a][itr] = matrixawal[a][operator[b]];

                            opnext[itr] = operator[b];

                            itr++;

                        }

                        itr = 0;

                    }

                    iterator += matrixawal.length;

                    //menampilkan penugasan dan operatornya

                    System.out.print("* penugasan ke " + (di + 1) + " : ");

                    for (int a = 0; a < matrixtukar.length; a++) {

                        for (int b = 0; b < matrixtukar.length; b++) {

                        }

                    }

                    for (int c = 0; c < opnext.length; c++) {

                        System.out.print(" " + opnext[c]);

                    }

                    //menghitung dan menampilkan nilai diagonal

                    diagonal = 0;

                    for (int i = 0; i < matrixtukar.length; i++) {

                        diagonal += matrixtukar[i][i];

                    }

                    System.out.print("   ---> biaya : " + diagonal);

                    System.out.println("");

                    //pengecekan

                    if (nilaiterkecil <= diagonal) {

                        di++;

                        lagi1 = true;

                    } else {

                        nilaiterkecil = diagonal;

                        //buat nyimpen operator baru

                        for (int a = 0; a < nextlevel.length; a++) {

                            nextlevel[a] = opnext[a];

                        }

                        lagi1 = false;

                    }

                } while ((di < kombinasi) && (lagi1));

                if (levelkecil > nilaiterkecil) {

                    levelkecil = nilaiterkecil;

                    System.out.println("nilai terkecil adalah : " + levelkecil);

                    System.out.print("operator yang digunakan adalah : ");

                    for (int a = 0; a < nextlevel.length; a++) {

                        System.out.print("  " + nextlevel[a]);

                    }

                    System.out.println("");

                    System.out.println("Bentuk Matriks penugasannya :");

                    for (int a = 0; a < matrixawal.length; a++) {

                        for (int b = 0; b < matrixawal.length; b++) {

                            System.out.print("  " + matrixawal[a][b]);

                        }

                        System.out.println("");

                    }

                    System.out.println("\n");

                    for (int a = 0; a < matrixawal.length; a++) {

                        for (int b = 0; b < matrixawal.length; b++) {

                            matrixsementara[a][b] = matrixawal[a][nextlevel[b]];

                        }

                    }

                    for (int a = 0; a < matrixawal.length; a++) {

                        for (int b = 0; b < matrixawal.length; b++) {

                            matrixawal[a][b] = matrixsementara[a][b];

                        }

                    }

                    lagi = true;

                    level++;

                } else {

                    System.out.println("nilai terkecil adalah : " + levelkecil);

                    System.out.print("operator yang digunakan adalah : ");

                    for (int a = 0; a < nextlevel.length; a++) {

                        System.out.print("  " + nextlevel[a]);

                    }

                    System.out.println("");

                    System.out.println("Bentuk Matriks Penugasannya : ");

                    for (int a = 0; a < matrixawal.length; a++) {

                        for (int b = 0; b < matrixawal.length; b++) {

                            System.out.print("  " + matrixawal[a][b]);

                        }

                        System.out.println("");

                    }

                    lagi = false;

                }

            } while (lagi);

        } else if (menu.equalsIgnoreCase("2")) {

            //menghitung biaya matrix asli`

            for (int i = 0; i < matrixawal.length; i++) {

                nilaiterkecil += matrixawal[i][i];

            }

            levelkecil = nilaiterkecil;

            //menampilkan biaya awal

            System.out.println("biaya awal adalah : " + nilaiterkecil);

            //menghitung kombinasi operator

            for (int a = 0; a < matrixawal.length; a++) {

                for (int b = a + 1; b < matrixawal.length; b++) {

                    kombinasi += 1;

                }

            }

            //membentuk operator yang digunakan

            int operator[] = new int[kombinasi * matrixawal.length];

            int index[] = new int[matrixawal.length];

            for (int i = 0; i < matrixawal.length; i++) {

                for (int j = i + 1; j < matrixawal.length; j++) {

                    for (int in = 0; in < index.length; in++) {

                        index[in] = in;

                    }

                    temptukar = index[i];

                    index[i] = index[j];

                    index[j] = temptukar;

                    for (int q = 0; q < matrixawal.length; q++) {

                        operator[iterator] = index[q];

                        iterator = iterator + 1;

                    }

                }

            }

            matrixtukar = new int[matrixawal.length][matrixawal.length];

            matrixsementara = new int[matrixawal.length][matrixawal.length];

            nextlevel = new int[matrixawal.length];

            opnext = new int[matrixawal.length];

            do {

                iterator = 0;

                System.out.println("level ke : " + level);

                //bikin perulangan buat itung level

                for (int x = 0; x < kombinasi; x++) {

                    //matrix baru hasil

                    //isi matrix baru

                    for (int a = 0; a < matrixawal.length; a++) {

                        for (int b = iterator; b < iterator + matrixawal.length; b++) {

                            matrixtukar[a][itr] = matrixawal[a][operator[b]];

                            opnext[itr] = operator[b];

                            itr++;

                        }

                        itr = 0;

                    }

                    iterator += matrixawal.length;

                    //menampilkan penugasan dan operatornya

                    System.out.print("penugasan ke " + (x + 1) + " : ");

                    for (int a = 0; a < matrixtukar.length; a++) {

                        for (int b = 0; b < matrixtukar.length; b++) {

                        }

                    }

                    for (int c = 0; c < opnext.length; c++) {

                        System.out.print(" " + opnext[c]);

                    }

                    //menghitung dan menampilkan nilai diagonal

                    diagonal = 0;

                    for (int i = 0; i < matrixtukar.length; i++) {

                        diagonal += matrixtukar[i][i];

                    }

                    System.out.print(" ---> biaya : " + diagonal);

                    System.out.println("");

                    //pengecekan

                    if (nilaiterkecil > diagonal) {

                        nilaiterkecil = diagonal;

                        //buat nyimpen operator baru

                        for (int a = 0; a < nextlevel.length; a++) {

                            nextlevel[a] = opnext[a];

                        }

                    }

                }

                if (levelkecil > nilaiterkecil) {

                    levelkecil = nilaiterkecil;

                    System.out.println("nilai terkecil adalah : " + levelkecil);

                    System.out.print("operator yang digunakan adalah : ");

                    for (int a = 0; a < nextlevel.length; a++) {

                        System.out.print("  " + nextlevel[a]);

                    }

                    System.out.println("");

                    System.out.println("Bentuk Matriks penugasannya : ");

                    for (int a = 0; a < matrixawal.length; a++) {

                        for (int b = 0; b < matrixawal.length; b++) {

                            System.out.print("  " + matrixawal[a][b]);

                        }

                        System.out.println("");

                    }

                    System.out.println("\n");

                    for (int a = 0; a < matrixawal.length; a++) {

                        for (int b = 0; b < matrixawal.length; b++) {

                            matrixsementara[a][b] = matrixawal[a][nextlevel[b]];

                        }

                    }

                    for (int a = 0; a < matrixawal.length; a++) {

                        for (int b = 0; b < matrixawal.length; b++) {

                            matrixawal[a][b] = matrixsementara[a][b];

                        }

                    }

                    lagi = true;

                    level++;

                } else {

                    System.out.println("nilai terkecil adalah : " + levelkecil);

                    System.out.print("operator yang digunakan adalah : ");

                    for (int a = 0; a < nextlevel.length; a++) {

                        System.out.print("  " + nextlevel[a]);

                    }

                    System.out.println("");

                    System.out.println("Bentuk Matriks penugasannya : ");

                    for (int a = 0; a < matrixawal.length; a++) {

                        for (int b = 0; b < matrixawal.length; b++) {

                            System.out.print("  " + matrixawal[a][b]);

                        }

                        System.out.println("");

                    }

                    lagi = false;

                }

            } while (lagi);

        }

    }
}