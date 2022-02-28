package com.company;

import java.util.Scanner;

public class Main {
    public static int checkwin(char[][] board) {
        int count = 0;


        if (board[1][1] == 'o' && board[1][2] == 'o' && board[1][3] == 'o') {
            System.out.println("o win");
            count++;
        }
        if (board[2][1] == 'o' && board[2][2] == 'o' && board[2][3] == 'o') {
            System.out.println("o win");
            count++;
        }
        if (board[3][1] == 'o' && board[3][2] == 'o' && board[3][3] == 'o') {
            System.out.println("o win");
            count++;

        }
        if (board[1][1] == 'o' && board[2][1] == 'o' && board[3][1] == 'o') {
            System.out.println("o win");
            count++;
        }
        if (board[1][2] == 'o' && board[2][2] == 'o' && board[3][2] == 'o') {
            System.out.println("o win");
            count++;

        }
        if (board[1][3] == 'o' && board[2][3] == 'o' && board[3][3] == 'o') {
            System.out.println("o win");
            count++;

        }
        if (board[1][1] == 'o' && board[2][2] == 'o' && board[3][3] == 'o') {
            System.out.println("o win");
            count++;
        }
        if (board[1][3] == 'o' && board[2][2] == 'o' && board[3][1] == 'o') {
            System.out.println("o win");
            count++;
        }

        if (board[1][1] == 'x' && board[1][2] == 'x' && board[1][3] == 'x') {
            System.out.println("x win");
            count++;
        }
        if (board[2][1] == 'x' && board[2][2] == 'x' && board[2][3] == 'x') {
            System.out.println("x win");
            count++;
        }
        if (board[3][1] == 'x' && board[3][2] == 'x' && board[3][3] == 'x') {
            System.out.println("x win");
            count++;

        }
        if (board[1][1] == 'x' && board[2][1] == 'x' && board[3][1] == 'x') {
            System.out.println("x win");
            count++;

        }
        if (board[1][2] == 'x' && board[2][2] == 'x' && board[3][2] == 'x') {
            System.out.println("x win");
            count++;

        }
        if (board[1][3] == 'x' && board[2][3] == 'x' && board[3][3] == 'x') {
            System.out.println("x win");
            count++;

        }
        if (board[1][1] == 'x' && board[2][2] == 'x' && board[3][3] == 'x') {
            System.out.println("x win");
            count++;

        }
        if (board[1][3] == 'x' && board[2][2] == 'x' && board[3][1] == 'x') {
            System.out.println("x win");
            count++;
        }
        return count;
    }

    public static void prind_arr(char[][] arr) {
        for (int i = 1; i <= 3; i++) {
            for (int j = 1; j <= 3; j++) {
                System.out.print(" |" + arr[i][j] + "|");
            }
            System.out.println("\n------------");
        }
    }

    public static void checkspace(char[][] board, int row, int col, char tur) {
        if (board[row][col] == 'o' || board[row][col] == 'x') {
            System.out.println("Occupancy slot");
            System.out.println();
        } else {
            board[row][col] = tur;
        }

    }

    public static int hackme(char tur, int num, int oldnum, char[][] board) {
        int co = 0;
        if (num == 9 & oldnum == 6) {
            System.out.println(tur + " is win");
            for (int i = 1; i <= 3; i++) {
                for (int j = 1; j <= 3; j++) {
                    board[i][j] = tur;
                }
            }
            prind_arr(board);

            co = 1;
        }
        return co;
    }

    public static Scanner reader = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Against whom you want to play computer/friend");
        String mode = reader.next();
        int game = 0;
        int oldnum = 0;
        int co = 0;
        int turn = 1;
        char tur;
        System.out.println(" |1| |2| |3|");
        System.out.println("------------");
        System.out.println(" |4| |5| |6|");
        System.out.println("------------");
        System.out.println(" |7| |8| |9|");
        System.out.println("------------");
        char[][] board = new char[4][4];
        char ch = '1';

        for (int i = 1; i <= 3; i++) {
            for (int j = 1; j <= 3; j++) {
                board[i][j] = ch++;
            }
        }
        if (mode.equals("computer")) {
            System.out.println("mode selected computer mode");
            char player = 'x', computer = 'o';
            int turnpc = 0;
            while (true) {
                if (turn % 2 == 1) {
                    tur = 'x';

                    int num = (int) (Math.random() * 9) + 1;
                    System.out.println(num);


                    int row = num / 3;
                    int col = num % 3;
                    System.out.println();
                    checkspace(board, row, col, tur);
                    row++;
                    if (col == 0) {
                        col = 3;
                        row--;
                    }
                    co = hackme(tur, num, oldnum, board);
                    if (co == 1) {
                        break;
                    }
                    prind_arr(board);
                    oldnum = num;
                    int checkwin = checkwin(board);
                    game++;
                    if (checkwin == 1) {
                        break;
                    }

                    if (checkwin == 2) {
                        System.out.println("double win");
                        break;

                    }
                    turn++;
                    if (turn == 10 && checkwin == 0) {
                        System.out.println("draw");
                        break;
                    }
                } else {
                    tur = 'o';
                    int num = reader.nextInt();

                    System.out.println("now turn " + tur);
                    System.out.println("where to put");

                    int row = num / 3;
                    int col = num % 3;
                    if (col == 0) {
                        col = 3;
                        row--;
                    }
                    row++;
                    System.out.println();
                    checkspace(board, row, col, tur);

                    co = hackme(tur, num, oldnum, board);
                    if (co == 1) {
                        break;
                    }

                    oldnum = num;
                    int checkwin = checkwin(board);
                    game++;
                    if (checkwin == 1) {
                        break;
                    }

                    if (checkwin == 2) {
                        System.out.println("double win");
                        break;

                    }
                    turn++;
                    if (turn == 10 && checkwin == 0) {
                        System.out.println("draw");
                        break;
                    }
                }


            }
            if (mode.equals("friend")) {

                System.out.println("mode selected friend mode");
                while (true) {
                    if (turn % 2 == 1) {
                        tur = 'x';

                    } else {
                        tur = 'o';

                    }

                    System.out.println("now turn " + tur);
                    System.out.println("where to put");
                    int num = reader.nextInt();

                    int row = num / 3;
                    int col = num % 3;
                    // prind_arr(board);
                    row++;

                    if (col == 0) {
                        col = 3;
                        row--;
                    }
                    System.out.println();
                    checkspace(board, row, col, tur);

                    co = hackme(tur, num, oldnum, board);
                    if (co == 1) {
                        break;
                    }
                    prind_arr(board);
                    oldnum = num;
                    int checkwin = checkwin(board);
                    game++;
                    if (checkwin == 1) {
                        break;
                    }

                    if (checkwin == 2) {
                        System.out.println("double win");
                        break;

                    }
                    turn++;
                    if (turn == 10 && checkwin == 0) {
                        System.out.println("draw");
                        break;
                    }

                }
            }
        }
    }
}
