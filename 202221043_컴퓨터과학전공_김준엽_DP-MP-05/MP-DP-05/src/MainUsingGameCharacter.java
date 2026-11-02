public class MainUsingGameCharacter {
    public static void main(String[] args) {

        // 마법사 캐릭터 생성
        GameCharacter mage = new GameCharacter.Builder(
                "Gandalf", "mage")
                .strength(30)
                .agility(40)
                .intelligence(95)
                .weapon("staff")
                .armor("robe")
                .build();

        // 전사 캐릭터 생성
        GameCharacter warrior = new GameCharacter.Builder(
                "Arthur", "warrior")
                .strength(90)
                .agility(70)
                .intelligence(30)
                .weapon("sword")
                .armor("leather armor")
                .build();

        System.out.println(mage);
        System.out.println(warrior);
    }
}
