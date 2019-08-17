interface sender{
    public void send();
}
class SenderA implements sender{

    @Override
    public void send() {
        System.out.println("AAAAA");
    }
}
class SenderB implements sender{

    @Override
    public void send() {
        System.out.println("BBBBB");
    }
}

public class factroy {
    public sender getSender(String type){
        sender sender = null;
        switch(type){
            case "A":
                return new SenderA();
            case "B":
                return new SenderB();
            default:
                return sender;
        }
    }
}
