package io.home.surf.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

/**
 * @author Dimitris Anastasopoulos
 *
 */
@Entity
public class Conversation {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;

  @ManyToOne(optional = false)
  @JoinColumn(name = "userA", nullable = false, updatable = false)
  private UserAccount userA;

  @ManyToOne(optional = false)
  @JoinColumn(name = "userB", nullable = false, updatable = false)
  private UserAccount userB;

  @OneToMany(mappedBy = "conversationId", cascade = CascadeType.ALL, orphanRemoval = true)
  private Set<Message> messages;

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public UserAccount getUserA() {
    return userA;
  }

  public void setUserA(UserAccount userA) {
    this.userA = userA;
  }

  public UserAccount getUserB() {
    return userB;
  }

  public void setUserB(UserAccount userB) {
    this.userB = userB;
  }

  public Set<Message> getMessages() {
    return messages;
  }

  public void setMessages(Set<Message> messages) {
    this.messages = messages;
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + id;
    result = prime * result + ((messages == null) ? 0 : messages.hashCode());
    result = prime * result + ((userA == null) ? 0 : userA.hashCode());
    result = prime * result + ((userB == null) ? 0 : userB.hashCode());
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
    Conversation other = (Conversation) obj;
    if (id != other.id)
      return false;
    if (messages == null) {
      if (other.messages != null)
        return false;
    } else if (!messages.equals(other.messages))
      return false;
    if (userA == null) {
      if (other.userA != null)
        return false;
    } else if (!userA.equals(other.userA))
      return false;
    if (userB == null) {
      if (other.userB != null)
        return false;
    } else if (!userB.equals(other.userB))
      return false;
    return true;
  }

}
