package AlonsoProjectCLI.Booking;
import AlonsoProjectCLI.User.User;
import AlonsoProjectCLI.Car.Car;

import java.time.LocalDate;
import java.util.Objects;
import java.util.UUID;

public class Booking {
    private UUID bookingId;
    private User user;
    private Car car;
    private LocalDate dateTime;
    private boolean isCanceled;

    public Booking(UUID bookingId, User user, Car car, LocalDate dateTime, boolean isCanceled) {
        this.bookingId = bookingId;
        this.user = user;
        this.car = car;
        this.dateTime = dateTime;
        this.isCanceled = isCanceled;
    }

    public Booking(UUID bookingId, User user, Car car, LocalDate dateTime) {
        this(bookingId,user,car,dateTime,false);
    }

    public UUID getBookingId() {
        return bookingId;
    }

    public void setBookingId(UUID bookingId) {
        this.bookingId = bookingId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public LocalDate getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDate dateTime) {
        this.dateTime = dateTime;
    }

    public boolean isCanceled() {
        return isCanceled;
    }

    public void setCanceled(boolean canceled) {
        isCanceled = canceled;
    }

    @Override
    public String toString() {
        return "Booking{" +
                "bookingId=" + bookingId +
                ", user=" + user +
                ", car=" + car +
                ", dateTime=" + dateTime +
                ", isCanceled=" + isCanceled +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Booking booking = (Booking) o;
        return isCanceled == booking.isCanceled && Objects.equals(bookingId, booking.bookingId) && Objects.equals(user, booking.user) && Objects.equals(car, booking.car) && Objects.equals(dateTime, booking.dateTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(bookingId, user, car, dateTime, isCanceled);
    }
}
