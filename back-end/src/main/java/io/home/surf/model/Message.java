package io.home.surf.model;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import io.home.surf.utils.TimestampAttributeConverter;

/**
 * @author Dimitris Anastasopoulos
 *
 */
@Entity
public class Message {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;

  @Column(nullable = false, unique = false)
  private String text;

  @Convert(converter = TimestampAttributeConverter.class)
  @Column(nullable = false, unique = false)
  private double timestamp;

  @ManyToOne(optional = false)
  @JoinColumn(name = "senderId", nullable = false, updatable = false)
  private UserAccount senderId;

  @ManyToOne(optional = false)
  @JoinColumn(name = "conversationId", nullable = false, updatable = false)
  private Conversation conversationId;

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getText() {
    return text;
  }

  public void setText(String text) {
    this.text = text;
  }

  public double getTimestamp() {
    return timestamp;
  }

  public void setTimestamp(double timestamp) {
    this.timestamp = timestamp;
  }

  public UserAccount getSenderId() {
    return senderId;
  }

  public void setSenderId(UserAccount senderId) {
    this.senderId = senderId;
  }

  public Conversation getConversationId() {
    return conversationId;
  }

  public void setConversationId(Conversation conversationId) {
    this.conversationId = conversationId;
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + id;
    result = prime * result + ((senderId == null) ? 0 : senderId.hashCode());
    result = prime * result + ((text == null) ? 0 : text.hashCode());
    long temp;
    temp = Double.doubleToLongBits(timestamp);
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
    Message other = (Message) obj;
    if (id != other.id)
      return false;
    if (senderId == null) {
      if (other.senderId != null)
        return false;
    } else if (!senderId.equals(other.senderId))
      return false;
    if (text == null) {
      if (other.text != null)
        return false;
    } else if (!text.equals(other.text))
      return false;
    if (Double.doubleToLongBits(timestamp) != Double.doubleToLongBits(other.timestamp))
      return false;
    return true;
  }

}
