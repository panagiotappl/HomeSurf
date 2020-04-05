package io.home.surf.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import io.home.surf.model.association.UserRoleRelId;

/**
 * @author Dimitris Anastasopoulos
 *
 */
@Entity
@IdClass(UserRoleRelId.class)
public class UserRoleRel {

  @Id
  @ManyToOne
  @JoinColumn(name = "userId", insertable = false, updatable = false)
  private UserAccount userAccount;

  @Id
  @ManyToOne
  @JoinColumn(name = "roleId", insertable = false, updatable = false)
  private UserRole userRole;

  public UserRoleRel() {
  }

  public UserAccount getUserAccount() {
    return userAccount;
  }

  public void setUserAccount(UserAccount userAccount) {
    this.userAccount = userAccount;
  }

  public UserRole getUserRole() {
    return userRole;
  }

  public void setUserRole(UserRole userRole) {
    this.userRole = userRole;
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((userAccount == null) ? 0 : userAccount.hashCode());
    result = prime * result + ((userRole == null) ? 0 : userRole.hashCode());
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
    UserRoleRel other = (UserRoleRel) obj;
    if (userAccount == null) {
      if (other.userAccount != null)
        return false;
    } else if (!userAccount.equals(other.userAccount))
      return false;
    if (userRole == null) {
      if (other.userRole != null)
        return false;
    } else if (!userRole.equals(other.userRole))
      return false;
    return true;
  }

}
