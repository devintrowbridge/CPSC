import static org.junit.jupiter.api.Assertions.*;

class MarkovModelTest {

   @org.junit.jupiter.api.Test
   void getRandomKgram() {
      String input = "ABCDE";
      MarkovModel model = new MarkovModel(5, input);
   }
}