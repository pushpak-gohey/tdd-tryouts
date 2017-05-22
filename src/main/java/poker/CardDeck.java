package poker;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by pushpak on 21/5/17.
 */
public class CardDeck {
    List<Card> cards = new ArrayList<>();
    public CardDeck() {
        createCards();
    }

    private void createCards() {

        for (Suits suit:
             Suits.values()) {
            for (int i = 0; i < 13; i++){
                cards.add(new Card(suit, getFaceValue(i), i));
            }
        }
    }

    private String getFaceValue(int rank) {
        if (rank < 8) {
            return String.valueOf(rank + 2);
        } else if ( rank == 8) {
            return "T";
        } else if (rank == 9){
            return "J";
        } else if ( rank == 10) {
            return "Q";
        }else if ( rank == 11) {
            return "K";
        }else {
            return "A";
        }
    }


    public List<Card> getCards() {
        return cards;
    }
}
