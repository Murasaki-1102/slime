package actor;

//村崎
public class Slime extends Actor {

  public Slime(String name, int hitPoint, int attack, int mode) {
    super(name, hitPoint, attack, mode);

    /**
     * mode について
     * 0 = 初期状態
     * 1 = グーの奥義
     * 2 = チョキの奥義
     * 3 = パーの奥義
     * 12 = グーチョキの奥義
     * 13 = グーパーの奥義
     * 23 = チョキパーの奥義
     * 123 = スーパースライム
     */
  }
}