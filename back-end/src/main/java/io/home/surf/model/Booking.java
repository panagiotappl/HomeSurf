package io.home.surf.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import io.home.surf.model.association.BookingId;

/**
 * @author Dimitris Anastasopoulos
 *
 */
@Entity
@IdClass(BookingId.class)
public class Booking {

  @Id
  private int id;

  @Id
  private Listing listingId;

  @Id
  private UserAccount tenantId;

  @Id
  private double from;

  @Id
  private double to;

  @Column(nullable = false, unique = false)
  private int numberOfGuests;

  @Column(nullable = false, unique = false)
  private double price;

  @OneToOne(cascade = CascadeType.ALL)
  @JoinColumn(name = "ratingId", referencedColumnName = "id")
  private BookingRating ratingId;

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public Listing getListingId() {
    return listingId;
  }

  public void setListingId(Listing listingId) {
    this.listingId = listingId;
  }

  public UserAccount getTenantId() {
    return tenantId;
  }

  public void setTenantId(UserAccount tenantId) {
    this.tenantId = tenantId;
  }

  public double getFrom() {
    return from;
  }

  public void setFrom(double from) {
    this.from = from;
  }

  public double getTo() {
    return to;
  }

  public void setTo(double to) {
    this.to = to;
  }

  public int getNumberOfGuests() {
    return numberOfGuests;
  }

  public void setNumberOfGuests(int numberOfGuests) {
    this.numberOfGuests = numberOfGuests;
  }

  public double getPrice() {
    return price;
  }

  public void setPrice(double price) {
    this.price = price;
  }

  public BookingRating getRatingId() {
    return ratingId;
  }

  public void setRatingId(BookingRating ratingId) {
    this.ratingId = ratingId;
  }

}
