import Game.Gamer;
import Game.Memento;

public class Main {
    public static void main(String[] args) {
        Gamer gamer=new Gamer(100);
        Memento memento=gamer.createMemento();
        for(int i=0;i<100;i++){
            System.out.println("========="+i);
            System.out.println("当前状态："+gamer);

            gamer.bet();

            System.out.println("所持金钱为 "+gamer.getMoney()+"元。");
            if(gamer.getMoney()>memento.getMoney()){
                System.out.println("     (所持金钱增多了，因此保存游戏当前的状态）");
                memento=gamer.createMemento();
            }else if(gamer.getMoney()<memento.getMoney()/2){
                System.out.println("     (所持金钱减少了，因此将游戏恢复至以前的状态）");
                gamer.restoreMemento(memento);
            }
            try{
                Thread.sleep(10);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
            System.out.println();
        }
    }
}
