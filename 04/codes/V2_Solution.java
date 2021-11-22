/**
 * Represents a simple real world car.
 */
public class Car {

  /**
   * The name of this car.
   */
  private String name;

  /**
   * The current mileage of this car.
   */
  private double mileage;

  /**
   * Constructs a car with the specified name.
   *
   * @param name the name of the car
   */
  public Car(String name) {
    this.name = name;
    mileage = 0;
  }

  /**
   * Drives the car by the given distance in kilometre.
   *
   * @param distance the distance in kilometre that the car should drive
   */
  public void drive(double distance) {
    mileage += distance;
  }

  /**
   * Returns the mileage of this car.
   *
   * @return the mileage of this car
   */
  public double getMileage() {
    return mileage;
  }

  /**
   * Returns the name of this car.
   *
   * @return the name of this car
   */
  public String getName() {
    return name;
  }
}