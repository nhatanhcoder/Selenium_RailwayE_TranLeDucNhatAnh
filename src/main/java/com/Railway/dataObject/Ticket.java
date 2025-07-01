package com.Railway.dataObject;
public class Ticket {
    private String departStation;
    private String arriveStation;
    private String departDate;
    private String seatType;
    private int ticketAmount;

    public Ticket() {}

    public Ticket(String departStation, String arriveStation, String departDate, String seatType, int ticketAmount) {
        this.departStation = departStation;
        this.arriveStation = arriveStation;
        this.departDate = departDate;
        this.seatType = seatType;
        this.ticketAmount = ticketAmount;
    }

    public String getDepartStation() { return departStation; }
    public String getArriveStation() { return arriveStation; }
    public String getDepartDate() { return departDate; }
    public String getSeatType() { return seatType; }
    public String getTicketAmount() { return String.valueOf(ticketAmount); }

    public String toBookingDataString() {
        return String.join(" | ", departStation, arriveStation, departDate, seatType, String.valueOf(ticketAmount));
    }
}
