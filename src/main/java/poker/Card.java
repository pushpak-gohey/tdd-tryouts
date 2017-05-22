package poker;

/**
 * Created by pushpak on 20/5/17.
 */
public class Card {
    private Suits suit;
    private String faceValue;
    private int rank;

    public Card(Suits suit, String facevalue, int rank ) {
        this.suit = suit;
        this.faceValue = facevalue;
        this.rank = rank;
    }

    public Suits getSuit() {
        return suit;
    }

    public String getFaceValue() {
        return faceValue;
    }

    public int getRank() {
        return rank;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Card card = (Card) o;

        if (rank != card.rank) return false;
        if (suit != card.suit) return false;
        return faceValue.equals(card.faceValue);
    }

    @Override
    public int hashCode() {
        int result = suit.hashCode();
        result = 31 * result + faceValue.hashCode();
        result = 31 * result + rank;
        return result;
    }

    @Override
    public String toString() {
        return "Card{" +
                "suit=" + suit +
                ", faceValue='" + faceValue + '\'' +
                ", rank=" + rank +
                '}';
    }
}
