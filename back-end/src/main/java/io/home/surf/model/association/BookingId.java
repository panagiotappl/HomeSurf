package io.home.surf.model.association;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import io.home.surf.model.Listing;
import io.home.surf.model.UserAccount;
import io.home.surf.utils.TimestampAttributeConverter;

/**
 * {@link Booking} entity composite key.
 * 
 * @author Dimitris Anastasopoulos
 *
 */
public class BookingId implements Serializable {

  private static final long serialVersionUID = -1556796144642324631L;

  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;

  @ManyToOne(optional = false)
  @JoinColumn(name = "listingId", updatable = false)
  private Listing listingId;

  @ManyToOne(optional = false)
  @JoinColumn(name = "tenantId", nullable = false, updatable = false)
  private UserAccount tenantId;

  @Column(name = "firstDay")
  @Convert(converter = TimestampAttributeConverter.class)
  private double from;

  @Column(name = "lastDay")
  @Convert(converter = TimestampAttributeConverter.class)
  private double to;

  public BookingId() {
  }

  public BookingId(int id, Listing listingId, UserAccount tenantId, double from, double to) {
    this.id = id;
    this.listingId = listingId;
    this.tenantId = tenantId;
    this.from = from;
    this.to = to;
  }

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

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    long temp;
    temp = Double.doubleToLongBits(from);
    result = prime * result + (int) (temp ^ (temp >>> 32));
    result = prime * result + id;
    result = prime * result + ((listingId == null) ? 0 : listingId.hashCode());
    result = prime * result + ((tenantId == null) ? 0 : tenantId.hashCode());
    temp = Double.doubleToLongBits(to);
    result = prime * result + (int) (temp ^ (temp >>> 32));
    return result;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    BookingId other = (BookingId) obj;
    if (Double.doubleToLongBits(from) != Double.doubleToLongBits(other.from))
      return false;
    if (id != other.id)
      return false;
    if (listingId == null) {
      if (other.listingId != null)
        return false;
    } else if (!listingId.equals(other.listingId))
      return false;
    if (tenantId == null) {
      if (other.tenantId != null)
        return false;
    } else if (!tenantId.equals(other.tenantId))
      return false;
    if (Double.doubleToLongBits(to) != Double.doubleToLongBits(other.to))
      return false;
    return true;
  }

}
