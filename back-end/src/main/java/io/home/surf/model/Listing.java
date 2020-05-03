package io.home.surf.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class Listing {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;

  @Column(nullable = false, unique = false)
  private String name;

  @Column(nullable = true, unique = false)
  private String description;

  @Column(nullable = false, unique = false)
  private double costPerDay;

  @Column(nullable = false, unique = false)
  private double extraCostPerGuest;

  // general info
  @Column(nullable = false, unique = false)
  private int numberOfBathrooms;

  @Column(nullable = false, unique = false)
  private int numberOfBeds;

  @Column(nullable = false, unique = false)
  private int numberOfBedrooms;

  /**
   * floor area in m2
   */
  @Column(nullable = false, unique = false)
  private double floorArea;

  @Column(nullable = false, unique = false)
  private String type;

  // rules
  @Column(nullable = false, unique = false)
  private boolean smokingAllowed;

  @Column(nullable = false, unique = false)
  private boolean petsAllowed;

  @Column(nullable = false, unique = false)
  private boolean eventsAllowed;

  @Column(nullable = false, unique = false)
  private int maxNumberOfGuests;

  @Column(nullable = false, unique = false)
  private int minDaysToStay;

  @OneToOne(cascade = CascadeType.ALL)
  @JoinColumn(name = "locationInfoId", referencedColumnName = "id")
  private ListingLocationInfo locationInfoId;

  // utilities
  @Column(nullable = false, unique = false)
  private boolean hasInternet;

  @Column(nullable = false, unique = false)
  private boolean hasTv;

  @Column(nullable = false, unique = false)
  private boolean hasAirCondition;

  @ManyToOne(optional = false)
  @JoinColumn(name = "ownerId", nullable = false, updatable = false)
  private UserAccount ownerId;

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public double getCostPerDay() {
    return costPerDay;
  }

  public void setCostPerDay(double costPerDay) {
    this.costPerDay = costPerDay;
  }

  public double getExtraCostPerGuest() {
    return extraCostPerGuest;
  }

  public void setExtraCostPerGuest(double extraCostPerGuest) {
    this.extraCostPerGuest = extraCostPerGuest;
  }

  public int getNumberOfBathrooms() {
    return numberOfBathrooms;
  }

  public void setNumberOfBathrooms(int numberOfBathrooms) {
    this.numberOfBathrooms = numberOfBathrooms;
  }

  public int getNumberOfBeds() {
    return numberOfBeds;
  }

  public void setNumberOfBeds(int numberOfBeds) {
    this.numberOfBeds = numberOfBeds;
  }

  public int getNumberOfBedrooms() {
    return numberOfBedrooms;
  }

  public void setNumberOfBedrooms(int numberOfBedrooms) {
    this.numberOfBedrooms = numberOfBedrooms;
  }

  public double getFloorArea() {
    return floorArea;
  }

  public void setFloorArea(double floorArea) {
    this.floorArea = floorArea;
  }

  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

  public boolean isSmokingAllowed() {
    return smokingAllowed;
  }

  public void setSmokingAllowed(boolean smokingAllowed) {
    this.smokingAllowed = smokingAllowed;
  }

  public boolean isPetsAllowed() {
    return petsAllowed;
  }

  public void setPetsAllowed(boolean petsAllowed) {
    this.petsAllowed = petsAllowed;
  }

  public boolean isEventsAllowed() {
    return eventsAllowed;
  }

  public void setEventsAllowed(boolean eventsAllowed) {
    this.eventsAllowed = eventsAllowed;
  }

  public int getMaxNumberOfGuests() {
    return maxNumberOfGuests;
  }

  public void setMaxNumberOfGuests(int maxNumberOfGuests) {
    this.maxNumberOfGuests = maxNumberOfGuests;
  }

  public int getMinDaysToStay() {
    return minDaysToStay;
  }

  public void setMinDaysToStay(int minDaysToStay) {
    this.minDaysToStay = minDaysToStay;
  }

  public ListingLocationInfo getLocationInfoId() {
    return locationInfoId;
  }

  public void setLocationInfoId(ListingLocationInfo locationInfoId) {
    this.locationInfoId = locationInfoId;
  }

  public boolean isHasInternet() {
    return hasInternet;
  }

  public void setHasInternet(boolean hasInternet) {
    this.hasInternet = hasInternet;
  }

  public boolean isHasTv() {
    return hasTv;
  }

  public void setHasTv(boolean hasTv) {
    this.hasTv = hasTv;
  }

  public boolean isHasAirCondition() {
    return hasAirCondition;
  }

  public void setHasAirCondition(boolean hasAirCondition) {
    this.hasAirCondition = hasAirCondition;
  }

  public UserAccount getOwnerId() {
    return ownerId;
  }

  public void setOwnerId(UserAccount ownerId) {
    this.ownerId = ownerId;
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    long temp;
    temp = Double.doubleToLongBits(costPerDay);
    result = prime * result + (int) (temp ^ (temp >>> 32));
    result = prime * result + ((description == null) ? 0 : description.hashCode());
    temp = Double.doubleToLongBits(extraCostPerGuest);
    result = prime * result + (int) (temp ^ (temp >>> 32));
    result = prime * result + ((locationInfoId == null) ? 0 : locationInfoId.hashCode());
    result = prime * result + maxNumberOfGuests;
    result = prime * result + minDaysToStay;
    result = prime * result + ((name == null) ? 0 : name.hashCode());
    result = prime * result + ((ownerId == null) ? 0 : ownerId.hashCode());
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
    Listing other = (Listing) obj;
    if (Double.doubleToLongBits(costPerDay) != Double.doubleToLongBits(other.costPerDay))
      return false;
    if (description == null) {
      if (other.description != null)
        return false;
    } else if (!description.equals(other.description))
      return false;
    if (Double.doubleToLongBits(extraCostPerGuest) != Double
        .doubleToLongBits(other.extraCostPerGuest))
      return false;
    if (locationInfoId == null) {
      if (other.locationInfoId != null)
        return false;
    } else if (!locationInfoId.equals(other.locationInfoId))
      return false;
    if (maxNumberOfGuests != other.maxNumberOfGuests)
      return false;
    if (minDaysToStay != other.minDaysToStay)
      return false;
    if (name == null) {
      if (other.name != null)
        return false;
    } else if (!name.equals(other.name))
      return false;
    if (ownerId == null) {
      if (other.ownerId != null)
        return false;
    } else if (!ownerId.equals(other.ownerId))
      return false;
    return true;
  }

}
