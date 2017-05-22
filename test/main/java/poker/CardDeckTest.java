package poker;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

/**
 * Created by pushpak on 21/5/17.
 */
public class CardDeckTest {
    @Test
    public void itShouldGetCardsFromCardDeck(){
        //given
        CardDeck cardDeck = new CardDeck();

        //when
        List<Card> cards = cardDeck.getCards();

        //then
        Assert.assertTrue(cards.contains(new Card(Suits.Clubs, "K", 11)));
        Assert.assertEquals(52, cards.size());
    }
}
