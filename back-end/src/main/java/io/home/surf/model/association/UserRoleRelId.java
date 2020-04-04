package io.home.surf.model.association;

import java.io.Serializable;
import java.util.UUID;

/**
 * @author Dimitris Anastasopoulos
 *
 */
public class UserRoleRelId implements Serializable {
  
  private static final long serialVersionUID = 5102060193010638386L;

  private UUID userAccount;
  
  private int userRole;

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((userAccount == null) ? 0 : userAccount.hashCode());
    result = prime * result + userRole;
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
    UserRoleRelId other = (UserRoleRelId) obj;
    if (userAccount == null) {
      if (other.userAccount != null)
        return false;
    } else if (!userAccount.equals(other.userAccount))
      return false;
    if (userRole != other.userRole)
      return false;
    return true;
  }

}
