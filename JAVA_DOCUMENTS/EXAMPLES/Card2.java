
public abstract class Card2{
    private char Number;

    public Card2(char Number) {
        this.Number = Number;
    }

    public void setNumber(char Number){
        this.Number = Number;
    }

    public char getNumber(){return this.Number;}

    public abstract char getType();

    @Override
    public String toString() {
        return String.valueOf(Number) + this.getType();
    }

    public static void main(String[] args) {
        Card2 c1 = new Diamonds('9');
        Card2 c2 = new Hearts('9');
        System.out.println(c1.toString());
        System.out.println(c2.toString());
    }
}

class Diamonds extends Card2{

    public Diamonds(char num){
        super(num);
    }

    @Override
    public char getType(){
        return 'D';
    }
}

class Spades extends Card2{

    public Spades(char num){
        super(num);
    }
    
    @Override
    public char getType(){
        return 'S';
    }
}

class Clubs extends Card2{

    public Clubs(char num){
        super(num);
    }
    
    @Override
    public char getType(){
        return 'C';
    }
}

class Hearts extends Card2{

    public Hearts(char num){
        super(num);
    }
    
    @Override
    public char getType(){
        return 'H';
    }
}