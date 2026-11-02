
public class GameCharacter {
    private String name;
    private String job;
    private int strength;
    private int agility;
    private int intelligence;
    private String weapon;
    private String armor;

    // Builder를 통해서만 객체 생성
    private GameCharacter(Builder builder) {
        name = builder.name;
        job = builder.job;
        strength = builder.strength;
        agility = builder.agility;
        intelligence = builder.intelligence;
        weapon = builder.weapon;
        armor = builder.armor;
    }

    @Override
    public String toString() {
        return name + ", " + job
                + ", 체력 = " + strength
                + ", 민첩성 = " + agility
                + ", 지능 = " + intelligence
                + ", 무기 = " + weapon
                + ", 갑옷 = " + armor;
    }

    public static class Builder {
        // 필수 요소
        private String name;
        private String job;

        // 선택 요소 및 기본값
        private int strength = 10;
        private int agility = 10;
        private int intelligence = 20;
        private String weapon = "Hands";
        private String armor = "Cloth";

        public Builder(String name, String job) {
            this.name = name;
            this.job = job;
        }

        public Builder strength(int strength) {
            this.strength = strength;
            return this;
        }

        public Builder agility(int agility) {
            this.agility = agility;
            return this;
        }

        public Builder intelligence(int intelligence) {
            this.intelligence = intelligence;
            return this;
        }

        public Builder weapon(String weapon) {
            this.weapon = weapon;
            return this;
        }

        public Builder armor(String armor) {
            this.armor = armor;
            return this;
        }

        public GameCharacter build() {
            return new GameCharacter(this);
        }
    }
}
