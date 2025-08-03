package info.shkryl.array.lottery.secondVaritan;

class Ticket {

    int numberTicket;
    long dateTimestamp; // используем long вместо Date (упрощение)
    String fioOwner;

    public Ticket(int number, long date, String fio) {
        this.numberTicket = number;
        this.dateTimestamp = date;
        this.fioOwner = fio;
    }
}