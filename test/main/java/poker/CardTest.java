package poker;

import org.junit.Assert;
import org.junit.Test;

public class CardTest {

    @Test
    public void itShouldValidateCardForItsSuitAndRank(){
        //given
        Card card = new Card(Suits.Hearts, "2", 0);
        //when
        Suits suit = card.getSuit();
        String faceValue = card.getFaceValue();
        int rank = card.getRank();
        //then
        Assert.assertEquals(Suits.Hearts, suit);
        Assert.assertEquals("2", faceValue);
        Assert.assertEquals(0, rank);
    }
}
