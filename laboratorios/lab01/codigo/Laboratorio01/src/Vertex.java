public class Vertex {
  
  private long id;
  private double coordinateX;
  private double coordinatey;
  
  Vertex(long id, double coordinateX, double coordinateY){
    this.id = id;
    this.coordinateX =  coordinateX;
    this.coordinatey = coordinateY;
  }
  
  public long getId () {
    return id;
  }
  
  public double getCoordinateX () {
    return coordinateX;
  }
  
  public double getCoordinatey () {
    return coordinatey;
  }
  
  @Override
  public boolean equals (Object obj) {
    if ( obj instanceof Vertex ){
      return id == (( Vertex ) obj).getId();
    }
    return false;
  }
}
