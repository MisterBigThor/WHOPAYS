


public class Card{
    private char Number;
    private CardType Type;

    public enum CardType{
        Clubs, Diamonds, Spades, Hearts
    }

    public Card(char number, Card.CardType type) {
        setNumber(number);
        setType(type);
    }

    public CardType getType() {
        return Type;
    }

    public void setType(CardType type) {
        this.Type = type;
    }

    public char getNumber() {
        return Number;
    }

    /**
     * Set the number of the card.
     * @param number Character with the internal representation (A-2-3...-9-J-Q-k)
     */
    public void setNumber(char number) throws Exception{
        if(!(number >= '1' && number <= '9') ||
            !(number == 'A') || !(number == 'J') ||
            !(number == 'J') || !(number == 'Q') ||
            !(number == 'K'))
            throw new Exception("Incorrect card number");
        else this.Number = number;
    }

    /**
     * Set the number of the card.
     * @param number Integer from [1 to 13]
     */
    public void setNumber(Integer number){
        
    }

    /**
     * Set the number of the card.
     * @param number String with the Number+Type (A4)
     */
    public void setNumber(String number, Boolean another){
        
    }

    @Override
    public String toString() {
        return "Card [Number=" + Number + ", Type=" + Type + "]";
    }

    public static void main(String[] args) {
        Card c = new Card('9', CardType.Clubs);
        System.out.println(c.toString());
    }
}