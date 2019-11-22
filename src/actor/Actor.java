package actor;

public class Actor {
  private String name;
  private int hitPoint;
  private int attack;

  public Actor(String name, int hitPoint, int attack) {
    this.name = name;
    this.hitPoint = hitPoint;
    this.attack = attack;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getName() {
    return name;
  }

  public void setHitPoint(int hitPoint) {
    this.hitPoint = hitPoint;
  }

  public int getHitPoint() {
    return hitPoint;
  }

  public void setAttack(int attack) {
    this.attack = attack;
  }

  public int getAttack() {
    return attack;
  }

  public void printData() {
    System.out.println("名前：" + this.name);
    System.out.println("体力：" + this.hitPoint);
    System.out.println("攻撃力：" + this.attack);
  }
}