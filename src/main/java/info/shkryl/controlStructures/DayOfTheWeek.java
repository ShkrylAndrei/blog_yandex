package info.shkryl.controlStructures;

public class DayOfTheWeek {

    public static void main(String[] args) {

        int day = 3;
        String dayName;

        switch (day) {
            case 1:
                dayName = "Понедельник";
                break;
            case 2:
                dayName = "Вторник";
                break;
            case 3:
                dayName = "Среда";
                break;
            case 4:
                dayName = "Четверг";
                break;
            case 5:
                dayName = "Пятница";
                break;
            case 6:
            case 7:
                dayName = "Выходные";
                break;
            default:
                dayName = "Неверный день";
                break;
        }

        System.out.println("День: " + dayName); // Среда
    }
}
