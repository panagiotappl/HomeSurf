package io.home.surf.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

/**
 * @author Dimitris Anastasopoulos
 *
 */
@Entity
public class BookingRating {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;

  @Column(nullable = false, unique = false)
  private int rating;

  @Column(nullable = true, unique = false)
  private String comment;

  @OneToOne(mappedBy = "ratingId")
  private Booking booking;

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public int getRating() {
    return rating;
  }

  public void setRating(int rating) {
    this.rating = rating;
  }

  public String getComment() {
    return comment;
  }

  public void setComment(String comment) {
    this.comment = comment;
  }

  public Booking getBooking() {
    return booking;
  }

  public void setBooking(Booking booking) {
    this.booking = booking;
  }

}
