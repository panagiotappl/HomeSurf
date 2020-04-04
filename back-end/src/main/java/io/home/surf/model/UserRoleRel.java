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

}
