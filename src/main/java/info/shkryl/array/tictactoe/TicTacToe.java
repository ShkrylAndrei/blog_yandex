package info.shkryl.array.tictactoe;

public class TicTacToe {

    private char[][] board; // игровое поле 3x3
    private char currentPlayer; // текущий игрок: 'X' или 'O'

    public TicTacToe() {
        board = new char[3][3];
        currentPlayer = 'X';
        initializeBoard();
    }

    private void initializeBoard() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = ' ';
            }
        }
    }

    public void printBoard() {
        System.out.println();
        for (int i = 0; i < 3; i++) {
            System.out.print(" ");
            System.out.print(board[i][0]);
            System.out.print(" | ");
            System.out.print(board[i][1]);
            System.out.print(" | ");
            System.out.print(board[i][2]);
            System.out.println();

            if (i < 2) {
                System.out.println("-----------");
            }
        }
        System.out.println();
    }

    public boolean makeMove(int row, int col) {
        // Проверяем, в пределах ли поля
        if (row < 0 || row > 2 || col < 0 || col > 2) {
            System.out.println("Ошибка: введите число от 0 до 2.");
            return false;
        }

        // Проверяем, свободна ли клетка
        if (board[row][col] != ' ') {
            System.out.println("Клетка занята! Выберите другую.");
            return false;
        }

        // Делаем ход
        board[row][col] = currentPlayer;
        return true;
    }

    public void makeComputerMove() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == ' ') {
                    board[i][j] = 'O';
                    System.out.println("Компьютер походил в (" + i + "," + j + ")");
                    return;
                }
            }
        }
    }

    public char checkWinner() {
        // Проверка строк
        for (int i = 0; i < 3; i++) {
            if (board[i][0] == board[i][1] && board[i][1] == board[i][2] && board[i][0] != ' ') {
                return board[i][0];
            }
        }

        // Проверка столбцов
        for (int j = 0; j < 3; j++) {
            if (board[0][j] == board[1][j] && board[1][j] == board[2][j] && board[0][j] != ' ') {
                return board[0][j];
            }
        }

        // Диагонали
        if (board[0][0] == board[1][1] && board[1][1] == board[2][2] && board[0][0] != ' ') {
            return board[0][0];
        }
        if (board[0][2] == board[1][1] && board[1][1] == board[2][0] && board[0][2] != ' ') {
            return board[0][2];
        }

        return ' '; // нет победителя
    }

    public boolean isBoardFull() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == ' ') {
                    return false;
                }
            }
        }
        return true;
    }

    public void play() {
        java.util.Scanner scanner = new java.util.Scanner(System.in);
        System.out.println("Добро пожаловать в Крестики-нолики!");
        System.out.println("Вы — X, компьютер — O");
        System.out.println("Введите строку и столбец (0-2)");

        while (true) {
            printBoard();
            // Ход игрока
            System.out.print("Ваш ход (строка и столбец): ");
            int row = scanner.nextInt();
            int col = scanner.nextInt();

            if (!makeMove(row, col)) {
                continue; // ошибка ввода — повторяем
            }
            if (checkWinner() == 'X') {
                printBoard();
                System.out.println("🎉 Поздравляем! Вы выиграли!");
                break;
            }
            if (isBoardFull()) {
                printBoard();
                System.out.println("🤝 Ничья!");
                break;
            }
            // Ход компьютера
            makeComputerMove();

            if (checkWinner() == 'O') {
                printBoard();
                System.out.println("🤖 Компьютер выиграл!");
                break;
            }
            if (isBoardFull()) {
                printBoard();
                System.out.println("🤝 Ничья!");
                break;
            }
        }
        scanner.close();
    }

    public static void main(String[] args) {
        TicTacToe game = new TicTacToe();
        game.play();
    }
}
