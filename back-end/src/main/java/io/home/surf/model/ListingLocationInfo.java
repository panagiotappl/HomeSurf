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
public class ListingLocationInfo {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;

  @Column(nullable = false, unique = false)
  private String address;

  @Column(nullable = false, unique = false)
  private int postalCode;

  @Column(nullable = false, unique = false)
  private String state;

  @Column(nullable = false, unique = false)
  private String city;

  @Column(nullable = false, unique = false)
  private String country;

  @Column(nullable = false, unique = false)
  private double latitude;

  @Column(nullable = false, unique = false)
  private double longitude;

  @OneToOne(mappedBy = "locationInfoId")
  private Listing listingId;

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }

  public int getPostalCode() {
    return postalCode;
  }

  public void setPostalCode(int postalCode) {
    this.postalCode = postalCode;
  }

  public String getState() {
    return state;
  }

  public void setState(String state) {
    this.state = state;
  }

  public String getCity() {
    return city;
  }

  public void setCity(String city) {
    this.city = city;
  }

  public String getCountry() {
    return country;
  }

  public void setCountry(String country) {
    this.country = country;
  }

  public double getLatitude() {
    return latitude;
  }

  public void setLatitude(double latitude) {
    this.latitude = latitude;
  }

  public double getLongitude() {
    return longitude;
  }

  public void setLongitude(double longitude) {
    this.longitude = longitude;
  }

  public Listing getListingId() {
    return listingId;
  }

  public void setListingId(Listing listingId) {
    this.listingId = listingId;
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((address == null) ? 0 : address.hashCode());
    result = prime * result + ((city == null) ? 0 : city.hashCode());
    result = prime * result + ((country == null) ? 0 : country.hashCode());
    long temp;
    temp = Double.doubleToLongBits(latitude);
    result = prime * result + (int) (temp ^ (temp >>> 32));
    temp = Double.doubleToLongBits(longitude);
    result = prime * result + (int) (temp ^ (temp >>> 32));
    result = prime * result + postalCode;
    result = prime * result + ((state == null) ? 0 : state.hashCode());
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
    ListingLocationInfo other = (ListingLocationInfo) obj;
    if (address == null) {
      if (other.address != null)
        return false;
    } else if (!address.equals(other.address))
      return false;
    if (city == null) {
      if (other.city != null)
        return false;
    } else if (!city.equals(other.city))
      return false;
    if (country == null) {
      if (other.country != null)
        return false;
    } else if (!country.equals(other.country))
      return false;
    if (Double.doubleToLongBits(latitude) != Double.doubleToLongBits(other.latitude))
      return false;
    if (Double.doubleToLongBits(longitude) != Double.doubleToLongBits(other.longitude))
      return false;
    if (postalCode != other.postalCode)
      return false;
    if (state == null) {
      if (other.state != null)
        return false;
    } else if (!state.equals(other.state))
      return false;
    return true;
  }

}
