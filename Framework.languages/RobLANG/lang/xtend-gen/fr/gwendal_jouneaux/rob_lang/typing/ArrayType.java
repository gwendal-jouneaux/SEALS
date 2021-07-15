package fr.gwendal_jouneaux.rob_lang.typing;

import fr.gwendal_jouneaux.rob_lang.typing.RobLANGType;

@SuppressWarnings("all")
public class ArrayType implements RobLANGType {
  private RobLANGType type;
  
  private int dimension;
  
  public ArrayType(final RobLANGType type, final int dimension) {
    this.type = type;
    this.dimension = dimension;
  }
  
  public RobLANGType afterAccess() {
    if ((this.dimension < 2)) {
      return this.type;
    }
    return new ArrayType(this.type, (this.dimension - 1));
  }
  
  @Override
  public String toString() {
    String _string = this.type.toString();
    String _plus = (_string + "[");
    String _plus_1 = (_plus + Integer.valueOf(this.dimension));
    return (_plus_1 + "]");
  }
}
