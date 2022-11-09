import org.testng.annotations.Test;


public class SearchTests extends BaseTests{
    @Test
    public void testSearchByFullTitle(){
        String title = "Agile Testing";
        page.search(title);
        validateWindow();
    }
}
