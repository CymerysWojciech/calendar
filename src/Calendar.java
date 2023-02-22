import java.time.DayOfWeek;
import java.time.LocalDate;

public class Calendar {
    private final LocalDate date;
    private final int year;
    private final int month;
    private final int day;
    private static final String[] months = {"", "Styczeń", "Luty", "Marzec", "Kwiecień", "Maj", "Czerwiec", "Lipiec", "Sierpień", "Wrzesień", "Pażdziernik", "Listopad", "Grudzień"};

    public Calendar(int year, int month, int day) {
        this.date = LocalDate.of(year, month, day);
        this.year = year;
        this.month = month;
        this.day = day;
    }

    public Calendar(LocalDate localDate) {
        this.date = localDate;
        this.year = localDate.getYear();
        this.month = localDate.getMonthValue();
        this.day = localDate.getDayOfMonth();
    }

    public void showMonth() {
        LocalDate dates = LocalDate.of(year, month, 1);
        calender(month, year, dates);
    }

    public void showYear() {
        LocalDate dates = LocalDate.of(year, 1, 1);
        for (int i = 1; i <= 12; i++) {
            calender(i, year, dates);
            dates = dates.plusMonths(1);
        }
    }


    private void calender(int m, int y, LocalDate d) {
        DayOfWeek weekday = d.getDayOfWeek();
        int value = weekday.getValue();
        System.out.println();
        System.out.println(" " + months[m] + "    " + y);
        System.out.println("----------------------------------");
        System.out.println(" Pn   Wt   Śr   Czw   Pt   So   N");
        for (int i = 1; i < value; i++) System.out.print("     ");
        while (d.getMonthValue() == m) {
            System.out.printf("%3d", d.getDayOfMonth());
            if (d.getDayOfMonth() == day && d.getMonthValue() == month) System.out.print("* ");
            else System.out.print("  ");
            d = d.plusDays(1);
            if (d.getDayOfWeek().getValue() == 1) System.out.println();
        }
        System.out.println();
        System.out.println("----------------------------------");
    }

    public LocalDate getDate() {
        return date;
    }

    public int getYear() {
        return year;
    }

    public int getMonth() {
        return month;
    }

    public int getDay() {
        return day;
    }

    @Override
    public String toString() {
        return "Calendar{" + "date=" + date + ", year=" + year + ", month=" + month + ", day=" + day + '}';
    }


}
