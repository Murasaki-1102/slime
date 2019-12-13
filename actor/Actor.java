package actor;

//村崎
public class Actor {
  private String name;
  private int hitPoint;
  private int attack;
  private int mode;
  /**
   * 12/4 中田
   * mode : キャラクターの特別な行動を制御する変数です
   * 例えば得意な手を制御したり、特別なタイミングで行動が変わったり、そういうのをイメージしてます
   * ぶっちゃけかなり分かりにくい実装になるので本当はこういうのやめたほうがいいと思います
   * 現在は進化バリュエーションの制御、あと勇者戦の特殊行動の制御に使っています
   * 新しくキャラクター作るなら適当に0で設定しといてください
   */

  public Actor(String name, int hitPoint, int attack,int mode) {
    this.name = name;
    this.hitPoint = hitPoint;
    this.attack = attack;
    this.mode = mode;
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

  public void setMode(int mode){
    this.mode = mode;
  }

  public int getMode(){
    return mode;
  }

  public void printData() {
    System.out.println("名前：" + this.name);
    System.out.println("体力：" + this.hitPoint);
    System.out.println("攻撃力：" + this.attack);
  }
}